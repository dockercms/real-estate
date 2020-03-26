package com.ztuo.modules.house.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.*;
import com.ztuo.modules.es.dao.HouseDocRepository;
import com.ztuo.modules.es.dao.UyHouseDocRepository;
import com.ztuo.modules.house.dao.EstateBrokerDAO;
import com.ztuo.modules.house.dao.HouseResourceDAO;
import com.ztuo.modules.house.dao.UygurHouseResourceDAO;
import com.ztuo.modules.house.entity.EstateBroker;
import com.ztuo.modules.house.entity.EstateBrokerExample;
import com.ztuo.modules.house.entity.HouseResource;
import com.ztuo.modules.house.entity.UygurHouseResource;
import com.ztuo.modules.house.service.BrokerService;
import com.ztuo.modules.house.service.IHouseCountSV;
import com.ztuo.modules.house.vo.BrokerQuery;
import com.ztuo.modules.house.vo.BrokerRegister;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: dupinyan
 * @Description: 后台经纪人使用
 * @Date: 2020/2/19 16:17
 * @Version: 1.0
 */
@Service
@Slf4j
public class BrokerServiceImpl implements BrokerService {

    @Autowired
    private EstateBrokerDAO dao;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private HouseResourceDAO houseResourceDAO;

    @Autowired
    private UygurHouseResourceDAO uygurHouseResourceDAO;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private EasemobService easemobService ;

    @Autowired
    private HouseDocRepository repository;

    @Autowired
    private UyHouseDocRepository uyHouseDocRepository;

    @Autowired
    private IHouseCountSV houseCountSV;


    @Override
    public Page<EstateBroker> criteriaQuery(BrokerQuery brokerQuery,Map<String, Object> params) throws Exception {
        Page page = new Page(brokerQuery.getPageNum(), brokerQuery.getPageSize());
        EstateBrokerExample brokerExample = new EstateBrokerExample();
        EstateBrokerExample.Criteria criteria = brokerExample.createCriteria();

        // 开始时间
        if (StringUtils.isNotEmpty(brokerQuery.getStartTime())) {
            criteria.andCreateTimeGreaterThanOrEqualTo(DateUtils.parseDate(brokerQuery.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        // 结束时间
        if (StringUtils.isNotEmpty(brokerQuery.getEndTime())) {
            criteria.andCreateTimeLessThanOrEqualTo(DateUtils.parseDate(brokerQuery.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        // 工作区域
        if (StringUtils.isNotEmpty(brokerQuery.getWorkArea())) {
            criteria.andWorkAreaLike(brokerQuery.getWorkArea());
        }
        // 经纪人级别
        if (brokerQuery.getBrokerLevel() != null) {
            criteria.andBrokerLevelEqualTo(brokerQuery.getBrokerLevel());
        }
        // 区域code
        if (StringUtils.isNotEmpty(brokerQuery.getAreaCode())) {
            criteria.andAreaCodeEqualTo(brokerQuery.getAreaCode());
        }
        // 审核状态
        if (brokerQuery.getAuditStatus() != null) {
            criteria.andAuditStatusEqualTo(brokerQuery.getAuditStatus());
        }
        // 经纪人姓名
        if (StringUtils.isNotEmpty(brokerQuery.getBrokerName())) {
            criteria.andBrokerNameEqualTo(brokerQuery.getBrokerName());
        }
        // 工作店铺
        if (StringUtils.isNotEmpty(brokerQuery.getWorkShop())) {
            criteria.andWorkShopLike(brokerQuery.getWorkShop());
        }
        brokerExample.setOrderByClause("create_time desc");
        List<EstateBroker> estateBrokers = dao.pageQueryByExample(page, brokerExample,params);
        return page.setRecords(estateBrokers);
    }

    @Override
    public RestResponse auditBroker(BrokerQuery brokerQuery) {
        EstateBroker broker = dao.getByPrimaryKey(brokerQuery.getBrokerId());
        if (broker == null) {
            return RestResponse.error("经纪人不存在");
        }
        if (broker.getAuditStatus() == 1 || broker.getAuditStatus() == 2) {
            return RestResponse.error("请勿重复审核");
        }
        broker.setAuditStatus(brokerQuery.getAuditStatus());
        dao.updateByPrimaryKeySelective(broker);
        return RestResponse.success("审核成功");
    }

    @Override
    public RestResponse registerByPhone(BrokerRegister brokerRegister) throws Exception {
        // 校验手机号是否合法
        EstateBroker broker = brokerRegister.getBroker();
        String mobilePhone = broker.getMobilePhone();
        mobilePhone = StringUtils.deleteWhitespace(mobilePhone);
        if (!ValidateUtil.isMobilePhone(mobilePhone)) {
            return RestResponse.error("手机号非法");
        }
        // 根据手机号查询账号看是否存在审核中
        EstateBroker auditInBroker = dao.getBrokerByPhoneAndStatus(mobilePhone, Constant.AUDIT_ING);
        EstateBroker auditSuccessBroker = dao.getBrokerByPhoneAndStatus(mobilePhone, Constant.AUDIT_SUCCESS);
        if (auditInBroker != null) {
            return RestResponse.error("账号审核中，请勿重复提交");
        }
        if (auditSuccessBroker != null) {
            return RestResponse.error("手机号已存在");
        }
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,}$";
        if (!brokerRegister.getBroker().getSignPassword().matches(regex)) {
            return RestResponse.error("密码需为6位以上数字字母组合");
        }
        String password = Md5.getMD5(brokerRegister.getBroker().getSignPassword() + Constant.MD5KEY).toLowerCase();
        log.info("---->加密后得密码---->password={}", password);
        // 创建对象保存数据库
        broker.setCreateTime(new Date());
        broker.setSignPassword(password);
        broker.setAuditStatus(0);
        broker.setGuestNumber(0);
        dao.save(broker);
        try {
            Long id = broker.getId();
            if(id!=null){
                log.info("经纪人管理 ={}",id);
                String userName = "b"+id;
                easemobService.registerEasemob(userName,userName,broker.getBrokerName());
            }
        }catch (Exception e){
            log.info("注册环信失败={}",e);
        }
        return RestResponse.success("注册成功");
    }

    @Override
    public RestResponse login(String mobilePhone, String password) throws Exception {
        // 根据手机号查询用户是否存在
        EstateBroker auditBrokerIn = dao.getBrokerByPhoneAndStatus(mobilePhone, 0);
        if (auditBrokerIn != null) {
            return RestResponse.error("账号审核中");
        }
        EstateBroker auditBrokerSuccess = dao.getBrokerByPhoneAndStatus(mobilePhone, 1);
        if (auditBrokerSuccess != null) {
            if (!Md5.getMD5(password + Constant.MD5KEY).toLowerCase().equals(auditBrokerSuccess.getSignPassword())) {
                return RestResponse.error("账号或密码错误");
            }
            String token = jwtUtils.generateToken(auditBrokerSuccess.getId().toString());
            String key = Constant.BROKER+auditBrokerSuccess.getId();
            redisUtil.set(key,token,jwtUtils.getExpire(),TimeUnit.SECONDS);
            Map<String, Object> map = new HashMap<>(4);
            map.put("token", token);
            map.put("expire", jwtUtils.getExpire());
            map.put("user", auditBrokerSuccess);
            return RestResponse.success(map);
        }
        return RestResponse.error("用户不存在");
    }

    @Override
    public RestResponse msgLogin(String mobilePhone, String msgCode) {
        // 查询经纪人是否存在
        EstateBroker auditBrokerIn = dao.getBrokerByPhoneAndStatus(mobilePhone, 0);
        if (auditBrokerIn != null) {
            return RestResponse.error("账号审核中");
        }
        EstateBroker auditBrokerSuccess = dao.getBrokerByPhoneAndStatus(mobilePhone, 1);
        if (auditBrokerSuccess != null) {
            // 校验验证码
            Object code = redisUtil.get(Constant.LOGIN_PHONE_CODE_ + mobilePhone);
            if (code == null) {
                return RestResponse.error("请重新发送验证码");
            }
            if (!code.toString().equals(msgCode)) {
                return RestResponse.error("验证码错误");
            }
            String token = jwtUtils.generateToken(auditBrokerSuccess.getId().toString());
            String key = Constant.BROKER+auditBrokerSuccess.getId();
            redisUtil.set(key,token,jwtUtils.getExpire(),TimeUnit.SECONDS);
            Map<String, Object> map = new HashMap<>(4);
            map.put("token", token);
            map.put("expire", jwtUtils.getExpire());
            map.put("user", auditBrokerSuccess);
            return RestResponse.success(map);
        }
        return RestResponse.error("用户不存在");
    }

    @Override
    public RestResponse forget(String mobilePhone, String msgCode, String newPassword) throws Exception {
        EstateBroker broker = dao.getBrokerByPhoneAndStatus(mobilePhone, 1);
        if (broker == null) {
            return RestResponse.error("用户不存在或在审核中");
        }
        Object code = redisUtil.get(Constant.FORGET_PHONE_CODE_ + mobilePhone);
        log.info("----经纪人重置密码获取验证码---code={}", code);
        if (code == null) {
            return RestResponse.error("请重新发送验证码");
        }
        if (!code.toString().equals(msgCode)) {
            return RestResponse.error("验证码错误");
        }
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,}$";
        if (!newPassword.matches(regex)) {
            return RestResponse.error("密码需为6位以上数字字母组合");
        }
        String password = Md5.getMD5(newPassword + Constant.MD5KEY).toLowerCase();
        log.info("---->加密后得密码---->password={}", password);
        broker.setSignPassword(password);
        dao.updateByPrimaryKeySelective(broker);
        return RestResponse.success("修改成功");
    }

    @Override
    public RestResponse add(EstateBroker broker) throws Exception {
        String mobilePhone = broker.getMobilePhone();
        EstateBroker auditBrokerIn = dao.getBrokerByPhoneAndStatus(mobilePhone, 0);
        if (auditBrokerIn != null) {
            return RestResponse.error("账号审核中，请勿重复提交");
        }
        EstateBroker auditBrokerSuccess = dao.getBrokerByPhoneAndStatus(mobilePhone, 1);
        if (auditBrokerSuccess != null) {
            return RestResponse.error("手机号已存在");
        }
        // 前端默认传递111111
        String password = Md5.getMD5(broker.getSignPassword() + Constant.MD5KEY).toLowerCase();
        log.info("---->加密后得密码---->password={}", password);
        // 创建对象保存数据库
        broker.setCreateTime(new Date());
        broker.setSignPassword(password);
        // 后台管理添加的经纪人无需审核，可直接登录
        broker.setAuditStatus(1);
        broker.setGuestNumber(0);
        dao.save(broker);
        try {
            Long id = broker.getId();
            if(id!=null){
                log.info("经纪人管理={}",id);
                String userName = "b"+id;
                easemobService.registerEasemob(userName,userName,broker.getBrokerName());
            }
        }catch (Exception e){
            log.info("注册环信失败={}",e);
        }
        return RestResponse.success("添加成功");
    }

    @Override
    public RestResponse delete(Long id) {
        dao.deleteByPrimaryKey(id);
        // 根据id查询该经纪人下得所有房源
        List<HouseResource> houseResourceList = houseResourceDAO.getByBrokerId(id);
        List<UygurHouseResource> uygurHouseResourceList = uygurHouseResourceDAO.getByBrokerId(id);
        if (houseResourceList != null && houseResourceList.size() > 0 && uygurHouseResourceList != null && uygurHouseResourceList.size() > 0) {
            for (int i = 0; i < houseResourceList.size(); i++) {
                HouseResource houseResource = houseResourceList.get(i);
                houseResource.setSellStatus(1);
                houseResourceDAO.updateByPrimaryKeySelective(houseResource);
                repository.deleteById(houseResource.getId());
                houseCountSV.subAccountByType(houseResource.getEstateType()+"",houseResource.getRegionCode());
            }
            for (int i = 0; i < uygurHouseResourceList.size(); i++) {
                UygurHouseResource uygurHouseResource = uygurHouseResourceList.get(i);
                uygurHouseResource.setSellStatus(1);
                uygurHouseResourceDAO.updateByPrimaryKeySelective(uygurHouseResource);
                uyHouseDocRepository.deleteById(uygurHouseResource.getId());
            }
            // 清除redis数据
            deleteRedisHomePageHouse(10);
            deleteRedisHomePageHouse(2);
            deleteRedisHomePageHouse(11);

        }
        return RestResponse.success("删除成功");
    }


    @Override
    public RestResponse checkBrokerMsg(String mobilePhone, String code) {
        // 校验验证码
        Object msgCode = redisUtil.get(Constant.REGISTER_PHONE_CODE + mobilePhone);
        if (msgCode == null) {
            return RestResponse.error("请重新发送验证码");
        }
        if (!msgCode.toString().equals(code)) {
            return RestResponse.error("验证码错误");
        }
        // 查询手机号是否存在
        EstateBroker broker = dao.getBrokerByPhoneAndStatus(mobilePhone, 1);
        if (broker != null) {
            return RestResponse.error("手机号已存在");
        }
        return RestResponse.success();
    }


    /**
     * 清除redis数据
     * @param estateType
     */
    private void deleteRedisHomePageHouse(Integer estateType) {
        // 二手房 首页数据
        if (estateType == 10) {
            redisUtil.delete("houseResourceSecondPC", "houseResourceSecondAPP", "uygurHouseResourceSecondPC", "uygurHouseResourceSecondAPP");
        }

        // 商铺
        if (estateType == 2) {
            redisUtil.delete("houseResourceShopPC", "houseResourceShopAPP", "uygurHouseResourceShopPC", "uygurHouseResourceShopAPP");
        }

        // 租房
        if (estateType == 11) {
            redisUtil.delete("houseResourceRentPC", "houseResourceRentAPP", "uygurHouseResourceRentPC", "uygurHouseResourceRentAPP");
        }
    }
}
