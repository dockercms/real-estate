package com.ztuo.modules.es.vo;

import com.ztuo.modules.house.vo.BaseQueryVo;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/6 9:39 上午
 */
@Data
public class HouseDocVo extends BaseQueryVo {

    @NotBlank(message = "查询内容不能为空")
    private String name;

    /**
     * 房源分类 0-住宅 1-别墅 2-商铺 3-写字楼 4-旅馆 5-厂房 6-仓库 7-土地 8-车位 9-新房 10-二手房 11-租房
     * This field corresponds to the database column house_resource.estate_type
     *
     * @date 2020-03-03 14:46:23
     */
    @NotNull(message = "查询类型不能为空")
    private Integer estateType;
}
