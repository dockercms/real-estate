package com.ztuo.modules.house.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import java.util.Date;  

/**
 * @author gs
 */
@Data
public class BuildDistrict implements Serializable{	

	private static final long serialVersionUID = 1L;

    /**
     * 主键
     * This field corresponds to the database column build_district.id
     *
     * @date 2020-03-02 18:04:46
     */  
	private Long id;
	
    /**
     * 上级机构ID
     * This field corresponds to the database column build_district.super_parent_no
     *
     * @date 2020-03-02 18:04:46
     */
    @NotBlank(message = "上级机构ID不能为空")
    private String superParentNo;
	
    /**
     * 上级机构ID
     * This field corresponds to the database column build_district.parent_no
     *
     * @date 2020-03-02 18:04:46
     */
    @NotBlank(message = "上级机构ID不能为空")
	private String parentNo;
	
    /**
     * 0砖混1钢筋混凝土2钢结构
     * This field corresponds to the database column build_district.build_cate
     *
     * @date 2020-03-02 18:04:46
     */
    @NotBlank(message = "建筑类型不能为空")
	private String buildCate;
	
    /**
     * 申请人
     * This field corresponds to the database column build_district.apply_name
     *
     * @date 2020-03-02 18:04:46
     */
	private String applyName;
	
    /**
     * 小区名称
     * This field corresponds to the database column build_district.build_name
     *
     * @date 2020-03-02 18:04:46
     */
    @NotBlank(message = "小区名称不能为空")
	private String buildName;
	
    /**
     * 小区名称
     * This field corresponds to the database column build_district.build_name_wy
     *
     * @date 2020-03-02 18:04:46
     */
    @NotBlank(message = "小区名称不能为空")
	private String buildNameWy;
	
    /**
     * 详细地址
     * This field corresponds to the database column build_district.detail_address
     *
     * @date 2020-03-02 18:04:46
     */
    @NotBlank(message = "详细地址不能为空")
	private String detailAddress;
	
    /**
     * 详细地址维语
     * This field corresponds to the database column build_district.detail_address_wy
     *
     * @date 2020-03-02 18:04:46
     */
    @NotBlank(message = "详细地址不能为空")
	private String detailAddressWy;
	
    /**
     * 年限
     * This field corresponds to the database column build_district.build_years
     *
     * @date 2020-03-02 18:04:46
     */
    @NotNull(message = "年限不能为空")
	private Integer buildYears;
	
    /**
     * 建成年代
     * This field corresponds to the database column build_district.create_years
     *
     * @date 2020-03-02 18:04:46
     */
    @NotNull(message = "建成年代不能为空")
	private Integer createYears;
	
    /**
     * 物业类型
     * This field corresponds to the database column build_district.developer
     *
     * @date 2020-03-02 18:04:46
     */  
	private String developer;

    /**
     * 0-可用,1-删除
     */
	private String buildStatus;
	
    /**
     * 创建时间
     * This field corresponds to the database column build_district.create_time
     *
     * @date 2020-03-02 18:04:46
     */  
	private Date createTime;
	
    /**
     * This field corresponds to the database column build_district.remark
     *
     * @date 2020-03-02 18:04:46
     */  
	private String remark;

    /**
     * 修改时间
     * This field corresponds to the database column build_district.update_time
     *
     * @date 2020-03-03 09:50:36
     */
    private Date updateTime;

    /**
     * 所属市
     * This field corresponds to the database column build_district.area_code
     *
     * @date 2020-03-04 16:01:03
     */
    private String areaCode;

    /**
     * 开发商
     * This field corresponds to the database column build_district.development
     *
     * @date 2020-03-04 16:01:03
     */
    private String development;





}