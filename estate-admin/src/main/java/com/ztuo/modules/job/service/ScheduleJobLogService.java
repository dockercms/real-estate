/*
 * 项目名称:my-museum
 * 类名称:ScheduleJobLogService.java
 * 包名称:com.platform.modules.job.service
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.modules.job.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ztuo.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author gs
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

    /**
     * 获取分页数据
     *
     * @param params 查询参数
     * @return Page
     */
    Page queryPage(Map<String, Object> params);

}
