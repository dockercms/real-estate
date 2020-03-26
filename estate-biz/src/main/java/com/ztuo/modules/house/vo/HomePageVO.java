package com.ztuo.modules.house.vo;

import com.ztuo.modules.house.entity.HouseResource;
import lombok.Data;

import java.util.List;

/**
 * @Author: dupinyan
 * @Description: 首页返回类
 * @Date: 2020/3/10 17:42
 * @Version: 1.0
 */
@Data
public class HomePageVO {

    /**
     * 二手房
     */
    List<HouseResource> homePageForRentHouse;

    /**
     * 商铺
     */
    List<HouseResource> homePageForShop;

    /**
     * 租房
     */
    List<HouseResource> homePageForSecondHouse;
}
