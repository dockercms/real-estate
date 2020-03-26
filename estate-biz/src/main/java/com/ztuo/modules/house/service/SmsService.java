package com.ztuo.modules.house.service;

import com.ztuo.common.utils.RestResponse;

/**
 * @Author: dupinyan
 * @Description: 发送短信接口
 * @Date: 2020/2/12 17:19
 * @Version: 1.0
 */
public interface SmsService {


    /**
     * 注册发送短信
     * @param mobilePhone
     * @return
     */
    RestResponse sendCodeByPhone(String mobilePhone) throws Exception;

    /**
     * 登录发送短信
     * @param mobilePhone
     * @return
     */
    RestResponse sendLoginCode(String mobilePhone) throws Exception;

    /**
     * 忘记密码发送
     * @param mobilePhone
     * @return
     */
    RestResponse sendForgetPasswordCode(String mobilePhone) throws Exception;
}
