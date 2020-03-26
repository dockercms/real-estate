package com.ztuo.modules.house.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;  
import java.util.Iterator;
import java.util.List;

public class EstateBrokerExample implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
	protected String orderByClause;
	
    /**
     * This field corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
	protected boolean distinct;
	
	/**
     * This field corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
	protected List<Criteria> oredCriteria;
	
	/**
     * This method corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
	public EstateBrokerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    /**
     * This method corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    /**
     * This method corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
    public String getOrderByClause() {
        return orderByClause;
    }
    
    /**
     * This method corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    
    /**
     * This method corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
    public boolean isDistinct() {
        return distinct;
    }
    
    /**
     * This method corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    
    /**
     * This method corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    
    /**
     * This method corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    
    /**
     * This method corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */   
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    /**
     * This method corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    
    /**
     * This method corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
	
	/**
     * This class corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
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
			
		public Criteria andMobilePhoneIsNull() {
            addCriterion("mobile_phone is null");
            return (Criteria) this;
        }
        
        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("mobile_phone is not null");
            return (Criteria) this;
        }
        
        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("mobile_phone =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("mobile_phone <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("mobile_phone >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_phone >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("mobile_phone <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("mobile_phone <=", value, "mobilePhone");
            return (Criteria) this;
        }
        
        public Criteria andMobilePhoneLike(String value) {
            addCriterion("mobile_phone like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("mobile_phone not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("mobile_phone in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("mobile_phone not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("mobile_phone between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("mobile_phone not between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }
			
		public Criteria andSignPasswordIsNull() {
            addCriterion("sign_password is null");
            return (Criteria) this;
        }
        
        public Criteria andSignPasswordIsNotNull() {
            addCriterion("sign_password is not null");
            return (Criteria) this;
        }
        
        public Criteria andSignPasswordEqualTo(String value) {
            addCriterion("sign_password =", value, "signPassword");
            return (Criteria) this;
        }

        public Criteria andSignPasswordNotEqualTo(String value) {
            addCriterion("sign_password <>", value, "signPassword");
            return (Criteria) this;
        }

        public Criteria andSignPasswordGreaterThan(String value) {
            addCriterion("sign_password >", value, "signPassword");
            return (Criteria) this;
        }

        public Criteria andSignPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("sign_password >=", value, "signPassword");
            return (Criteria) this;
        }

        public Criteria andSignPasswordLessThan(String value) {
            addCriterion("sign_password <", value, "signPassword");
            return (Criteria) this;
        }

        public Criteria andSignPasswordLessThanOrEqualTo(String value) {
            addCriterion("sign_password <=", value, "signPassword");
            return (Criteria) this;
        }
        
        public Criteria andSignPasswordLike(String value) {
            addCriterion("sign_password like", value, "signPassword");
            return (Criteria) this;
        }

        public Criteria andSignPasswordNotLike(String value) {
            addCriterion("sign_password not like", value, "signPassword");
            return (Criteria) this;
        }

        public Criteria andSignPasswordIn(List<String> values) {
            addCriterion("sign_password in", values, "signPassword");
            return (Criteria) this;
        }

        public Criteria andSignPasswordNotIn(List<String> values) {
            addCriterion("sign_password not in", values, "signPassword");
            return (Criteria) this;
        }

        public Criteria andSignPasswordBetween(String value1, String value2) {
            addCriterion("sign_password between", value1, value2, "signPassword");
            return (Criteria) this;
        }

        public Criteria andSignPasswordNotBetween(String value1, String value2) {
            addCriterion("sign_password not between", value1, value2, "signPassword");
            return (Criteria) this;
        }
			
		public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }
        
        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }
        
        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }
        
        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }
			
		public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }
        
        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }
        
        public Criteria andDeviceTypeEqualTo(Integer value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(Integer value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(Integer value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(Integer value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }
        
        public Criteria andDeviceTypeIn(List<Integer> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<Integer> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(Integer value1, Integer value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }
			
		public Criteria andDeviceTokenIsNull() {
            addCriterion("device_token is null");
            return (Criteria) this;
        }
        
        public Criteria andDeviceTokenIsNotNull() {
            addCriterion("device_token is not null");
            return (Criteria) this;
        }
        
        public Criteria andDeviceTokenEqualTo(String value) {
            addCriterion("device_token =", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenNotEqualTo(String value) {
            addCriterion("device_token <>", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenGreaterThan(String value) {
            addCriterion("device_token >", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenGreaterThanOrEqualTo(String value) {
            addCriterion("device_token >=", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenLessThan(String value) {
            addCriterion("device_token <", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenLessThanOrEqualTo(String value) {
            addCriterion("device_token <=", value, "deviceToken");
            return (Criteria) this;
        }
        
        public Criteria andDeviceTokenLike(String value) {
            addCriterion("device_token like", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenNotLike(String value) {
            addCriterion("device_token not like", value, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenIn(List<String> values) {
            addCriterion("device_token in", values, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenNotIn(List<String> values) {
            addCriterion("device_token not in", values, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenBetween(String value1, String value2) {
            addCriterion("device_token between", value1, value2, "deviceToken");
            return (Criteria) this;
        }

        public Criteria andDeviceTokenNotBetween(String value1, String value2) {
            addCriterion("device_token not between", value1, value2, "deviceToken");
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
			
		public Criteria andBrokerNameIsNull() {
            addCriterion("broker_name is null");
            return (Criteria) this;
        }
        
        public Criteria andBrokerNameIsNotNull() {
            addCriterion("broker_name is not null");
            return (Criteria) this;
        }
        
        public Criteria andBrokerNameEqualTo(String value) {
            addCriterion("broker_name =", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotEqualTo(String value) {
            addCriterion("broker_name <>", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameGreaterThan(String value) {
            addCriterion("broker_name >", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameGreaterThanOrEqualTo(String value) {
            addCriterion("broker_name >=", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameLessThan(String value) {
            addCriterion("broker_name <", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameLessThanOrEqualTo(String value) {
            addCriterion("broker_name <=", value, "brokerName");
            return (Criteria) this;
        }
        
        public Criteria andBrokerNameLike(String value) {
            addCriterion("broker_name like", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotLike(String value) {
            addCriterion("broker_name not like", value, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameIn(List<String> values) {
            addCriterion("broker_name in", values, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotIn(List<String> values) {
            addCriterion("broker_name not in", values, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameBetween(String value1, String value2) {
            addCriterion("broker_name between", value1, value2, "brokerName");
            return (Criteria) this;
        }

        public Criteria andBrokerNameNotBetween(String value1, String value2) {
            addCriterion("broker_name not between", value1, value2, "brokerName");
            return (Criteria) this;
        }
			
		public Criteria andUygurBrokerNameIsNull() {
            addCriterion("uygur_broker_name is null");
            return (Criteria) this;
        }
        
        public Criteria andUygurBrokerNameIsNotNull() {
            addCriterion("uygur_broker_name is not null");
            return (Criteria) this;
        }
        
        public Criteria andUygurBrokerNameEqualTo(String value) {
            addCriterion("uygur_broker_name =", value, "uygurBrokerName");
            return (Criteria) this;
        }

        public Criteria andUygurBrokerNameNotEqualTo(String value) {
            addCriterion("uygur_broker_name <>", value, "uygurBrokerName");
            return (Criteria) this;
        }

        public Criteria andUygurBrokerNameGreaterThan(String value) {
            addCriterion("uygur_broker_name >", value, "uygurBrokerName");
            return (Criteria) this;
        }

        public Criteria andUygurBrokerNameGreaterThanOrEqualTo(String value) {
            addCriterion("uygur_broker_name >=", value, "uygurBrokerName");
            return (Criteria) this;
        }

        public Criteria andUygurBrokerNameLessThan(String value) {
            addCriterion("uygur_broker_name <", value, "uygurBrokerName");
            return (Criteria) this;
        }

        public Criteria andUygurBrokerNameLessThanOrEqualTo(String value) {
            addCriterion("uygur_broker_name <=", value, "uygurBrokerName");
            return (Criteria) this;
        }
        
        public Criteria andUygurBrokerNameLike(String value) {
            addCriterion("uygur_broker_name like", value, "uygurBrokerName");
            return (Criteria) this;
        }

        public Criteria andUygurBrokerNameNotLike(String value) {
            addCriterion("uygur_broker_name not like", value, "uygurBrokerName");
            return (Criteria) this;
        }

        public Criteria andUygurBrokerNameIn(List<String> values) {
            addCriterion("uygur_broker_name in", values, "uygurBrokerName");
            return (Criteria) this;
        }

        public Criteria andUygurBrokerNameNotIn(List<String> values) {
            addCriterion("uygur_broker_name not in", values, "uygurBrokerName");
            return (Criteria) this;
        }

        public Criteria andUygurBrokerNameBetween(String value1, String value2) {
            addCriterion("uygur_broker_name between", value1, value2, "uygurBrokerName");
            return (Criteria) this;
        }

        public Criteria andUygurBrokerNameNotBetween(String value1, String value2) {
            addCriterion("uygur_broker_name not between", value1, value2, "uygurBrokerName");
            return (Criteria) this;
        }
			
		public Criteria andWorkAreaIsNull() {
            addCriterion("work_area is null");
            return (Criteria) this;
        }
        
        public Criteria andWorkAreaIsNotNull() {
            addCriterion("work_area is not null");
            return (Criteria) this;
        }
        
        public Criteria andWorkAreaEqualTo(String value) {
            addCriterion("work_area =", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaNotEqualTo(String value) {
            addCriterion("work_area <>", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaGreaterThan(String value) {
            addCriterion("work_area >", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaGreaterThanOrEqualTo(String value) {
            addCriterion("work_area >=", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaLessThan(String value) {
            addCriterion("work_area <", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaLessThanOrEqualTo(String value) {
            addCriterion("work_area <=", value, "workArea");
            return (Criteria) this;
        }
        
        public Criteria andWorkAreaLike(String value) {
            addCriterion("work_area like", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaNotLike(String value) {
            addCriterion("work_area not like", value, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaIn(List<String> values) {
            addCriterion("work_area in", values, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaNotIn(List<String> values) {
            addCriterion("work_area not in", values, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaBetween(String value1, String value2) {
            addCriterion("work_area between", value1, value2, "workArea");
            return (Criteria) this;
        }

        public Criteria andWorkAreaNotBetween(String value1, String value2) {
            addCriterion("work_area not between", value1, value2, "workArea");
            return (Criteria) this;
        }
			
		public Criteria andWorkShopIsNull() {
            addCriterion("work_shop is null");
            return (Criteria) this;
        }
        
        public Criteria andWorkShopIsNotNull() {
            addCriterion("work_shop is not null");
            return (Criteria) this;
        }
        
        public Criteria andWorkShopEqualTo(String value) {
            addCriterion("work_shop =", value, "workShop");
            return (Criteria) this;
        }

        public Criteria andWorkShopNotEqualTo(String value) {
            addCriterion("work_shop <>", value, "workShop");
            return (Criteria) this;
        }

        public Criteria andWorkShopGreaterThan(String value) {
            addCriterion("work_shop >", value, "workShop");
            return (Criteria) this;
        }

        public Criteria andWorkShopGreaterThanOrEqualTo(String value) {
            addCriterion("work_shop >=", value, "workShop");
            return (Criteria) this;
        }

        public Criteria andWorkShopLessThan(String value) {
            addCriterion("work_shop <", value, "workShop");
            return (Criteria) this;
        }

        public Criteria andWorkShopLessThanOrEqualTo(String value) {
            addCriterion("work_shop <=", value, "workShop");
            return (Criteria) this;
        }
        
        public Criteria andWorkShopLike(String value) {
            addCriterion("work_shop like", value, "workShop");
            return (Criteria) this;
        }

        public Criteria andWorkShopNotLike(String value) {
            addCriterion("work_shop not like", value, "workShop");
            return (Criteria) this;
        }

        public Criteria andWorkShopIn(List<String> values) {
            addCriterion("work_shop in", values, "workShop");
            return (Criteria) this;
        }

        public Criteria andWorkShopNotIn(List<String> values) {
            addCriterion("work_shop not in", values, "workShop");
            return (Criteria) this;
        }

        public Criteria andWorkShopBetween(String value1, String value2) {
            addCriterion("work_shop between", value1, value2, "workShop");
            return (Criteria) this;
        }

        public Criteria andWorkShopNotBetween(String value1, String value2) {
            addCriterion("work_shop not between", value1, value2, "workShop");
            return (Criteria) this;
        }
			
		public Criteria andBrokerLevelIsNull() {
            addCriterion("broker_level is null");
            return (Criteria) this;
        }
        
        public Criteria andBrokerLevelIsNotNull() {
            addCriterion("broker_level is not null");
            return (Criteria) this;
        }
        
        public Criteria andBrokerLevelEqualTo(Integer value) {
            addCriterion("broker_level =", value, "brokerLevel");
            return (Criteria) this;
        }

        public Criteria andBrokerLevelNotEqualTo(Integer value) {
            addCriterion("broker_level <>", value, "brokerLevel");
            return (Criteria) this;
        }

        public Criteria andBrokerLevelGreaterThan(Integer value) {
            addCriterion("broker_level >", value, "brokerLevel");
            return (Criteria) this;
        }

        public Criteria andBrokerLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("broker_level >=", value, "brokerLevel");
            return (Criteria) this;
        }

        public Criteria andBrokerLevelLessThan(Integer value) {
            addCriterion("broker_level <", value, "brokerLevel");
            return (Criteria) this;
        }

        public Criteria andBrokerLevelLessThanOrEqualTo(Integer value) {
            addCriterion("broker_level <=", value, "brokerLevel");
            return (Criteria) this;
        }
        
        public Criteria andBrokerLevelIn(List<Integer> values) {
            addCriterion("broker_level in", values, "brokerLevel");
            return (Criteria) this;
        }

        public Criteria andBrokerLevelNotIn(List<Integer> values) {
            addCriterion("broker_level not in", values, "brokerLevel");
            return (Criteria) this;
        }

        public Criteria andBrokerLevelBetween(Integer value1, Integer value2) {
            addCriterion("broker_level between", value1, value2, "brokerLevel");
            return (Criteria) this;
        }

        public Criteria andBrokerLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("broker_level not between", value1, value2, "brokerLevel");
            return (Criteria) this;
        }
			
		public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }
        
        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }
        
        public Criteria andBirthDateEqualTo(Date value) {
            addCriterion("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(Date value) {
            addCriterion("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(Date value) {
            addCriterion("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(Date value) {
            addCriterion("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(Date value) {
            addCriterion("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(Date value) {
            addCriterion("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }
        
        public Criteria andBirthDateIn(List<Date> values) {
            addCriterion("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<Date> values) {
            addCriterion("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(Date value1, Date value2) {
            addCriterion("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(Date value1, Date value2) {
            addCriterion("birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }
			
		public Criteria andIdentityNumberIsNull() {
            addCriterion("identity_number is null");
            return (Criteria) this;
        }
        
        public Criteria andIdentityNumberIsNotNull() {
            addCriterion("identity_number is not null");
            return (Criteria) this;
        }
        
        public Criteria andIdentityNumberEqualTo(String value) {
            addCriterion("identity_number =", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotEqualTo(String value) {
            addCriterion("identity_number <>", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberGreaterThan(String value) {
            addCriterion("identity_number >", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberGreaterThanOrEqualTo(String value) {
            addCriterion("identity_number >=", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLessThan(String value) {
            addCriterion("identity_number <", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLessThanOrEqualTo(String value) {
            addCriterion("identity_number <=", value, "identityNumber");
            return (Criteria) this;
        }
        
        public Criteria andIdentityNumberLike(String value) {
            addCriterion("identity_number like", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotLike(String value) {
            addCriterion("identity_number not like", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberIn(List<String> values) {
            addCriterion("identity_number in", values, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotIn(List<String> values) {
            addCriterion("identity_number not in", values, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberBetween(String value1, String value2) {
            addCriterion("identity_number between", value1, value2, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotBetween(String value1, String value2) {
            addCriterion("identity_number not between", value1, value2, "identityNumber");
            return (Criteria) this;
        }
			
		public Criteria andHomeAddressIsNull() {
            addCriterion("home_address is null");
            return (Criteria) this;
        }
        
        public Criteria andHomeAddressIsNotNull() {
            addCriterion("home_address is not null");
            return (Criteria) this;
        }
        
        public Criteria andHomeAddressEqualTo(String value) {
            addCriterion("home_address =", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotEqualTo(String value) {
            addCriterion("home_address <>", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThan(String value) {
            addCriterion("home_address >", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("home_address >=", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThan(String value) {
            addCriterion("home_address <", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressLessThanOrEqualTo(String value) {
            addCriterion("home_address <=", value, "homeAddress");
            return (Criteria) this;
        }
        
        public Criteria andHomeAddressLike(String value) {
            addCriterion("home_address like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotLike(String value) {
            addCriterion("home_address not like", value, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressIn(List<String> values) {
            addCriterion("home_address in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotIn(List<String> values) {
            addCriterion("home_address not in", values, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressBetween(String value1, String value2) {
            addCriterion("home_address between", value1, value2, "homeAddress");
            return (Criteria) this;
        }

        public Criteria andHomeAddressNotBetween(String value1, String value2) {
            addCriterion("home_address not between", value1, value2, "homeAddress");
            return (Criteria) this;
        }
			
		public Criteria andPhotoUrlIsNull() {
            addCriterion("photo_url is null");
            return (Criteria) this;
        }
        
        public Criteria andPhotoUrlIsNotNull() {
            addCriterion("photo_url is not null");
            return (Criteria) this;
        }
        
        public Criteria andPhotoUrlEqualTo(String value) {
            addCriterion("photo_url =", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotEqualTo(String value) {
            addCriterion("photo_url <>", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThan(String value) {
            addCriterion("photo_url >", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("photo_url >=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThan(String value) {
            addCriterion("photo_url <", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("photo_url <=", value, "photoUrl");
            return (Criteria) this;
        }
        
        public Criteria andPhotoUrlLike(String value) {
            addCriterion("photo_url like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotLike(String value) {
            addCriterion("photo_url not like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIn(List<String> values) {
            addCriterion("photo_url in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotIn(List<String> values) {
            addCriterion("photo_url not in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlBetween(String value1, String value2) {
            addCriterion("photo_url between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("photo_url not between", value1, value2, "photoUrl");
            return (Criteria) this;
        }
			
		public Criteria andGuestNumberIsNull() {
            addCriterion("guest_number is null");
            return (Criteria) this;
        }
        
        public Criteria andGuestNumberIsNotNull() {
            addCriterion("guest_number is not null");
            return (Criteria) this;
        }
        
        public Criteria andGuestNumberEqualTo(Integer value) {
            addCriterion("guest_number =", value, "guestNumber");
            return (Criteria) this;
        }

        public Criteria andGuestNumberNotEqualTo(Integer value) {
            addCriterion("guest_number <>", value, "guestNumber");
            return (Criteria) this;
        }

        public Criteria andGuestNumberGreaterThan(Integer value) {
            addCriterion("guest_number >", value, "guestNumber");
            return (Criteria) this;
        }

        public Criteria andGuestNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("guest_number >=", value, "guestNumber");
            return (Criteria) this;
        }

        public Criteria andGuestNumberLessThan(Integer value) {
            addCriterion("guest_number <", value, "guestNumber");
            return (Criteria) this;
        }

        public Criteria andGuestNumberLessThanOrEqualTo(Integer value) {
            addCriterion("guest_number <=", value, "guestNumber");
            return (Criteria) this;
        }
        
        public Criteria andGuestNumberIn(List<Integer> values) {
            addCriterion("guest_number in", values, "guestNumber");
            return (Criteria) this;
        }

        public Criteria andGuestNumberNotIn(List<Integer> values) {
            addCriterion("guest_number not in", values, "guestNumber");
            return (Criteria) this;
        }

        public Criteria andGuestNumberBetween(Integer value1, Integer value2) {
            addCriterion("guest_number between", value1, value2, "guestNumber");
            return (Criteria) this;
        }

        public Criteria andGuestNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("guest_number not between", value1, value2, "guestNumber");
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
			
		public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }
        
        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }
        
        public Criteria andAuditStatusEqualTo(Integer value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(Integer value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(Integer value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(Integer value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }
        
        public Criteria andAuditStatusIn(List<Integer> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<Integer> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }
		}
	
	/**
     * This class corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
     */
	public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
    
    /**
     * This class corresponds to the database table EstateBroker
     *
     * @date 2020-03-20 11:01:20
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