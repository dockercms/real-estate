/*
 * 项目名称:platform-boot
 * 类名称:AppLoginController.java
 * 包名称:com.platform.modules.app.controller
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.modules.app.controller.other;

import com.ztuo.common.utils.JwtUtils;
import com.ztuo.common.utils.RestResponse;
import com.ztuo.modules.app.annotation.IgnoreAuth;
import com.ztuo.modules.app.entity.UserEntity;
import com.ztuo.modules.tb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * APP登录授权
 *
 * @author gs
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app")
@Api(tags = "AppLoginController|APP登录接口")
public class AppLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 用户名密码登录
     *
     * @param mobile   手机号
     * @param password 密码
     * @return RestResponse
     */
    @IgnoreAuth
    @PostMapping("login")
    @ApiOperation(value = "登录", notes = "根据手机号密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobile", value = "手机号", required = true, dataType = "string", example = "15209831990"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "string", example = "admin")
    })
    public RestResponse login(String mobile, String password) {

        //用户登录
        String userId = userService.login(mobile, password);

        //生成token
        String token = jwtUtils.generateToken(userId);

        Map<String, Object> map = new HashMap<>(4);
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        return RestResponse.success(map);
    }

    /**
     * 根据openId换取登录token，方便本地开发调试
     *
     * @param openId openId
     * @return RestResponse
     */
    @IgnoreAuth
    @PostMapping("loginByOpenId")
    @ApiOperation(value = "openId换取登录token", notes = "根据openId换取登录token，方便本地开发调试")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "openId", value = "openId", required = true, dataType = "string", example = "oxaA11ulr9134oBL9Xscon5at_Gc")
    })
    public RestResponse loginByOpenId(String openId) {

        //生成token
        String token = jwtUtils.generateToken(openId);
        UserEntity user = userService.selectByOpenId(openId);

        Map<String, Object> map = new HashMap<>(8);
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());
        map.put("openId", openId);
        map.put("user", user);

        return RestResponse.success(map);
    }
}
