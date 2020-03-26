/*
 * 项目名称:my-museum
 * 类名称:SysOrgDao.java
 * 包名称:com.platform.modules.sys.dao
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-01-22 11:11:13        gs     初版做成
 *
 * Copyright (c) 2018-2019
 */
package com.ztuo.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztuo.modules.sys.entity.SysOrgEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 组织机构Dao
 *
 * @author gs
 * @date 2019-01-22 11:11:13
 */
@Mapper
public interface SysOrgTranDao extends BaseMapper<SysOrgEntity> {


    List<SysOrgEntity> getArea(@Param("parentNo") String parentNo, @Param("orgType")Integer orgType);
}
