/*
 * 项目名称:my-museum
 * 类名称:SysRoleMenuEntity.java
 * 包名称:com.platform.modules.sys.entity
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色与菜单对应关系
 *
 * @author gs
 */
@Data
@TableName("SYS_ROLE_MENU")
public class SysRoleMenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 菜单ID
     */
    private String menuId;

}
