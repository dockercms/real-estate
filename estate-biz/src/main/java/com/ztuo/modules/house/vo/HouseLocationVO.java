package com.ztuo.modules.house.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/9 6:31 下午
 */
@Data
public class HouseLocationVO {

    private Long id;

    /**
     * 经度
     * This field corresponds to the database column house_resource.longitude
     *
     * @date 2020-03-09 12:00:51
     */
    private String longitude;

    /**
     * 纬度
     * This field corresponds to the database column house_resource.latitude
     *
     * @date 2020-03-09 12:00:51
     */
    private String latitude;

    /**
     * 房源分类 0-住宅 1-别墅 2-商铺 3-写字楼 4-旅馆 5-厂房 6-仓库 7-土地 8-车位 9-新房 10-二手房 11-租房
     * This field corresponds to the database column house_resource.estate_type
     *
     * @date 2020-03-09 12:00:51
     */
    private Integer estateType;

    /**
     * 均价
     * This field corresponds to the database column house_resource.average_price
     *
     * @date 2020-03-09 12:00:51
     */
    private BigDecimal averagePrice;

    /**
     * 月租金
     * This field corresponds to the database column house_resource.monthly_rent
     *
     * @date 2020-03-09 12:00:51
     */
    private BigDecimal monthlyRent;

    /**
     * 小区名称
     * This field corresponds to the database column house_resource.plot_name
     *
     * @date 2020-03-09 12:00:51
     */
    private String plotName;


}
