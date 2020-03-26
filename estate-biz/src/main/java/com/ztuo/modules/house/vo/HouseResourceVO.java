package com.ztuo.modules.house.vo;

import lombok.Data;

/**
 * @Author: dupinyan
 * @Description:
 * @Date: 2020/2/17 15:42
 * @Version: 1.0
 */
@Data
public class HouseResourceVO extends BaseQueryVo{


    /**
     * 房源分类 0-住宅 1-别墅 2-商铺 3-写字楼 4-旅馆 5-厂房 6-仓库 7-土地 8-车位
     */
    private Integer estateType;

    /**
     * 申请开始时间
     */
    private String startTime;

    /**
     * 申请结束时间
     */
    private String endTime;

    /**
     * 用途 0-出租 1-出售 2-转让
     */
    private Integer useWay;

    /**
     * 申请人姓名
     */
    private String applicantName;

    /**
     * 审核状态 0-审核中 1-审核成功 2-审核失败
     */
    private Integer recordStatus;

    /**
     * 房源id
     */
    private Long houseResourceId;

    /**
     * 区域名称
     */
    private String region;

    /**
     * 0-上架 1-下架
     */
    private String sellStatus;

}
