package com.ztuo.modules.house.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 别墅出售
 * @Date: 2020/2/23 15:17
 * @Version: 1.0
 */
@Data
public class VillaSellDTO extends BaseHouseDTO {

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
     * 资产期限
     */
    private String maturityAssets;

    /**
     * 装修
     */
    private Integer decorationType;

    /**
     * 配备电梯
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
     * 售价
     */
    private Integer price;

    /**
     * 房源特色
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
     * 置顶
     */
    private Integer sticky;

}
