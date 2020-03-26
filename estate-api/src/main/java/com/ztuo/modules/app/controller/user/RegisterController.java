package com.ztuo.modules.app.controller.user;

import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.EasemobService;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.handler.MessageSourceHandler;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.house.entity.EstateBroker;
import com.ztuo.modules.house.entity.EstateUser;
import com.ztuo.modules.house.entity.UserAgreement;
import com.ztuo.modules.house.service.*;
import com.ztuo.modules.house.vo.BrokerRegister;
import com.ztuo.modules.house.vo.LoginByPhone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Author: dupinyan
 * @Description: 用户注册
 * @Date: 2020/2/11 17:03
 * @Version: 1.0
 */
@RestController
@RequestMapping("register")
@Slf4j
public class RegisterController extends RestResponse {

    @Autowired
    private EstateUserService userService;

    @Autowired
    private BrokerService brokerService;

    @Autowired
    private EasemobService easemobService ;

    @Autowired
    private IUserAgreementSV userAgreementSV ;

    @Autowired
    private IEstateBrokerSV estateBrokerSV ;

    @Autowired
    private IEstateUserSV estateUserSV ;

    @Autowired
    private MessageSourceHandler messageSourceHandler;


    /**
     * 用户手机短信注册
     * @param loginByPhone
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "user/phone", method = RequestMethod.POST)
    public RestResponse registerByPhone(@RequestBody LoginByPhone loginByPhone) {
        log.info("---->用户手机注册---->loginByPhone={}", loginByPhone);
        Assert.hasText(loginByPhone.getMobilePhone(), messageSourceHandler.getMessage("MOBILE_NOT_NULL"));
        Assert.hasText(loginByPhone.getPassword(), messageSourceHandler.getMessage("PASSWORD_NOT_NULL"));
        Assert.hasText(loginByPhone.getMsgCode(), messageSourceHandler.getMessage("MESSAGE_CODE_NOT_NULL"));
        try {
            return userService.registerByPhone(loginByPhone);
        } catch (Exception e) {
            log.info("---->用户手机注册异常---->", e);
            return error(messageSourceHandler.getMessage("REGISTER_ERROR"));
        }
    }


    /**
     * pc用户手机注册并且登录
     * @param loginByPhone
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "login/phone", method = RequestMethod.POST)
    public RestResponse registerLogin(@RequestBody LoginByPhone loginByPhone) {
        log.info("---->pc端手机注册并且登录---->loginByPhone={}", loginByPhone);
        Assert.hasText(loginByPhone.getMobilePhone(), messageSourceHandler.getMessage("MOBILE_NOT_NULL"));
        Assert.hasText(loginByPhone.getPassword(), messageSourceHandler.getMessage("PASSWORD_NOT_NULL"));
        Assert.hasText(loginByPhone.getMsgCode(), messageSourceHandler.getMessage("MESSAGE_CODE_NOT_NULL"));
        try {
            return userService.registerLogin(loginByPhone);
        } catch (Exception e) {
            log.info("----->pc用户手机注册异常---->", e);
            return error(messageSourceHandler.getMessage("REGISTER_ERROR"));
        }
    }


    /**
     * 经纪人手机短信注册
     * @param brokerRegister
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "broker/phone", method = RequestMethod.POST)
    public RestResponse registerBrokerByPhone(@Valid @RequestBody BrokerRegister brokerRegister) {
        log.info("---->经纪人手机注册---->brokerRegister={}", brokerRegister);
        try {
            return brokerService.registerByPhone(brokerRegister);
        } catch (Exception e) {
            log.info("---->经纪人手机注册异常---->", e);
            return error("注册失败");
        }
    }


    /**
     * 校验验证码
     * @param mobilePhone
     * @param msgCode
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "broker/check", method = RequestMethod.POST)
    public RestResponse registerBrokerMsg(@RequestParam("mobilePhone") String mobilePhone,
                                          @RequestParam("msgCode") String msgCode) {
        return brokerService.checkBrokerMsg(mobilePhone, msgCode);
    }

    /**
     * 新增环信用户
     * @param request
     * @param userType
     * @return
     */
    @RequestMapping(value = "ease/{userType}",method = RequestMethod.GET)
    public RestResponse register(HttpServletRequest request, @PathVariable("userType")String userType )  throws Exception{
        String userId = request.getHeader(Constant.HEADER_USER_ID);
        if("0".equalsIgnoreCase(userType)){
            //0代表经纪人
            userId = "b"+userId ;
        }else {
            userId = "c"+userId ;
        }
        boolean check = easemobService.checkUserRegister(userId);
        if(!check) {
            log.info("环信用户不存在={}",check);
            if("0".equalsIgnoreCase(userType)){
                EstateBroker estateBroker = estateBrokerSV.getByPrimaryKey(Long.parseLong(userId));
                easemobService.registerEasemob(userId, userId, estateBroker.getBrokerName());
            }else {
                EstateUser estateUser = estateUserSV.getByPrimaryKey(Long.parseLong(userId));
                easemobService.registerEasemob(userId, userId, estateUser.getNickname());
            }
        }
        return RestResponse.success();
    }

    /**
     * 查询用户协议
     * @param type
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "agreement/{type}",method = RequestMethod.GET)
    public RestResponse getUserAgreement(@PathVariable("type")String type){
        log.info("查询用户协议={}",type);
        RestResponse restResponse = new RestResponse();
        UserAgreement userAgreement = userAgreementSV.findShelvesAgreement(type);
        if(userAgreement!=null){
            return restResponse.putData(userAgreement);
        }else {
            return restResponse.putData("暂无用户协议");
        }
    }



}
