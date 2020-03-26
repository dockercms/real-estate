package com.ztuo.modules.house.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 酒店(旅馆)出售
 * @Date: 2020/2/23 19:50
 * @Version: 1.0
 */
@Data
public class HotelSellDTO extends BaseHouseDTO {

    /**
     * 售价
     */
    private Integer price;

    /**
     * 装修
     */
    private Integer decorationType;

    /**
     * 房间数量
     */
    private String roomNum;

    /**
     * 层数
     */
    private String floornum;

    /**
     * 建造时间
     */
    private Date buildTime;

    /**
     * 停车位
     */
    private String parkingSpace;

    /**
     * 年代
     */
    private Date buildYear;

}
