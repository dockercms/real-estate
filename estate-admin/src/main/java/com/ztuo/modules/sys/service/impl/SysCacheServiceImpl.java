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

import com.alibaba.fastjson.JSONObject;
import com.ztuo.common.utils.RedisUtil;
import com.ztuo.modules.sys.entity.SysCacheEntity;
import com.ztuo.modules.sys.service.SysCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author gs
 */
@Service("sysCacheService")
public class SysCacheServiceImpl implements SysCacheService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<SysCacheEntity> queryAll(Map<String, String> params) {
        SysCacheEntity sysCacheEntity;
        List<SysCacheEntity> result = new ArrayList<>();

        String pattern = params.get("pattern");
        // 获取所有key
        Set<String> keySet = redisUtil.keys(pattern);
        for (String key : keySet) {
            sysCacheEntity = new SysCacheEntity();
            sysCacheEntity.setCacheKey(key);
            try {
                sysCacheEntity.setValue(JSONObject.toJSON(redisUtil.get(key)).toString());
            } catch (Exception e) {
                sysCacheEntity.setValue("");
            }
            sysCacheEntity.setSeconds(redisUtil.ttl(key));
            result.add(sysCacheEntity);
        }
        return result;
    }

    @Override
    public int deleteBatch(String[] keys) {
        for (String key : keys) {
            redisUtil.delete(key);
        }
        return keys.length;
    }
}
