package com.ztuo.modules.house.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class HouseCountExample implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
	protected String orderByClause;
	
    /**
     * This field corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
	protected boolean distinct;
	
	/**
     * This field corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
	protected List<Criteria> oredCriteria;
	
	/**
     * This method corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
	public HouseCountExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    /**
     * This method corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    /**
     * This method corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
    public String getOrderByClause() {
        return orderByClause;
    }
    
    /**
     * This method corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    
    /**
     * This method corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
    public boolean isDistinct() {
        return distinct;
    }
    
    /**
     * This method corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    
    /**
     * This method corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    
    /**
     * This method corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    
    /**
     * This method corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */   
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    /**
     * This method corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    
    /**
     * This method corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
	
	/**
     * This class corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
	protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }         
		
		public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }
        
        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }
        
        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }
        
        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
			
		public Criteria andHouseRegionProvinceIsNull() {
            addCriterion("house_region_province is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionProvinceIsNotNull() {
            addCriterion("house_region_province is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionProvinceEqualTo(String value) {
            addCriterion("house_region_province =", value, "houseRegionProvince");
            return (Criteria) this;
        }

        public Criteria andHouseRegionProvinceNotEqualTo(String value) {
            addCriterion("house_region_province <>", value, "houseRegionProvince");
            return (Criteria) this;
        }

        public Criteria andHouseRegionProvinceGreaterThan(String value) {
            addCriterion("house_region_province >", value, "houseRegionProvince");
            return (Criteria) this;
        }

        public Criteria andHouseRegionProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("house_region_province >=", value, "houseRegionProvince");
            return (Criteria) this;
        }

        public Criteria andHouseRegionProvinceLessThan(String value) {
            addCriterion("house_region_province <", value, "houseRegionProvince");
            return (Criteria) this;
        }

        public Criteria andHouseRegionProvinceLessThanOrEqualTo(String value) {
            addCriterion("house_region_province <=", value, "houseRegionProvince");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionProvinceLike(String value) {
            addCriterion("house_region_province like", value, "houseRegionProvince");
            return (Criteria) this;
        }

        public Criteria andHouseRegionProvinceNotLike(String value) {
            addCriterion("house_region_province not like", value, "houseRegionProvince");
            return (Criteria) this;
        }

        public Criteria andHouseRegionProvinceIn(List<String> values) {
            addCriterion("house_region_province in", values, "houseRegionProvince");
            return (Criteria) this;
        }

        public Criteria andHouseRegionProvinceNotIn(List<String> values) {
            addCriterion("house_region_province not in", values, "houseRegionProvince");
            return (Criteria) this;
        }

        public Criteria andHouseRegionProvinceBetween(String value1, String value2) {
            addCriterion("house_region_province between", value1, value2, "houseRegionProvince");
            return (Criteria) this;
        }

        public Criteria andHouseRegionProvinceNotBetween(String value1, String value2) {
            addCriterion("house_region_province not between", value1, value2, "houseRegionProvince");
            return (Criteria) this;
        }
			
		public Criteria andProvinceCodeIsNull() {
            addCriterion("province_code is null");
            return (Criteria) this;
        }
        
        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("province_code is not null");
            return (Criteria) this;
        }
        
        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("province_code <=", value, "provinceCode");
            return (Criteria) this;
        }
        
        public Criteria andProvinceCodeLike(String value) {
            addCriterion("province_code like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("province_code not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }
			
		public Criteria andHouseRegionCityIsNull() {
            addCriterion("house_region_city is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionCityIsNotNull() {
            addCriterion("house_region_city is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionCityEqualTo(String value) {
            addCriterion("house_region_city =", value, "houseRegionCity");
            return (Criteria) this;
        }

        public Criteria andHouseRegionCityNotEqualTo(String value) {
            addCriterion("house_region_city <>", value, "houseRegionCity");
            return (Criteria) this;
        }

        public Criteria andHouseRegionCityGreaterThan(String value) {
            addCriterion("house_region_city >", value, "houseRegionCity");
            return (Criteria) this;
        }

        public Criteria andHouseRegionCityGreaterThanOrEqualTo(String value) {
            addCriterion("house_region_city >=", value, "houseRegionCity");
            return (Criteria) this;
        }

        public Criteria andHouseRegionCityLessThan(String value) {
            addCriterion("house_region_city <", value, "houseRegionCity");
            return (Criteria) this;
        }

        public Criteria andHouseRegionCityLessThanOrEqualTo(String value) {
            addCriterion("house_region_city <=", value, "houseRegionCity");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionCityLike(String value) {
            addCriterion("house_region_city like", value, "houseRegionCity");
            return (Criteria) this;
        }

        public Criteria andHouseRegionCityNotLike(String value) {
            addCriterion("house_region_city not like", value, "houseRegionCity");
            return (Criteria) this;
        }

        public Criteria andHouseRegionCityIn(List<String> values) {
            addCriterion("house_region_city in", values, "houseRegionCity");
            return (Criteria) this;
        }

        public Criteria andHouseRegionCityNotIn(List<String> values) {
            addCriterion("house_region_city not in", values, "houseRegionCity");
            return (Criteria) this;
        }

        public Criteria andHouseRegionCityBetween(String value1, String value2) {
            addCriterion("house_region_city between", value1, value2, "houseRegionCity");
            return (Criteria) this;
        }

        public Criteria andHouseRegionCityNotBetween(String value1, String value2) {
            addCriterion("house_region_city not between", value1, value2, "houseRegionCity");
            return (Criteria) this;
        }
			
		public Criteria andCityCodeIsNull() {
            addCriterion("city_code is null");
            return (Criteria) this;
        }
        
        public Criteria andCityCodeIsNotNull() {
            addCriterion("city_code is not null");
            return (Criteria) this;
        }
        
        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("city_code <=", value, "cityCode");
            return (Criteria) this;
        }
        
        public Criteria andCityCodeLike(String value) {
            addCriterion("city_code like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("city_code not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("city_code not between", value1, value2, "cityCode");
            return (Criteria) this;
        }
			
		public Criteria andHouseRegionAreaIsNull() {
            addCriterion("house_region_area is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionAreaIsNotNull() {
            addCriterion("house_region_area is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionAreaEqualTo(String value) {
            addCriterion("house_region_area =", value, "houseRegionArea");
            return (Criteria) this;
        }

        public Criteria andHouseRegionAreaNotEqualTo(String value) {
            addCriterion("house_region_area <>", value, "houseRegionArea");
            return (Criteria) this;
        }

        public Criteria andHouseRegionAreaGreaterThan(String value) {
            addCriterion("house_region_area >", value, "houseRegionArea");
            return (Criteria) this;
        }

        public Criteria andHouseRegionAreaGreaterThanOrEqualTo(String value) {
            addCriterion("house_region_area >=", value, "houseRegionArea");
            return (Criteria) this;
        }

        public Criteria andHouseRegionAreaLessThan(String value) {
            addCriterion("house_region_area <", value, "houseRegionArea");
            return (Criteria) this;
        }

        public Criteria andHouseRegionAreaLessThanOrEqualTo(String value) {
            addCriterion("house_region_area <=", value, "houseRegionArea");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionAreaLike(String value) {
            addCriterion("house_region_area like", value, "houseRegionArea");
            return (Criteria) this;
        }

        public Criteria andHouseRegionAreaNotLike(String value) {
            addCriterion("house_region_area not like", value, "houseRegionArea");
            return (Criteria) this;
        }

        public Criteria andHouseRegionAreaIn(List<String> values) {
            addCriterion("house_region_area in", values, "houseRegionArea");
            return (Criteria) this;
        }

        public Criteria andHouseRegionAreaNotIn(List<String> values) {
            addCriterion("house_region_area not in", values, "houseRegionArea");
            return (Criteria) this;
        }

        public Criteria andHouseRegionAreaBetween(String value1, String value2) {
            addCriterion("house_region_area between", value1, value2, "houseRegionArea");
            return (Criteria) this;
        }

        public Criteria andHouseRegionAreaNotBetween(String value1, String value2) {
            addCriterion("house_region_area not between", value1, value2, "houseRegionArea");
            return (Criteria) this;
        }
			
		public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }
        
        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }
        
        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }
        
        public Criteria andAreaCodeLike(String value) {
            addCriterion("area_code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("area_code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }
			
		public Criteria andProvinceWyIsNull() {
            addCriterion("province_wy is null");
            return (Criteria) this;
        }
        
        public Criteria andProvinceWyIsNotNull() {
            addCriterion("province_wy is not null");
            return (Criteria) this;
        }
        
        public Criteria andProvinceWyEqualTo(String value) {
            addCriterion("province_wy =", value, "provinceWy");
            return (Criteria) this;
        }

        public Criteria andProvinceWyNotEqualTo(String value) {
            addCriterion("province_wy <>", value, "provinceWy");
            return (Criteria) this;
        }

        public Criteria andProvinceWyGreaterThan(String value) {
            addCriterion("province_wy >", value, "provinceWy");
            return (Criteria) this;
        }

        public Criteria andProvinceWyGreaterThanOrEqualTo(String value) {
            addCriterion("province_wy >=", value, "provinceWy");
            return (Criteria) this;
        }

        public Criteria andProvinceWyLessThan(String value) {
            addCriterion("province_wy <", value, "provinceWy");
            return (Criteria) this;
        }

        public Criteria andProvinceWyLessThanOrEqualTo(String value) {
            addCriterion("province_wy <=", value, "provinceWy");
            return (Criteria) this;
        }
        
        public Criteria andProvinceWyLike(String value) {
            addCriterion("province_wy like", value, "provinceWy");
            return (Criteria) this;
        }

        public Criteria andProvinceWyNotLike(String value) {
            addCriterion("province_wy not like", value, "provinceWy");
            return (Criteria) this;
        }

        public Criteria andProvinceWyIn(List<String> values) {
            addCriterion("province_wy in", values, "provinceWy");
            return (Criteria) this;
        }

        public Criteria andProvinceWyNotIn(List<String> values) {
            addCriterion("province_wy not in", values, "provinceWy");
            return (Criteria) this;
        }

        public Criteria andProvinceWyBetween(String value1, String value2) {
            addCriterion("province_wy between", value1, value2, "provinceWy");
            return (Criteria) this;
        }

        public Criteria andProvinceWyNotBetween(String value1, String value2) {
            addCriterion("province_wy not between", value1, value2, "provinceWy");
            return (Criteria) this;
        }
			
		public Criteria andCityWyIsNull() {
            addCriterion("city_wy is null");
            return (Criteria) this;
        }
        
        public Criteria andCityWyIsNotNull() {
            addCriterion("city_wy is not null");
            return (Criteria) this;
        }
        
        public Criteria andCityWyEqualTo(String value) {
            addCriterion("city_wy =", value, "cityWy");
            return (Criteria) this;
        }

        public Criteria andCityWyNotEqualTo(String value) {
            addCriterion("city_wy <>", value, "cityWy");
            return (Criteria) this;
        }

        public Criteria andCityWyGreaterThan(String value) {
            addCriterion("city_wy >", value, "cityWy");
            return (Criteria) this;
        }

        public Criteria andCityWyGreaterThanOrEqualTo(String value) {
            addCriterion("city_wy >=", value, "cityWy");
            return (Criteria) this;
        }

        public Criteria andCityWyLessThan(String value) {
            addCriterion("city_wy <", value, "cityWy");
            return (Criteria) this;
        }

        public Criteria andCityWyLessThanOrEqualTo(String value) {
            addCriterion("city_wy <=", value, "cityWy");
            return (Criteria) this;
        }
        
        public Criteria andCityWyLike(String value) {
            addCriterion("city_wy like", value, "cityWy");
            return (Criteria) this;
        }

        public Criteria andCityWyNotLike(String value) {
            addCriterion("city_wy not like", value, "cityWy");
            return (Criteria) this;
        }

        public Criteria andCityWyIn(List<String> values) {
            addCriterion("city_wy in", values, "cityWy");
            return (Criteria) this;
        }

        public Criteria andCityWyNotIn(List<String> values) {
            addCriterion("city_wy not in", values, "cityWy");
            return (Criteria) this;
        }

        public Criteria andCityWyBetween(String value1, String value2) {
            addCriterion("city_wy between", value1, value2, "cityWy");
            return (Criteria) this;
        }

        public Criteria andCityWyNotBetween(String value1, String value2) {
            addCriterion("city_wy not between", value1, value2, "cityWy");
            return (Criteria) this;
        }
			
		public Criteria andAreaWyIsNull() {
            addCriterion("area_wy is null");
            return (Criteria) this;
        }
        
        public Criteria andAreaWyIsNotNull() {
            addCriterion("area_wy is not null");
            return (Criteria) this;
        }
        
        public Criteria andAreaWyEqualTo(String value) {
            addCriterion("area_wy =", value, "areaWy");
            return (Criteria) this;
        }

        public Criteria andAreaWyNotEqualTo(String value) {
            addCriterion("area_wy <>", value, "areaWy");
            return (Criteria) this;
        }

        public Criteria andAreaWyGreaterThan(String value) {
            addCriterion("area_wy >", value, "areaWy");
            return (Criteria) this;
        }

        public Criteria andAreaWyGreaterThanOrEqualTo(String value) {
            addCriterion("area_wy >=", value, "areaWy");
            return (Criteria) this;
        }

        public Criteria andAreaWyLessThan(String value) {
            addCriterion("area_wy <", value, "areaWy");
            return (Criteria) this;
        }

        public Criteria andAreaWyLessThanOrEqualTo(String value) {
            addCriterion("area_wy <=", value, "areaWy");
            return (Criteria) this;
        }
        
        public Criteria andAreaWyLike(String value) {
            addCriterion("area_wy like", value, "areaWy");
            return (Criteria) this;
        }

        public Criteria andAreaWyNotLike(String value) {
            addCriterion("area_wy not like", value, "areaWy");
            return (Criteria) this;
        }

        public Criteria andAreaWyIn(List<String> values) {
            addCriterion("area_wy in", values, "areaWy");
            return (Criteria) this;
        }

        public Criteria andAreaWyNotIn(List<String> values) {
            addCriterion("area_wy not in", values, "areaWy");
            return (Criteria) this;
        }

        public Criteria andAreaWyBetween(String value1, String value2) {
            addCriterion("area_wy between", value1, value2, "areaWy");
            return (Criteria) this;
        }

        public Criteria andAreaWyNotBetween(String value1, String value2) {
            addCriterion("area_wy not between", value1, value2, "areaWy");
            return (Criteria) this;
        }
			
		public Criteria andNewHouseCountIsNull() {
            addCriterion("new_house_count is null");
            return (Criteria) this;
        }
        
        public Criteria andNewHouseCountIsNotNull() {
            addCriterion("new_house_count is not null");
            return (Criteria) this;
        }
        
        public Criteria andNewHouseCountEqualTo(Integer value) {
            addCriterion("new_house_count =", value, "newHouseCount");
            return (Criteria) this;
        }

        public Criteria andNewHouseCountNotEqualTo(Integer value) {
            addCriterion("new_house_count <>", value, "newHouseCount");
            return (Criteria) this;
        }

        public Criteria andNewHouseCountGreaterThan(Integer value) {
            addCriterion("new_house_count >", value, "newHouseCount");
            return (Criteria) this;
        }

        public Criteria andNewHouseCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_house_count >=", value, "newHouseCount");
            return (Criteria) this;
        }

        public Criteria andNewHouseCountLessThan(Integer value) {
            addCriterion("new_house_count <", value, "newHouseCount");
            return (Criteria) this;
        }

        public Criteria andNewHouseCountLessThanOrEqualTo(Integer value) {
            addCriterion("new_house_count <=", value, "newHouseCount");
            return (Criteria) this;
        }
        
        public Criteria andNewHouseCountIn(List<Integer> values) {
            addCriterion("new_house_count in", values, "newHouseCount");
            return (Criteria) this;
        }

        public Criteria andNewHouseCountNotIn(List<Integer> values) {
            addCriterion("new_house_count not in", values, "newHouseCount");
            return (Criteria) this;
        }

        public Criteria andNewHouseCountBetween(Integer value1, Integer value2) {
            addCriterion("new_house_count between", value1, value2, "newHouseCount");
            return (Criteria) this;
        }

        public Criteria andNewHouseCountNotBetween(Integer value1, Integer value2) {
            addCriterion("new_house_count not between", value1, value2, "newHouseCount");
            return (Criteria) this;
        }
			
		public Criteria andRentHouseCountIsNull() {
            addCriterion("rent_house_count is null");
            return (Criteria) this;
        }
        
        public Criteria andRentHouseCountIsNotNull() {
            addCriterion("rent_house_count is not null");
            return (Criteria) this;
        }
        
        public Criteria andRentHouseCountEqualTo(Integer value) {
            addCriterion("rent_house_count =", value, "rentHouseCount");
            return (Criteria) this;
        }

        public Criteria andRentHouseCountNotEqualTo(Integer value) {
            addCriterion("rent_house_count <>", value, "rentHouseCount");
            return (Criteria) this;
        }

        public Criteria andRentHouseCountGreaterThan(Integer value) {
            addCriterion("rent_house_count >", value, "rentHouseCount");
            return (Criteria) this;
        }

        public Criteria andRentHouseCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("rent_house_count >=", value, "rentHouseCount");
            return (Criteria) this;
        }

        public Criteria andRentHouseCountLessThan(Integer value) {
            addCriterion("rent_house_count <", value, "rentHouseCount");
            return (Criteria) this;
        }

        public Criteria andRentHouseCountLessThanOrEqualTo(Integer value) {
            addCriterion("rent_house_count <=", value, "rentHouseCount");
            return (Criteria) this;
        }
        
        public Criteria andRentHouseCountIn(List<Integer> values) {
            addCriterion("rent_house_count in", values, "rentHouseCount");
            return (Criteria) this;
        }

        public Criteria andRentHouseCountNotIn(List<Integer> values) {
            addCriterion("rent_house_count not in", values, "rentHouseCount");
            return (Criteria) this;
        }

        public Criteria andRentHouseCountBetween(Integer value1, Integer value2) {
            addCriterion("rent_house_count between", value1, value2, "rentHouseCount");
            return (Criteria) this;
        }

        public Criteria andRentHouseCountNotBetween(Integer value1, Integer value2) {
            addCriterion("rent_house_count not between", value1, value2, "rentHouseCount");
            return (Criteria) this;
        }
			
		public Criteria andSecondHouseCountIsNull() {
            addCriterion("second_house_count is null");
            return (Criteria) this;
        }
        
        public Criteria andSecondHouseCountIsNotNull() {
            addCriterion("second_house_count is not null");
            return (Criteria) this;
        }
        
        public Criteria andSecondHouseCountEqualTo(Integer value) {
            addCriterion("second_house_count =", value, "secondHouseCount");
            return (Criteria) this;
        }

        public Criteria andSecondHouseCountNotEqualTo(Integer value) {
            addCriterion("second_house_count <>", value, "secondHouseCount");
            return (Criteria) this;
        }

        public Criteria andSecondHouseCountGreaterThan(Integer value) {
            addCriterion("second_house_count >", value, "secondHouseCount");
            return (Criteria) this;
        }

        public Criteria andSecondHouseCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_house_count >=", value, "secondHouseCount");
            return (Criteria) this;
        }

        public Criteria andSecondHouseCountLessThan(Integer value) {
            addCriterion("second_house_count <", value, "secondHouseCount");
            return (Criteria) this;
        }

        public Criteria andSecondHouseCountLessThanOrEqualTo(Integer value) {
            addCriterion("second_house_count <=", value, "secondHouseCount");
            return (Criteria) this;
        }
        
        public Criteria andSecondHouseCountIn(List<Integer> values) {
            addCriterion("second_house_count in", values, "secondHouseCount");
            return (Criteria) this;
        }

        public Criteria andSecondHouseCountNotIn(List<Integer> values) {
            addCriterion("second_house_count not in", values, "secondHouseCount");
            return (Criteria) this;
        }

        public Criteria andSecondHouseCountBetween(Integer value1, Integer value2) {
            addCriterion("second_house_count between", value1, value2, "secondHouseCount");
            return (Criteria) this;
        }

        public Criteria andSecondHouseCountNotBetween(Integer value1, Integer value2) {
            addCriterion("second_house_count not between", value1, value2, "secondHouseCount");
            return (Criteria) this;
        }
			
		public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }
        
        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }
        
        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }
        
        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
		}
	
	/**
     * This class corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
	public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
    
    /**
     * This class corresponds to the database table HouseCount
     *
     * @date 2020-03-09 17:50:35
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}