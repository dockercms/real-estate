/*
 * 项目名称:my-museum
 * 类名称:SysOrgService.java
 * 包名称:com.platform.modules.sys.service
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-01-21 11:29:22        gs     初版做成
 *
 * Copyright (c) 2018-2019
 */
package com.ztuo.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztuo.modules.sys.entity.SysOrgEntity;

import java.util.List;
import java.util.Map;

/**
 * 组织机构Service接口
 *
 * @author gs
 * @date 2019-01-21 11:29:22
 */
public interface SysOrgTranService extends IService<SysOrgEntity> {

    List<SysOrgEntity> getArea(String parentCode,Integer level);
}
