package com.ztuo.modules.house.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 旅馆
 * @Date: 2020/3/5 11:28
 * @Version: 1.0
 */
@Data
public class HotelDTO extends BaseHouseDTO {

    /**
     * 月租金
     */
    private BigDecimal monthlyRent;

    /**
     * 年租金
     */
    private BigDecimal annualRent;

    /**
     * 租赁方式
     */
    private String leasingMethod;

    /**
     * 住宿数量
     */
    private String roomNum;

    /**
     * 装修层数
     */
    private String decorationFloor;

    /**
     * 停车位
     */
    private String parkingSpace;

    /**
     * 建造时间
     */
    private Date buildTime;

    /**
     * 年代
     */
    private Date buildYear;

    /**
     * 配套
     */
    private String supportingIds;

    /**
     * 售价
     */
    private Integer price;

    /**
     * 装修
     */
    private Integer decorationType;


    /**
     * 层数
     */
    private String floornum;


}
