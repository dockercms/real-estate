package com.ztuo.modules.house.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/9 6:31 下午
 */
@Data
public class HouseCountVO {

    /**
     *
     */
    @NotBlank(message = "城市区编码不能为空")
    private String cityCode;

    /**
     * 0-新房,1-租房,2-二手房
     */
    @NotBlank(message = "房屋类型不能为空")
    private String estateType;
}
