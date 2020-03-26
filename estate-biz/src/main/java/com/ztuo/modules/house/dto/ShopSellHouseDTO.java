package com.ztuo.modules.house.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 商铺出售
 * @Date: 2020/2/23 16:07
 * @Version: 1.0
 */
@Data
public class ShopSellHouseDTO extends BaseHouseDTO {

    /**
     * 年代
     */
    private Date buildYear;

    /**
     * 楼层信息
     */
    private String floorInformation;

    /**
     * 规格宽度
     */
    private String specificationWidth;

    /**
     * 规格高度
     */
    private String specificationHeight;

    /**
     * 经营状态
     */
    private Integer operatingStatus;

    /**
     * 经营项目
     */
    private String operatingItem;

    /**
     * 估值
     */
    private String valuation;

    /**
     * 售价
     */
    private Integer price;

    /**
     * 相关费用
     */
    private String relatedCost;

    /**
     * 房源特色
     */
    private String listingFeaturesIds;

    /**
     * 物业类型
     */
    private String propertyType;


    /**
     * 置顶 0-否 1-是
     */
    private String sticky;

}
