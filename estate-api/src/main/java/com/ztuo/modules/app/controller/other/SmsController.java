package com.ztuo.modules.app.controller.other;

import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.house.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dupinyan
 * @Description: 发送短信
 * @Date: 2020/2/12 17:16
 * @Version: 1.0
 */
@RestController
@RequestMapping("sms")
@Slf4j
public class SmsController {

    @Autowired
    private SmsService smsService;


    /**
     * 注册发送验证码
     * @param mobilePhone
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "register/code", method = RequestMethod.POST)
    public RestResponse sendRegisterCode(@RequestParam("mobilePhone") String mobilePhone) {
        try {
            return smsService.sendCodeByPhone(mobilePhone);
        } catch (Exception e) {
            log.info("---->注册发送短信失败---->", e);
            return RestResponse.error("发送失败");
        }
    }


    /**
     * 登录发送验证码
     * @param mobilePhone
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "login/code", method = RequestMethod.POST)
    public RestResponse sendLoginCode(@RequestParam("mobilePhone") String mobilePhone) {
        try {
            return smsService.sendLoginCode(mobilePhone);
        } catch (Exception e) {
            log.info("---->登录发送失败---->", e);
            return RestResponse.error("发送失败");
        }
    }


    /**
     * 忘记密码发送验证码
     * @param mobilePhone
     * @return
     */
    @IgnoreAuth
    @RequestMapping(value = "forget/code", method = RequestMethod.POST)
    public RestResponse forgetPasswordCode(@RequestParam("mobilePhone") String mobilePhone) {
        try {
            return smsService.sendForgetPasswordCode(mobilePhone);
        } catch (Exception e) {
            log.info("----->忘记密码发送失败---->", e);
            return RestResponse.error("发送失败");
        }
    }
}
