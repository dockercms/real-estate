package com.ztuo.modules.house.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * @author gs
 */
@Data
public class HouseCountNews implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * id
     * This field corresponds to the database column house_count.id
     *
     * @date 2020-03-09 17:50:35
     */  
	private Long id;
	
    /**
     * 区域-省
     * This field corresponds to the database column house_count.house_region_province
     *
     * @date 2020-03-09 17:50:35
     */  
	private String houseRegionProvince;
	
    /**
     * 省code
     * This field corresponds to the database column house_count.province_code
     *
     * @date 2020-03-09 17:50:35
     */  
	private String provinceCode;
	
    /**
     * 区域-市
     * This field corresponds to the database column house_count.house_region_city
     *
     * @date 2020-03-09 17:50:35
     */  
	private String houseRegionCity;
	
    /**
     * 市code(区域code)
     * This field corresponds to the database column house_count.city_code
     *
     * @date 2020-03-09 17:50:35
     */  
	private String cityCode;
	
    /**
     * 区域-区
     * This field corresponds to the database column house_count.house_region_area
     *
     * @date 2020-03-09 17:50:35
     */  
	private String houseRegionArea;
	
    /**
     * 区code
     * This field corresponds to the database column house_count.area_code
     *
     * @date 2020-03-09 17:50:35
     */  
	private String areaCode;
	
    /**
     * 省维语
     * This field corresponds to the database column house_count.province_wy
     *
     * @date 2020-03-09 17:50:35
     */  
	private String provinceWy;
	
    /**
     * 市维语
     * This field corresponds to the database column house_count.city_wy
     *
     * @date 2020-03-09 17:50:35
     */  
	private String cityWy;
	
    /**
     * 区维语
     * This field corresponds to the database column house_count.area_wy
     *
     * @date 2020-03-09 17:50:35
     */  
	private String areaWy;
	

	private Integer houseCount;
	
    /**
     * 备注
     * This field corresponds to the database column house_count.remark
     *
     * @date 2020-03-09 17:50:35
     */  
	private String remark;

}