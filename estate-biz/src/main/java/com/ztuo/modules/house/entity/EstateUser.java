package com.ztuo.modules.house.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dpy
 */
@Data
public class EstateUser implements Serializable{	

	private static final long serialVersionUID = 1L;

    /**
     * id
     * This field corresponds to the database column estate_user.id
     *
     * @date 2020-02-11 10:05:12
     */  
	private Long id;
	
    /**
     * 手机号
     * This field corresponds to the database column estate_user.mobile_phone
     *
     * @date 2020-02-11 10:05:12
     */  
	private String mobilePhone;
	
    /**
     * 微信openId
     * This field corresponds to the database column estate_user.open_id
     *
     * @date 2020-02-11 10:05:12
     */  
	private String openId;
	
    /**
     * 设备类型 0-ios 1-Android
     * This field corresponds to the database column estate_user.device_type
     *
     * @date 2020-02-11 10:05:12
     */  
	private Integer deviceType;
	
    /**
     * 设备标识
     * This field corresponds to the database column estate_user.device_token
     *
     * @date 2020-02-11 10:05:12
     */  
	private String deviceToken;
	
    /**
     * 区域标识
     * This field corresponds to the database column estate_user.area_code
     *
     * @date 2020-02-11 10:05:12
     */  
	private String areaCode;
	
    /**
     * 昵称
     * This field corresponds to the database column estate_user.nickname
     *
     * @date 2020-02-11 10:05:12
     */  
	private String nickname;
	
    /**
     * 头像地址
     * This field corresponds to the database column estate_user.avatar_url
     *
     * @date 2020-02-11 10:05:12
     */  
	private String avatarUrl;
	
    /**
     * 登陆密码
     * This field corresponds to the database column estate_user.sign_password
     *
     * @date 2020-02-11 10:05:12
     */
	private String signPassword;
	
    /**
     * 创建时间
     * This field corresponds to the database column estate_user.create_time
     *
     * @date 2020-02-11 10:05:12
     */  
	private Date createTime;
	
    /**
     * 房源数量
     * This field corresponds to the database column estate_user.house_resourse_num
     *
     * @date 2020-02-11 10:05:12
     */  
	private Integer houseResourseNum;
	

}