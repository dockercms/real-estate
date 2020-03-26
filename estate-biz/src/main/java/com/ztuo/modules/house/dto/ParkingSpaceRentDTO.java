package com.ztuo.modules.house.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: dupinyan
 * @Description: 车位出租
 * @Date: 2020/2/24 11:13
 * @Version: 1.0
 */
@Data
public class ParkingSpaceRentDTO extends BaseHouseDTO {

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

}
