/*
 * 项目名称:my-museum
 * 类名称:SysOrgEntity.java
 * 包名称:com.platform.modules.sys.entity
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-01-21 11:29:22        gs     初版做成
 *
 * Copyright (c) 2018-2019
 */
package com.ztuo.modules.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 组织机构实体
 * 表名 sys_org
 *
 * @author gs
 * @date 2019-01-21 11:29:22
 */
@Data
public class SysOrgVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 机构编码
     */
    private String orgNo;
    /**
     * 机构名称
     */
    private String orgName;


    private List<SysOrgVO> orgEntityList;


}
