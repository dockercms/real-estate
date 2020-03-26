package com.ztuo.modules.house.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 厂房出租
 * @Date: 2020/2/23 20:05
 * @Version: 1.0
 */
@Data
public class WorkShopRentDTO extends BaseHouseDTO {

    /**
     * 租赁方式
     */
    private String leasingMethod;

    /**
     * 价格
     */
    private BigDecimal monthlyRent;

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

}
