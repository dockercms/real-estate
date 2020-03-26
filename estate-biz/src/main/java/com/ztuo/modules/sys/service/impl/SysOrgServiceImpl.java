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
import com.ztuo.modules.house.dto.SysOrgDTO;
import com.ztuo.modules.house.entity.HouseCountExample;
import com.ztuo.modules.house.service.IHouseCountSV;
import com.ztuo.modules.sys.dao.SysOrgDao;
import com.ztuo.modules.sys.entity.SysOrgEntity;
import com.ztuo.modules.sys.entity.SysOrgVO;
import com.ztuo.modules.sys.service.SysOrgService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service("sysOrgService")
public class SysOrgServiceImpl extends ServiceImpl<SysOrgDao, SysOrgEntity> implements SysOrgService {


    @Autowired
    private SysOrgDao dao;

    @Autowired
    private IHouseCountSV houseCountSV;

    @Override
    public List<SysOrgEntity> queryAll(Map<String, Object> params) {
        return baseMapper.queryAll(params);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysOrgEntity sysOrg) {

        String parentNo = sysOrg.getParentNo();

        String maxId = baseMapper.queryMaxIdByParentNo(parentNo);
        String orgNo = StringUtils.addOne(parentNo, maxId);
        sysOrg.setOrgNo(orgNo);

        int orgType = getOrgType(orgNo);
        sysOrg.setOrgType(orgType);
        sysOrg.setCreateTime(new Date());

        baseMapper.insert(sysOrg);
        //如果是第三级类型同时新增区域数量汇总表
        int result = houseCountSV.saveByOrg(sysOrg);
        log.info("----保存houseCount结果:"+result);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysOrgEntity sysOrg) {
        String orgNo = sysOrg.getOrgNo();

        int orgType = getOrgType(orgNo);
        sysOrg.setOrgType(orgType);

        this.updateById(sysOrg);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String orgNo) {
        this.removeById(orgNo);
        //删除房屋汇总houseCount
        HouseCountExample example = new HouseCountExample();
        HouseCountExample.Criteria criteria = example.createCriteria();
        criteria.andAreaCodeEqualTo(orgNo);
        try {
            int result = houseCountSV.deleteByExample(example);
            log.info("----删除houseCount结果result={}",result);
        } catch (Exception e) {
            log.info("----删除houseCount异常e={}",e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(String[] orgNos) {
        this.removeByIds(Arrays.asList(orgNos));
    }

    @Override
    public List<SysOrgEntity> queryListByOrgNo(String orgNo) {
        return baseMapper.selectChildrensByOrgNo(orgNo);
    }

    @Override
    public List<SysOrgVO> getArea(String parentCode, Integer level) {
        return dao.getArea(parentCode,level);
    }

    @Override
    public List<SysOrgVO> getAreaWy(String parentCode, Integer level) {
        return dao.getAreaWy(parentCode,level);
    }

    @Override
    public SysOrgEntity getByOrgNo(String orgNo) {
        return dao.getByOrgNo(orgNo);
    }

    @Override
    public List<SysOrgDTO> getAreaAll(String parentCode, Integer level) {
        return dao.getAreaAll(parentCode, level);
    }

    private int getOrgType(String orgNo) {
        int two = 2;
        int four = 4;
        int six = 6;
        int egight = 8;
        int ten = 10;
        int level = 0;

        if (orgNo.length() == two) {
            level = 1;
        } else if (orgNo.length() == four) {
            level = 2;
        } else if (orgNo.length() == six) {
            level = 3;
        } else if (orgNo.length() == egight) {
            level = 4;
        } else if (orgNo.length() == ten) {
            level = 5;
        }

        return level;
    }
}
