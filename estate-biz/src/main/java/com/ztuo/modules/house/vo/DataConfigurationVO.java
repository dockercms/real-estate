package com.ztuo.modules.house.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataConfigurationVO implements Serializable{


    /**
     * 父级目录配置id
     * This field corresponds to the database column data_configuration.parent_id
     *
     * @date 2020-02-11 10:05:12
     */  
	private Long parentId;


}