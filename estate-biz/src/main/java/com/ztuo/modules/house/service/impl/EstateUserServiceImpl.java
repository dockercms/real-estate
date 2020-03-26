package com.ztuo.modules.house.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.*;
import com.ztuo.modules.house.dao.EstateUserDAO;
import com.ztuo.modules.house.entity.EstateUser;
import com.ztuo.modules.house.entity.EstateUserExample;
import com.ztuo.modules.house.service.EstateUserService;
import com.ztuo.modules.house.vo.LoginByPhone;
import com.ztuo.modules.house.vo.UserQueryVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: dupinyan
 * @Description: 用户模块
 * @Date: 2020/2/11 18:13
 * @Version: 1.0
 */
@Service
@Slf4j
public class EstateUserServiceImpl implements EstateUserService {

    @Autowired
    private EstateUserDAO estateUserDAO;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private EasemobService easemobService ;

    /**
     *  用户注册
     * @param loginByPhone
     */
    @Override
    public RestResponse registerByPhone(LoginByPhone loginByPhone) throws Exception {
        // 校验手机号是否合法
        String mobilePhone = loginByPhone.getMobilePhone();
        mobilePhone = StringUtils.deleteWhitespace(mobilePhone);
        if (!ValidateUtil.isMobilePhone(mobilePhone)) {
            return RestResponse.error("手机号非法");
        }
        // 已存在该用户
        EstateUser userByPhone = estateUserDAO.getUserByPhone(mobilePhone);
        log.info("---->查询出用户---->userByPhone={}", userByPhone);
        if (userByPhone != null) {
            return RestResponse.error("该手机号已存在，请核实");
        }
        // 校验验证码
        Object msgCode = redisUtil.get(Constant.REGISTER_PHONE_CODE + mobilePhone);
        log.info("--->用户登陆校验验证码--->msgCode={}", msgCode);
        if (msgCode == null) {
            return RestResponse.error("请重新发送验证码");
        }
        if (!msgCode.toString().equals(loginByPhone.getMsgCode())) {
            return RestResponse.error("验证码错误");
        }
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,}$";
        String phonePassword = loginByPhone.getPassword();
        if (!phonePassword.matches(regex)) {
            return RestResponse.error("密码需为6位以上数字字母组合");
        }
        String password = Md5.getMD5(phonePassword + Constant.MD5KEY).toLowerCase();
        log.info("---->加密后得密码---->password={}", password);
        // 创建用户对象添加属性保存
        EstateUser user = new EstateUser();
        user.setCreateTime(new Date());
        user.setMobilePhone(mobilePhone);
        String nickName = mobilePhone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        log.info("---->替换后的昵称---->nickName={}", nickName);
        user.setNickname(nickName);
        user.setSignPassword(password);
        user.setHouseResourseNum(0);
        estateUserDAO.save(user);
        try {
            Long id = user.getId();
            log.info("id ={}",id);
            if(id!=null){
                String userName = "c"+id;
                easemobService.registerEasemob(userName,userName,user.getNickname());
            }
        }catch (Exception e){
            log.info("注册环信失败,信息={}",e);
        }
        return RestResponse.success("注册成功");
    }


    /**
     * 手机号密码登录
     * @param mobilePhone
     * @param password
     * @return
     */
    @Override
    public RestResponse login(String mobilePhone, String password) throws Exception {
        EstateUser user = estateUserDAO.getUserByPhone(mobilePhone);
        if (user == null) {
            return RestResponse.error("用户不存在");
        }
        if (!Md5.getMD5(password + Constant.MD5KEY).toLowerCase().equals(user.getSignPassword())) {
            return RestResponse.error("账号或密码错误");
        }
        String token = jwtUtils.generateToken(user.getId().toString());
        String key = Constant.CUSTOMER+user.getId();
        redisUtil.set(key,token,jwtUtils.getExpire(),TimeUnit.SECONDS);
        Map<String, Object> map = new HashMap<>(4);
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());
        map.put("user", user);

        return RestResponse.success(map);
    }

    /**
     * 手机验证码登录
     * @param mobilePhone 手机号
     * @param msgCode   验证码
     * @return
     */
    @Override
    public RestResponse msgLogin(String mobilePhone, String msgCode, HttpServletRequest request) throws Exception {
        // 校验验证码
        Object code = redisUtil.get(Constant.LOGIN_PHONE_CODE_ + mobilePhone);
        if (code == null) {
            return RestResponse.error("请重新发送验证码");
        }
        if (!code.toString().equals(msgCode)) {
            return RestResponse.error("验证码错误");
        }
        EstateUser user = estateUserDAO.getUserByPhone(mobilePhone);
        if (user != null) {
            String token = jwtUtils.generateToken(user.getId().toString());
            String key = Constant.CUSTOMER+user.getId();
            redisUtil.set(key,token,jwtUtils.getExpire(),TimeUnit.SECONDS);
            Map<String, Object> map = new HashMap<>(4);
            map.put("token", token);
            map.put("expire", jwtUtils.getExpire());
            map.put("user", user);

            return RestResponse.success(map);
        }
        // 用户为空，注册添加默认密码
        // 校验手机号是否合法
        mobilePhone = StringUtils.deleteWhitespace(mobilePhone);
        if (!ValidateUtil.isMobilePhone(mobilePhone)) {
            return RestResponse.error("手机号非法");
        }
        String password = Md5.getMD5("111111" + Constant.MD5KEY).toLowerCase();
        String nickName = mobilePhone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        log.info("---->替换后的昵称---->nickName={}", nickName);
        user = new EstateUser();
        user.setCreateTime(new Date());
        user.setMobilePhone(mobilePhone);
        user.setNickname(nickName);
        user.setSignPassword(password);
        user.setHouseResourseNum(0);
        estateUserDAO.save(user);
        Map<String, Object> map = new HashMap<>(4);
        try {
            Long id = user.getId();
            log.info("id ={}",id);
            if(id!=null){
                String token = jwtUtils.generateToken(user.getId().toString());
                String key = Constant.CUSTOMER+user.getId();
                redisUtil.set(key,token,jwtUtils.getExpire(),TimeUnit.SECONDS);

                map.put("token", token);
                map.put("expire", jwtUtils.getExpire());
                map.put("user", user);
                String userName = "c"+id;
                easemobService.registerEasemob(userName,userName,user.getNickname());
            }
        }catch (Exception e){
            log.info("注册环信失败,信息={}",e);
        }
        if (map.isEmpty()) {
            return RestResponse.error("快捷登录失败");
        }
        return RestResponse.success(map);
    }

    private RestResponse pcLogin(String mobilePhone, String msgCode) {
        EstateUser user = estateUserDAO.getUserByPhone(mobilePhone);
        if (user == null) {
            return RestResponse.error("用户不存在");
        }
        // 校验验证码
        Object code = redisUtil.get(Constant.LOGIN_PHONE_CODE_ + mobilePhone);
        if (code == null) {
            return RestResponse.error("请重新发送验证码");
        }
        if (!code.toString().equals(msgCode)) {
            return RestResponse.error("验证码错误");
        }
        String token = jwtUtils.generateToken(user.getId().toString());
        String key = Constant.CUSTOMER+user.getId();
        redisUtil.set(key,token,jwtUtils.getExpire(),TimeUnit.SECONDS);
        Map<String, Object> map = new HashMap<>(4);
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());
        map.put("user", user);

        return RestResponse.success(map);
    }

    private RestResponse appLogin(String mobilePhone, String msgCode) throws Exception {
        // 校验验证码
        Object code = redisUtil.get(Constant.LOGIN_PHONE_CODE_ + mobilePhone);
        if (code == null) {
            return RestResponse.error("请重新发送验证码");
        }
        if (!code.toString().equals(msgCode)) {
            return RestResponse.error("验证码错误");
        }
        EstateUser user = estateUserDAO.getUserByPhone(mobilePhone);
        if (user != null) {
            String token = jwtUtils.generateToken(user.getId().toString());
            String key = Constant.CUSTOMER+user.getId();
            redisUtil.set(key,token,jwtUtils.getExpire(),TimeUnit.SECONDS);
            Map<String, Object> map = new HashMap<>(4);
            map.put("token", token);
            map.put("expire", jwtUtils.getExpire());
            map.put("user", user);

            return RestResponse.success(map);
        }
        // 用户为空，注册添加默认密码
        // 校验手机号是否合法
        mobilePhone = StringUtils.deleteWhitespace(mobilePhone);
        if (!ValidateUtil.isMobilePhone(mobilePhone)) {
            return RestResponse.error("手机号非法");
        }
        String password = Md5.getMD5("111111" + Constant.MD5KEY).toLowerCase();
        String nickName = mobilePhone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        log.info("---->替换后的昵称---->nickName={}", nickName);
        user = new EstateUser();
        user.setCreateTime(new Date());
        user.setMobilePhone(mobilePhone);
        user.setNickname(nickName);
        user.setSignPassword(password);
        user.setHouseResourseNum(0);
        estateUserDAO.save(user);
        Map<String, Object> map = new HashMap<>(4);
        try {
            Long id = user.getId();
            log.info("id ={}",id);
            if(id!=null){
                String token = jwtUtils.generateToken(user.getId().toString());
                String key = Constant.CUSTOMER+user.getId();
                redisUtil.set(key,token,jwtUtils.getExpire(),TimeUnit.SECONDS);

                map.put("token", token);
                map.put("expire", jwtUtils.getExpire());
                map.put("user", user);
                String userName = "c"+id;
                easemobService.registerEasemob(userName,userName,user.getNickname());
            }
        }catch (Exception e){
            log.info("注册环信失败,信息={}",e);
        }
        if (map.isEmpty()) {
            return RestResponse.error("快捷登录失败");
        }
        return RestResponse.success(map);
    }

    @Override
    public RestResponse forget(String mobilePhone, String msgCode, String newPassword) throws Exception {
        // 根据手机号查询
        EstateUser user = estateUserDAO.getUserByPhone(mobilePhone);
        if (user == null) {
            return RestResponse.error("用户不存在");
        }
        Object code = redisUtil.get(Constant.FORGET_PHONE_CODE_ + mobilePhone);
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
        user.setSignPassword(password);
        estateUserDAO.updateByPrimaryKeySelective(user);

        return RestResponse.success("修改成功");
    }


    @Override
    public RestResponse registerLogin(LoginByPhone loginByPhone) throws Exception {
        // 校验手机号是否合法
        String mobilePhone = loginByPhone.getMobilePhone();
        mobilePhone = StringUtils.deleteWhitespace(mobilePhone);
        if (!ValidateUtil.isMobilePhone(mobilePhone)) {
            return RestResponse.error("手机号非法");
        }
        // 已存在该用户
        EstateUser userByPhone = estateUserDAO.getUserByPhone(mobilePhone);
        log.info("---->查询出用户---->userByPhone={}", userByPhone);
        if (userByPhone != null) {
            return RestResponse.error("该手机号已存在，请核实");
        }
        // 校验验证码
        Object msgCode = redisUtil.get(Constant.REGISTER_PHONE_CODE + mobilePhone);
        log.info("--->用户登陆校验验证码--->msgCode={}", msgCode);
        if (msgCode == null) {
            return RestResponse.error("请重新发送验证码");
        }
        if (!msgCode.toString().equals(loginByPhone.getMsgCode())) {
            return RestResponse.error("验证码错误");
        }
        // 添加密码校验 6位以上字母加数字
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,}$";
        String phonePassword = loginByPhone.getPassword();
        if (!phonePassword.matches(regex)) {
            return RestResponse.error("密码需为6位以上数字字母组合");
        }
        String password = Md5.getMD5(phonePassword + Constant.MD5KEY).toLowerCase();
        log.info("---->加密后得密码---->password={}", password);
        // 创建用户对象添加属性保存
        EstateUser user = new EstateUser();
        user.setCreateTime(new Date());
        user.setMobilePhone(mobilePhone);
        String nickName = mobilePhone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        log.info("---->替换后的昵称---->nickName={}", nickName);
        user.setNickname(nickName);
        user.setSignPassword(password);
        user.setHouseResourseNum(0);
        estateUserDAO.save(user);
        EstateUser userMessage = estateUserDAO.getUserByPhone(mobilePhone);

        // 注册后默认为登录状态
        String token = jwtUtils.generateToken(userMessage.getId().toString());
        Map<String, Object> map = new HashMap<>(4);
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());
        map.put("user", userMessage);
        String key = Constant.CUSTOMER+user.getId();
        redisUtil.set(key,token,jwtUtils.getExpire(),TimeUnit.SECONDS);
        try {
            Long id = user.getId();
            log.info("id  ={}",id);
            if(id!=null){
                String userName = "c"+id;
                easemobService.registerEasemob(userName,userName,user.getNickname());
            }
        }catch (Exception e){
            log.info("注册环信失败,信息={}",e);
        }
        return RestResponse.success(map);
    }

    @Override
    public EstateUser findByOpenId(String openId) {

        return estateUserDAO.findByOpenId(openId);
    }

    @Override
    public void saveEstateUser(EstateUser estateUser) {
        estateUserDAO.save(estateUser);
    }

    @Override
    public void updateUser(EstateUser update) {
        estateUserDAO.updateByPrimaryKeySelective(update);
    }

    @Override
    public RestResponse pageQueryByCondition(UserQueryVO userQueryVO) throws Exception {
        // 创建分页
        Page page = new Page(userQueryVO.getPageNum(), userQueryVO.getPageSize());
        EstateUserExample example = new EstateUserExample();
        example.setOrderByClause("create_time desc");
        EstateUserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(userQueryVO.getStartTime())) {
            criteria.andCreateTimeGreaterThanOrEqualTo(DateUtils.parseDate(userQueryVO.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNotBlank(userQueryVO.getEndTime())) {
            criteria.andCreateTimeLessThanOrEqualTo(DateUtils.parseDate(userQueryVO.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNotBlank(userQueryVO.getNickName())) {
            criteria.andNicknameLike(userQueryVO.getNickName());
        }
        if (StringUtils.isNotBlank(userQueryVO.getMobilePhone())) {
            criteria.andMobilePhoneEqualTo(userQueryVO.getMobilePhone());
        }
        List<EstateUser> userList = estateUserDAO.pageQueryByExample(page, example);
        return RestResponse.success(page.setRecords(userList));
    }


}
