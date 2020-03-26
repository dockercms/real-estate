package com.ztuo.modules.house.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;  
import java.util.Iterator;
import java.util.List;

public class BrokerGuestExample implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
	protected String orderByClause;
	
    /**
     * This field corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
	protected boolean distinct;
	
	/**
     * This field corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
	protected List<Criteria> oredCriteria;
	
	/**
     * This method corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
	public BrokerGuestExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    /**
     * This method corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    /**
     * This method corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
    public String getOrderByClause() {
        return orderByClause;
    }
    
    /**
     * This method corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    
    /**
     * This method corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
    public boolean isDistinct() {
        return distinct;
    }
    
    /**
     * This method corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    
    /**
     * This method corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    
    /**
     * This method corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    
    /**
     * This method corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */   
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    /**
     * This method corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    
    /**
     * This method corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
	
	/**
     * This class corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
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
  
		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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
			
		public Criteria andClientNameIsNull() {
            addCriterion("client_name is null");
            return (Criteria) this;
        }
        
        public Criteria andClientNameIsNotNull() {
            addCriterion("client_name is not null");
            return (Criteria) this;
        }
        
        public Criteria andClientNameEqualTo(String value) {
            addCriterion("client_name =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotEqualTo(String value) {
            addCriterion("client_name <>", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThan(String value) {
            addCriterion("client_name >", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("client_name >=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThan(String value) {
            addCriterion("client_name <", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThanOrEqualTo(String value) {
            addCriterion("client_name <=", value, "clientName");
            return (Criteria) this;
        }
        
        public Criteria andClientNameLike(String value) {
            addCriterion("client_name like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotLike(String value) {
            addCriterion("client_name not like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameIn(List<String> values) {
            addCriterion("client_name in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotIn(List<String> values) {
            addCriterion("client_name not in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameBetween(String value1, String value2) {
            addCriterion("client_name between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotBetween(String value1, String value2) {
            addCriterion("client_name not between", value1, value2, "clientName");
            return (Criteria) this;
        }
			
		public Criteria andClientPhoneIsNull() {
            addCriterion("client_phone is null");
            return (Criteria) this;
        }
        
        public Criteria andClientPhoneIsNotNull() {
            addCriterion("client_phone is not null");
            return (Criteria) this;
        }
        
        public Criteria andClientPhoneEqualTo(String value) {
            addCriterion("client_phone =", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotEqualTo(String value) {
            addCriterion("client_phone <>", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneGreaterThan(String value) {
            addCriterion("client_phone >", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("client_phone >=", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneLessThan(String value) {
            addCriterion("client_phone <", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneLessThanOrEqualTo(String value) {
            addCriterion("client_phone <=", value, "clientPhone");
            return (Criteria) this;
        }
        
        public Criteria andClientPhoneLike(String value) {
            addCriterion("client_phone like", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotLike(String value) {
            addCriterion("client_phone not like", value, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneIn(List<String> values) {
            addCriterion("client_phone in", values, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotIn(List<String> values) {
            addCriterion("client_phone not in", values, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneBetween(String value1, String value2) {
            addCriterion("client_phone between", value1, value2, "clientPhone");
            return (Criteria) this;
        }

        public Criteria andClientPhoneNotBetween(String value1, String value2) {
            addCriterion("client_phone not between", value1, value2, "clientPhone");
            return (Criteria) this;
        }
			
		public Criteria andHouseRegionIsNull() {
            addCriterion("house_region is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionIsNotNull() {
            addCriterion("house_region is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionEqualTo(String value) {
            addCriterion("house_region =", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionNotEqualTo(String value) {
            addCriterion("house_region <>", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionGreaterThan(String value) {
            addCriterion("house_region >", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionGreaterThanOrEqualTo(String value) {
            addCriterion("house_region >=", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionLessThan(String value) {
            addCriterion("house_region <", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionLessThanOrEqualTo(String value) {
            addCriterion("house_region <=", value, "houseRegion");
            return (Criteria) this;
        }
        
        public Criteria andHouseRegionLike(String value) {
            addCriterion("house_region like", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionNotLike(String value) {
            addCriterion("house_region not like", value, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionIn(List<String> values) {
            addCriterion("house_region in", values, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionNotIn(List<String> values) {
            addCriterion("house_region not in", values, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionBetween(String value1, String value2) {
            addCriterion("house_region between", value1, value2, "houseRegion");
            return (Criteria) this;
        }

        public Criteria andHouseRegionNotBetween(String value1, String value2) {
            addCriterion("house_region not between", value1, value2, "houseRegion");
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
			
		public Criteria andStreetCodeIsNull() {
            addCriterion("street_code is null");
            return (Criteria) this;
        }
        
        public Criteria andStreetCodeIsNotNull() {
            addCriterion("street_code is not null");
            return (Criteria) this;
        }
        
        public Criteria andStreetCodeEqualTo(String value) {
            addCriterion("street_code =", value, "streetCode");
            return (Criteria) this;
        }

        public Criteria andStreetCodeNotEqualTo(String value) {
            addCriterion("street_code <>", value, "streetCode");
            return (Criteria) this;
        }

        public Criteria andStreetCodeGreaterThan(String value) {
            addCriterion("street_code >", value, "streetCode");
            return (Criteria) this;
        }

        public Criteria andStreetCodeGreaterThanOrEqualTo(String value) {
            addCriterion("street_code >=", value, "streetCode");
            return (Criteria) this;
        }

        public Criteria andStreetCodeLessThan(String value) {
            addCriterion("street_code <", value, "streetCode");
            return (Criteria) this;
        }

        public Criteria andStreetCodeLessThanOrEqualTo(String value) {
            addCriterion("street_code <=", value, "streetCode");
            return (Criteria) this;
        }
        
        public Criteria andStreetCodeLike(String value) {
            addCriterion("street_code like", value, "streetCode");
            return (Criteria) this;
        }

        public Criteria andStreetCodeNotLike(String value) {
            addCriterion("street_code not like", value, "streetCode");
            return (Criteria) this;
        }

        public Criteria andStreetCodeIn(List<String> values) {
            addCriterion("street_code in", values, "streetCode");
            return (Criteria) this;
        }

        public Criteria andStreetCodeNotIn(List<String> values) {
            addCriterion("street_code not in", values, "streetCode");
            return (Criteria) this;
        }

        public Criteria andStreetCodeBetween(String value1, String value2) {
            addCriterion("street_code between", value1, value2, "streetCode");
            return (Criteria) this;
        }

        public Criteria andStreetCodeNotBetween(String value1, String value2) {
            addCriterion("street_code not between", value1, value2, "streetCode");
            return (Criteria) this;
        }
			
		public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }
        
        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }
        
        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }
        
        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }
			
		public Criteria andHouseAreaIsNull() {
            addCriterion("house_area is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseAreaIsNotNull() {
            addCriterion("house_area is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseAreaEqualTo(String value) {
            addCriterion("house_area =", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotEqualTo(String value) {
            addCriterion("house_area <>", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThan(String value) {
            addCriterion("house_area >", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThanOrEqualTo(String value) {
            addCriterion("house_area >=", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThan(String value) {
            addCriterion("house_area <", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThanOrEqualTo(String value) {
            addCriterion("house_area <=", value, "houseArea");
            return (Criteria) this;
        }
        
        public Criteria andHouseAreaLike(String value) {
            addCriterion("house_area like", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotLike(String value) {
            addCriterion("house_area not like", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIn(List<String> values) {
            addCriterion("house_area in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotIn(List<String> values) {
            addCriterion("house_area not in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaBetween(String value1, String value2) {
            addCriterion("house_area between", value1, value2, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotBetween(String value1, String value2) {
            addCriterion("house_area not between", value1, value2, "houseArea");
            return (Criteria) this;
        }
			
		public Criteria andHouseTypeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeEqualTo(String value) {
            addCriterion("house_type =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(String value) {
            addCriterion("house_type <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(String value) {
            addCriterion("house_type >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("house_type >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(String value) {
            addCriterion("house_type <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(String value) {
            addCriterion("house_type <=", value, "houseType");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeLike(String value) {
            addCriterion("house_type like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotLike(String value) {
            addCriterion("house_type not like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<String> values) {
            addCriterion("house_type in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<String> values) {
            addCriterion("house_type not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(String value1, String value2) {
            addCriterion("house_type between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(String value1, String value2) {
            addCriterion("house_type not between", value1, value2, "houseType");
            return (Criteria) this;
        }
			
		public Criteria andHouseFloorIsNull() {
            addCriterion("house_floor is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseFloorIsNotNull() {
            addCriterion("house_floor is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseFloorEqualTo(String value) {
            addCriterion("house_floor =", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotEqualTo(String value) {
            addCriterion("house_floor <>", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorGreaterThan(String value) {
            addCriterion("house_floor >", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorGreaterThanOrEqualTo(String value) {
            addCriterion("house_floor >=", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorLessThan(String value) {
            addCriterion("house_floor <", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorLessThanOrEqualTo(String value) {
            addCriterion("house_floor <=", value, "houseFloor");
            return (Criteria) this;
        }
        
        public Criteria andHouseFloorLike(String value) {
            addCriterion("house_floor like", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotLike(String value) {
            addCriterion("house_floor not like", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorIn(List<String> values) {
            addCriterion("house_floor in", values, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotIn(List<String> values) {
            addCriterion("house_floor not in", values, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorBetween(String value1, String value2) {
            addCriterion("house_floor between", value1, value2, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotBetween(String value1, String value2) {
            addCriterion("house_floor not between", value1, value2, "houseFloor");
            return (Criteria) this;
        }
			
		public Criteria andTowardsIsNull() {
            addCriterion("towards is null");
            return (Criteria) this;
        }
        
        public Criteria andTowardsIsNotNull() {
            addCriterion("towards is not null");
            return (Criteria) this;
        }
        
        public Criteria andTowardsEqualTo(Integer value) {
            addCriterion("towards =", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsNotEqualTo(Integer value) {
            addCriterion("towards <>", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsGreaterThan(Integer value) {
            addCriterion("towards >", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsGreaterThanOrEqualTo(Integer value) {
            addCriterion("towards >=", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsLessThan(Integer value) {
            addCriterion("towards <", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsLessThanOrEqualTo(Integer value) {
            addCriterion("towards <=", value, "towards");
            return (Criteria) this;
        }
        
        public Criteria andTowardsIn(List<Integer> values) {
            addCriterion("towards in", values, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsNotIn(List<Integer> values) {
            addCriterion("towards not in", values, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsBetween(Integer value1, Integer value2) {
            addCriterion("towards between", value1, value2, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsNotBetween(Integer value1, Integer value2) {
            addCriterion("towards not between", value1, value2, "towards");
            return (Criteria) this;
        }
			
		public Criteria andDecorationTypeIsNull() {
            addCriterion("decoration_type is null");
            return (Criteria) this;
        }
        
        public Criteria andDecorationTypeIsNotNull() {
            addCriterion("decoration_type is not null");
            return (Criteria) this;
        }
        
        public Criteria andDecorationTypeEqualTo(Integer value) {
            addCriterion("decoration_type =", value, "decorationType");
            return (Criteria) this;
        }

        public Criteria andDecorationTypeNotEqualTo(Integer value) {
            addCriterion("decoration_type <>", value, "decorationType");
            return (Criteria) this;
        }

        public Criteria andDecorationTypeGreaterThan(Integer value) {
            addCriterion("decoration_type >", value, "decorationType");
            return (Criteria) this;
        }

        public Criteria andDecorationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("decoration_type >=", value, "decorationType");
            return (Criteria) this;
        }

        public Criteria andDecorationTypeLessThan(Integer value) {
            addCriterion("decoration_type <", value, "decorationType");
            return (Criteria) this;
        }

        public Criteria andDecorationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("decoration_type <=", value, "decorationType");
            return (Criteria) this;
        }
        
        public Criteria andDecorationTypeIn(List<Integer> values) {
            addCriterion("decoration_type in", values, "decorationType");
            return (Criteria) this;
        }

        public Criteria andDecorationTypeNotIn(List<Integer> values) {
            addCriterion("decoration_type not in", values, "decorationType");
            return (Criteria) this;
        }

        public Criteria andDecorationTypeBetween(Integer value1, Integer value2) {
            addCriterion("decoration_type between", value1, value2, "decorationType");
            return (Criteria) this;
        }

        public Criteria andDecorationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("decoration_type not between", value1, value2, "decorationType");
            return (Criteria) this;
        }
			
		public Criteria andReasonDemandIsNull() {
            addCriterion("reason_demand is null");
            return (Criteria) this;
        }
        
        public Criteria andReasonDemandIsNotNull() {
            addCriterion("reason_demand is not null");
            return (Criteria) this;
        }
        
        public Criteria andReasonDemandEqualTo(String value) {
            addCriterion("reason_demand =", value, "reasonDemand");
            return (Criteria) this;
        }

        public Criteria andReasonDemandNotEqualTo(String value) {
            addCriterion("reason_demand <>", value, "reasonDemand");
            return (Criteria) this;
        }

        public Criteria andReasonDemandGreaterThan(String value) {
            addCriterion("reason_demand >", value, "reasonDemand");
            return (Criteria) this;
        }

        public Criteria andReasonDemandGreaterThanOrEqualTo(String value) {
            addCriterion("reason_demand >=", value, "reasonDemand");
            return (Criteria) this;
        }

        public Criteria andReasonDemandLessThan(String value) {
            addCriterion("reason_demand <", value, "reasonDemand");
            return (Criteria) this;
        }

        public Criteria andReasonDemandLessThanOrEqualTo(String value) {
            addCriterion("reason_demand <=", value, "reasonDemand");
            return (Criteria) this;
        }
        
        public Criteria andReasonDemandLike(String value) {
            addCriterion("reason_demand like", value, "reasonDemand");
            return (Criteria) this;
        }

        public Criteria andReasonDemandNotLike(String value) {
            addCriterion("reason_demand not like", value, "reasonDemand");
            return (Criteria) this;
        }

        public Criteria andReasonDemandIn(List<String> values) {
            addCriterion("reason_demand in", values, "reasonDemand");
            return (Criteria) this;
        }

        public Criteria andReasonDemandNotIn(List<String> values) {
            addCriterion("reason_demand not in", values, "reasonDemand");
            return (Criteria) this;
        }

        public Criteria andReasonDemandBetween(String value1, String value2) {
            addCriterion("reason_demand between", value1, value2, "reasonDemand");
            return (Criteria) this;
        }

        public Criteria andReasonDemandNotBetween(String value1, String value2) {
            addCriterion("reason_demand not between", value1, value2, "reasonDemand");
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
			
		public Criteria andRecordStatusIsNull() {
            addCriterion("record_status is null");
            return (Criteria) this;
        }
        
        public Criteria andRecordStatusIsNotNull() {
            addCriterion("record_status is not null");
            return (Criteria) this;
        }
        
        public Criteria andRecordStatusEqualTo(Integer value) {
            addCriterion("record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Integer value) {
            addCriterion("record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Integer value) {
            addCriterion("record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Integer value) {
            addCriterion("record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Integer value) {
            addCriterion("record_status <=", value, "recordStatus");
            return (Criteria) this;
        }
        
        public Criteria andRecordStatusIn(List<Integer> values) {
            addCriterion("record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Integer> values) {
            addCriterion("record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Integer value1, Integer value2) {
            addCriterion("record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }
			
		public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }
        
        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }
        
        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }
        
        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
			
		public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }
        
        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }
        
        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }
        
        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
			
		public Criteria andBrokerIdIsNull() {
            addCriterion("broker_id is null");
            return (Criteria) this;
        }
        
        public Criteria andBrokerIdIsNotNull() {
            addCriterion("broker_id is not null");
            return (Criteria) this;
        }
        
        public Criteria andBrokerIdEqualTo(Long value) {
            addCriterion("broker_id =", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotEqualTo(Long value) {
            addCriterion("broker_id <>", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdGreaterThan(Long value) {
            addCriterion("broker_id >", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("broker_id >=", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLessThan(Long value) {
            addCriterion("broker_id <", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLessThanOrEqualTo(Long value) {
            addCriterion("broker_id <=", value, "brokerId");
            return (Criteria) this;
        }
        
        public Criteria andBrokerIdIn(List<Long> values) {
            addCriterion("broker_id in", values, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotIn(List<Long> values) {
            addCriterion("broker_id not in", values, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdBetween(Long value1, Long value2) {
            addCriterion("broker_id between", value1, value2, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotBetween(Long value1, Long value2) {
            addCriterion("broker_id not between", value1, value2, "brokerId");
            return (Criteria) this;
        }
		}
	
	/**
     * This class corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
     */
	public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
    
    /**
     * This class corresponds to the database table BrokerGuest
     *
     * @date 2020-03-05 14:39:15
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