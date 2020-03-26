/*
 * 项目名称:my-museum
 * 类名称:UserService.java
 * 包名称:com.platform.modules.app.service
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.modules.tb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztuo.modules.app.entity.UserEntity;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 用户service
 *
 * @author gs
 */
public interface UserService extends IService<UserEntity> {

    /**
     * queryByMobile
     *
     * @param mobile 手机号
     * @return UserEntity
     */
    UserEntity queryByMobile(String mobile);

    /**
     * 登录
     *
     * @param mobile   手机号
     * @param password 密码
     * @return String
     */
    String login(String mobile, String password);

    /**
     * 根据openId获取用户
     *
     * @param openId openId
     * @return UserEntity
     */
    UserEntity selectByOpenId(String openId);

    /**
     * 新增或者修改
     *
     * @param user user
     * @return UserEntity
     */
    UserEntity saveOrUpdateByOpenId(WxMpUser user);
}
