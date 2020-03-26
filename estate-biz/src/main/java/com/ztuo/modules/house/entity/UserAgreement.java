package com.ztuo.modules.house.entity;

import lombok.Data;

import java.io.Serializable;

import java.util.Date;  

@Data
public class UserAgreement implements Serializable{	

	private static final long serialVersionUID = 1L;

    /**
     * 主键
     * This field corresponds to the database column user_agreement.id
     *
     * @date 2020-03-14 15:35:10
     */  
	private Long id;
	
    /**
     * 0有效 1无效
     * This field corresponds to the database column user_agreement.status
     *
     * @date 2020-03-14 15:35:10
     */  
	private String status;
	
    /**
     * 0用户端 1客户端
     * This field corresponds to the database column user_agreement.agreement_type
     *
     * @date 2020-03-14 15:35:10
     */  
	private String agreementType;
	
    /**
     * 协议名称
     * This field corresponds to the database column user_agreement.agreement_name
     *
     * @date 2020-03-14 15:35:10
     */  
	private String agreementName;
	
    /**
     * 协议描述
     * This field corresponds to the database column user_agreement.agreement_desc
     *
     * @date 2020-03-14 15:35:10
     */  
	private String agreementDesc;
	
    /**
     * 协议地址
     * This field corresponds to the database column user_agreement.agreement_address
     *
     * @date 2020-03-14 15:35:10
     */  
	private String agreementAddress;
	
    /**
     * 协议地址
     * This field corresponds to the database column user_agreement.agreement_content
     *
     * @date 2020-03-14 15:35:10
     */  
	private String agreementContent;
	
    /**
     * 创建时间
     * This field corresponds to the database column user_agreement.create_time
     *
     * @date 2020-03-14 15:35:10
     */  
	private Date createTime;
	
    /**
     * 修改时间
     * This field corresponds to the database column user_agreement.update_time
     *
     * @date 2020-03-14 15:35:10
     */  
	private Date updateTime;
	
    /**
     * This field corresponds to the database column user_agreement.remark
     *
     * @date 2020-03-14 15:35:10
     */  
	private String remark;
	

}