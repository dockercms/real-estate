package com.ztuo.modules.house.vo;

import com.ztuo.modules.house.entity.UygurHouseResource;
import lombok.Data;

import java.util.List;

/**
 * @Author: dupinyan
 * @Description:
 * @Date: 2020/3/18 19:34
 * @Version: 1.0
 */
@Data
public class HomePageUyVO {

    /**
     * 二手房
     */
    List<UygurHouseResource> homePageForRentHouse;

    /**
     * 商铺
     */
    List<UygurHouseResource> homePageForShop;

    /**
     * 租房
     */
    List<UygurHouseResource> homePageForSecondHouse;
}
