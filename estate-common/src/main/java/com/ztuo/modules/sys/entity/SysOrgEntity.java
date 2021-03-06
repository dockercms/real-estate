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

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ztuo.common.validator.group.AddGroup;
import com.ztuo.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 组织机构实体
 * 表名 sys_org
 *
 * @author gs
 * @date 2019-01-21 11:29:22
 */
@Data
@TableName("SYS_ORG")
public class SysOrgEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 机构编码
     */
    @TableId
    private String orgNo;
    /**
     * 机构名称
     */
    @NotBlank(message = "机构名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String orgName;

    @NotBlank(message = "维语名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String orgNameWy;
    /**
     * 上级机构ID，一级机构为0
     */
    @NotBlank(message = "上级机构不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String parentNo;
    /**
     * 级别
     */
    @NotNull(message = "机构级别不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Integer orgType;
    /**
     * 状态  0：无效   1：有效
     */
    private Integer status;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 创建者ID
     */
    private String createUserId;
    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private String parentName;
}
