package com.ztuo.modules.house.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gs
 */
@Data
public class TbAppVersion implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * 主键
     * This field corresponds to the database column tb_app_version.id
     *
     * @date 2019-07-13 10:22:13
     */  
	private Long id;
	
    /**
     * 0安卓用户端，1安卓经纪人端，2-IOS用户端 3-IOS经纪人端
     * This field corresponds to the database column tb_app_version.app_cate
     *
     * @date 2019-07-13 10:22:13
     */  
	private String appCate;
	
    /**
     * app版本
     * This field corresponds to the database column tb_app_version.app_version
     *
     * @date 2019-07-13 10:22:13
     */  
	private String appVersion;
	
    /**
     * 下载地址
     * This field corresponds to the database column tb_app_version.app_down_url
     *
     * @date 2019-07-13 10:22:13
     */  
	private String appDownUrl;
	
    /**
     * 创建时间
     * This field corresponds to the database column tb_app_version.create_time
     *
     * @date 2019-07-13 10:22:13
     */  
	private Date createTime;
	
    /**
     * 升级内容
     * This field corresponds to the database column tb_app_version.app_upgrade_content
     *
     * @date 2019-07-13 10:22:13
     */  
	private String appUpgradeContent;
	
    /**
     * This field corresponds to the database column tb_app_version.remark
     *
     * @date 2019-07-13 10:22:13
     */  
	private String remark;

}