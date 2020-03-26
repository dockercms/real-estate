package com.ztuo.modules.house.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: dupinyan
 * @Description: 房产共有属性
 * @Date: 2020/2/22 16:45
 * @Version: 1.0
 */
@Data
public class BaseHouseDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 所属经纪人id
     */
    private Long brokerId;

    /**
     * 经纪人姓名
     */
    private String brokerName;

    /**
     * 经纪人头像地址
     */
    private String brokerPhoto;

    /**
     * 经纪人手机号
     */
    private String applicantPhone;

    /**
     * 房源分类 0-住宅 1-别墅 2-商铺 3-写字楼 4-旅馆 5-厂房 6-仓库 7-土地 8-车位 9-新房 10-二手房 11-租房
     */
    private Integer estateType;

    /**
     * 用途 0-出租 1-出售 2-转让
     */
    private Integer useWay;

    /**
     * 业主姓名
     */
    private String ownerName;

    /**
     * 业主联系电话
     */
    private String ownerPhone;

    /**
     * 标题
     */
    private String title;

    /**
     * 区域省
     */
    private String houseRegionProvince;

    /**
     * 区域市
     */
    private String houseRegionCity;

    /**
     * 省code
     */
    private String provinceCode;

    /**
     * 市code
     */
    private String cityCode;

    /**
     * 区域区
     */
    private String houseRegionArea;

    /**
     * 区code
     */
    private String regionCode;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 楼层 0-底层 1-中层 2-高层
     */
    private Integer floorType;

    /**
     * 面积
     */
    private BigDecimal houseArea;

    /**
     * 房源描述
     */
    private String listingDescription;

    /**
     * 房源图片
     */
    private String listingPictures;

    /**
     * 支付方式
     */
    private Integer paymentMethod;

    /**
     * 出售状态 是否上下架 0-上架 1-下架
     */
    private Integer sellStatus;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 维语汉语标记
     */
    private String signLabel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 关注状态
     */
    private boolean favoriteHouseStatus ;

}
