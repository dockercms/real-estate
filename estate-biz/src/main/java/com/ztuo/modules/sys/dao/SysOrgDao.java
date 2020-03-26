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
import com.ztuo.modules.house.dto.SysOrgDTO;
import com.ztuo.modules.sys.entity.SysOrgEntity;
import com.ztuo.modules.sys.entity.SysOrgVO;
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
public interface SysOrgDao extends BaseMapper<SysOrgEntity> {

    /**
     * 查询存在的最大ID
     *
     * @param orgNo 机构编码
     * @return String
     */
    String queryMaxIdByParentNo(String orgNo);

    /**
     * 查询所有列表
     *
     * @param params 查询参数
     * @return List
     */
    List<SysOrgEntity> queryAll(Map<String, Object> params);

    /**
     * 根据orgNo查询所有下级列表
     *
     * @param orgNo 机构编码
     * @return List
     */
    List<SysOrgEntity> selectChildrensByOrgNo(String orgNo);

    List<SysOrgVO> getArea(@Param("parentNo") String parentNo, @Param("orgType")Integer orgType);

    List<SysOrgVO> getAreaWy(@Param("parentNo") String parentNo, @Param("orgType")Integer orgType);

    SysOrgEntity getByOrgNo(@Param("orgNo")String orgNo);

    List<SysOrgDTO> getAreaAll(@Param("parentNo") String parentNo, @Param("orgType")Integer orgType);

}
