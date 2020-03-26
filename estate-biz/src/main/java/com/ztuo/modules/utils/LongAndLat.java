package com.ztuo.modules.utils;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/3 4:37 下午
 */
@Data
public class LongAndLat {

    /**
     * 经度
     */
    private BigDecimal Longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;


}
