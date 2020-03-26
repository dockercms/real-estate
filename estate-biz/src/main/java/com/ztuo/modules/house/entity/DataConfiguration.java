package com.ztuo.modules.house.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DataConfiguration implements Serializable{	

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
     * 维语描述
     * This field corresponds to the database column data_configuration.uygur_description
     *
     * @date 2020-03-06 18:06:08
     */  
	private String uygurDescription;
	
    /**
     * 创建时间
     * This field corresponds to the database column data_configuration.create_time
     *
     * @date 2020-03-06 18:06:08
     */  
	private Date createTime;
	
    /**
     * 修改时间
     * This field corresponds to the database column data_configuration.update_time
     *
     * @date 2020-03-06 18:06:08
     */  
	private Date updateTime;


	public DataConfiguration() {
	}

	public DataConfiguration(Long id, Long parentId, String description, String uygurDescription) {
		this.id = id;
		this.parentId = parentId;
		this.description = description;
		this.uygurDescription = uygurDescription;
	}

	public DataConfiguration(Long id, Long parentId, String description, String uygurDescription, Date createTime, Date updateTime) {
		this.id = id;
		this.parentId = parentId;
		this.description = description;
		this.uygurDescription = uygurDescription;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
}