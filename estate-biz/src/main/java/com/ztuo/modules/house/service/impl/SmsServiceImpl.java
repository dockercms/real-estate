package com.ztuo.modules.house.service.impl;

import com.ztuo.common.utils.*;
import com.ztuo.modules.house.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: dupinyan
 * @Description: 发送短信服务
 * @Date: 2020/2/12 17:20
 * @Version: 1.0
 */
@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UESSSMSProvider provider;

    /**
     * 发送注册短信
     * @param mobilePhone
     * @return
     */
    @Override
    public RestResponse sendCodeByPhone(String mobilePhone) throws Exception {
        String randomCode = String.valueOf(GeneratorUtil.getRandomNumber(100000, 999999));

        log.info("注册手机号mobilePhone={}, 验证码randomCode={}", mobilePhone, randomCode);
        boolean result = UESSSMSProvider.aliyunMessage(mobilePhone, randomCode);
        String key = Constant.REGISTER_PHONE_VERIFY_CODE_TIME_TIME_OUT + mobilePhone;
        Object message = redisUtil.get(key);
        if (message != null) {
            return RestResponse.error("请求频繁，请稍后再试");
        }
        if (result) {
            // 清除缓存并重新添加
            redisUtil.delete(Constant.REGISTER_PHONE_VERIFY_CODE_TIME + mobilePhone, Constant.REGISTER_PHONE_CODE + mobilePhone);
            // 添加验证码缓存 5分钟有效期
            redisUtil.set(Constant.REGISTER_PHONE_CODE + mobilePhone, randomCode, Constant.REGISTER_PHONE_CODE_VALID_TIME, TimeUnit.MINUTES);
            // 添加发送间隔 60s
            redisUtil.set(Constant.REGISTER_PHONE_VERIFY_CODE_TIME_TIME_OUT + mobilePhone, new Date(), Constant.REGISTER_PHONE_VERIFY_CODE_TIME_TIME_OUT, TimeUnit.SECONDS);
            return RestResponse.success("发送成功");
        } else {
            return RestResponse.error("发送失败，请稍后再试");
        }
    }

    /**
     * 发送登录验证码
     * @param mobilePhone
     * @return
     */
    @Override
    public RestResponse sendLoginCode(String mobilePhone) throws Exception {
        String randomCode = String.valueOf(GeneratorUtil.getRandomNumber(100000, 999999));
        log.info("登录手机号mobilePhone={}, 验证码randomCode={}", mobilePhone, randomCode);
        boolean result = UESSSMSProvider.aliyunMessage(mobilePhone, randomCode);

        String key = Constant.LOGIN_PHONE_CODE_TIME_OUT + mobilePhone;
        Object message = redisUtil.get(key);
        if (message != null) {
            return RestResponse.error("请求频繁，请稍后再试");
        }
        if (result) {
            // 清除缓存并重新添加
            redisUtil.delete(Constant.LOGIN_PHONE_CODE_ + mobilePhone, Constant.LOGIN_PHONE_CODE_TIME_OUT + mobilePhone);
            // 添加验证码缓存 5m
            redisUtil.set(Constant.LOGIN_PHONE_CODE_ + mobilePhone, randomCode, Constant.LOGIN_PHONE_CODE_VALID_TIME, TimeUnit.MINUTES);
            // 添加验证码时长限制缓存 60s
            redisUtil.set(Constant.LOGIN_PHONE_CODE_TIME_OUT + mobilePhone, new Date(), Constant.LOGIN_PHONE_CODE_TIME_OUT_NUM, TimeUnit.SECONDS);
            return RestResponse.success("发送成功");
        } else {
            return RestResponse.error("发送失败，请稍后再试");
        }
    }

    @Override
    public RestResponse sendForgetPasswordCode(String mobilePhone) throws Exception {
        String randomCode = String.valueOf(GeneratorUtil.getRandomNumber(100000, 999999));
        log.info("忘记密码手机号mobilePhone={}, 验证码randomCode={}", mobilePhone, randomCode);
        boolean result = UESSSMSProvider.aliyunMessage(mobilePhone, randomCode);

        String key = Constant.FORGET_PHONE_CODE_TIME_OUT + mobilePhone;
        Object message = redisUtil.get(key);
        if (message != null) {
            return RestResponse.error("请求频繁，请稍后再试");
        }
        if (result) {
            // 清除缓存并重新添加
            redisUtil.delete(Constant.FORGET_PHONE_CODE_ + mobilePhone, Constant.FORGET_PHONE_CODE_TIME_OUT + mobilePhone);
            // 添加验证码缓存 5m
            redisUtil.set(Constant.FORGET_PHONE_CODE_ + mobilePhone, randomCode, Constant.FORGET_PHONE_CODE_VALID_TIME, TimeUnit.MINUTES);
            // 添加验证码时长限制缓存 60s
            redisUtil.set(Constant.FORGET_PHONE_CODE_TIME_OUT + mobilePhone, new Date(), Constant.FORGET_PHONE_CODE_TIME_OUT_NUM, TimeUnit.SECONDS);
            return RestResponse.success("发送成功");
        } else {
            return RestResponse.error("发送失败，请稍后再试");
        }
    }
}
