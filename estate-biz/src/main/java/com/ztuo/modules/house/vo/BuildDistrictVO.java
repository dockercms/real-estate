package com.ztuo.modules.house.vo;

import lombok.Data;

/**
 * @Author: dupinyan
 * @Description: 经纪人查询
 * @Date: 2020/2/19 15:46
 * @Version: 1.0
 */
@Data
public class BuildDistrictVO extends BaseQueryVo {

    private Long id;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 小区名称
     * This field corresponds to the database column build_district.build_name
     *
     * @date 2020-03-02 18:04:46
     */
    private String buildName;

    /**
     * 0砖混1钢筋混凝土2钢结构
     * This field corresponds to the database column build_district.build_cate
     *
     * @date 2020-03-02 18:04:46
     */
    private String buildCate;

    /**
     * 年限
     * This field corresponds to the database column build_district.build_years
     *
     * @date 2020-03-02 18:04:46
     */
    private Integer buildYears;


}
