package com.ztuo.modules.house.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.UygurUserHouse;
import com.ztuo.modules.house.entity.UygurUserHouseExample;
import com.ztuo.modules.house.vo.UserHouseQuery;

import java.util.List;

public interface IUygurUserHouseSV {
    
    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table uygur_user_house
     *
     * @date 2020-02-10 16:50:53
     */
    int countByExample(UygurUserHouseExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table uygur_user_house
     *
     * @date 2020-02-10 16:50:53
     */
    int deleteByExample(UygurUserHouseExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table uygur_user_house
     *
     * @date 2020-02-10 16:50:53
     */
    int deleteByPrimaryKey(Long parameterId) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table uygur_user_house
     *
     * @date 2020-02-10 16:50:53
     */
    int save(UygurUserHouse record) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table uygur_user_house
     *
     * @date 2020-02-10 16:50:53
     */
    int saveSelective(UygurUserHouse record) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table uygur_user_house
     *
     * @date 2020-02-10 16:50:53
     */
    List<UygurUserHouse> getByExample(UygurUserHouseExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table uygur_user_house
     *
     * @date 2020-02-10 16:50:53
     */
    UygurUserHouse getByPrimaryKey(Long parameterId) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table uygur_user_house
     *
     * @date 2020-02-10 16:50:53
     */
    int updateByExampleSelective(UygurUserHouse record, UygurUserHouseExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table uygur_user_house
     *
     * @date 2020-02-10 16:50:53
     */
    int updateByExample(UygurUserHouse record, UygurUserHouseExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table uygur_user_house
     *
     * @date 2020-02-10 16:50:53
     */
    int updateByPrimaryKeySelective(UygurUserHouse record) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table uygur_user_house
     *
     * @date 2020-02-10 16:50:53
     */
    int updateByPrimaryKey(UygurUserHouse record) throws Exception;

    Page<UygurUserHouse> pageQuery(UserHouseQuery houseQuery) throws Exception;

    UygurUserHouse findBySingLabel(String signLabel);
}