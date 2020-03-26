package com.ztuo.modules.house.dto;

import lombok.Data;

/**
 * @Author: dupinyan
 * @Description: 仓库出售
 * @Date: 2020/2/24 11:07
 * @Version: 1.0
 */
@Data
public class WareHouseSellDTO extends BaseHouseDTO {

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
    private String buildYear;

}
