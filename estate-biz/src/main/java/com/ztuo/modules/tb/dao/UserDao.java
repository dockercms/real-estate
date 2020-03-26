/*
 * 项目名称:my-museum
 * 类名称:UserDao.java
 * 包名称:com.platform.modules.app.dao
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.modules.tb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztuo.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author gs
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
