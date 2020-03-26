package com.ztuo.modules.house.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: dupinyan
 * @Description: 车位
 * @Date: 2020/3/5 11:33
 * @Version: 1.0
 */
@Data
public class ParkingSpaceDTO extends BaseHouseDTO {

    /**
     * 月价
     */
    private BigDecimal monthlyRent;

    /**
     * 日价
     */
    private BigDecimal dayRent;

    /**
     * 租期
     */
    private String leaseTerm;

    /**
     * 车位类别
     */
    private String parkingCategory;

    /**
     * 配套
     */
    private String supportingIds;

    /**
     * 价格
     */
    private String price;

    /**
     * 每平方价格
     */
    private String squarePrice;

    /**
     * 预付的车位类型
     */
    private String truckSpaceType;

    /**
     * 转让价格
     */
    private Integer transferPrice;

    /**
     * 剩余租期
     */
    private String remainingLease;


}
