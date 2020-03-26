package com.ztuo.modules.house.dto;

import lombok.Data;

/**
 * @Author: dupinyan
 * @Description: 车位出售
 * @Date: 2020/2/24 11:32
 * @Version: 1.0
 */
@Data
public class ParkingSpaceSellDTO extends BaseHouseDTO {

    /**
     * 价格
     */
    private Integer price;

    /**
     * 月价
     */
    private String monthlyRent;

    /**
     * 每平方价格
     */
    private String squarePrice;

    /**
     * 预付的车位类型
     */
    private String truckSpaceType;

}
