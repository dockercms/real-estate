package com.ztuo.modules.house.vo;

import lombok.Data;

/**
 * @Author: dupinyan
 * @Description:
 * @Date: 2020/3/13 11:56
 * @Version: 1.0
 */
@Data
public class HouseDetailVO {

    /**
     * 当前记录id
     */
    private Long id;

    /**
     * 查询类型 0-新房 1-二手房 2-租房 3-别墅 4-商铺 5-写字楼 6-酒店 7-厂房 8-仓库 9-土地转让 10-车位
     */
    private Integer estateType;

    /**
     * 用途 0-出租 1-出售 2-转让
     */
    private Integer useWay;

}
