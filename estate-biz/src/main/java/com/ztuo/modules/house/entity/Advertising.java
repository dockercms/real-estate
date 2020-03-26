package com.ztuo.modules.house.entity;

import lombok.Data;

import java.io.Serializable;

import java.util.Date;  
@Data
public class Advertising implements Serializable{	

	private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column advertising.id
     *
     * @date 2020-03-03 18:41:23
     */  
	private Long id;
	
    /**
     * 标题
     * This field corresponds to the database column advertising.title
     *
     * @date 2020-03-03 18:41:23
     */  
	private String title;
	
    /**
     * 0 开启 1 关闭
     * This field corresponds to the database column advertising.status
     *
     * @date 2020-03-03 18:41:23
     */  
	private String status;
	
    /**
     * 位置
     * This field corresponds to the database column advertising.location
     *
     * @date 2020-03-03 18:41:23
     */  
	private String location;
	
    /**
     * url地址
     * This field corresponds to the database column advertising.url_address
     *
     * @date 2020-03-03 18:41:23
     */  
	private String urlAddress;
	
    /**
     * 排序
     * This field corresponds to the database column advertising.sorts
     *
     * @date 2020-03-03 18:41:23
     */  
	private String sorts;
	
    /**
     * 生效时间
     * This field corresponds to the database column advertising.effect_time
     *
     * @date 2020-03-03 18:41:23
     */  
	private Date effectTime;
	
    /**
     * 失效时间
     * This field corresponds to the database column advertising.failure_time
     *
     * @date 2020-03-03 18:41:23
     */  
	private Date failureTime;
	
    /**
     * 创建时间
     * This field corresponds to the database column advertising.create_time
     *
     * @date 2020-03-03 18:41:23
     */  
	private Date createTime;
	
    /**
     * This method returns the value of the database column advertising.id
     *
     * @return the value of advertising.id
     *
     * @date 2020-03-03 18:41:23
     */
	public Long getId() {  
        return id;  
    }  
    /**
     * This method sets the value of the database column advertising.id
     *
     * @param id the value for advertising.id
     *
     * @date 2020-03-03 18:41:23
     */
    public void setId(Long id) {  
        this.id = id;
    }

    /**
     * 标题
     * This method returns the value of the database column advertising.title
     *
     * @return the value of advertising.title
     *
     * @date 2020-03-03 18:41:23
     */
	public String getTitle() {  
        return title;  
    }  
    /**
     * 标题
     * This method sets the value of the database column advertising.title
     *
     * @param title the value for advertising.title
     *
     * @date 2020-03-03 18:41:23
     */
    public void setTitle(String title) {  
        this.title = title == null ? null : title.trim();
    }

    /**
     * 0 开启 1 关闭
     * This method returns the value of the database column advertising.status
     *
     * @return the value of advertising.status
     *
     * @date 2020-03-03 18:41:23
     */
	public String getStatus() {  
        return status;  
    }  
    /**
     * 0 开启 1 关闭
     * This method sets the value of the database column advertising.status
     *
     * @param status the value for advertising.status
     *
     * @date 2020-03-03 18:41:23
     */
    public void setStatus(String status) {  
        this.status = status == null ? null : status.trim();
    }

    /**
     * 位置
     * This method returns the value of the database column advertising.location
     *
     * @return the value of advertising.location
     *
     * @date 2020-03-03 18:41:23
     */
	public String getLocation() {  
        return location;  
    }  
    /**
     * 位置
     * This method sets the value of the database column advertising.location
     *
     * @param location the value for advertising.location
     *
     * @date 2020-03-03 18:41:23
     */
    public void setLocation(String location) {  
        this.location = location == null ? null : location.trim();
    }

    /**
     * url地址
     * This method returns the value of the database column advertising.url_address
     *
     * @return the value of advertising.url_address
     *
     * @date 2020-03-03 18:41:23
     */
	public String getUrlAddress() {  
        return urlAddress;  
    }  
    /**
     * url地址
     * This method sets the value of the database column advertising.url_address
     *
     * @param urlAddress the value for advertising.url_address
     *
     * @date 2020-03-03 18:41:23
     */
    public void setUrlAddress(String urlAddress) {  
        this.urlAddress = urlAddress == null ? null : urlAddress.trim();
    }

    /**
     * 排序
     * This method returns the value of the database column advertising.sorts
     *
     * @return the value of advertising.sorts
     *
     * @date 2020-03-03 18:41:23
     */
	public String getSorts() {  
        return sorts;  
    }  
    /**
     * 排序
     * This method sets the value of the database column advertising.sorts
     *
     * @param sorts the value for advertising.sorts
     *
     * @date 2020-03-03 18:41:23
     */
    public void setSorts(String sorts) {  
        this.sorts = sorts == null ? null : sorts.trim();
    }

    /**
     * 生效时间
     * This method returns the value of the database column advertising.effect_time
     *
     * @return the value of advertising.effect_time
     *
     * @date 2020-03-03 18:41:23
     */
	public Date getEffectTime() {  
        return effectTime;  
    }  
    /**
     * 生效时间
     * This method sets the value of the database column advertising.effect_time
     *
     * @param effectTime the value for advertising.effect_time
     *
     * @date 2020-03-03 18:41:23
     */
    public void setEffectTime(Date effectTime) {  
        this.effectTime = effectTime;
    }

    /**
     * 失效时间
     * This method returns the value of the database column advertising.failure_time
     *
     * @return the value of advertising.failure_time
     *
     * @date 2020-03-03 18:41:23
     */
	public Date getFailureTime() {  
        return failureTime;  
    }  
    /**
     * 失效时间
     * This method sets the value of the database column advertising.failure_time
     *
     * @param failureTime the value for advertising.failure_time
     *
     * @date 2020-03-03 18:41:23
     */
    public void setFailureTime(Date failureTime) {  
        this.failureTime = failureTime;
    }

    /**
     * 创建时间
     * This method returns the value of the database column advertising.create_time
     *
     * @return the value of advertising.create_time
     *
     * @date 2020-03-03 18:41:23
     */
	public Date getCreateTime() {  
        return createTime;  
    }  
    /**
     * 创建时间
     * This method sets the value of the database column advertising.create_time
     *
     * @param createTime the value for advertising.create_time
     *
     * @date 2020-03-03 18:41:23
     */
    public void setCreateTime(Date createTime) {  
        this.createTime = createTime;
    }

}