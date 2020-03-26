package com.ztuo.modules.house.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 仓库转让
 * @Date: 2020/2/24 11:03
 * @Version: 1.0
 */
@Data
public class WareHouseTransferDTO extends BaseHouseDTO {

    /**
     * 月价格
     */
    private BigDecimal monthlyRent;

    /**
     * 转让价格
     */
    private Integer transferPrice;

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

    /**
     * 剩余租期
     */
    private String remainingLease;


}
