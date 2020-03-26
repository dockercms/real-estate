package com.ztuo.modules.house.entity;

import lombok.Data;

import java.io.Serializable;

import java.util.Date;  

@Data
public class BrokerGuest implements Serializable{	

	private static final long serialVersionUID = 1L;

    /**
     * id
     * This field corresponds to the database column broker_guest.id
     *
     * @date 2020-03-05 14:39:15
     */  
	private Long id;
	
    /**
     * 客户姓名
     * This field corresponds to the database column broker_guest.client_name
     *
     * @date 2020-03-05 14:39:15
     */  
	private String clientName;
	
    /**
     * 客户手机号
     * This field corresponds to the database column broker_guest.client_phone
     *
     * @date 2020-03-05 14:39:15
     */  
	private String clientPhone;
	
    /**
     * 区域
     * This field corresponds to the database column broker_guest.house_region
     *
     * @date 2020-03-05 14:39:15
     */  
	private String houseRegion;
	
    /**
     * 城市编码
     * This field corresponds to the database column broker_guest.area_code
     *
     * @date 2020-03-05 14:39:15
     */  
	private String areaCode;
	
    /**
     * 省编码
     * This field corresponds to the database column broker_guest.province_code
     *
     * @date 2020-03-05 14:39:15
     */  
	private String provinceCode;
	
    /**
     * 市编码
     * This field corresponds to the database column broker_guest.city_code
     *
     * @date 2020-03-05 14:39:15
     */  
	private String cityCode;
	
    /**
     * 街道编码
     * This field corresponds to the database column broker_guest.street_code
     *
     * @date 2020-03-05 14:39:15
     */  
	private String streetCode;
	
    /**
     * 金额
     * This field corresponds to the database column broker_guest.price
     *
     * @date 2020-03-05 14:39:15
     */  
	private String price;
	
    /**
     * 面积
     * This field corresponds to the database column broker_guest.house_area
     *
     * @date 2020-03-05 14:39:15
     */  
	private String houseArea;
	
    /**
     * 户型
     * This field corresponds to the database column broker_guest.house_type
     *
     * @date 2020-03-05 14:39:15
     */  
	private String houseType;
	
    /**
     * 楼层
     * This field corresponds to the database column broker_guest.house_floor
     *
     * @date 2020-03-05 14:39:15
     */  
	private String houseFloor;
	
    /**
     * 房屋朝向 0-东 1-西 2-南 3-北 4-南北 5-东西 6-东南 7-西南 8-东北 9-西北
     * This field corresponds to the database column broker_guest.towards
     *
     * @date 2020-03-05 14:39:15
     */  
	private Integer towards;
	
    /**
     * 装修类型 0-毛坯房 1-简装 2-精装修 3-豪装
     * This field corresponds to the database column broker_guest.decoration_type
     *
     * @date 2020-03-05 14:39:15
     */  
	private Integer decorationType;
	
    /**
     * 需求原因
     * This field corresponds to the database column broker_guest.reason_demand
     *
     * @date 2020-03-05 14:39:15
     */  
	private String reasonDemand;
	
    /**
     * 备注
     * This field corresponds to the database column broker_guest.remark
     *
     * @date 2020-03-05 14:39:15
     */  
	private String remark;
	
    /**
     * 0-正常 1-前端删除
     * This field corresponds to the database column broker_guest.record_status
     *
     * @date 2020-03-05 14:39:15
     */  
	private Integer recordStatus;
	
    /**
     * 创建时间
     * This field corresponds to the database column broker_guest.create_time
     *
     * @date 2020-03-05 14:39:15
     */  
	private Date createTime;
	
    /**
     * 更新时间
     * This field corresponds to the database column broker_guest.update_time
     *
     * @date 2020-03-05 14:39:15
     */  
	private Date updateTime;
	
    /**
     * 所属经纪人id
     * This field corresponds to the database column broker_guest.broker_id
     *
     * @date 2020-03-05 14:39:15
     */  
	private Long brokerId;
	

}