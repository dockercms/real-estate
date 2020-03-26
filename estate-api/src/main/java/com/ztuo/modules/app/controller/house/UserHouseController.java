package com.ztuo.modules.app.controller.house;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.handler.MessageSourceHandler;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.house.entity.*;
import com.ztuo.modules.house.service.*;
import com.ztuo.modules.house.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @description: UserHouseController
 * @author: MrGao
 * @create: 2020/02/11 14:05
 */
@Slf4j
@RestController
@RequestMapping("houses")
public class UserHouseController {

    @Autowired
    private IUserHouseSV userHouseSV;

    @Autowired
    private IUygurUserHouseSV uygurUserHouseSV ;

    @Autowired
    private IFavoriteHouseSV favoriteHouseSV ;

    @Autowired
    private IFeedbackSV feedbackSV ;

    @Autowired
    private IHouseResourceSV houseResourceSV ;

    @Autowired
    private IUygurHouseResourceSV uygurHouseResourceSV ;

    @Autowired
    private ILastContactSV lastContactSV ;

    @Autowired
    private BrokerService brokerService;

    @Autowired
    private  IEstateBrokerSV estateBrokerSV ;

    @Autowired
    private IScanHouseRecordSV scanHouseRecordSV ;

    @Autowired
    private MessageSourceHandler messageSourceHandler ;

    /**
     * 我的委托是估价，求购 0 2
     * 我的房子是出租和卖房
     */
    @RequestMapping(value = "page_query/my",method = RequestMethod.POST)
    public RestResponse pageQueryMyHouse(HttpServletRequest request, @RequestBody UserHouseQuery houseQuery) throws Exception{
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        houseQuery.setUserId(Long.parseLong(userId));
        List<String> loadTypes = new ArrayList<>();
        if(StringUtils.isNotEmpty(houseQuery.getEntrustQuery()) && "1".equalsIgnoreCase(houseQuery.getEntrustQuery())){
            loadTypes.add("0");
            loadTypes.add("2");
        }else {
            loadTypes.add("1");
            loadTypes.add("3");
        }
        houseQuery.setLoadTypes(loadTypes);
        houseQuery.setWebQuery("1");
        log.info("分页查询我的房子={},houseQuery={}",header,houseQuery);
        if (header != null && "wy".equals(header)){
            Page<UygurUserHouse> page = uygurUserHouseSV.pageQuery(houseQuery);
            return RestResponse.success(page);
        }else {
            Page<UserHouse> page = userHouseSV.pageQuery(houseQuery,null);
            return RestResponse.success(page);
        }
    }

    /**
     * 我要估价
     * @param userHouse
     * @return
     */
    @RequestMapping(value = "valuation/house",method = RequestMethod.POST)
    public RestResponse haveValuationHouse(HttpServletRequest request,@RequestBody UserHouse userHouse) throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        log.info("我要估价={},userId={},header={}",userHouse,userId,header);
        userHouse.setCreateTime(new Date());
        userHouse.setLoadType("0");
        userHouse.setStatus("0");
        userHouse.setUserId(userId);
        String sign = UUID.randomUUID().toString().replace("-", "");
        userHouse.setSignLabel(sign);
        saveHouseByHeader(userHouse, header);
        return RestResponse.success(messageSourceHandler.getMessage("SUCCESS"));
    }


    /**
     * 我要卖房
     * @param userHouse
     * @return
     */
    @RequestMapping(value = "sell/house",method = RequestMethod.POST)
    public RestResponse haveSellHouse(HttpServletRequest request,@RequestBody UserHouse userHouse) throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        log.info("我要卖房={}userId={},header={}",userHouse,userId,header);
        userHouse.setCreateTime(new Date());
        userHouse.setLoadType("1");
        userHouse.setStatus("0");
        userHouse.setUserId(userId);
        String sign = UUID.randomUUID().toString().replace("-", "");
        userHouse.setSignLabel(sign);
        saveHouseByHeader(userHouse, header);
        return RestResponse.success(messageSourceHandler.getMessage("SUCCESS"));
    }

    private void saveHouseByHeader( UserHouse userHouse, String header) throws Exception {
        if (header != null && "wy".equals(header)){
            UygurUserHouse uygurUserHouse = new UygurUserHouse();
            BeanUtils.copyProperties(userHouse,uygurUserHouse);
            uygurUserHouseSV.save(uygurUserHouse);
        }else {
            userHouseSV.save(userHouse);
        }
    }


    /**
     * 我要求购
     * @param userHouse
     * @return
     */
    @RequestMapping(value = "buy/house",method = RequestMethod.POST)
    public RestResponse haveBuyHouse(HttpServletRequest request,@RequestBody  UserHouse userHouse) throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        log.info("我要卖房={}userId={},header={}",userHouse,userId,header);
        userHouse.setCreateTime(new Date());
        userHouse.setLoadType("2");
        userHouse.setStatus("0");
        userHouse.setUserId(userId);
        String sign = UUID.randomUUID().toString().replace("-", "");
        userHouse.setSignLabel(sign);
        saveHouseByHeader(userHouse, header);
        return RestResponse.success(messageSourceHandler.getMessage("SUCCESS"));
    }

    /**
     * 我要出租
     * @param userHouse
     * @return
     */
    @RequestMapping(value = "rent/house",method = RequestMethod.POST)
    public RestResponse haveRentHouse(HttpServletRequest request,@RequestBody UserHouse userHouse) throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        log.info("我要卖房={}userId={},header={}",userHouse,userId,header);
        userHouse.setCreateTime(new Date());
        userHouse.setLoadType("3");
        userHouse.setStatus("0");
        userHouse.setUserId(userId);
        String sign = UUID.randomUUID().toString().replace("-", "");
        userHouse.setSignLabel(sign);
        saveHouseByHeader(userHouse, header);
        return RestResponse.success(messageSourceHandler.getMessage("SUCCESS"));
    }

    /**
     * 查询 我的关注 待修改
     * @param request
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "focus/houses/page_query",method = RequestMethod.POST)
    public RestResponse pageQueryMyFocus(HttpServletRequest request,@RequestBody FavoriteHouseQuery queryVo){
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        queryVo.setUserId(Long.parseLong(userId));
        log.info("header={},queryVo={}",header,queryVo);
        if (header != null && "wy".equals(header)){
             queryVo.setLanguageType("1");
        } else {
            queryVo.setLanguageType("0");
        }
        Page<Object> page = favoriteHouseSV.pageQueryFavoriteHouse(queryVo);
        return RestResponse.success(page);
    }

    /**
     * 关注
     * @param request
     * @param favoriteHouse
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "focus/houses/save",method = RequestMethod.POST)
    public RestResponse saveMyFocus(HttpServletRequest request, @RequestBody FavoriteHouse favoriteHouse) throws Exception{
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        log.info("新增我的关注favoriteHouse={}header={},userId={}",favoriteHouse,header,userId);
        favoriteHouse.setCreateTime(new Date());
        favoriteHouse.setUserId(Long.parseLong(userId));
        Long houseId = favoriteHouse.getHouseId();
        FavoriteHouseExample example = new FavoriteHouseExample();
        FavoriteHouseExample.Criteria criteria = example.createCriteria();
        criteria.andHouseIdEqualTo(favoriteHouse.getHouseId());
        criteria.andUserIdEqualTo(Long.parseLong(userId));
        int count = favoriteHouseSV.countByExample(example);
        if(count == 2){
            return RestResponse.success(messageSourceHandler.getMessage("HOUSE_ALREADY_FOCUS"));
        }
        if (header != null && "wy".equals(header)){
            UygurHouseResource uygurHouseResource = uygurHouseResourceSV.getByPrimaryKey(favoriteHouse.getHouseId());
            if(uygurHouseResource==null){
                return RestResponse.error(messageSourceHandler.getMessage("PARAMS_ERROR"));
            }
            String signLabel = uygurHouseResource.getSignLabel();
            HouseResource bySignLabel = houseResourceSV.findBySignLabel(signLabel);
            if(bySignLabel==null){
                return RestResponse.error(messageSourceHandler.getMessage("PARAMS_ERROR"));
            }
            favoriteHouse.setHouseId(uygurHouseResource.getId());
            favoriteHouse.setLanguageType("1");
            favoriteHouseSV.save(favoriteHouse);
            favoriteHouse.setHouseId(bySignLabel.getId());
            favoriteHouse.setLanguageType("0");
            favoriteHouseSV.save(favoriteHouse);
        } else {
            HouseResource houseResource = houseResourceSV.getByPrimaryKey(houseId);
            if(houseResource==null){
                return RestResponse.error(messageSourceHandler.getMessage("PARAMS_ERROR"));
            }
            String signLabel = houseResource.getSignLabel();
            UygurHouseResource uygurHouseResource = uygurHouseResourceSV.findBySignLabel(signLabel);
            if(uygurHouseResource==null){
                return RestResponse.error(messageSourceHandler.getMessage("PARAMS_ERROR"));
            }
            favoriteHouse.setHouseId(houseResource.getId());
            favoriteHouse.setLanguageType("0");
            favoriteHouseSV.save(favoriteHouse);
            favoriteHouse.setHouseId(uygurHouseResource.getId());
            favoriteHouse.setLanguageType("1");
            favoriteHouseSV.save(favoriteHouse);
        }
        return RestResponse.success(messageSourceHandler.getMessage("FOCUS_SUCCESS"));
    }


    /**
     * 关注
     * @param request
     * @param favoriteHouse
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "focus/houses/delete",method = RequestMethod.POST)
    public RestResponse deleteMyFocus(HttpServletRequest request, @RequestBody FavoriteHouse favoriteHouse) throws Exception{
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        favoriteHouse.setUserId(Long.parseLong(userId));
        log.info("取消我的关注favoriteHouse={}header={},userId={}",favoriteHouse,header,userId);
        if (header != null && "wy".equals(header)){
            UygurHouseResource uygurHouseResource = uygurHouseResourceSV.getByPrimaryKey(favoriteHouse.getHouseId());
            favoriteHouseSV.deleteByConditions(favoriteHouse);
            HouseResource houseResource = houseResourceSV.findBySignLabel(uygurHouseResource.getSignLabel());
            if(houseResource!=null){
                favoriteHouse.setHouseId(houseResource.getId());
                favoriteHouseSV.deleteByConditions(favoriteHouse);
            }
        } else {
            HouseResource house = houseResourceSV.getByPrimaryKey(favoriteHouse.getHouseId());
            favoriteHouseSV.deleteByConditions(favoriteHouse);
            UygurHouseResource uygurHouseResource = uygurHouseResourceSV.findBySignLabel(house.getSignLabel());
            if(uygurHouseResource!=null) {
                favoriteHouse.setHouseId(uygurHouseResource.getId());
                favoriteHouseSV.deleteByConditions(favoriteHouse);
            }
        }
        return RestResponse.success(messageSourceHandler.getMessage("CANCEL_FOCUS_SUCCESS"));
    }



    /**
     * 提交意见反馈
     * @param feedback
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "feed_back/save",method = RequestMethod.POST)
    public RestResponse feedBack(HttpServletRequest request,@RequestBody Feedback feedback)throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        feedback.setUserId(Long.parseLong(userId));
        log.info("feedBack={}",feedback);
        feedback.setCreateTime(new Date());
        feedbackSV.save(feedback);
        return RestResponse.success(messageSourceHandler.getMessage("SUCCESS"));
    }

    /**
     * 查询最近联系经纪人
     * @param queryVo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "contract/last",method = RequestMethod.POST)
    public RestResponse contractLastQuery(HttpServletRequest request,@RequestBody BaseQueryVo queryVo)throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        String header = request.getHeader(Constant.HEADER_LANGUAGE);
        queryVo.setUserId(Long.parseLong(userId));
        log.info("查询最近联系经纪人={},header={}",queryVo,header);
        Page<LastContact> page = lastContactSV.pageQuery(queryVo);
        List<LastContact> records = page.getRecords();
        Page<EstateBroker> brokerPage = new Page<>();
        BeanUtils.copyProperties(page,brokerPage);
        if(records ==null || records.size()==0){
            BrokerQuery query = new BrokerQuery();
            query.setPageNum(query.getPageNum());
            query.setPageSize(query.getPageSize());
            Page<EstateBroker> brokerPage1 = brokerService.criteriaQuery(query,null);
            if(header != null && "wy".equals(header)) {
                List<EstateBroker> brokers = brokerPage1.getRecords();
                for (EstateBroker broker : brokers) {
                    broker.setBrokerName(broker.getUygurBrokerName());
                }
            }
            return RestResponse.success(brokerPage1);
        }else {
            List<Long> ids = new ArrayList<>();
            for (LastContact lastContact:records){
                ids.add(lastContact.getBrokerId());
            }
            EstateBrokerExample example = new EstateBrokerExample();
            EstateBrokerExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            List<EstateBroker> byExample = estateBrokerSV.getByExample(example);
            if(header != null && "wy".equals(header)) {
                for (EstateBroker broker : byExample) {
                    broker.setBrokerName(broker.getUygurBrokerName());
                }
            }
            brokerPage.setRecords(byExample);
            return RestResponse.success(brokerPage);
        }
    }



    /**
     * 联系经纪人
     * @param brokerId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "contract/broker/{id}",method = RequestMethod.GET)
    public RestResponse contractBroker(HttpServletRequest request,@PathVariable("id") Long  brokerId)throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        log.info("联系经纪人={}",brokerId);
        LastContact contact = lastContactSV.findByUserIdAndBrokerId(Long.parseLong(userId),brokerId);
        if(contact==null){
            contact = new LastContact();
            contact.setBrokerId(brokerId);
            contact.setContractTime(new Date());
            contact.setUserId(Long.parseLong(userId));
            contact.setRemark("");
            lastContactSV.save(contact);
        }else {
            contact.setContractTime(new Date());
            lastContactSV.updateByPrimaryKeySelective(contact);
        }
        return RestResponse.success(messageSourceHandler.getMessage("SUCCESS"));
    }

    /**
     * 新增看房记录
     * @param houseId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "scan/record/{houseId}",method = RequestMethod.GET)
    public RestResponse scanHouseRecord(HttpServletRequest request,@PathVariable("houseId") Long houseId)throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        String language = request.getHeader(Constant.HEADER_LANGUAGE);
        ScanHouseRecordExample example = new ScanHouseRecordExample();
        ScanHouseRecordExample.Criteria criteria = example.createCriteria();
        criteria.andHouseIdEqualTo(houseId);
        criteria.andUserIdEqualTo(Long.parseLong(userId));
        String languageType ;
        if (language != null && "wy".equals(language)){
            criteria.andLanguageTypeEqualTo("1");
            languageType = "1";
        }else {
            languageType = "0";
            criteria.andLanguageTypeEqualTo("0");
        }
        List<ScanHouseRecord> scanHouseRecords = scanHouseRecordSV.getByExample(example);
        if(scanHouseRecords==null || scanHouseRecords.size()==0){
            ScanHouseRecord scanHouseRecord = new ScanHouseRecord();
            scanHouseRecord.setHouseId(houseId);
            scanHouseRecord.setCreateTime(new Date());
            scanHouseRecord.setLanguageType(languageType);
            scanHouseRecord.setRemark("");
            scanHouseRecord.setUserId(Long.parseLong(userId));
            scanHouseRecordSV.save(scanHouseRecord);
        }else {
            ScanHouseRecord scanHouseRecord = scanHouseRecords.get(0);
            scanHouseRecord.setCreateTime(new Date());
            scanHouseRecordSV.updateByPrimaryKeySelective(scanHouseRecord);
        }
        return RestResponse.success(messageSourceHandler.getMessage("SUCCESS"));
    }


    /**
     * 看房记录
     * @param queryVo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "scan/page_query",method = RequestMethod.POST)
    public RestResponse scanHouseRecord(HttpServletRequest request,@RequestBody BaseQueryVo queryVo)throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        String language = request.getHeader(Constant.HEADER_LANGUAGE);
        queryVo.setUserId(Long.parseLong(userId));
        log.info("看房记录={},language={}",queryVo,language);
        Page<ScanHouseRecord> page = scanHouseRecordSV.pageQuery(queryVo);
        List<ScanHouseRecord> records = page.getRecords();
        List<Long> ids = new ArrayList<>();
        for (ScanHouseRecord record:records){
            ids.add(record.getHouseId());
        }
        if (language != null && "wy".equals(language)){
            Page<UygurHouseResource> housePage = new Page<>();
            BeanUtils.copyProperties(page,housePage);
            if(ids.isEmpty()){
                return RestResponse.success(housePage);
            }else {
                UygurHouseResourceExample example = new UygurHouseResourceExample();
                UygurHouseResourceExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(ids);
                criteria.andSellStatusEqualTo(0);
                List<UygurHouseResource> houseResources = uygurHouseResourceSV.getByExample(example);
                housePage.setRecords(houseResources);
                return RestResponse.success(housePage);
            }
        }else {
            Page<HouseResource> housePage = new Page<>();
            BeanUtils.copyProperties(page,housePage);
            if(ids.isEmpty()){
                return RestResponse.success(housePage);
            }else {
               HouseResourceExample example = new HouseResourceExample();
                HouseResourceExample.Criteria criteria = example.createCriteria();
                criteria.andIdIn(ids);
                criteria.andSellStatusEqualTo(0);
                List<HouseResource> houseResources = houseResourceSV.getByExample(example);
                housePage.setRecords(houseResources);
                return RestResponse.success(housePage);
            }
        }
    }

    @RequestMapping(value = "favorite/status/{houseId}",method = RequestMethod.GET)
    public RestResponse findHouseFavoriteStatus(HttpServletRequest request,@PathVariable("houseId") Long houseId){
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        String language = request.getHeader(Constant.HEADER_LANGUAGE);
        log.info("查询房源是否关注={},={}",userId,language);
        RestResponse restResponse = new RestResponse();
        if(StringUtils.isEmpty(userId)){
            return restResponse.putData(false);
        }else {
            boolean status ;
            FavoriteHouse favoriteHouse ;
            if (language != null && "wy".equals(language)){
                favoriteHouse = favoriteHouseSV.findHouseStatus(userId,houseId,"1");
            }else {
                favoriteHouse = favoriteHouseSV.findHouseStatus(userId,houseId,"0");
            }
            status = favoriteHouse ==null?false:true;
            return restResponse.putData(status);
        }
    }






}
