/*
 * 项目名称:my-museum
 * 类名称:SysOrgServiceImpl.java
 * 包名称:com.platform.modules.sys.service.impl
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-01-21 11:29:22        gs     初版做成
 *
 * Copyright (c) 2018-2019
 */
package com.ztuo.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztuo.common.utils.StringUtils;
import com.ztuo.modules.sys.dao.SysOrgDao;
import com.ztuo.modules.sys.dao.SysOrgTranDao;
import com.ztuo.modules.sys.entity.SysOrgEntity;
import com.ztuo.modules.sys.service.SysOrgService;
import com.ztuo.modules.sys.service.SysOrgTranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 组织机构Service实现类
 *
 * @author gs
 * @date 2019-01-21 11:29:22
 */
@Service("sysOrgTranService")
public class SysOrgTranServiceImpl extends ServiceImpl<SysOrgTranDao, SysOrgEntity> implements SysOrgTranService {

    @Autowired
    private SysOrgTranDao dao;

    @Override
    public List<SysOrgEntity> getArea(String parentCode,Integer level) {
        return dao.getArea(parentCode,level);
    }
}
