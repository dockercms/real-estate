package com.ztuo.modules.house.entity;

import lombok.Data;

import java.io.Serializable;

import java.util.Date;

@Data
public class ScanHouseRecord implements Serializable{	

	private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column scan_house_record.id
     *
     * @date 2020-03-02 18:25:52
     */  
	private Long id;
	
    /**
     * 房源id
     * This field corresponds to the database column scan_house_record.house_id
     *
     * @date 2020-03-02 18:25:52
     */  
	private Long houseId;
	
    /**
     * 会员id
     * This field corresponds to the database column scan_house_record.user_id
     *
     * @date 2020-03-02 18:25:52
     */  
	private Long userId;
	
    /**
     * 房源类型 0-汉语 1-维语
     * This field corresponds to the database column scan_house_record.language_type
     *
     * @date 2020-03-02 18:25:52
     */  
	private String languageType;
	
    /**
     * 备注
     * This field corresponds to the database column scan_house_record.remark
     *
     * @date 2020-03-02 18:25:52
     */  
	private String remark;
	
    /**
     * 创建时间
     * This field corresponds to the database column scan_house_record.create_time
     *
     * @date 2020-03-02 18:25:52
     */  
	private Date createTime;
	
    /**
     * This method returns the value of the database column scan_house_record.id
     *
     * @return the value of scan_house_record.id
     *
     * @date 2020-03-02 18:25:52
     */
	public Long getId() {  
        return id;  
    }  
    /**
     * This method sets the value of the database column scan_house_record.id
     *
     * @param id the value for scan_house_record.id
     *
     * @date 2020-03-02 18:25:52
     */
    public void setId(Long id) {  
        this.id = id;
    }

    /**
     * 房源id
     * This method returns the value of the database column scan_house_record.house_id
     *
     * @return the value of scan_house_record.house_id
     *
     * @date 2020-03-02 18:25:52
     */
	public Long getHouseId() {  
        return houseId;  
    }  
    /**
     * 房源id
     * This method sets the value of the database column scan_house_record.house_id
     *
     * @param houseId the value for scan_house_record.house_id
     *
     * @date 2020-03-02 18:25:52
     */
    public void setHouseId(Long houseId) {  
        this.houseId = houseId;
    }

    /**
     * 会员id
     * This method returns the value of the database column scan_house_record.user_id
     *
     * @return the value of scan_house_record.user_id
     *
     * @date 2020-03-02 18:25:52
     */
	public Long getUserId() {  
        return userId;  
    }  
    /**
     * 会员id
     * This method sets the value of the database column scan_house_record.user_id
     *
     * @param userId the value for scan_house_record.user_id
     *
     * @date 2020-03-02 18:25:52
     */
    public void setUserId(Long userId) {  
        this.userId = userId;
    }

    /**
     * 房源类型 0-汉语 1-维语
     * This method returns the value of the database column scan_house_record.language_type
     *
     * @return the value of scan_house_record.language_type
     *
     * @date 2020-03-02 18:25:52
     */
	public String getLanguageType() {  
        return languageType;  
    }  
    /**
     * 房源类型 0-汉语 1-维语
     * This method sets the value of the database column scan_house_record.language_type
     *
     * @param languageType the value for scan_house_record.language_type
     *
     * @date 2020-03-02 18:25:52
     */
    public void setLanguageType(String languageType) {  
        this.languageType = languageType == null ? null : languageType.trim();
    }

    /**
     * 备注
     * This method returns the value of the database column scan_house_record.remark
     *
     * @return the value of scan_house_record.remark
     *
     * @date 2020-03-02 18:25:52
     */
	public String getRemark() {  
        return remark;  
    }  
    /**
     * 备注
     * This method sets the value of the database column scan_house_record.remark
     *
     * @param remark the value for scan_house_record.remark
     *
     * @date 2020-03-02 18:25:52
     */
    public void setRemark(String remark) {  
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 创建时间
     * This method returns the value of the database column scan_house_record.create_time
     *
     * @return the value of scan_house_record.create_time
     *
     * @date 2020-03-02 18:25:52
     */
	public Date getCreateTime() {  
        return createTime;  
    }  
    /**
     * 创建时间
     * This method sets the value of the database column scan_house_record.create_time
     *
     * @param createTime the value for scan_house_record.create_time
     *
     * @date 2020-03-02 18:25:52
     */
    public void setCreateTime(Date createTime) {  
        this.createTime = createTime;
    }

}