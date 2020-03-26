package com.ztuo.modules.house.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: dupinyan
 * @Description:
 * @Date: 2020/2/26 19:51
 * @Version: 1.0
 */
@Data
public class HouseKindQueryVO extends BaseQueryVo {

    /**
     * 当前记录id
     */
    private Long id;

    /**
     * 市code
     */
    private String cityCode;

    /**
     * 区域code
     */
    private String regionCode;

    /**
     * 最小价格
     */
    private Integer minPrice;

    /**
     * 最大价格
     */
    private Integer maxPrice;

    /**
     * 房型 1-一室 2-二室 3-三室 4-四室 5-五室及以上
     */
    private Integer houseType;

    /**
     * 排序类型 1-单价从低到高 2-单价由高到低 3-开盘时间顺序 4-开盘时间倒序 5-均价顺序 6-均价倒序 7-面积顺序 8-面积倒序 9-月租顺序
     *  10-月租倒序
     */
    private Integer sortType;

    /**
     * 查看类型 0-即将开售 1-在售楼盘
     */
    private Integer queryType;

    /**
     * 租房类型 0-整租 1-合租
     */
    private Integer rentalType;

    /**
     *  用途 0-出租 1-出售 2-转让
     */
    private Integer useWay;

    /**
     * 房源类型 0-新房 1-二手房 2-租房 3-别墅 4-商铺 5-写字楼 6-酒店 7-厂房 8-仓库 9-土地转让 10-车位
     */
    private Integer propertyType;

    /**
     * 最小面积
     */
    private String minArea;

    /**
     * 最大面积
     */
    private String maxArea;

    /**
     * 房屋朝向 0-东 1-西 2-南 3-北 4-南北 5-东西 6-东南 7-西南 8-东北 9-西北
     */
    private Integer towards;

    /**
     * 装修类型 0-毛坯房 1-简装 2-精装修 3-豪装
     */
    private Integer decorationType;

    /**
     * 配备电梯 0-无 1-有
     */
    private Integer elevator;

    /**
     * 楼层类型 0-底层 1-中层 2-高层
     */
    private Integer floorType;

    /**
     * 房源特色表id集合
     */
    private List<String> listingFeaturesIds;
}
