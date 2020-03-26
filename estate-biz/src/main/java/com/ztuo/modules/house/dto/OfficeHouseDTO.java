package com.ztuo.modules.house.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 写字楼
 * @Date: 2020/3/5 11:26
 * @Version: 1.0
 */
@Data
public class OfficeHouseDTO extends BaseHouseDTO {

    /**
     * 年代
     */
    private Date buildYear;

    /**
     * 建筑等级
     */
    private String buildingGrade;

    /**
     * 使用率
     */
    private String usageRate;


    /**
     * 日价格
     */
    private BigDecimal dayRent;

    /**
     * 月价
     */
    private BigDecimal monthlyRent;

    /**
     * 租期
     */
    private String leaseTerm;

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
     * 售价
     */
    private Integer price;


}
