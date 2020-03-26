/*
 * 项目名称:my-museum
 * 类名称:SysLoginForm.java
 * 包名称:com.platform.modules.sys.form
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.modules.sys.form;

import lombok.Data;

/**
 * 登录表单
 *
 * @author gs
 */
@Data
public class SysLoginForm {
    private String userName;
    private String password;
    private String captcha;
    private String uuid;
}
