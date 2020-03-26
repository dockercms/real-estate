package com.ztuo.modules.house.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 写字楼出售
 * @Date: 2020/2/23 18:36
 * @Version: 1.0
 */
@Data
public class OfficeSellHouseDTO extends BaseHouseDTO {

    /**
     * 年代
     */
    private Date buildYear;

    /**
     * 售价
     */
    private Integer price;

    /**
     * 装修
     */
    private Integer decorationType;

    /**
     * 楼盘名称
     */
    private String propertyName;

    /**
     * 物业费
     */
    private String propertyCost;

    /**
     * 房源特色
     */
    private String listingFeaturesIds;

    /**
     * 物业类型
     */
    private String propertyType;

    /**
     * 建筑等级
     */
    private String buildingGrade;

    /**
     * 使用率
     */
    private String usageRate;

}
