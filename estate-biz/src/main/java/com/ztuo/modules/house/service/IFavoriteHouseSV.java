package com.ztuo.modules.house.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztuo.modules.house.entity.FavoriteHouse;
import com.ztuo.modules.house.entity.FavoriteHouseExample;
import com.ztuo.modules.house.vo.FavoriteHouseQuery;

import java.util.List;

public interface IFavoriteHouseSV {
    
    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table favorite_house
     *
     * @date 2020-02-10 16:50:53
     */
    int countByExample(FavoriteHouseExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table favorite_house
     *
     * @date 2020-02-10 16:50:53
     */
    int deleteByExample(FavoriteHouseExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table favorite_house
     *
     * @date 2020-02-10 16:50:53
     */
    int deleteByPrimaryKey(Long parameterId) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table favorite_house
     *
     * @date 2020-02-10 16:50:53
     */
    int save(FavoriteHouse record) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table favorite_house
     *
     * @date 2020-02-10 16:50:53
     */
    int saveSelective(FavoriteHouse record) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table favorite_house
     *
     * @date 2020-02-10 16:50:53
     */
    List<FavoriteHouse> getByExample(FavoriteHouseExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table favorite_house
     *
     * @date 2020-02-10 16:50:53
     */
    FavoriteHouse getByPrimaryKey(Long parameterId) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table favorite_house
     *
     * @date 2020-02-10 16:50:53
     */
    int updateByExampleSelective(FavoriteHouse record, FavoriteHouseExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table favorite_house
     *
     * @date 2020-02-10 16:50:53
     */
    int updateByExample(FavoriteHouse record, FavoriteHouseExample example) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table favorite_house
     *
     * @date 2020-02-10 16:50:53
     */
    int updateByPrimaryKeySelective(FavoriteHouse record) throws Exception;

    /**
     * This method was generated by IDE Plugin.
     * This method corresponds to the database table favorite_house
     *
     * @date 2020-02-10 16:50:53
     */
    int updateByPrimaryKey(FavoriteHouse record) throws Exception;

    Page<Object> pageQueryFavoriteHouse(FavoriteHouseQuery queryVo);

    int deleteByConditions(FavoriteHouse favoriteHouse);

    FavoriteHouse findHouseStatus(String userId, Long houseId, String language);
}