package com.ztuo.modules.house.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.dao.LastContactDAO;
import com.ztuo.modules.house.entity.LastContact;
import com.ztuo.modules.house.entity.LastContactExample;
import com.ztuo.modules.house.service.ILastContactSV;
import com.ztuo.modules.house.vo.BaseQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LastContactSVImpl implements ILastContactSV {
    
    @Autowired
    private LastContactDAO dao;
    
    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table last_contact
     *
     * @date 2020-02-10 16:50:53
     */
    @Override
    public int countByExample(LastContactExample example) throws Exception {
    		return dao.countByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table last_contact
     *
     * @date 2020-02-10 16:50:53
     */
    @Override
    public int deleteByExample(LastContactExample example) throws Exception {
    		return dao.deleteByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table last_contact
     *
     * @date 2020-02-10 16:50:53
     */
    @Override
    public int deleteByPrimaryKey(Long parameterId) throws Exception {
    		return dao.deleteByPrimaryKey(parameterId);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table last_contact
     *
     * @date 2020-02-10 16:50:53
     */
    @Override
    public int save(LastContact record) throws Exception {
    		return dao.save(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table last_contact
     *
     * @date 2020-02-10 16:50:53
     */
    @Override
    public int saveSelective(LastContact record) throws Exception {
    		return dao.saveSelective(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table last_contact
     *
     * @date 2020-02-10 16:50:53
     */
    @Override
    public List<LastContact> getByExample(LastContactExample example) throws Exception {
    		return dao.getByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table last_contact
     *
     * @date 2020-02-10 16:50:53
     */
    @Override
    public LastContact getByPrimaryKey(Long parameterId) throws Exception {
    		return dao.getByPrimaryKey(parameterId);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table last_contact
     *
     * @date 2020-02-10 16:50:53
     */
    @Override
    public int updateByExampleSelective(LastContact record, LastContactExample example) throws Exception {
    		return dao.updateByExampleSelective(record, example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table last_contact
     *
     * @date 2020-02-10 16:50:53
     */
    @Override
    public int updateByExample(LastContact record, LastContactExample example) throws Exception {
    		return dao.updateByExample(record, example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table last_contact
     *
     * @date 2020-02-10 16:50:53
     */
    @Override
    public int updateByPrimaryKeySelective(LastContact record) throws Exception {
    		return dao.updateByPrimaryKeySelective(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table last_contact
     *
     * @date 2020-02-10 16:50:53
     */
    @Override
    public int updateByPrimaryKey(LastContact record) throws Exception {
    		return dao.updateByPrimaryKey(record);
    }

    @Override
    public Page<LastContact> pageQuery(BaseQueryVo queryVo) {
        Page<LastContact> page = new Page<>(queryVo.getPageNum(),queryVo.getPageSize());
        LastContactExample example = new LastContactExample();
        LastContactExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(queryVo.getUserId());
        example.setOrderByClause(" contract_time desc ");
        List<LastContact> lastContacts = dao.pageQueryByExample(page,example);
        return page.setRecords(lastContacts);
    }

    @Override
    public LastContact findByUserIdAndBrokerId(Long userId, Long brokerId) {
        LastContactExample example = new LastContactExample();
        LastContactExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andBrokerIdEqualTo(brokerId);
        List<LastContact> lastContacts = dao.getByExample(example);
        if(lastContacts!=null && lastContacts.size()==1){
            return lastContacts.get(0);
        }
        return null;
    }
}
