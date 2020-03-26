package com.ztuo.modules.house.service.impl;

import com.ztuo.modules.house.dao.EstateUserDAO;
import com.ztuo.modules.house.entity.EstateUser;
import com.ztuo.modules.house.entity.EstateUserExample;
import com.ztuo.modules.house.service.IEstateUserSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateUserSVImpl implements IEstateUserSV {
    
    @Autowired
    private EstateUserDAO dao;
    
    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table estate_user
     *
     * @date 2020-02-11 10:05:12
     */
    public int countByExample(EstateUserExample example) throws Exception {
    		return dao.countByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table estate_user
     *
     * @date 2020-02-11 10:05:12
     */
    public int deleteByExample(EstateUserExample example) throws Exception {
    		return dao.deleteByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table estate_user
     *
     * @date 2020-02-11 10:05:12
     */
    public int deleteByPrimaryKey(Long parameterId) throws Exception {
    		return dao.deleteByPrimaryKey(parameterId);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table estate_user
     *
     * @date 2020-02-11 10:05:12
     */
    public int save(EstateUser record) throws Exception {
    		return dao.save(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table estate_user
     *
     * @date 2020-02-11 10:05:12
     */
    public int saveSelective(EstateUser record) throws Exception {
    		return dao.saveSelective(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table estate_user
     *
     * @date 2020-02-11 10:05:12
     */
    public List<EstateUser> getByExample(EstateUserExample example) throws Exception {
    		return dao.getByExample(example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table estate_user
     *
     * @date 2020-02-11 10:05:12
     */
    public EstateUser getByPrimaryKey(Long parameterId) throws Exception {
    		return dao.getByPrimaryKey(parameterId);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table estate_user
     *
     * @date 2020-02-11 10:05:12
     */
    public int updateByExampleSelective(EstateUser record, EstateUserExample example) throws Exception {
    		return dao.updateByExampleSelective(record, example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table estate_user
     *
     * @date 2020-02-11 10:05:12
     */
    public int updateByExample(EstateUser record, EstateUserExample example) throws Exception {
    		return dao.updateByExample(record, example);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table estate_user
     *
     * @date 2020-02-11 10:05:12
     */
    public int updateByPrimaryKeySelective(EstateUser record) throws Exception {
    		return dao.updateByPrimaryKeySelective(record);
    }

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table estate_user
     *
     * @date 2020-02-11 10:05:12
     */
    public int updateByPrimaryKey(EstateUser record) throws Exception {
    		return dao.updateByPrimaryKey(record);
    }

    /**
     * 根据手机号查询用户
     * @param mobilePhone
     * @return
     */
    @Override
    public EstateUser getByPhone(String mobilePhone) {
        return dao.getUserByPhone(mobilePhone);
    }
}