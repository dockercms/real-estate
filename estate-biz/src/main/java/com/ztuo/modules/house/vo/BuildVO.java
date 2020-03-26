package com.ztuo.modules.house.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author gs
 */
@Data
public class BuildVO implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * 主键
     * This field corresponds to the database column build_district.id
     *
     * @date 2020-03-02 18:04:46
     */  
	private Long id;


    /**
     * 小区名称
     * This field corresponds to the database column build_district.build_name
     *
     * @date 2020-03-02 18:04:46
     */
	private String buildName;
	

	
    /**
     * 详细地址
     * This field corresponds to the database column build_district.detail_address
     *
     * @date 2020-03-02 18:04:46
     */
	private String detailAddress;




}