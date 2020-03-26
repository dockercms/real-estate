package com.ztuo.modules.house.vo;

import lombok.Data;

/**
 * @Author: dupinyan
 * @Description: 用户登录vo
 * @Date: 2020/2/11 15:30
 * @Version: 1.0
 */
@Data
public class LoginByPhone {

    /**
     * 用户手机号
     */
    private String mobilePhone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 验证码
     */
    private String msgCode;


}
