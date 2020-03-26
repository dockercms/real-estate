package com.ztuo.modules.house.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 仓库出租
 * @Date: 2020/2/24 10:58
 * @Version: 1.0
 */
@Data
public class WareHouseRentDTO extends BaseHouseDTO {

    /**
     * 月价
     */
    private BigDecimal monthlyRent;

    /**
     * 租赁方式
     */
    private String leasingMethod;

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
     * 楼层
     */
    private String floornum;

}
