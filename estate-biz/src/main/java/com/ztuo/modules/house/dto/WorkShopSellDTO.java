package com.ztuo.modules.house.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 厂房出售
 * @Date: 2020/2/24 10:52
 * @Version: 1.0
 */
@Data
public class WorkShopSellDTO extends BaseHouseDTO {

    /**
     * 价格
     */
    private String price;

    /**
     * 首付
     */
    private String downPayment;

    /**
     * 楼层
     */
    private String floorInformation;

    /**
     * 楼高
     */
    private String specificationHeight;

    /**
     * 年代
     */
    private Date buildYear;

}
