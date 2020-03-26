/*
 * 项目名称:my-museum
 * 类名称:SysCaptchaService.java
 * 包名称:com.platform.modules.sys.service
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztuo.modules.sys.entity.SysCaptchaEntity;

import java.awt.image.BufferedImage;

/**
 * 验证码
 *
 * @author gs
 */
public interface SysCaptchaService extends IService<SysCaptchaEntity> {
    /**
     * 获取图片验证码
     *
     * @param uuid uuid
     * @return BufferedImage
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码效验
     *
     * @param uuid uuid
     * @param code code
     * @return 校验结果
     */
    boolean validate(String uuid, String code);
}
