package com.ztuo.modules.house.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 厂房
 * @Date: 2020/3/5 11:29
 * @Version: 1.0
 */
@Data
public class WorkShopDTO extends BaseHouseDTO {

    /**
     * 租赁方式
     */
    private String leasingMethod;

    /**
     * 厂房 楼层
     */
    private String floornum;

    /**
     * 租期
     */
    private String leaseTerm;

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

    /**
     * 配套
     */
    private String supportingIds;

    /**
     * 价格
     */
    private String price;

    /**
     * 首付
     */
    private String downPayment;


    /**
     * 月价格
     */
    private BigDecimal monthlyRent;

    /**
     * 转让价格
     */
    private Integer transferPrice;

    /**
     * 项目
     */
    private String operatingItem;

    /**
     * 剩余租期
     */
    private String remainingLease;


}
