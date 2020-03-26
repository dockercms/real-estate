package com.ztuo.modules.house.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 车位转让
 * @Date: 2020/2/24 11:29
 * @Version: 1.0
 */
@Data
public class ParkingSpaceTransferDTO extends BaseHouseDTO {


    /**
     * 转让价格
     */
    private Integer transferPrice;

    /**
     * 剩余租期
     */
    private String remainingLease;

    /**
     * 车位类型
     */
    private String parkingCategory;

    /**
     * 月租金
     */
    private String monthlyRent;

    /**
     * 经营项目
     */
    private String operatingItem;

    /**
     * 规格高度
     */
    private String specificationHeight;

    /**
     * 建造年代
     */
    private Date buildYear;


}
