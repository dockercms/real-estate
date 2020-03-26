/*
 * 项目名称:my-museum
 * 类名称:SysLogDao.java
 * 包名称:com.platform.modules.sys.dao
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-01-22 10:36:49        gs     初版做成
 *
 * Copyright (c) 2018-2019
 */
package com.ztuo.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztuo.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志Dao
 *
 * @author gs
 * @date 2019-01-22 10:36:49
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {

}
