package com.ztuo.modules.house.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DataConfigurationInfo implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * id
     * This field corresponds to the database column data_configuration.id
     *
     * @date 2020-03-06 18:06:08
     */
	private Long id;

    /**
     * 父级目录配置id
     * This field corresponds to the database column data_configuration.parent_id
     *
     * @date 2020-03-06 18:06:08
     */
	private Long parentId;

    /**
     * 描述
     * This field corresponds to the database column data_configuration.description
     *
     * @date 2020-03-06 18:06:08
     */
	private String description;

    /**
     * 创建时间
     * This field corresponds to the database column data_configuration.create_time
     *
     * @date 2020-03-06 18:06:08
     */
	private Date createTime;

}