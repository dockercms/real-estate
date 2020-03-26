package com.ztuo.modules.house.entity;

import lombok.Data;

import java.io.Serializable;

import java.util.Date;  
@Data
public class FavoriteHouse implements Serializable{	

	private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column favorite_house.id
     *
     * @date 2020-03-02 10:01:48
     */  
	private Long id;
	
    /**
     * 房源id
     * This field corresponds to the database column favorite_house.house_id
     *
     * @date 2020-03-02 10:01:48
     */  
	private Long houseId;
	
    /**
     * 会员id
     * This field corresponds to the database column favorite_house.user_id
     *
     * @date 2020-03-02 10:01:48
     */  
	private Long userId;
	
    /**
     * 房源类型 0-新房 1-二手房 2-租房 3-别墅 4-商铺 5-写字楼 6-酒店 7-厂房 8-仓库 9-土地 10-车位
     * This field corresponds to the database column favorite_house.house_type
     *
     * @date 2020-03-02 10:01:48
     */  
	private String houseType;
	
    /**
     * 房源类型 0-汉语 1-维语
     * This field corresponds to the database column favorite_house.language_type
     *
     * @date 2020-03-02 10:01:48
     */  
	private String languageType;
	
    /**
     * 备注
     * This field corresponds to the database column favorite_house.remark
     *
     * @date 2020-03-02 10:01:48
     */  
	private String remark;
	
    /**
     * 创建时间
     * This field corresponds to the database column favorite_house.create_time
     *
     * @date 2020-03-02 10:01:48
     */  
	private Date createTime;

}