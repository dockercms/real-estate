package com.ztuo.modules.house.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 租房
 * @Date: 2020/2/23 11:22
 * @Version: 1.0
 */
@Data
public class RentHouseDTO extends BaseHouseDTO {

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 租房类型 0-整租 1-合租
     */
    private Integer rentalType;

    /**
     * 门牌号
     */
    private String houseNumber;

    /**
     * 年代
     */
    private String buildYear;

    /**
     * 资产期限(40 50 70)
     */
    private String maturityAssets;

    /**
     * 装修 (精装、简装、毛坯房)
     */
    private Integer decorationType;

    /**
     * 配备电梯(有、无)
     */
    private Integer elevator;

    /**
     * 户型 室
     */
    private String houseTypeRoom;

    /**
     * 户型 厅
     */
    private String houseTypeHall;

    /**
     * 户型 卫
     */
    private String houseTypeToilet;

    /**
     * 配套表ids
     */
    private String supportingIds;

    /**
     * 楼层信息
     */
    private String floorInformation;

    /**
     * 朝向
     */
    private Integer towards;

    /**
     * 售价
     */
    private Integer price;

    /**
     * 房源特色 id组字符串
     */
    private String listingFeaturesIds;

    /**
     * 物业类型
     */
    private String propertyType;

    /**
     * 开盘时间
     */
    private Date openDate;

    /**
     * 月价格
     */
    private BigDecimal monthlyRent;

    /**
     * 年租金
     */
    private BigDecimal annualRent;

    /**
     * 置顶 0-否 1-是
     */
    private String sticky;

}
