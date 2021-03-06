/*
 * 项目名称:my-museum
 * 类名称:SysLoginController.java
 * 包名称:com.platform.modules.sys.controller
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.modules.sys.controller;

import com.ztuo.common.annotation.SysLog;
import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.sys.entity.SysUserEntity;
import com.ztuo.modules.sys.form.SysLoginForm;
import com.ztuo.modules.sys.oauth2.Oauth2Token;
import com.ztuo.modules.sys.service.SysCaptchaService;
import com.ztuo.modules.sys.service.SysUserService;
import com.ztuo.modules.sys.service.SysUserTokenService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录相关
 *
 * @author gs
 */
@RestController
public class SysLoginController extends AbstractController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private SysCaptchaService sysCaptchaService;

    /**
     * 验证码
     *
     * @param response response
     * @param uuid     uuid
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录
     * @param form 登录表单
     * @return RestResponse
     */
    @SysLog("登录")
    @PostMapping("/sys/login")
    public RestResponse login(@RequestBody SysLoginForm form) {
        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if (!captcha) {
            return RestResponse.error("验证码不正确");
        }

        //用户信息
        SysUserEntity user = sysUserService.queryByUserName(form.getUserName());

        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return RestResponse.error("账号或密码不正确");
        }

        //账号锁定
        if (user.getStatus() == 0) {
            return RestResponse.error("账号已被锁定,请联系管理员");
        }

        //生成token，并保存到数据库
        String token = sysUserTokenService.createToken(user.getUserId());
        AuthenticationToken oauth2Token = new Oauth2Token(token);
        SecurityUtils.getSubject().login(oauth2Token);
        return RestResponse.success().put("token", token).put("expire", Constant.EXPIRE);
    }


    /**
     * 退出系统
     *
     * @return RestResponse
     */
    @PostMapping("/sys/logout")
    public RestResponse logout() {
        sysUserTokenService.logout(getUserId());
        return RestResponse.success();
    }

}
