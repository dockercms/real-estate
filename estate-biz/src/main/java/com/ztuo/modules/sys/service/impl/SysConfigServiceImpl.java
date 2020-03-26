/*
 * 项目名称:my-museum
 * 类名称:SysConfigServiceImpl.java
 * 包名称:com.platform.modules.sys.service.impl
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    gs      初版完成
 *
 * Copyright (c) 2019-2019
 */
package com.ztuo.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.ztuo.common.exception.BusinessException;
import com.ztuo.common.utils.Constant;
import com.ztuo.common.utils.RedisUtil;
import com.ztuo.common.utils.Query;
import com.ztuo.modules.sys.dao.SysConfigDao;
import com.ztuo.modules.sys.entity.SysConfigEntity;
import com.ztuo.modules.sys.service.SysConfigService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Map;

/**
 * @author gs
 */
@Service("sysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigDao, SysConfigEntity> implements SysConfigService {
    @Autowired
    private RedisUtil redisUtils;

    @Override
    public Page queryPage(Map<String, Object> params) {
        String paramKey = (String) params.get("paramKey");
        Page<SysConfigEntity> page = new Query<SysConfigEntity>(params).getPage();
        return (Page) baseMapper.selectPage(page,
                new QueryWrapper<SysConfigEntity>()
                        .like(StringUtils.isNotBlank(paramKey), "PARAM_KEY", paramKey)
                        .eq("STATUS", 1));
    }

    @Override
    public void add(SysConfigEntity config) {
        this.save(config);
        saveOrUpdateFromRedis(config);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysConfigEntity config) {
        baseMapper.updateById(config);
        saveOrUpdateFromRedis(config);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateValueByKey(String key, String value) {
        baseMapper.updateValueByKey(key, value);
        deleteFromRedis(key);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(String[] ids) {
        for (String id : ids) {
            SysConfigEntity config = this.getById(id);
            deleteFromRedis(config.getParamKey());
        }

        this.removeByIds(Arrays.asList(ids));
    }

    @Override
    public String getValue(String key) {
        SysConfigEntity config = getFromRedis(key);
        if (config == null) {
            config = baseMapper.queryByKey(key);
            saveOrUpdateFromRedis(config);
        }

        return config == null ? null : config.getParamValue();
    }

    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key);
        if (StringUtils.isNotBlank(value)) {
            return new Gson().fromJson(value, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new BusinessException("获取参数失败");
        }
    }

    private void saveOrUpdateFromRedis(SysConfigEntity config) {
        if (config == null) {
            return;
        }
        String key = Constant.SYS_CACHE + config.getParamKey();
        redisUtils.set(key, config);
    }

    private void deleteFromRedis(String configKey) {
        String key = Constant.SYS_CACHE + configKey;
        redisUtils.delete(key);
    }

    private SysConfigEntity getFromRedis(String configKey) {
        String key = Constant.SYS_CACHE + configKey;
        return (SysConfigEntity) redisUtils.get(key);
    }
}
