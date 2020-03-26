package com.ztuo.modules.house.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class EstateBroker implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * id
     * This field corresponds to the database column estate_broker.id
     *
     * @date 2020-03-20 11:01:20
     */  
	private Long id;
	
    /**
     * 手机号
     * This field corresponds to the database column estate_broker.mobile_phone
     *
     * @date 2020-02-19 16:41:04
     */
    @NotBlank(message = "手机号不能为空")
	private String mobilePhone;
	
    /**
     * 登陆密码
     * This field corresponds to the database column estate_broker.sign_password
     *
     * @date 2020-02-19 16:41:04
     */
    @NotBlank(message = "密码不能为空")
	private String signPassword;
	
    /**
     * 微信openId
     * This field corresponds to the database column estate_broker.open_id
     *
     * @date 2020-03-20 11:01:20
     */  
	private String openId;
	
    /**
     * 设备类型 0-ios 1-Android
     * This field corresponds to the database column estate_broker.device_type
     *
     * @date 2020-03-20 11:01:20
     */  
	private Integer deviceType;
	
    /**
     * 设备标识
     * This field corresponds to the database column estate_broker.device_token
     *
     * @date 2020-03-20 11:01:20
     */  
	private String deviceToken;
	
    /**
     * 区域标识
     * This field corresponds to the database column estate_broker.area_code
     *
     * @date 2020-03-20 11:01:20
     */  
	private String areaCode;
	
    /**
     * 经纪人姓名
     * This field corresponds to the database column estate_broker.broker_name
     *
     * @date 2020-02-19 16:41:04
     */
    @NotBlank(message = "姓名不能为空")
	private String brokerName;
	
    /**
     * 经纪人姓名维语
     * This field corresponds to the database column estate_broker.uygur_broker_name
     *
     * @date 2020-03-20 11:01:20
     */
    @NotBlank(message = "维语姓名不能为空")
	private String uygurBrokerName;
	
    /**
     * 工作区域
     * This field corresponds to the database column estate_broker.work_area
     *
     * @date 2020-02-19 16:41:04
     */
    @NotBlank(message = "工作区域不能为空")
	private String workArea;
	
    /**
     * 工作店铺
     * This field corresponds to the database column estate_broker.work_shop
     *
     * @date 2020-02-19 16:41:04
     */
    @NotBlank(message = "工作店铺不能为空")
	private String workShop;
	
    /**
     * 经纪人级别 0-初级 1-中级 2-高级
     * This field corresponds to the database column estate_broker.broker_level
     *
     * @date 2020-02-19 16:41:04
     */
    @NotNull(message = "经纪人级别不能为空")
	private Integer brokerLevel;
	
    /**
     * 出生年月
     * This field corresponds to the database column estate_broker.birth_date
     *
     * @date 2020-02-19 16:41:04
     */
    @NotNull(message = "出生年月不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
	private Date birthDate;
	
    /**
     * 身份证号
     * This field corresponds to the database column estate_broker.identity_number
     *
     * @date 2020-02-19 16:41:04
     */
    @NotBlank(message = "身份证号不能为空")
	private String identityNumber;
	
    /**
     * 家庭住址
     * This field corresponds to the database column estate_broker.home_address
     *
     * @date 2020-02-19 16:41:04
     */
    @NotBlank(message = "家庭住址不能为空")
	private String homeAddress;
	
    /**
     * 证件照URL
     * This field corresponds to the database column estate_broker.photo_url
     *
     * @date 2020-02-19 16:41:04
     */
    @NotBlank(message = "证件照不能为空")
	private String photoUrl;
	
    /**
     * 客源数量
     * This field corresponds to the database column estate_broker.guest_number
     *
     * @date 2020-03-20 11:01:20
     */  
	private Integer guestNumber;
	
    /**
     * 创建时间
     * This field corresponds to the database column estate_broker.create_time
     *
     * @date 2020-03-20 11:01:20
     */  
	private Date createTime;
	
    /**
     * 审核状态 0-审核中 1-审核成功 2-审核失败
     * This field corresponds to the database column estate_broker.audit_status
     *
     * @date 2020-03-20 11:01:20
     */  
	private Integer auditStatus;

}