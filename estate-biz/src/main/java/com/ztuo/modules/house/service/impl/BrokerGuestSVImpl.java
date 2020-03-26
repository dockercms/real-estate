package com.ztuo.modules.house.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.common.utils.DateUtil;
import com.ztuo.modules.house.dao.BrokerGuestDAO;
import com.ztuo.modules.house.entity.BrokerGuest;
import com.ztuo.modules.house.entity.BrokerGuestExample;
import com.ztuo.modules.house.service.IBrokerGuestSV;
import com.ztuo.modules.house.vo.BaseQueryVo;
import com.ztuo.modules.house.vo.BrokerGuestVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BrokerGuestSVImpl implements IBrokerGuestSV {
    
    @Autowired
    private BrokerGuestDAO dao;
    
    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table broker_guest
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int countByExample(BrokerGuestExample example) throws Exception {
    		return dao.countByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table broker_guest
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int deleteByExample(BrokerGuestExample example) throws Exception {
    		return dao.deleteByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table broker_guest
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int deleteByPrimaryKey(Long parameterId) throws Exception {
    		return dao.deleteByPrimaryKey(parameterId);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table broker_guest
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int save(BrokerGuest record) throws Exception {
    		return dao.save(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table broker_guest
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int saveSelective(BrokerGuest record) throws Exception {
    		return dao.saveSelective(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table broker_guest
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public List<BrokerGuest> getByExample(BrokerGuestExample example) throws Exception {
    		return dao.getByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table broker_guest
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public BrokerGuest getByPrimaryKey(Long parameterId) throws Exception {
    		return dao.getByPrimaryKey(parameterId);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table broker_guest
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int updateByExampleSelective(BrokerGuest record, BrokerGuestExample example) throws Exception {
    		return dao.updateByExampleSelective(record, example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table broker_guest
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int updateByExample(BrokerGuest record, BrokerGuestExample example) throws Exception {
    		return dao.updateByExample(record, example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table broker_guest
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int updateByPrimaryKeySelective(BrokerGuest record) throws Exception {
    		return dao.updateByPrimaryKeySelective(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table broker_guest
     *
     * @date 2020-02-11 10:05:12
     */
    @Override
    public int updateByPrimaryKey(BrokerGuest record) throws Exception {
    		return dao.updateByPrimaryKey(record);
    }

    @Override
    public Page<BrokerGuest> pageQuery(BrokerGuestVo queryVo, Map<String, Object> params) throws Exception{
        Page<BrokerGuest> page = new Page<>(queryVo.getPageNum(),queryVo.getPageSize());
        BrokerGuestExample example = new BrokerGuestExample();
        BrokerGuestExample.Criteria criteria = example.createCriteria();
        if(queryVo.getUserId()!=null){
            criteria.andBrokerIdEqualTo(queryVo.getUserId());
        }
        if (StringUtils.isNotEmpty(queryVo.getStatus())){
            criteria.andRecordStatusEqualTo(Integer.parseInt(queryVo.getStatus()));
        }
        if(StringUtils.isNotEmpty(queryVo.getClientName())){
            criteria.andClientNameLike("%"+queryVo.getClientName()+"%");
        }
        if(StringUtils.isNotEmpty(queryVo.getClientPhone())){
            criteria.andClientPhoneEqualTo(queryVo.getClientPhone());
        }
        if(StringUtils.isNotEmpty(queryVo.getHouseRegion())){
            criteria.andHouseRegionEqualTo(queryVo.getHouseRegion());
        }
        if(StringUtils.isNotEmpty(queryVo.getCreateStartTime())){
            criteria.andCreateTimeGreaterThan(DateUtil.YYYY_MM_DD_MM_HH_SS.parse(queryVo.getCreateStartTime()));
        }
        if(StringUtils.isNotEmpty(queryVo.getCreateEndTime())){
            criteria.andCreateTimeLessThan(DateUtil.YYYY_MM_DD_MM_HH_SS.parse(queryVo.getCreateEndTime()));
        }
        if(StringUtils.isNotEmpty(queryVo.getBrokerId())){
            criteria.andBrokerIdEqualTo(Long.parseLong(queryVo.getBrokerId()));
        }
        example.setOrderByClause("create_time desc");
        List<BrokerGuest> list =  dao.pageQueryByExample(page,example,params);
        return page.setRecords(list);
    }
}
