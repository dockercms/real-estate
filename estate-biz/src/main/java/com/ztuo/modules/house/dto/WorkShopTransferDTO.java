package com.ztuo.modules.house.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 厂房转让
 * @Date: 2020/2/24 10:35
 * @Version: 1.0
 */
@Data
public class WorkShopTransferDTO extends BaseHouseDTO {

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

    /**
     * 楼层
     */
    private String floorInformation;

    /**
     * 楼层高度
     */
    private String specificationHeight;

    /**
     * 年代
     */
    private Date buildYear;


}
