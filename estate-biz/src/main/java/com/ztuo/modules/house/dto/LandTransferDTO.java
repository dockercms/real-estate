package com.ztuo.modules.house.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 土地转让
 * @Date: 2020/2/24 11:11
 * @Version: 1.0
 */
@Data
public class LandTransferDTO extends BaseHouseDTO {

    /**
     * 转让价格
     */
    private Integer transferPrice;

    /**
     * 主权
     */
    private String landSovereignty;

    /**
     * 使用计划
     */
    private String usePlan;

    /**
     * 剩余租期
     */
    private String remainingLease;

    /**
     * 年代
     */
    private Date buildYear;

}
