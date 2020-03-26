package com.ztuo.modules.house.service;

import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.house.entity.EstateUser;
import com.ztuo.modules.house.vo.LoginByPhone;
import com.ztuo.modules.house.vo.UserQueryVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: dupinyan
 * @Description:
 * @Date: 2020/2/11 17:30
 * @Version: 1.0
 */
public interface EstateUserService {

    /**
     * 用户注册
     * @param loginByPhone 手机号
     * @return
     * @throws Exception
     */
    RestResponse registerByPhone(LoginByPhone loginByPhone) throws Exception;

    /**
     * 手机密码登录
     * @param mobilePhone   手机号
     * @param password  密码(目前明文)
     * @return
     */
    RestResponse login(String mobilePhone, String password) throws Exception;

    /**
     * 验证码登录
     * @param mobilePhone 手机号
     * @param msgCode   验证码
     * @return
     */
    RestResponse msgLogin(String mobilePhone, String msgCode, HttpServletRequest request) throws Exception;

    /**
     * 用户忘记密码
     * @param mobilePhone
     * @param msgCode
     * @return
     */
    RestResponse forget(String mobilePhone, String msgCode, String newPassword) throws Exception;

    /**
     * 用户注册并且登录返回信息
     * @param loginByPhone
     * @return
     */
    RestResponse registerLogin(LoginByPhone loginByPhone) throws Exception;

    EstateUser findByOpenId(String openId);

    void saveEstateUser(EstateUser estateUser);

    void updateUser(EstateUser update);

    RestResponse pageQueryByCondition(UserQueryVO userQueryVO) throws Exception;
}
