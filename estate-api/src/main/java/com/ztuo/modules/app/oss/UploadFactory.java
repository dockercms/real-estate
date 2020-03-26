/*
 * 项目名称:my-museum
 * 类名称:SysOssController.java
 * 包名称:com.platform.modules.oss.controller
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2019/1/17 16:21    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.modules.app.oss;


import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.SpringContextUtils;
import com.ztuo.modules.sys.service.SysConfigService;

/**
 * 文件上传Factory
 *
 * @author gs
 * @date 2019-01-17 16:21:01
 */
public final class UploadFactory {
    private static SysConfigService sysConfigService;

    static {
        UploadFactory.sysConfigService = (SysConfigService) SpringContextUtils.getBean("sysConfigService");
    }

    public static AbstractCloudStorageService build() {
        //获取云存储配置信息
        CloudStorageConfig config = sysConfigService.getConfigObject(Constant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if (config.getType() == Constant.CloudService.ALIYUN.getValue()) {
            return new AliyunCloudStorageService(config);
        }

        return null;
    }

}
