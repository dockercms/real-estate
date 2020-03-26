package com.ztuo.modules.house.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 别墅
 * @Date: 2020/3/5 11:18
 * @Version: 1.0
 */
@Data
public class VillaDTO extends BaseHouseDTO {

    /**
     * 租房类型(整租、合租)
     */
    private Integer rentalType;

    /**
     * 小区名称
     */
    private String plotName;

    /**
     * 门牌号
     */
    private String houseNumber;

    /**
     * 年代
     */
    private Date buildYear;

    /**
     * 资产期限(40、50、70)
     */
    private String maturityAssets;

    /**
     * 装修(精装、简装、毛坯房)
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
     * 楼层信息
     */
    private String floorInformation;

    /**
     * 朝向
     */
    private Integer towards;

    /**
     * 月租金
     */
    private BigDecimal monthlyRent;

    /**
     * 年租金
     */
    private BigDecimal annualRent;

    /**
     * 房源特色ids
     */
    private String listingFeaturesIds;

    /**
     * 物业类型ids
     */
    private String propertyType;


    /**
     * 置顶
     */
    private Integer sticky;

    /**
     * 配套表ids
     */
    private String supportingIds;

    /**
     * 开盘时间
     */
    private Date openDate;

    /**
     * 售价
     */
    private Integer price;


}
