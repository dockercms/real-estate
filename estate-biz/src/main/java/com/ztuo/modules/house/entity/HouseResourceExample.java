package com.ztuo.modules.house.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.math.BigDecimal;  
import java.util.Date;  
import java.util.Iterator;
import java.util.List;

public class HouseResourceExample implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
	protected String orderByClause;
	
    /**
     * This field corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
	protected boolean distinct;
	
	/**
     * This field corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
	protected List<Criteria> oredCriteria;
	
	/**
     * This method corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
	public HouseResourceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    /**
     * This method corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    /**
     * This method corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
    public String getOrderByClause() {
        return orderByClause;
    }
    
    /**
     * This method corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    
    /**
     * This method corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
    public boolean isDistinct() {
        return distinct;
    }
    
    /**
     * This method corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    
    /**
     * This method corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    
    /**
     * This method corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    
    /**
     * This method corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */   
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    /**
     * This method corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    
    /**
     * This method corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
	
	/**
     * This class corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
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
			
		public Criteria andApplicantNameIsNull() {
            addCriterion("applicant_name is null");
            return (Criteria) this;
        }
        
        public Criteria andApplicantNameIsNotNull() {
            addCriterion("applicant_name is not null");
            return (Criteria) this;
        }
        
        public Criteria andApplicantNameEqualTo(String value) {
            addCriterion("applicant_name =", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotEqualTo(String value) {
            addCriterion("applicant_name <>", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameGreaterThan(String value) {
            addCriterion("applicant_name >", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_name >=", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLessThan(String value) {
            addCriterion("applicant_name <", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameLessThanOrEqualTo(String value) {
            addCriterion("applicant_name <=", value, "applicantName");
            return (Criteria) this;
        }
        
        public Criteria andApplicantNameLike(String value) {
            addCriterion("applicant_name like", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotLike(String value) {
            addCriterion("applicant_name not like", value, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameIn(List<String> values) {
            addCriterion("applicant_name in", values, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotIn(List<String> values) {
            addCriterion("applicant_name not in", values, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameBetween(String value1, String value2) {
            addCriterion("applicant_name between", value1, value2, "applicantName");
            return (Criteria) this;
        }

        public Criteria andApplicantNameNotBetween(String value1, String value2) {
            addCriterion("applicant_name not between", value1, value2, "applicantName");
            return (Criteria) this;
        }
			
		public Criteria andApplicantPhoneIsNull() {
            addCriterion("applicant_phone is null");
            return (Criteria) this;
        }
        
        public Criteria andApplicantPhoneIsNotNull() {
            addCriterion("applicant_phone is not null");
            return (Criteria) this;
        }
        
        public Criteria andApplicantPhoneEqualTo(String value) {
            addCriterion("applicant_phone =", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotEqualTo(String value) {
            addCriterion("applicant_phone <>", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneGreaterThan(String value) {
            addCriterion("applicant_phone >", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("applicant_phone >=", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneLessThan(String value) {
            addCriterion("applicant_phone <", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneLessThanOrEqualTo(String value) {
            addCriterion("applicant_phone <=", value, "applicantPhone");
            return (Criteria) this;
        }
        
        public Criteria andApplicantPhoneLike(String value) {
            addCriterion("applicant_phone like", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotLike(String value) {
            addCriterion("applicant_phone not like", value, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneIn(List<String> values) {
            addCriterion("applicant_phone in", values, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotIn(List<String> values) {
            addCriterion("applicant_phone not in", values, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneBetween(String value1, String value2) {
            addCriterion("applicant_phone between", value1, value2, "applicantPhone");
            return (Criteria) this;
        }

        public Criteria andApplicantPhoneNotBetween(String value1, String value2) {
            addCriterion("applicant_phone not between", value1, value2, "applicantPhone");
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
			
		public Criteria andBrokerPhotoIsNull() {
            addCriterion("broker_photo is null");
            return (Criteria) this;
        }
        
        public Criteria andBrokerPhotoIsNotNull() {
            addCriterion("broker_photo is not null");
            return (Criteria) this;
        }
        
        public Criteria andBrokerPhotoEqualTo(String value) {
            addCriterion("broker_photo =", value, "brokerPhoto");
            return (Criteria) this;
        }

        public Criteria andBrokerPhotoNotEqualTo(String value) {
            addCriterion("broker_photo <>", value, "brokerPhoto");
            return (Criteria) this;
        }

        public Criteria andBrokerPhotoGreaterThan(String value) {
            addCriterion("broker_photo >", value, "brokerPhoto");
            return (Criteria) this;
        }

        public Criteria andBrokerPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("broker_photo >=", value, "brokerPhoto");
            return (Criteria) this;
        }

        public Criteria andBrokerPhotoLessThan(String value) {
            addCriterion("broker_photo <", value, "brokerPhoto");
            return (Criteria) this;
        }

        public Criteria andBrokerPhotoLessThanOrEqualTo(String value) {
            addCriterion("broker_photo <=", value, "brokerPhoto");
            return (Criteria) this;
        }
        
        public Criteria andBrokerPhotoLike(String value) {
            addCriterion("broker_photo like", value, "brokerPhoto");
            return (Criteria) this;
        }

        public Criteria andBrokerPhotoNotLike(String value) {
            addCriterion("broker_photo not like", value, "brokerPhoto");
            return (Criteria) this;
        }

        public Criteria andBrokerPhotoIn(List<String> values) {
            addCriterion("broker_photo in", values, "brokerPhoto");
            return (Criteria) this;
        }

        public Criteria andBrokerPhotoNotIn(List<String> values) {
            addCriterion("broker_photo not in", values, "brokerPhoto");
            return (Criteria) this;
        }

        public Criteria andBrokerPhotoBetween(String value1, String value2) {
            addCriterion("broker_photo between", value1, value2, "brokerPhoto");
            return (Criteria) this;
        }

        public Criteria andBrokerPhotoNotBetween(String value1, String value2) {
            addCriterion("broker_photo not between", value1, value2, "brokerPhoto");
            return (Criteria) this;
        }
			
		public Criteria andEstateTypeIsNull() {
            addCriterion("estate_type is null");
            return (Criteria) this;
        }
        
        public Criteria andEstateTypeIsNotNull() {
            addCriterion("estate_type is not null");
            return (Criteria) this;
        }
        
        public Criteria andEstateTypeEqualTo(Integer value) {
            addCriterion("estate_type =", value, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeNotEqualTo(Integer value) {
            addCriterion("estate_type <>", value, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeGreaterThan(Integer value) {
            addCriterion("estate_type >", value, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("estate_type >=", value, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeLessThan(Integer value) {
            addCriterion("estate_type <", value, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("estate_type <=", value, "estateType");
            return (Criteria) this;
        }
        
        public Criteria andEstateTypeIn(List<Integer> values) {
            addCriterion("estate_type in", values, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeNotIn(List<Integer> values) {
            addCriterion("estate_type not in", values, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeBetween(Integer value1, Integer value2) {
            addCriterion("estate_type between", value1, value2, "estateType");
            return (Criteria) this;
        }

        public Criteria andEstateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("estate_type not between", value1, value2, "estateType");
            return (Criteria) this;
        }
			
		public Criteria andUseWayIsNull() {
            addCriterion("use_way is null");
            return (Criteria) this;
        }
        
        public Criteria andUseWayIsNotNull() {
            addCriterion("use_way is not null");
            return (Criteria) this;
        }
        
        public Criteria andUseWayEqualTo(Integer value) {
            addCriterion("use_way =", value, "useWay");
            return (Criteria) this;
        }

        public Criteria andUseWayNotEqualTo(Integer value) {
            addCriterion("use_way <>", value, "useWay");
            return (Criteria) this;
        }

        public Criteria andUseWayGreaterThan(Integer value) {
            addCriterion("use_way >", value, "useWay");
            return (Criteria) this;
        }

        public Criteria andUseWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_way >=", value, "useWay");
            return (Criteria) this;
        }

        public Criteria andUseWayLessThan(Integer value) {
            addCriterion("use_way <", value, "useWay");
            return (Criteria) this;
        }

        public Criteria andUseWayLessThanOrEqualTo(Integer value) {
            addCriterion("use_way <=", value, "useWay");
            return (Criteria) this;
        }
        
        public Criteria andUseWayIn(List<Integer> values) {
            addCriterion("use_way in", values, "useWay");
            return (Criteria) this;
        }

        public Criteria andUseWayNotIn(List<Integer> values) {
            addCriterion("use_way not in", values, "useWay");
            return (Criteria) this;
        }

        public Criteria andUseWayBetween(Integer value1, Integer value2) {
            addCriterion("use_way between", value1, value2, "useWay");
            return (Criteria) this;
        }

        public Criteria andUseWayNotBetween(Integer value1, Integer value2) {
            addCriterion("use_way not between", value1, value2, "useWay");
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
			
		public Criteria andOwnerNameIsNull() {
            addCriterion("owner_name is null");
            return (Criteria) this;
        }
        
        public Criteria andOwnerNameIsNotNull() {
            addCriterion("owner_name is not null");
            return (Criteria) this;
        }
        
        public Criteria andOwnerNameEqualTo(String value) {
            addCriterion("owner_name =", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotEqualTo(String value) {
            addCriterion("owner_name <>", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThan(String value) {
            addCriterion("owner_name >", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("owner_name >=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThan(String value) {
            addCriterion("owner_name <", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("owner_name <=", value, "ownerName");
            return (Criteria) this;
        }
        
        public Criteria andOwnerNameLike(String value) {
            addCriterion("owner_name like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotLike(String value) {
            addCriterion("owner_name not like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIn(List<String> values) {
            addCriterion("owner_name in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotIn(List<String> values) {
            addCriterion("owner_name not in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameBetween(String value1, String value2) {
            addCriterion("owner_name between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotBetween(String value1, String value2) {
            addCriterion("owner_name not between", value1, value2, "ownerName");
            return (Criteria) this;
        }
			
		public Criteria andOwnerPhoneIsNull() {
            addCriterion("owner_phone is null");
            return (Criteria) this;
        }
        
        public Criteria andOwnerPhoneIsNotNull() {
            addCriterion("owner_phone is not null");
            return (Criteria) this;
        }
        
        public Criteria andOwnerPhoneEqualTo(String value) {
            addCriterion("owner_phone =", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotEqualTo(String value) {
            addCriterion("owner_phone <>", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneGreaterThan(String value) {
            addCriterion("owner_phone >", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("owner_phone >=", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneLessThan(String value) {
            addCriterion("owner_phone <", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneLessThanOrEqualTo(String value) {
            addCriterion("owner_phone <=", value, "ownerPhone");
            return (Criteria) this;
        }
        
        public Criteria andOwnerPhoneLike(String value) {
            addCriterion("owner_phone like", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotLike(String value) {
            addCriterion("owner_phone not like", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneIn(List<String> values) {
            addCriterion("owner_phone in", values, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotIn(List<String> values) {
            addCriterion("owner_phone not in", values, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneBetween(String value1, String value2) {
            addCriterion("owner_phone between", value1, value2, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotBetween(String value1, String value2) {
            addCriterion("owner_phone not between", value1, value2, "ownerPhone");
            return (Criteria) this;
        }
			
		public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }
        
        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }
        
        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }
        
        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }
			
		public Criteria andHouseDetailTypeIsNull() {
            addCriterion("house_detail_type is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseDetailTypeIsNotNull() {
            addCriterion("house_detail_type is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseDetailTypeEqualTo(Integer value) {
            addCriterion("house_detail_type =", value, "houseDetailType");
            return (Criteria) this;
        }

        public Criteria andHouseDetailTypeNotEqualTo(Integer value) {
            addCriterion("house_detail_type <>", value, "houseDetailType");
            return (Criteria) this;
        }

        public Criteria andHouseDetailTypeGreaterThan(Integer value) {
            addCriterion("house_detail_type >", value, "houseDetailType");
            return (Criteria) this;
        }

        public Criteria andHouseDetailTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_detail_type >=", value, "houseDetailType");
            return (Criteria) this;
        }

        public Criteria andHouseDetailTypeLessThan(Integer value) {
            addCriterion("house_detail_type <", value, "houseDetailType");
            return (Criteria) this;
        }

        public Criteria andHouseDetailTypeLessThanOrEqualTo(Integer value) {
            addCriterion("house_detail_type <=", value, "houseDetailType");
            return (Criteria) this;
        }
        
        public Criteria andHouseDetailTypeIn(List<Integer> values) {
            addCriterion("house_detail_type in", values, "houseDetailType");
            return (Criteria) this;
        }

        public Criteria andHouseDetailTypeNotIn(List<Integer> values) {
            addCriterion("house_detail_type not in", values, "houseDetailType");
            return (Criteria) this;
        }

        public Criteria andHouseDetailTypeBetween(Integer value1, Integer value2) {
            addCriterion("house_detail_type between", value1, value2, "houseDetailType");
            return (Criteria) this;
        }

        public Criteria andHouseDetailTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("house_detail_type not between", value1, value2, "houseDetailType");
            return (Criteria) this;
        }
			
		public Criteria andRentalTypeIsNull() {
            addCriterion("rental_type is null");
            return (Criteria) this;
        }
        
        public Criteria andRentalTypeIsNotNull() {
            addCriterion("rental_type is not null");
            return (Criteria) this;
        }
        
        public Criteria andRentalTypeEqualTo(Integer value) {
            addCriterion("rental_type =", value, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeNotEqualTo(Integer value) {
            addCriterion("rental_type <>", value, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeGreaterThan(Integer value) {
            addCriterion("rental_type >", value, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rental_type >=", value, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeLessThan(Integer value) {
            addCriterion("rental_type <", value, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeLessThanOrEqualTo(Integer value) {
            addCriterion("rental_type <=", value, "rentalType");
            return (Criteria) this;
        }
        
        public Criteria andRentalTypeIn(List<Integer> values) {
            addCriterion("rental_type in", values, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeNotIn(List<Integer> values) {
            addCriterion("rental_type not in", values, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeBetween(Integer value1, Integer value2) {
            addCriterion("rental_type between", value1, value2, "rentalType");
            return (Criteria) this;
        }

        public Criteria andRentalTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("rental_type not between", value1, value2, "rentalType");
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
			
		public Criteria andRegionCodeIsNull() {
            addCriterion("region_code is null");
            return (Criteria) this;
        }
        
        public Criteria andRegionCodeIsNotNull() {
            addCriterion("region_code is not null");
            return (Criteria) this;
        }
        
        public Criteria andRegionCodeEqualTo(String value) {
            addCriterion("region_code =", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotEqualTo(String value) {
            addCriterion("region_code <>", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThan(String value) {
            addCriterion("region_code >", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("region_code >=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThan(String value) {
            addCriterion("region_code <", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("region_code <=", value, "regionCode");
            return (Criteria) this;
        }
        
        public Criteria andRegionCodeLike(String value) {
            addCriterion("region_code like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotLike(String value) {
            addCriterion("region_code not like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIn(List<String> values) {
            addCriterion("region_code in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotIn(List<String> values) {
            addCriterion("region_code not in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeBetween(String value1, String value2) {
            addCriterion("region_code between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotBetween(String value1, String value2) {
            addCriterion("region_code not between", value1, value2, "regionCode");
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
			
		public Criteria andPlotNameIsNull() {
            addCriterion("plot_name is null");
            return (Criteria) this;
        }
        
        public Criteria andPlotNameIsNotNull() {
            addCriterion("plot_name is not null");
            return (Criteria) this;
        }
        
        public Criteria andPlotNameEqualTo(String value) {
            addCriterion("plot_name =", value, "plotName");
            return (Criteria) this;
        }

        public Criteria andPlotNameNotEqualTo(String value) {
            addCriterion("plot_name <>", value, "plotName");
            return (Criteria) this;
        }

        public Criteria andPlotNameGreaterThan(String value) {
            addCriterion("plot_name >", value, "plotName");
            return (Criteria) this;
        }

        public Criteria andPlotNameGreaterThanOrEqualTo(String value) {
            addCriterion("plot_name >=", value, "plotName");
            return (Criteria) this;
        }

        public Criteria andPlotNameLessThan(String value) {
            addCriterion("plot_name <", value, "plotName");
            return (Criteria) this;
        }

        public Criteria andPlotNameLessThanOrEqualTo(String value) {
            addCriterion("plot_name <=", value, "plotName");
            return (Criteria) this;
        }
        
        public Criteria andPlotNameLike(String value) {
            addCriterion("plot_name like", value, "plotName");
            return (Criteria) this;
        }

        public Criteria andPlotNameNotLike(String value) {
            addCriterion("plot_name not like", value, "plotName");
            return (Criteria) this;
        }

        public Criteria andPlotNameIn(List<String> values) {
            addCriterion("plot_name in", values, "plotName");
            return (Criteria) this;
        }

        public Criteria andPlotNameNotIn(List<String> values) {
            addCriterion("plot_name not in", values, "plotName");
            return (Criteria) this;
        }

        public Criteria andPlotNameBetween(String value1, String value2) {
            addCriterion("plot_name between", value1, value2, "plotName");
            return (Criteria) this;
        }

        public Criteria andPlotNameNotBetween(String value1, String value2) {
            addCriterion("plot_name not between", value1, value2, "plotName");
            return (Criteria) this;
        }
			
		public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }
        
        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }
        
        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }
        
        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }
			
		public Criteria andHouseNumberIsNull() {
            addCriterion("house_number is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseNumberIsNotNull() {
            addCriterion("house_number is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseNumberEqualTo(String value) {
            addCriterion("house_number =", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberNotEqualTo(String value) {
            addCriterion("house_number <>", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberGreaterThan(String value) {
            addCriterion("house_number >", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("house_number >=", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberLessThan(String value) {
            addCriterion("house_number <", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberLessThanOrEqualTo(String value) {
            addCriterion("house_number <=", value, "houseNumber");
            return (Criteria) this;
        }
        
        public Criteria andHouseNumberLike(String value) {
            addCriterion("house_number like", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberNotLike(String value) {
            addCriterion("house_number not like", value, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberIn(List<String> values) {
            addCriterion("house_number in", values, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberNotIn(List<String> values) {
            addCriterion("house_number not in", values, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberBetween(String value1, String value2) {
            addCriterion("house_number between", value1, value2, "houseNumber");
            return (Criteria) this;
        }

        public Criteria andHouseNumberNotBetween(String value1, String value2) {
            addCriterion("house_number not between", value1, value2, "houseNumber");
            return (Criteria) this;
        }
			
		public Criteria andFloorTypeIsNull() {
            addCriterion("floor_type is null");
            return (Criteria) this;
        }
        
        public Criteria andFloorTypeIsNotNull() {
            addCriterion("floor_type is not null");
            return (Criteria) this;
        }
        
        public Criteria andFloorTypeEqualTo(Integer value) {
            addCriterion("floor_type =", value, "floorType");
            return (Criteria) this;
        }

        public Criteria andFloorTypeNotEqualTo(Integer value) {
            addCriterion("floor_type <>", value, "floorType");
            return (Criteria) this;
        }

        public Criteria andFloorTypeGreaterThan(Integer value) {
            addCriterion("floor_type >", value, "floorType");
            return (Criteria) this;
        }

        public Criteria andFloorTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("floor_type >=", value, "floorType");
            return (Criteria) this;
        }

        public Criteria andFloorTypeLessThan(Integer value) {
            addCriterion("floor_type <", value, "floorType");
            return (Criteria) this;
        }

        public Criteria andFloorTypeLessThanOrEqualTo(Integer value) {
            addCriterion("floor_type <=", value, "floorType");
            return (Criteria) this;
        }
        
        public Criteria andFloorTypeIn(List<Integer> values) {
            addCriterion("floor_type in", values, "floorType");
            return (Criteria) this;
        }

        public Criteria andFloorTypeNotIn(List<Integer> values) {
            addCriterion("floor_type not in", values, "floorType");
            return (Criteria) this;
        }

        public Criteria andFloorTypeBetween(Integer value1, Integer value2) {
            addCriterion("floor_type between", value1, value2, "floorType");
            return (Criteria) this;
        }

        public Criteria andFloorTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("floor_type not between", value1, value2, "floorType");
            return (Criteria) this;
        }
			
		public Criteria andFloorInformationIsNull() {
            addCriterion("floor_information is null");
            return (Criteria) this;
        }
        
        public Criteria andFloorInformationIsNotNull() {
            addCriterion("floor_information is not null");
            return (Criteria) this;
        }
        
        public Criteria andFloorInformationEqualTo(String value) {
            addCriterion("floor_information =", value, "floorInformation");
            return (Criteria) this;
        }

        public Criteria andFloorInformationNotEqualTo(String value) {
            addCriterion("floor_information <>", value, "floorInformation");
            return (Criteria) this;
        }

        public Criteria andFloorInformationGreaterThan(String value) {
            addCriterion("floor_information >", value, "floorInformation");
            return (Criteria) this;
        }

        public Criteria andFloorInformationGreaterThanOrEqualTo(String value) {
            addCriterion("floor_information >=", value, "floorInformation");
            return (Criteria) this;
        }

        public Criteria andFloorInformationLessThan(String value) {
            addCriterion("floor_information <", value, "floorInformation");
            return (Criteria) this;
        }

        public Criteria andFloorInformationLessThanOrEqualTo(String value) {
            addCriterion("floor_information <=", value, "floorInformation");
            return (Criteria) this;
        }
        
        public Criteria andFloorInformationLike(String value) {
            addCriterion("floor_information like", value, "floorInformation");
            return (Criteria) this;
        }

        public Criteria andFloorInformationNotLike(String value) {
            addCriterion("floor_information not like", value, "floorInformation");
            return (Criteria) this;
        }

        public Criteria andFloorInformationIn(List<String> values) {
            addCriterion("floor_information in", values, "floorInformation");
            return (Criteria) this;
        }

        public Criteria andFloorInformationNotIn(List<String> values) {
            addCriterion("floor_information not in", values, "floorInformation");
            return (Criteria) this;
        }

        public Criteria andFloorInformationBetween(String value1, String value2) {
            addCriterion("floor_information between", value1, value2, "floorInformation");
            return (Criteria) this;
        }

        public Criteria andFloorInformationNotBetween(String value1, String value2) {
            addCriterion("floor_information not between", value1, value2, "floorInformation");
            return (Criteria) this;
        }
			
		public Criteria andBuildYearIsNull() {
            addCriterion("build_year is null");
            return (Criteria) this;
        }
        
        public Criteria andBuildYearIsNotNull() {
            addCriterion("build_year is not null");
            return (Criteria) this;
        }
        
        public Criteria andBuildYearEqualTo(Date value) {
            addCriterion("build_year =", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotEqualTo(Date value) {
            addCriterion("build_year <>", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearGreaterThan(Date value) {
            addCriterion("build_year >", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearGreaterThanOrEqualTo(Date value) {
            addCriterion("build_year >=", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearLessThan(Date value) {
            addCriterion("build_year <", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearLessThanOrEqualTo(Date value) {
            addCriterion("build_year <=", value, "buildYear");
            return (Criteria) this;
        }
        
        public Criteria andBuildYearIn(List<Date> values) {
            addCriterion("build_year in", values, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotIn(List<Date> values) {
            addCriterion("build_year not in", values, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearBetween(Date value1, Date value2) {
            addCriterion("build_year between", value1, value2, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotBetween(Date value1, Date value2) {
            addCriterion("build_year not between", value1, value2, "buildYear");
            return (Criteria) this;
        }
			
		public Criteria andMaturityAssetsIsNull() {
            addCriterion("maturity_assets is null");
            return (Criteria) this;
        }
        
        public Criteria andMaturityAssetsIsNotNull() {
            addCriterion("maturity_assets is not null");
            return (Criteria) this;
        }
        
        public Criteria andMaturityAssetsEqualTo(String value) {
            addCriterion("maturity_assets =", value, "maturityAssets");
            return (Criteria) this;
        }

        public Criteria andMaturityAssetsNotEqualTo(String value) {
            addCriterion("maturity_assets <>", value, "maturityAssets");
            return (Criteria) this;
        }

        public Criteria andMaturityAssetsGreaterThan(String value) {
            addCriterion("maturity_assets >", value, "maturityAssets");
            return (Criteria) this;
        }

        public Criteria andMaturityAssetsGreaterThanOrEqualTo(String value) {
            addCriterion("maturity_assets >=", value, "maturityAssets");
            return (Criteria) this;
        }

        public Criteria andMaturityAssetsLessThan(String value) {
            addCriterion("maturity_assets <", value, "maturityAssets");
            return (Criteria) this;
        }

        public Criteria andMaturityAssetsLessThanOrEqualTo(String value) {
            addCriterion("maturity_assets <=", value, "maturityAssets");
            return (Criteria) this;
        }
        
        public Criteria andMaturityAssetsLike(String value) {
            addCriterion("maturity_assets like", value, "maturityAssets");
            return (Criteria) this;
        }

        public Criteria andMaturityAssetsNotLike(String value) {
            addCriterion("maturity_assets not like", value, "maturityAssets");
            return (Criteria) this;
        }

        public Criteria andMaturityAssetsIn(List<String> values) {
            addCriterion("maturity_assets in", values, "maturityAssets");
            return (Criteria) this;
        }

        public Criteria andMaturityAssetsNotIn(List<String> values) {
            addCriterion("maturity_assets not in", values, "maturityAssets");
            return (Criteria) this;
        }

        public Criteria andMaturityAssetsBetween(String value1, String value2) {
            addCriterion("maturity_assets between", value1, value2, "maturityAssets");
            return (Criteria) this;
        }

        public Criteria andMaturityAssetsNotBetween(String value1, String value2) {
            addCriterion("maturity_assets not between", value1, value2, "maturityAssets");
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
			
		public Criteria andElevatorIsNull() {
            addCriterion("elevator is null");
            return (Criteria) this;
        }
        
        public Criteria andElevatorIsNotNull() {
            addCriterion("elevator is not null");
            return (Criteria) this;
        }
        
        public Criteria andElevatorEqualTo(Integer value) {
            addCriterion("elevator =", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorNotEqualTo(Integer value) {
            addCriterion("elevator <>", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorGreaterThan(Integer value) {
            addCriterion("elevator >", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("elevator >=", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorLessThan(Integer value) {
            addCriterion("elevator <", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorLessThanOrEqualTo(Integer value) {
            addCriterion("elevator <=", value, "elevator");
            return (Criteria) this;
        }
        
        public Criteria andElevatorIn(List<Integer> values) {
            addCriterion("elevator in", values, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorNotIn(List<Integer> values) {
            addCriterion("elevator not in", values, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorBetween(Integer value1, Integer value2) {
            addCriterion("elevator between", value1, value2, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorNotBetween(Integer value1, Integer value2) {
            addCriterion("elevator not between", value1, value2, "elevator");
            return (Criteria) this;
        }
			
		public Criteria andHouseTypeRoomIsNull() {
            addCriterion("house_type_room is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeRoomIsNotNull() {
            addCriterion("house_type_room is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeRoomEqualTo(Integer value) {
            addCriterion("house_type_room =", value, "houseTypeRoom");
            return (Criteria) this;
        }

        public Criteria andHouseTypeRoomNotEqualTo(Integer value) {
            addCriterion("house_type_room <>", value, "houseTypeRoom");
            return (Criteria) this;
        }

        public Criteria andHouseTypeRoomGreaterThan(Integer value) {
            addCriterion("house_type_room >", value, "houseTypeRoom");
            return (Criteria) this;
        }

        public Criteria andHouseTypeRoomGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_type_room >=", value, "houseTypeRoom");
            return (Criteria) this;
        }

        public Criteria andHouseTypeRoomLessThan(Integer value) {
            addCriterion("house_type_room <", value, "houseTypeRoom");
            return (Criteria) this;
        }

        public Criteria andHouseTypeRoomLessThanOrEqualTo(Integer value) {
            addCriterion("house_type_room <=", value, "houseTypeRoom");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeRoomIn(List<Integer> values) {
            addCriterion("house_type_room in", values, "houseTypeRoom");
            return (Criteria) this;
        }

        public Criteria andHouseTypeRoomNotIn(List<Integer> values) {
            addCriterion("house_type_room not in", values, "houseTypeRoom");
            return (Criteria) this;
        }

        public Criteria andHouseTypeRoomBetween(Integer value1, Integer value2) {
            addCriterion("house_type_room between", value1, value2, "houseTypeRoom");
            return (Criteria) this;
        }

        public Criteria andHouseTypeRoomNotBetween(Integer value1, Integer value2) {
            addCriterion("house_type_room not between", value1, value2, "houseTypeRoom");
            return (Criteria) this;
        }
			
		public Criteria andHouseTypeHallIsNull() {
            addCriterion("house_type_hall is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeHallIsNotNull() {
            addCriterion("house_type_hall is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeHallEqualTo(Integer value) {
            addCriterion("house_type_hall =", value, "houseTypeHall");
            return (Criteria) this;
        }

        public Criteria andHouseTypeHallNotEqualTo(Integer value) {
            addCriterion("house_type_hall <>", value, "houseTypeHall");
            return (Criteria) this;
        }

        public Criteria andHouseTypeHallGreaterThan(Integer value) {
            addCriterion("house_type_hall >", value, "houseTypeHall");
            return (Criteria) this;
        }

        public Criteria andHouseTypeHallGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_type_hall >=", value, "houseTypeHall");
            return (Criteria) this;
        }

        public Criteria andHouseTypeHallLessThan(Integer value) {
            addCriterion("house_type_hall <", value, "houseTypeHall");
            return (Criteria) this;
        }

        public Criteria andHouseTypeHallLessThanOrEqualTo(Integer value) {
            addCriterion("house_type_hall <=", value, "houseTypeHall");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeHallIn(List<Integer> values) {
            addCriterion("house_type_hall in", values, "houseTypeHall");
            return (Criteria) this;
        }

        public Criteria andHouseTypeHallNotIn(List<Integer> values) {
            addCriterion("house_type_hall not in", values, "houseTypeHall");
            return (Criteria) this;
        }

        public Criteria andHouseTypeHallBetween(Integer value1, Integer value2) {
            addCriterion("house_type_hall between", value1, value2, "houseTypeHall");
            return (Criteria) this;
        }

        public Criteria andHouseTypeHallNotBetween(Integer value1, Integer value2) {
            addCriterion("house_type_hall not between", value1, value2, "houseTypeHall");
            return (Criteria) this;
        }
			
		public Criteria andHouseTypeToiletIsNull() {
            addCriterion("house_type_toilet is null");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeToiletIsNotNull() {
            addCriterion("house_type_toilet is not null");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeToiletEqualTo(Integer value) {
            addCriterion("house_type_toilet =", value, "houseTypeToilet");
            return (Criteria) this;
        }

        public Criteria andHouseTypeToiletNotEqualTo(Integer value) {
            addCriterion("house_type_toilet <>", value, "houseTypeToilet");
            return (Criteria) this;
        }

        public Criteria andHouseTypeToiletGreaterThan(Integer value) {
            addCriterion("house_type_toilet >", value, "houseTypeToilet");
            return (Criteria) this;
        }

        public Criteria andHouseTypeToiletGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_type_toilet >=", value, "houseTypeToilet");
            return (Criteria) this;
        }

        public Criteria andHouseTypeToiletLessThan(Integer value) {
            addCriterion("house_type_toilet <", value, "houseTypeToilet");
            return (Criteria) this;
        }

        public Criteria andHouseTypeToiletLessThanOrEqualTo(Integer value) {
            addCriterion("house_type_toilet <=", value, "houseTypeToilet");
            return (Criteria) this;
        }
        
        public Criteria andHouseTypeToiletIn(List<Integer> values) {
            addCriterion("house_type_toilet in", values, "houseTypeToilet");
            return (Criteria) this;
        }

        public Criteria andHouseTypeToiletNotIn(List<Integer> values) {
            addCriterion("house_type_toilet not in", values, "houseTypeToilet");
            return (Criteria) this;
        }

        public Criteria andHouseTypeToiletBetween(Integer value1, Integer value2) {
            addCriterion("house_type_toilet between", value1, value2, "houseTypeToilet");
            return (Criteria) this;
        }

        public Criteria andHouseTypeToiletNotBetween(Integer value1, Integer value2) {
            addCriterion("house_type_toilet not between", value1, value2, "houseTypeToilet");
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
        
        public Criteria andHouseAreaEqualTo(BigDecimal value) {
            addCriterion("house_area =", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotEqualTo(BigDecimal value) {
            addCriterion("house_area <>", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThan(BigDecimal value) {
            addCriterion("house_area >", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("house_area >=", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThan(BigDecimal value) {
            addCriterion("house_area <", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("house_area <=", value, "houseArea");
            return (Criteria) this;
        }
        
        public Criteria andHouseAreaIn(List<BigDecimal> values) {
            addCriterion("house_area in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotIn(List<BigDecimal> values) {
            addCriterion("house_area not in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("house_area between", value1, value2, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("house_area not between", value1, value2, "houseArea");
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
			
		public Criteria andMonthlyRentIsNull() {
            addCriterion("monthly_rent is null");
            return (Criteria) this;
        }
        
        public Criteria andMonthlyRentIsNotNull() {
            addCriterion("monthly_rent is not null");
            return (Criteria) this;
        }
        
        public Criteria andMonthlyRentEqualTo(BigDecimal value) {
            addCriterion("monthly_rent =", value, "monthlyRent");
            return (Criteria) this;
        }

        public Criteria andMonthlyRentNotEqualTo(BigDecimal value) {
            addCriterion("monthly_rent <>", value, "monthlyRent");
            return (Criteria) this;
        }

        public Criteria andMonthlyRentGreaterThan(BigDecimal value) {
            addCriterion("monthly_rent >", value, "monthlyRent");
            return (Criteria) this;
        }

        public Criteria andMonthlyRentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_rent >=", value, "monthlyRent");
            return (Criteria) this;
        }

        public Criteria andMonthlyRentLessThan(BigDecimal value) {
            addCriterion("monthly_rent <", value, "monthlyRent");
            return (Criteria) this;
        }

        public Criteria andMonthlyRentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_rent <=", value, "monthlyRent");
            return (Criteria) this;
        }
        
        public Criteria andMonthlyRentIn(List<BigDecimal> values) {
            addCriterion("monthly_rent in", values, "monthlyRent");
            return (Criteria) this;
        }

        public Criteria andMonthlyRentNotIn(List<BigDecimal> values) {
            addCriterion("monthly_rent not in", values, "monthlyRent");
            return (Criteria) this;
        }

        public Criteria andMonthlyRentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_rent between", value1, value2, "monthlyRent");
            return (Criteria) this;
        }

        public Criteria andMonthlyRentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_rent not between", value1, value2, "monthlyRent");
            return (Criteria) this;
        }
			
		public Criteria andAnnualRentIsNull() {
            addCriterion("annual_rent is null");
            return (Criteria) this;
        }
        
        public Criteria andAnnualRentIsNotNull() {
            addCriterion("annual_rent is not null");
            return (Criteria) this;
        }
        
        public Criteria andAnnualRentEqualTo(BigDecimal value) {
            addCriterion("annual_rent =", value, "annualRent");
            return (Criteria) this;
        }

        public Criteria andAnnualRentNotEqualTo(BigDecimal value) {
            addCriterion("annual_rent <>", value, "annualRent");
            return (Criteria) this;
        }

        public Criteria andAnnualRentGreaterThan(BigDecimal value) {
            addCriterion("annual_rent >", value, "annualRent");
            return (Criteria) this;
        }

        public Criteria andAnnualRentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("annual_rent >=", value, "annualRent");
            return (Criteria) this;
        }

        public Criteria andAnnualRentLessThan(BigDecimal value) {
            addCriterion("annual_rent <", value, "annualRent");
            return (Criteria) this;
        }

        public Criteria andAnnualRentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("annual_rent <=", value, "annualRent");
            return (Criteria) this;
        }
        
        public Criteria andAnnualRentIn(List<BigDecimal> values) {
            addCriterion("annual_rent in", values, "annualRent");
            return (Criteria) this;
        }

        public Criteria andAnnualRentNotIn(List<BigDecimal> values) {
            addCriterion("annual_rent not in", values, "annualRent");
            return (Criteria) this;
        }

        public Criteria andAnnualRentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annual_rent between", value1, value2, "annualRent");
            return (Criteria) this;
        }

        public Criteria andAnnualRentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annual_rent not between", value1, value2, "annualRent");
            return (Criteria) this;
        }
			
		public Criteria andPaymentMethodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }
        
        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }
        
        public Criteria andPaymentMethodEqualTo(Integer value) {
            addCriterion("payment_method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(Integer value) {
            addCriterion("payment_method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(Integer value) {
            addCriterion("payment_method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(Integer value) {
            addCriterion("payment_method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(Integer value) {
            addCriterion("payment_method <=", value, "paymentMethod");
            return (Criteria) this;
        }
        
        public Criteria andPaymentMethodIn(List<Integer> values) {
            addCriterion("payment_method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<Integer> values) {
            addCriterion("payment_method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(Integer value1, Integer value2) {
            addCriterion("payment_method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }
			
		public Criteria andListingDescriptionIsNull() {
            addCriterion("listing_description is null");
            return (Criteria) this;
        }
        
        public Criteria andListingDescriptionIsNotNull() {
            addCriterion("listing_description is not null");
            return (Criteria) this;
        }
        
        public Criteria andListingDescriptionEqualTo(String value) {
            addCriterion("listing_description =", value, "listingDescription");
            return (Criteria) this;
        }

        public Criteria andListingDescriptionNotEqualTo(String value) {
            addCriterion("listing_description <>", value, "listingDescription");
            return (Criteria) this;
        }

        public Criteria andListingDescriptionGreaterThan(String value) {
            addCriterion("listing_description >", value, "listingDescription");
            return (Criteria) this;
        }

        public Criteria andListingDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("listing_description >=", value, "listingDescription");
            return (Criteria) this;
        }

        public Criteria andListingDescriptionLessThan(String value) {
            addCriterion("listing_description <", value, "listingDescription");
            return (Criteria) this;
        }

        public Criteria andListingDescriptionLessThanOrEqualTo(String value) {
            addCriterion("listing_description <=", value, "listingDescription");
            return (Criteria) this;
        }
        
        public Criteria andListingDescriptionLike(String value) {
            addCriterion("listing_description like", value, "listingDescription");
            return (Criteria) this;
        }

        public Criteria andListingDescriptionNotLike(String value) {
            addCriterion("listing_description not like", value, "listingDescription");
            return (Criteria) this;
        }

        public Criteria andListingDescriptionIn(List<String> values) {
            addCriterion("listing_description in", values, "listingDescription");
            return (Criteria) this;
        }

        public Criteria andListingDescriptionNotIn(List<String> values) {
            addCriterion("listing_description not in", values, "listingDescription");
            return (Criteria) this;
        }

        public Criteria andListingDescriptionBetween(String value1, String value2) {
            addCriterion("listing_description between", value1, value2, "listingDescription");
            return (Criteria) this;
        }

        public Criteria andListingDescriptionNotBetween(String value1, String value2) {
            addCriterion("listing_description not between", value1, value2, "listingDescription");
            return (Criteria) this;
        }
			
		public Criteria andListingPicturesIsNull() {
            addCriterion("listing_pictures is null");
            return (Criteria) this;
        }
        
        public Criteria andListingPicturesIsNotNull() {
            addCriterion("listing_pictures is not null");
            return (Criteria) this;
        }
        
        public Criteria andListingPicturesEqualTo(String value) {
            addCriterion("listing_pictures =", value, "listingPictures");
            return (Criteria) this;
        }

        public Criteria andListingPicturesNotEqualTo(String value) {
            addCriterion("listing_pictures <>", value, "listingPictures");
            return (Criteria) this;
        }

        public Criteria andListingPicturesGreaterThan(String value) {
            addCriterion("listing_pictures >", value, "listingPictures");
            return (Criteria) this;
        }

        public Criteria andListingPicturesGreaterThanOrEqualTo(String value) {
            addCriterion("listing_pictures >=", value, "listingPictures");
            return (Criteria) this;
        }

        public Criteria andListingPicturesLessThan(String value) {
            addCriterion("listing_pictures <", value, "listingPictures");
            return (Criteria) this;
        }

        public Criteria andListingPicturesLessThanOrEqualTo(String value) {
            addCriterion("listing_pictures <=", value, "listingPictures");
            return (Criteria) this;
        }
        
        public Criteria andListingPicturesLike(String value) {
            addCriterion("listing_pictures like", value, "listingPictures");
            return (Criteria) this;
        }

        public Criteria andListingPicturesNotLike(String value) {
            addCriterion("listing_pictures not like", value, "listingPictures");
            return (Criteria) this;
        }

        public Criteria andListingPicturesIn(List<String> values) {
            addCriterion("listing_pictures in", values, "listingPictures");
            return (Criteria) this;
        }

        public Criteria andListingPicturesNotIn(List<String> values) {
            addCriterion("listing_pictures not in", values, "listingPictures");
            return (Criteria) this;
        }

        public Criteria andListingPicturesBetween(String value1, String value2) {
            addCriterion("listing_pictures between", value1, value2, "listingPictures");
            return (Criteria) this;
        }

        public Criteria andListingPicturesNotBetween(String value1, String value2) {
            addCriterion("listing_pictures not between", value1, value2, "listingPictures");
            return (Criteria) this;
        }
			
		public Criteria andListingFeaturesIdsIsNull() {
            addCriterion("listing_features_ids is null");
            return (Criteria) this;
        }
        
        public Criteria andListingFeaturesIdsIsNotNull() {
            addCriterion("listing_features_ids is not null");
            return (Criteria) this;
        }
        
        public Criteria andListingFeaturesIdsEqualTo(String value) {
            addCriterion("listing_features_ids =", value, "listingFeaturesIds");
            return (Criteria) this;
        }

        public Criteria andListingFeaturesIdsNotEqualTo(String value) {
            addCriterion("listing_features_ids <>", value, "listingFeaturesIds");
            return (Criteria) this;
        }

        public Criteria andListingFeaturesIdsGreaterThan(String value) {
            addCriterion("listing_features_ids >", value, "listingFeaturesIds");
            return (Criteria) this;
        }

        public Criteria andListingFeaturesIdsGreaterThanOrEqualTo(String value) {
            addCriterion("listing_features_ids >=", value, "listingFeaturesIds");
            return (Criteria) this;
        }

        public Criteria andListingFeaturesIdsLessThan(String value) {
            addCriterion("listing_features_ids <", value, "listingFeaturesIds");
            return (Criteria) this;
        }

        public Criteria andListingFeaturesIdsLessThanOrEqualTo(String value) {
            addCriterion("listing_features_ids <=", value, "listingFeaturesIds");
            return (Criteria) this;
        }
        
        public Criteria andListingFeaturesIdsLike(String value) {
            addCriterion("listing_features_ids like", value, "listingFeaturesIds");
            return (Criteria) this;
        }

        public Criteria andListingFeaturesIdsNotLike(String value) {
            addCriterion("listing_features_ids not like", value, "listingFeaturesIds");
            return (Criteria) this;
        }

        public Criteria andListingFeaturesIdsIn(List<String> values) {
            addCriterion("listing_features_ids in", values, "listingFeaturesIds");
            return (Criteria) this;
        }

        public Criteria andListingFeaturesIdsNotIn(List<String> values) {
            addCriterion("listing_features_ids not in", values, "listingFeaturesIds");
            return (Criteria) this;
        }

        public Criteria andListingFeaturesIdsBetween(String value1, String value2) {
            addCriterion("listing_features_ids between", value1, value2, "listingFeaturesIds");
            return (Criteria) this;
        }

        public Criteria andListingFeaturesIdsNotBetween(String value1, String value2) {
            addCriterion("listing_features_ids not between", value1, value2, "listingFeaturesIds");
            return (Criteria) this;
        }
			
		public Criteria andPropertyTypeIsNull() {
            addCriterion("property_type is null");
            return (Criteria) this;
        }
        
        public Criteria andPropertyTypeIsNotNull() {
            addCriterion("property_type is not null");
            return (Criteria) this;
        }
        
        public Criteria andPropertyTypeEqualTo(String value) {
            addCriterion("property_type =", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotEqualTo(String value) {
            addCriterion("property_type <>", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThan(String value) {
            addCriterion("property_type >", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("property_type >=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThan(String value) {
            addCriterion("property_type <", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThanOrEqualTo(String value) {
            addCriterion("property_type <=", value, "propertyType");
            return (Criteria) this;
        }
        
        public Criteria andPropertyTypeLike(String value) {
            addCriterion("property_type like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotLike(String value) {
            addCriterion("property_type not like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIn(List<String> values) {
            addCriterion("property_type in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotIn(List<String> values) {
            addCriterion("property_type not in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeBetween(String value1, String value2) {
            addCriterion("property_type between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotBetween(String value1, String value2) {
            addCriterion("property_type not between", value1, value2, "propertyType");
            return (Criteria) this;
        }
			
		public Criteria andOpenDateIsNull() {
            addCriterion("open_date is null");
            return (Criteria) this;
        }
        
        public Criteria andOpenDateIsNotNull() {
            addCriterion("open_date is not null");
            return (Criteria) this;
        }
        
        public Criteria andOpenDateEqualTo(Date value) {
            addCriterion("open_date =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(Date value) {
            addCriterion("open_date <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(Date value) {
            addCriterion("open_date >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(Date value) {
            addCriterion("open_date >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(Date value) {
            addCriterion("open_date <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(Date value) {
            addCriterion("open_date <=", value, "openDate");
            return (Criteria) this;
        }
        
        public Criteria andOpenDateIn(List<Date> values) {
            addCriterion("open_date in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<Date> values) {
            addCriterion("open_date not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(Date value1, Date value2) {
            addCriterion("open_date between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(Date value1, Date value2) {
            addCriterion("open_date not between", value1, value2, "openDate");
            return (Criteria) this;
        }
			
		public Criteria andStickyIsNull() {
            addCriterion("sticky is null");
            return (Criteria) this;
        }
        
        public Criteria andStickyIsNotNull() {
            addCriterion("sticky is not null");
            return (Criteria) this;
        }
        
        public Criteria andStickyEqualTo(Integer value) {
            addCriterion("sticky =", value, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyNotEqualTo(Integer value) {
            addCriterion("sticky <>", value, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyGreaterThan(Integer value) {
            addCriterion("sticky >", value, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyGreaterThanOrEqualTo(Integer value) {
            addCriterion("sticky >=", value, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyLessThan(Integer value) {
            addCriterion("sticky <", value, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyLessThanOrEqualTo(Integer value) {
            addCriterion("sticky <=", value, "sticky");
            return (Criteria) this;
        }
        
        public Criteria andStickyIn(List<Integer> values) {
            addCriterion("sticky in", values, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyNotIn(List<Integer> values) {
            addCriterion("sticky not in", values, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyBetween(Integer value1, Integer value2) {
            addCriterion("sticky between", value1, value2, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyNotBetween(Integer value1, Integer value2) {
            addCriterion("sticky not between", value1, value2, "sticky");
            return (Criteria) this;
        }
			
		public Criteria andSupportingIdsIsNull() {
            addCriterion("supporting_ids is null");
            return (Criteria) this;
        }
        
        public Criteria andSupportingIdsIsNotNull() {
            addCriterion("supporting_ids is not null");
            return (Criteria) this;
        }
        
        public Criteria andSupportingIdsEqualTo(String value) {
            addCriterion("supporting_ids =", value, "supportingIds");
            return (Criteria) this;
        }

        public Criteria andSupportingIdsNotEqualTo(String value) {
            addCriterion("supporting_ids <>", value, "supportingIds");
            return (Criteria) this;
        }

        public Criteria andSupportingIdsGreaterThan(String value) {
            addCriterion("supporting_ids >", value, "supportingIds");
            return (Criteria) this;
        }

        public Criteria andSupportingIdsGreaterThanOrEqualTo(String value) {
            addCriterion("supporting_ids >=", value, "supportingIds");
            return (Criteria) this;
        }

        public Criteria andSupportingIdsLessThan(String value) {
            addCriterion("supporting_ids <", value, "supportingIds");
            return (Criteria) this;
        }

        public Criteria andSupportingIdsLessThanOrEqualTo(String value) {
            addCriterion("supporting_ids <=", value, "supportingIds");
            return (Criteria) this;
        }
        
        public Criteria andSupportingIdsLike(String value) {
            addCriterion("supporting_ids like", value, "supportingIds");
            return (Criteria) this;
        }

        public Criteria andSupportingIdsNotLike(String value) {
            addCriterion("supporting_ids not like", value, "supportingIds");
            return (Criteria) this;
        }

        public Criteria andSupportingIdsIn(List<String> values) {
            addCriterion("supporting_ids in", values, "supportingIds");
            return (Criteria) this;
        }

        public Criteria andSupportingIdsNotIn(List<String> values) {
            addCriterion("supporting_ids not in", values, "supportingIds");
            return (Criteria) this;
        }

        public Criteria andSupportingIdsBetween(String value1, String value2) {
            addCriterion("supporting_ids between", value1, value2, "supportingIds");
            return (Criteria) this;
        }

        public Criteria andSupportingIdsNotBetween(String value1, String value2) {
            addCriterion("supporting_ids not between", value1, value2, "supportingIds");
            return (Criteria) this;
        }
			
		public Criteria andLeaseTermIsNull() {
            addCriterion("lease_term is null");
            return (Criteria) this;
        }
        
        public Criteria andLeaseTermIsNotNull() {
            addCriterion("lease_term is not null");
            return (Criteria) this;
        }
        
        public Criteria andLeaseTermEqualTo(String value) {
            addCriterion("lease_term =", value, "leaseTerm");
            return (Criteria) this;
        }

        public Criteria andLeaseTermNotEqualTo(String value) {
            addCriterion("lease_term <>", value, "leaseTerm");
            return (Criteria) this;
        }

        public Criteria andLeaseTermGreaterThan(String value) {
            addCriterion("lease_term >", value, "leaseTerm");
            return (Criteria) this;
        }

        public Criteria andLeaseTermGreaterThanOrEqualTo(String value) {
            addCriterion("lease_term >=", value, "leaseTerm");
            return (Criteria) this;
        }

        public Criteria andLeaseTermLessThan(String value) {
            addCriterion("lease_term <", value, "leaseTerm");
            return (Criteria) this;
        }

        public Criteria andLeaseTermLessThanOrEqualTo(String value) {
            addCriterion("lease_term <=", value, "leaseTerm");
            return (Criteria) this;
        }
        
        public Criteria andLeaseTermLike(String value) {
            addCriterion("lease_term like", value, "leaseTerm");
            return (Criteria) this;
        }

        public Criteria andLeaseTermNotLike(String value) {
            addCriterion("lease_term not like", value, "leaseTerm");
            return (Criteria) this;
        }

        public Criteria andLeaseTermIn(List<String> values) {
            addCriterion("lease_term in", values, "leaseTerm");
            return (Criteria) this;
        }

        public Criteria andLeaseTermNotIn(List<String> values) {
            addCriterion("lease_term not in", values, "leaseTerm");
            return (Criteria) this;
        }

        public Criteria andLeaseTermBetween(String value1, String value2) {
            addCriterion("lease_term between", value1, value2, "leaseTerm");
            return (Criteria) this;
        }

        public Criteria andLeaseTermNotBetween(String value1, String value2) {
            addCriterion("lease_term not between", value1, value2, "leaseTerm");
            return (Criteria) this;
        }
			
		public Criteria andSpecificationWidthIsNull() {
            addCriterion("specification_width is null");
            return (Criteria) this;
        }
        
        public Criteria andSpecificationWidthIsNotNull() {
            addCriterion("specification_width is not null");
            return (Criteria) this;
        }
        
        public Criteria andSpecificationWidthEqualTo(String value) {
            addCriterion("specification_width =", value, "specificationWidth");
            return (Criteria) this;
        }

        public Criteria andSpecificationWidthNotEqualTo(String value) {
            addCriterion("specification_width <>", value, "specificationWidth");
            return (Criteria) this;
        }

        public Criteria andSpecificationWidthGreaterThan(String value) {
            addCriterion("specification_width >", value, "specificationWidth");
            return (Criteria) this;
        }

        public Criteria andSpecificationWidthGreaterThanOrEqualTo(String value) {
            addCriterion("specification_width >=", value, "specificationWidth");
            return (Criteria) this;
        }

        public Criteria andSpecificationWidthLessThan(String value) {
            addCriterion("specification_width <", value, "specificationWidth");
            return (Criteria) this;
        }

        public Criteria andSpecificationWidthLessThanOrEqualTo(String value) {
            addCriterion("specification_width <=", value, "specificationWidth");
            return (Criteria) this;
        }
        
        public Criteria andSpecificationWidthLike(String value) {
            addCriterion("specification_width like", value, "specificationWidth");
            return (Criteria) this;
        }

        public Criteria andSpecificationWidthNotLike(String value) {
            addCriterion("specification_width not like", value, "specificationWidth");
            return (Criteria) this;
        }

        public Criteria andSpecificationWidthIn(List<String> values) {
            addCriterion("specification_width in", values, "specificationWidth");
            return (Criteria) this;
        }

        public Criteria andSpecificationWidthNotIn(List<String> values) {
            addCriterion("specification_width not in", values, "specificationWidth");
            return (Criteria) this;
        }

        public Criteria andSpecificationWidthBetween(String value1, String value2) {
            addCriterion("specification_width between", value1, value2, "specificationWidth");
            return (Criteria) this;
        }

        public Criteria andSpecificationWidthNotBetween(String value1, String value2) {
            addCriterion("specification_width not between", value1, value2, "specificationWidth");
            return (Criteria) this;
        }
			
		public Criteria andSpecificationHeightIsNull() {
            addCriterion("specification_height is null");
            return (Criteria) this;
        }
        
        public Criteria andSpecificationHeightIsNotNull() {
            addCriterion("specification_height is not null");
            return (Criteria) this;
        }
        
        public Criteria andSpecificationHeightEqualTo(String value) {
            addCriterion("specification_height =", value, "specificationHeight");
            return (Criteria) this;
        }

        public Criteria andSpecificationHeightNotEqualTo(String value) {
            addCriterion("specification_height <>", value, "specificationHeight");
            return (Criteria) this;
        }

        public Criteria andSpecificationHeightGreaterThan(String value) {
            addCriterion("specification_height >", value, "specificationHeight");
            return (Criteria) this;
        }

        public Criteria andSpecificationHeightGreaterThanOrEqualTo(String value) {
            addCriterion("specification_height >=", value, "specificationHeight");
            return (Criteria) this;
        }

        public Criteria andSpecificationHeightLessThan(String value) {
            addCriterion("specification_height <", value, "specificationHeight");
            return (Criteria) this;
        }

        public Criteria andSpecificationHeightLessThanOrEqualTo(String value) {
            addCriterion("specification_height <=", value, "specificationHeight");
            return (Criteria) this;
        }
        
        public Criteria andSpecificationHeightLike(String value) {
            addCriterion("specification_height like", value, "specificationHeight");
            return (Criteria) this;
        }

        public Criteria andSpecificationHeightNotLike(String value) {
            addCriterion("specification_height not like", value, "specificationHeight");
            return (Criteria) this;
        }

        public Criteria andSpecificationHeightIn(List<String> values) {
            addCriterion("specification_height in", values, "specificationHeight");
            return (Criteria) this;
        }

        public Criteria andSpecificationHeightNotIn(List<String> values) {
            addCriterion("specification_height not in", values, "specificationHeight");
            return (Criteria) this;
        }

        public Criteria andSpecificationHeightBetween(String value1, String value2) {
            addCriterion("specification_height between", value1, value2, "specificationHeight");
            return (Criteria) this;
        }

        public Criteria andSpecificationHeightNotBetween(String value1, String value2) {
            addCriterion("specification_height not between", value1, value2, "specificationHeight");
            return (Criteria) this;
        }
			
		public Criteria andOperatingStatusIsNull() {
            addCriterion("operating_status is null");
            return (Criteria) this;
        }
        
        public Criteria andOperatingStatusIsNotNull() {
            addCriterion("operating_status is not null");
            return (Criteria) this;
        }
        
        public Criteria andOperatingStatusEqualTo(Integer value) {
            addCriterion("operating_status =", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusNotEqualTo(Integer value) {
            addCriterion("operating_status <>", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusGreaterThan(Integer value) {
            addCriterion("operating_status >", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("operating_status >=", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusLessThan(Integer value) {
            addCriterion("operating_status <", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusLessThanOrEqualTo(Integer value) {
            addCriterion("operating_status <=", value, "operatingStatus");
            return (Criteria) this;
        }
        
        public Criteria andOperatingStatusIn(List<Integer> values) {
            addCriterion("operating_status in", values, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusNotIn(List<Integer> values) {
            addCriterion("operating_status not in", values, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusBetween(Integer value1, Integer value2) {
            addCriterion("operating_status between", value1, value2, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("operating_status not between", value1, value2, "operatingStatus");
            return (Criteria) this;
        }
			
		public Criteria andOperatingItemIsNull() {
            addCriterion("operating_item is null");
            return (Criteria) this;
        }
        
        public Criteria andOperatingItemIsNotNull() {
            addCriterion("operating_item is not null");
            return (Criteria) this;
        }
        
        public Criteria andOperatingItemEqualTo(String value) {
            addCriterion("operating_item =", value, "operatingItem");
            return (Criteria) this;
        }

        public Criteria andOperatingItemNotEqualTo(String value) {
            addCriterion("operating_item <>", value, "operatingItem");
            return (Criteria) this;
        }

        public Criteria andOperatingItemGreaterThan(String value) {
            addCriterion("operating_item >", value, "operatingItem");
            return (Criteria) this;
        }

        public Criteria andOperatingItemGreaterThanOrEqualTo(String value) {
            addCriterion("operating_item >=", value, "operatingItem");
            return (Criteria) this;
        }

        public Criteria andOperatingItemLessThan(String value) {
            addCriterion("operating_item <", value, "operatingItem");
            return (Criteria) this;
        }

        public Criteria andOperatingItemLessThanOrEqualTo(String value) {
            addCriterion("operating_item <=", value, "operatingItem");
            return (Criteria) this;
        }
        
        public Criteria andOperatingItemLike(String value) {
            addCriterion("operating_item like", value, "operatingItem");
            return (Criteria) this;
        }

        public Criteria andOperatingItemNotLike(String value) {
            addCriterion("operating_item not like", value, "operatingItem");
            return (Criteria) this;
        }

        public Criteria andOperatingItemIn(List<String> values) {
            addCriterion("operating_item in", values, "operatingItem");
            return (Criteria) this;
        }

        public Criteria andOperatingItemNotIn(List<String> values) {
            addCriterion("operating_item not in", values, "operatingItem");
            return (Criteria) this;
        }

        public Criteria andOperatingItemBetween(String value1, String value2) {
            addCriterion("operating_item between", value1, value2, "operatingItem");
            return (Criteria) this;
        }

        public Criteria andOperatingItemNotBetween(String value1, String value2) {
            addCriterion("operating_item not between", value1, value2, "operatingItem");
            return (Criteria) this;
        }
			
		public Criteria andRelatedCostIsNull() {
            addCriterion("related_cost is null");
            return (Criteria) this;
        }
        
        public Criteria andRelatedCostIsNotNull() {
            addCriterion("related_cost is not null");
            return (Criteria) this;
        }
        
        public Criteria andRelatedCostEqualTo(String value) {
            addCriterion("related_cost =", value, "relatedCost");
            return (Criteria) this;
        }

        public Criteria andRelatedCostNotEqualTo(String value) {
            addCriterion("related_cost <>", value, "relatedCost");
            return (Criteria) this;
        }

        public Criteria andRelatedCostGreaterThan(String value) {
            addCriterion("related_cost >", value, "relatedCost");
            return (Criteria) this;
        }

        public Criteria andRelatedCostGreaterThanOrEqualTo(String value) {
            addCriterion("related_cost >=", value, "relatedCost");
            return (Criteria) this;
        }

        public Criteria andRelatedCostLessThan(String value) {
            addCriterion("related_cost <", value, "relatedCost");
            return (Criteria) this;
        }

        public Criteria andRelatedCostLessThanOrEqualTo(String value) {
            addCriterion("related_cost <=", value, "relatedCost");
            return (Criteria) this;
        }
        
        public Criteria andRelatedCostLike(String value) {
            addCriterion("related_cost like", value, "relatedCost");
            return (Criteria) this;
        }

        public Criteria andRelatedCostNotLike(String value) {
            addCriterion("related_cost not like", value, "relatedCost");
            return (Criteria) this;
        }

        public Criteria andRelatedCostIn(List<String> values) {
            addCriterion("related_cost in", values, "relatedCost");
            return (Criteria) this;
        }

        public Criteria andRelatedCostNotIn(List<String> values) {
            addCriterion("related_cost not in", values, "relatedCost");
            return (Criteria) this;
        }

        public Criteria andRelatedCostBetween(String value1, String value2) {
            addCriterion("related_cost between", value1, value2, "relatedCost");
            return (Criteria) this;
        }

        public Criteria andRelatedCostNotBetween(String value1, String value2) {
            addCriterion("related_cost not between", value1, value2, "relatedCost");
            return (Criteria) this;
        }
			
		public Criteria andTransferPriceIsNull() {
            addCriterion("transfer_price is null");
            return (Criteria) this;
        }
        
        public Criteria andTransferPriceIsNotNull() {
            addCriterion("transfer_price is not null");
            return (Criteria) this;
        }
        
        public Criteria andTransferPriceEqualTo(Integer value) {
            addCriterion("transfer_price =", value, "transferPrice");
            return (Criteria) this;
        }

        public Criteria andTransferPriceNotEqualTo(Integer value) {
            addCriterion("transfer_price <>", value, "transferPrice");
            return (Criteria) this;
        }

        public Criteria andTransferPriceGreaterThan(Integer value) {
            addCriterion("transfer_price >", value, "transferPrice");
            return (Criteria) this;
        }

        public Criteria andTransferPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("transfer_price >=", value, "transferPrice");
            return (Criteria) this;
        }

        public Criteria andTransferPriceLessThan(Integer value) {
            addCriterion("transfer_price <", value, "transferPrice");
            return (Criteria) this;
        }

        public Criteria andTransferPriceLessThanOrEqualTo(Integer value) {
            addCriterion("transfer_price <=", value, "transferPrice");
            return (Criteria) this;
        }
        
        public Criteria andTransferPriceIn(List<Integer> values) {
            addCriterion("transfer_price in", values, "transferPrice");
            return (Criteria) this;
        }

        public Criteria andTransferPriceNotIn(List<Integer> values) {
            addCriterion("transfer_price not in", values, "transferPrice");
            return (Criteria) this;
        }

        public Criteria andTransferPriceBetween(Integer value1, Integer value2) {
            addCriterion("transfer_price between", value1, value2, "transferPrice");
            return (Criteria) this;
        }

        public Criteria andTransferPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("transfer_price not between", value1, value2, "transferPrice");
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
        
        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }
        
        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }
			
		public Criteria andDayRentIsNull() {
            addCriterion("day_rent is null");
            return (Criteria) this;
        }
        
        public Criteria andDayRentIsNotNull() {
            addCriterion("day_rent is not null");
            return (Criteria) this;
        }
        
        public Criteria andDayRentEqualTo(String value) {
            addCriterion("day_rent =", value, "dayRent");
            return (Criteria) this;
        }

        public Criteria andDayRentNotEqualTo(String value) {
            addCriterion("day_rent <>", value, "dayRent");
            return (Criteria) this;
        }

        public Criteria andDayRentGreaterThan(String value) {
            addCriterion("day_rent >", value, "dayRent");
            return (Criteria) this;
        }

        public Criteria andDayRentGreaterThanOrEqualTo(String value) {
            addCriterion("day_rent >=", value, "dayRent");
            return (Criteria) this;
        }

        public Criteria andDayRentLessThan(String value) {
            addCriterion("day_rent <", value, "dayRent");
            return (Criteria) this;
        }

        public Criteria andDayRentLessThanOrEqualTo(String value) {
            addCriterion("day_rent <=", value, "dayRent");
            return (Criteria) this;
        }
        
        public Criteria andDayRentLike(String value) {
            addCriterion("day_rent like", value, "dayRent");
            return (Criteria) this;
        }

        public Criteria andDayRentNotLike(String value) {
            addCriterion("day_rent not like", value, "dayRent");
            return (Criteria) this;
        }

        public Criteria andDayRentIn(List<String> values) {
            addCriterion("day_rent in", values, "dayRent");
            return (Criteria) this;
        }

        public Criteria andDayRentNotIn(List<String> values) {
            addCriterion("day_rent not in", values, "dayRent");
            return (Criteria) this;
        }

        public Criteria andDayRentBetween(String value1, String value2) {
            addCriterion("day_rent between", value1, value2, "dayRent");
            return (Criteria) this;
        }

        public Criteria andDayRentNotBetween(String value1, String value2) {
            addCriterion("day_rent not between", value1, value2, "dayRent");
            return (Criteria) this;
        }
			
		public Criteria andLeasingMethodIsNull() {
            addCriterion("leasing_method is null");
            return (Criteria) this;
        }
        
        public Criteria andLeasingMethodIsNotNull() {
            addCriterion("leasing_method is not null");
            return (Criteria) this;
        }
        
        public Criteria andLeasingMethodEqualTo(String value) {
            addCriterion("leasing_method =", value, "leasingMethod");
            return (Criteria) this;
        }

        public Criteria andLeasingMethodNotEqualTo(String value) {
            addCriterion("leasing_method <>", value, "leasingMethod");
            return (Criteria) this;
        }

        public Criteria andLeasingMethodGreaterThan(String value) {
            addCriterion("leasing_method >", value, "leasingMethod");
            return (Criteria) this;
        }

        public Criteria andLeasingMethodGreaterThanOrEqualTo(String value) {
            addCriterion("leasing_method >=", value, "leasingMethod");
            return (Criteria) this;
        }

        public Criteria andLeasingMethodLessThan(String value) {
            addCriterion("leasing_method <", value, "leasingMethod");
            return (Criteria) this;
        }

        public Criteria andLeasingMethodLessThanOrEqualTo(String value) {
            addCriterion("leasing_method <=", value, "leasingMethod");
            return (Criteria) this;
        }
        
        public Criteria andLeasingMethodLike(String value) {
            addCriterion("leasing_method like", value, "leasingMethod");
            return (Criteria) this;
        }

        public Criteria andLeasingMethodNotLike(String value) {
            addCriterion("leasing_method not like", value, "leasingMethod");
            return (Criteria) this;
        }

        public Criteria andLeasingMethodIn(List<String> values) {
            addCriterion("leasing_method in", values, "leasingMethod");
            return (Criteria) this;
        }

        public Criteria andLeasingMethodNotIn(List<String> values) {
            addCriterion("leasing_method not in", values, "leasingMethod");
            return (Criteria) this;
        }

        public Criteria andLeasingMethodBetween(String value1, String value2) {
            addCriterion("leasing_method between", value1, value2, "leasingMethod");
            return (Criteria) this;
        }

        public Criteria andLeasingMethodNotBetween(String value1, String value2) {
            addCriterion("leasing_method not between", value1, value2, "leasingMethod");
            return (Criteria) this;
        }
			
		public Criteria andBuildTimeIsNull() {
            addCriterion("build_time is null");
            return (Criteria) this;
        }
        
        public Criteria andBuildTimeIsNotNull() {
            addCriterion("build_time is not null");
            return (Criteria) this;
        }
        
        public Criteria andBuildTimeEqualTo(Date value) {
            addCriterion("build_time =", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotEqualTo(Date value) {
            addCriterion("build_time <>", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeGreaterThan(Date value) {
            addCriterion("build_time >", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("build_time >=", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeLessThan(Date value) {
            addCriterion("build_time <", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeLessThanOrEqualTo(Date value) {
            addCriterion("build_time <=", value, "buildTime");
            return (Criteria) this;
        }
        
        public Criteria andBuildTimeIn(List<Date> values) {
            addCriterion("build_time in", values, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotIn(List<Date> values) {
            addCriterion("build_time not in", values, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeBetween(Date value1, Date value2) {
            addCriterion("build_time between", value1, value2, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotBetween(Date value1, Date value2) {
            addCriterion("build_time not between", value1, value2, "buildTime");
            return (Criteria) this;
        }
			
		public Criteria andFloornumIsNull() {
            addCriterion("floorNum is null");
            return (Criteria) this;
        }
        
        public Criteria andFloornumIsNotNull() {
            addCriterion("floorNum is not null");
            return (Criteria) this;
        }
        
        public Criteria andFloornumEqualTo(String value) {
            addCriterion("floorNum =", value, "floornum");
            return (Criteria) this;
        }

        public Criteria andFloornumNotEqualTo(String value) {
            addCriterion("floorNum <>", value, "floornum");
            return (Criteria) this;
        }

        public Criteria andFloornumGreaterThan(String value) {
            addCriterion("floorNum >", value, "floornum");
            return (Criteria) this;
        }

        public Criteria andFloornumGreaterThanOrEqualTo(String value) {
            addCriterion("floorNum >=", value, "floornum");
            return (Criteria) this;
        }

        public Criteria andFloornumLessThan(String value) {
            addCriterion("floorNum <", value, "floornum");
            return (Criteria) this;
        }

        public Criteria andFloornumLessThanOrEqualTo(String value) {
            addCriterion("floorNum <=", value, "floornum");
            return (Criteria) this;
        }
        
        public Criteria andFloornumLike(String value) {
            addCriterion("floorNum like", value, "floornum");
            return (Criteria) this;
        }

        public Criteria andFloornumNotLike(String value) {
            addCriterion("floorNum not like", value, "floornum");
            return (Criteria) this;
        }

        public Criteria andFloornumIn(List<String> values) {
            addCriterion("floorNum in", values, "floornum");
            return (Criteria) this;
        }

        public Criteria andFloornumNotIn(List<String> values) {
            addCriterion("floorNum not in", values, "floornum");
            return (Criteria) this;
        }

        public Criteria andFloornumBetween(String value1, String value2) {
            addCriterion("floorNum between", value1, value2, "floornum");
            return (Criteria) this;
        }

        public Criteria andFloornumNotBetween(String value1, String value2) {
            addCriterion("floorNum not between", value1, value2, "floornum");
            return (Criteria) this;
        }
			
		public Criteria andValuationIsNull() {
            addCriterion("valuation is null");
            return (Criteria) this;
        }
        
        public Criteria andValuationIsNotNull() {
            addCriterion("valuation is not null");
            return (Criteria) this;
        }
        
        public Criteria andValuationEqualTo(String value) {
            addCriterion("valuation =", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationNotEqualTo(String value) {
            addCriterion("valuation <>", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationGreaterThan(String value) {
            addCriterion("valuation >", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationGreaterThanOrEqualTo(String value) {
            addCriterion("valuation >=", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationLessThan(String value) {
            addCriterion("valuation <", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationLessThanOrEqualTo(String value) {
            addCriterion("valuation <=", value, "valuation");
            return (Criteria) this;
        }
        
        public Criteria andValuationLike(String value) {
            addCriterion("valuation like", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationNotLike(String value) {
            addCriterion("valuation not like", value, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationIn(List<String> values) {
            addCriterion("valuation in", values, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationNotIn(List<String> values) {
            addCriterion("valuation not in", values, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationBetween(String value1, String value2) {
            addCriterion("valuation between", value1, value2, "valuation");
            return (Criteria) this;
        }

        public Criteria andValuationNotBetween(String value1, String value2) {
            addCriterion("valuation not between", value1, value2, "valuation");
            return (Criteria) this;
        }
			
		public Criteria andPropertyNameIsNull() {
            addCriterion("property_name is null");
            return (Criteria) this;
        }
        
        public Criteria andPropertyNameIsNotNull() {
            addCriterion("property_name is not null");
            return (Criteria) this;
        }
        
        public Criteria andPropertyNameEqualTo(String value) {
            addCriterion("property_name =", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotEqualTo(String value) {
            addCriterion("property_name <>", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThan(String value) {
            addCriterion("property_name >", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThanOrEqualTo(String value) {
            addCriterion("property_name >=", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThan(String value) {
            addCriterion("property_name <", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThanOrEqualTo(String value) {
            addCriterion("property_name <=", value, "propertyName");
            return (Criteria) this;
        }
        
        public Criteria andPropertyNameLike(String value) {
            addCriterion("property_name like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotLike(String value) {
            addCriterion("property_name not like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIn(List<String> values) {
            addCriterion("property_name in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotIn(List<String> values) {
            addCriterion("property_name not in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameBetween(String value1, String value2) {
            addCriterion("property_name between", value1, value2, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotBetween(String value1, String value2) {
            addCriterion("property_name not between", value1, value2, "propertyName");
            return (Criteria) this;
        }
			
		public Criteria andPropertyCostIsNull() {
            addCriterion("property_cost is null");
            return (Criteria) this;
        }
        
        public Criteria andPropertyCostIsNotNull() {
            addCriterion("property_cost is not null");
            return (Criteria) this;
        }
        
        public Criteria andPropertyCostEqualTo(String value) {
            addCriterion("property_cost =", value, "propertyCost");
            return (Criteria) this;
        }

        public Criteria andPropertyCostNotEqualTo(String value) {
            addCriterion("property_cost <>", value, "propertyCost");
            return (Criteria) this;
        }

        public Criteria andPropertyCostGreaterThan(String value) {
            addCriterion("property_cost >", value, "propertyCost");
            return (Criteria) this;
        }

        public Criteria andPropertyCostGreaterThanOrEqualTo(String value) {
            addCriterion("property_cost >=", value, "propertyCost");
            return (Criteria) this;
        }

        public Criteria andPropertyCostLessThan(String value) {
            addCriterion("property_cost <", value, "propertyCost");
            return (Criteria) this;
        }

        public Criteria andPropertyCostLessThanOrEqualTo(String value) {
            addCriterion("property_cost <=", value, "propertyCost");
            return (Criteria) this;
        }
        
        public Criteria andPropertyCostLike(String value) {
            addCriterion("property_cost like", value, "propertyCost");
            return (Criteria) this;
        }

        public Criteria andPropertyCostNotLike(String value) {
            addCriterion("property_cost not like", value, "propertyCost");
            return (Criteria) this;
        }

        public Criteria andPropertyCostIn(List<String> values) {
            addCriterion("property_cost in", values, "propertyCost");
            return (Criteria) this;
        }

        public Criteria andPropertyCostNotIn(List<String> values) {
            addCriterion("property_cost not in", values, "propertyCost");
            return (Criteria) this;
        }

        public Criteria andPropertyCostBetween(String value1, String value2) {
            addCriterion("property_cost between", value1, value2, "propertyCost");
            return (Criteria) this;
        }

        public Criteria andPropertyCostNotBetween(String value1, String value2) {
            addCriterion("property_cost not between", value1, value2, "propertyCost");
            return (Criteria) this;
        }
			
		public Criteria andBuildingGradeIsNull() {
            addCriterion("building_grade is null");
            return (Criteria) this;
        }
        
        public Criteria andBuildingGradeIsNotNull() {
            addCriterion("building_grade is not null");
            return (Criteria) this;
        }
        
        public Criteria andBuildingGradeEqualTo(String value) {
            addCriterion("building_grade =", value, "buildingGrade");
            return (Criteria) this;
        }

        public Criteria andBuildingGradeNotEqualTo(String value) {
            addCriterion("building_grade <>", value, "buildingGrade");
            return (Criteria) this;
        }

        public Criteria andBuildingGradeGreaterThan(String value) {
            addCriterion("building_grade >", value, "buildingGrade");
            return (Criteria) this;
        }

        public Criteria andBuildingGradeGreaterThanOrEqualTo(String value) {
            addCriterion("building_grade >=", value, "buildingGrade");
            return (Criteria) this;
        }

        public Criteria andBuildingGradeLessThan(String value) {
            addCriterion("building_grade <", value, "buildingGrade");
            return (Criteria) this;
        }

        public Criteria andBuildingGradeLessThanOrEqualTo(String value) {
            addCriterion("building_grade <=", value, "buildingGrade");
            return (Criteria) this;
        }
        
        public Criteria andBuildingGradeLike(String value) {
            addCriterion("building_grade like", value, "buildingGrade");
            return (Criteria) this;
        }

        public Criteria andBuildingGradeNotLike(String value) {
            addCriterion("building_grade not like", value, "buildingGrade");
            return (Criteria) this;
        }

        public Criteria andBuildingGradeIn(List<String> values) {
            addCriterion("building_grade in", values, "buildingGrade");
            return (Criteria) this;
        }

        public Criteria andBuildingGradeNotIn(List<String> values) {
            addCriterion("building_grade not in", values, "buildingGrade");
            return (Criteria) this;
        }

        public Criteria andBuildingGradeBetween(String value1, String value2) {
            addCriterion("building_grade between", value1, value2, "buildingGrade");
            return (Criteria) this;
        }

        public Criteria andBuildingGradeNotBetween(String value1, String value2) {
            addCriterion("building_grade not between", value1, value2, "buildingGrade");
            return (Criteria) this;
        }
			
		public Criteria andUsageRateIsNull() {
            addCriterion("usage_rate is null");
            return (Criteria) this;
        }
        
        public Criteria andUsageRateIsNotNull() {
            addCriterion("usage_rate is not null");
            return (Criteria) this;
        }
        
        public Criteria andUsageRateEqualTo(String value) {
            addCriterion("usage_rate =", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateNotEqualTo(String value) {
            addCriterion("usage_rate <>", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateGreaterThan(String value) {
            addCriterion("usage_rate >", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateGreaterThanOrEqualTo(String value) {
            addCriterion("usage_rate >=", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateLessThan(String value) {
            addCriterion("usage_rate <", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateLessThanOrEqualTo(String value) {
            addCriterion("usage_rate <=", value, "usageRate");
            return (Criteria) this;
        }
        
        public Criteria andUsageRateLike(String value) {
            addCriterion("usage_rate like", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateNotLike(String value) {
            addCriterion("usage_rate not like", value, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateIn(List<String> values) {
            addCriterion("usage_rate in", values, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateNotIn(List<String> values) {
            addCriterion("usage_rate not in", values, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateBetween(String value1, String value2) {
            addCriterion("usage_rate between", value1, value2, "usageRate");
            return (Criteria) this;
        }

        public Criteria andUsageRateNotBetween(String value1, String value2) {
            addCriterion("usage_rate not between", value1, value2, "usageRate");
            return (Criteria) this;
        }
			
		public Criteria andRoomNumIsNull() {
            addCriterion("room_num is null");
            return (Criteria) this;
        }
        
        public Criteria andRoomNumIsNotNull() {
            addCriterion("room_num is not null");
            return (Criteria) this;
        }
        
        public Criteria andRoomNumEqualTo(String value) {
            addCriterion("room_num =", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotEqualTo(String value) {
            addCriterion("room_num <>", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumGreaterThan(String value) {
            addCriterion("room_num >", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumGreaterThanOrEqualTo(String value) {
            addCriterion("room_num >=", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLessThan(String value) {
            addCriterion("room_num <", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLessThanOrEqualTo(String value) {
            addCriterion("room_num <=", value, "roomNum");
            return (Criteria) this;
        }
        
        public Criteria andRoomNumLike(String value) {
            addCriterion("room_num like", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotLike(String value) {
            addCriterion("room_num not like", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumIn(List<String> values) {
            addCriterion("room_num in", values, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotIn(List<String> values) {
            addCriterion("room_num not in", values, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumBetween(String value1, String value2) {
            addCriterion("room_num between", value1, value2, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotBetween(String value1, String value2) {
            addCriterion("room_num not between", value1, value2, "roomNum");
            return (Criteria) this;
        }
			
		public Criteria andDecorationFloorIsNull() {
            addCriterion("decoration_floor is null");
            return (Criteria) this;
        }
        
        public Criteria andDecorationFloorIsNotNull() {
            addCriterion("decoration_floor is not null");
            return (Criteria) this;
        }
        
        public Criteria andDecorationFloorEqualTo(String value) {
            addCriterion("decoration_floor =", value, "decorationFloor");
            return (Criteria) this;
        }

        public Criteria andDecorationFloorNotEqualTo(String value) {
            addCriterion("decoration_floor <>", value, "decorationFloor");
            return (Criteria) this;
        }

        public Criteria andDecorationFloorGreaterThan(String value) {
            addCriterion("decoration_floor >", value, "decorationFloor");
            return (Criteria) this;
        }

        public Criteria andDecorationFloorGreaterThanOrEqualTo(String value) {
            addCriterion("decoration_floor >=", value, "decorationFloor");
            return (Criteria) this;
        }

        public Criteria andDecorationFloorLessThan(String value) {
            addCriterion("decoration_floor <", value, "decorationFloor");
            return (Criteria) this;
        }

        public Criteria andDecorationFloorLessThanOrEqualTo(String value) {
            addCriterion("decoration_floor <=", value, "decorationFloor");
            return (Criteria) this;
        }
        
        public Criteria andDecorationFloorLike(String value) {
            addCriterion("decoration_floor like", value, "decorationFloor");
            return (Criteria) this;
        }

        public Criteria andDecorationFloorNotLike(String value) {
            addCriterion("decoration_floor not like", value, "decorationFloor");
            return (Criteria) this;
        }

        public Criteria andDecorationFloorIn(List<String> values) {
            addCriterion("decoration_floor in", values, "decorationFloor");
            return (Criteria) this;
        }

        public Criteria andDecorationFloorNotIn(List<String> values) {
            addCriterion("decoration_floor not in", values, "decorationFloor");
            return (Criteria) this;
        }

        public Criteria andDecorationFloorBetween(String value1, String value2) {
            addCriterion("decoration_floor between", value1, value2, "decorationFloor");
            return (Criteria) this;
        }

        public Criteria andDecorationFloorNotBetween(String value1, String value2) {
            addCriterion("decoration_floor not between", value1, value2, "decorationFloor");
            return (Criteria) this;
        }
			
		public Criteria andParkingSpaceIsNull() {
            addCriterion("parking_space is null");
            return (Criteria) this;
        }
        
        public Criteria andParkingSpaceIsNotNull() {
            addCriterion("parking_space is not null");
            return (Criteria) this;
        }
        
        public Criteria andParkingSpaceEqualTo(String value) {
            addCriterion("parking_space =", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNotEqualTo(String value) {
            addCriterion("parking_space <>", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceGreaterThan(String value) {
            addCriterion("parking_space >", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceGreaterThanOrEqualTo(String value) {
            addCriterion("parking_space >=", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceLessThan(String value) {
            addCriterion("parking_space <", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceLessThanOrEqualTo(String value) {
            addCriterion("parking_space <=", value, "parkingSpace");
            return (Criteria) this;
        }
        
        public Criteria andParkingSpaceLike(String value) {
            addCriterion("parking_space like", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNotLike(String value) {
            addCriterion("parking_space not like", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceIn(List<String> values) {
            addCriterion("parking_space in", values, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNotIn(List<String> values) {
            addCriterion("parking_space not in", values, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceBetween(String value1, String value2) {
            addCriterion("parking_space between", value1, value2, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNotBetween(String value1, String value2) {
            addCriterion("parking_space not between", value1, value2, "parkingSpace");
            return (Criteria) this;
        }
			
		public Criteria andDownPaymentIsNull() {
            addCriterion("down_payment is null");
            return (Criteria) this;
        }
        
        public Criteria andDownPaymentIsNotNull() {
            addCriterion("down_payment is not null");
            return (Criteria) this;
        }
        
        public Criteria andDownPaymentEqualTo(String value) {
            addCriterion("down_payment =", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentNotEqualTo(String value) {
            addCriterion("down_payment <>", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentGreaterThan(String value) {
            addCriterion("down_payment >", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("down_payment >=", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentLessThan(String value) {
            addCriterion("down_payment <", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentLessThanOrEqualTo(String value) {
            addCriterion("down_payment <=", value, "downPayment");
            return (Criteria) this;
        }
        
        public Criteria andDownPaymentLike(String value) {
            addCriterion("down_payment like", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentNotLike(String value) {
            addCriterion("down_payment not like", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentIn(List<String> values) {
            addCriterion("down_payment in", values, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentNotIn(List<String> values) {
            addCriterion("down_payment not in", values, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentBetween(String value1, String value2) {
            addCriterion("down_payment between", value1, value2, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentNotBetween(String value1, String value2) {
            addCriterion("down_payment not between", value1, value2, "downPayment");
            return (Criteria) this;
        }
			
		public Criteria andLandSovereigntyIsNull() {
            addCriterion("land_sovereignty is null");
            return (Criteria) this;
        }
        
        public Criteria andLandSovereigntyIsNotNull() {
            addCriterion("land_sovereignty is not null");
            return (Criteria) this;
        }
        
        public Criteria andLandSovereigntyEqualTo(String value) {
            addCriterion("land_sovereignty =", value, "landSovereignty");
            return (Criteria) this;
        }

        public Criteria andLandSovereigntyNotEqualTo(String value) {
            addCriterion("land_sovereignty <>", value, "landSovereignty");
            return (Criteria) this;
        }

        public Criteria andLandSovereigntyGreaterThan(String value) {
            addCriterion("land_sovereignty >", value, "landSovereignty");
            return (Criteria) this;
        }

        public Criteria andLandSovereigntyGreaterThanOrEqualTo(String value) {
            addCriterion("land_sovereignty >=", value, "landSovereignty");
            return (Criteria) this;
        }

        public Criteria andLandSovereigntyLessThan(String value) {
            addCriterion("land_sovereignty <", value, "landSovereignty");
            return (Criteria) this;
        }

        public Criteria andLandSovereigntyLessThanOrEqualTo(String value) {
            addCriterion("land_sovereignty <=", value, "landSovereignty");
            return (Criteria) this;
        }
        
        public Criteria andLandSovereigntyLike(String value) {
            addCriterion("land_sovereignty like", value, "landSovereignty");
            return (Criteria) this;
        }

        public Criteria andLandSovereigntyNotLike(String value) {
            addCriterion("land_sovereignty not like", value, "landSovereignty");
            return (Criteria) this;
        }

        public Criteria andLandSovereigntyIn(List<String> values) {
            addCriterion("land_sovereignty in", values, "landSovereignty");
            return (Criteria) this;
        }

        public Criteria andLandSovereigntyNotIn(List<String> values) {
            addCriterion("land_sovereignty not in", values, "landSovereignty");
            return (Criteria) this;
        }

        public Criteria andLandSovereigntyBetween(String value1, String value2) {
            addCriterion("land_sovereignty between", value1, value2, "landSovereignty");
            return (Criteria) this;
        }

        public Criteria andLandSovereigntyNotBetween(String value1, String value2) {
            addCriterion("land_sovereignty not between", value1, value2, "landSovereignty");
            return (Criteria) this;
        }
			
		public Criteria andUsePlanIsNull() {
            addCriterion("use_plan is null");
            return (Criteria) this;
        }
        
        public Criteria andUsePlanIsNotNull() {
            addCriterion("use_plan is not null");
            return (Criteria) this;
        }
        
        public Criteria andUsePlanEqualTo(String value) {
            addCriterion("use_plan =", value, "usePlan");
            return (Criteria) this;
        }

        public Criteria andUsePlanNotEqualTo(String value) {
            addCriterion("use_plan <>", value, "usePlan");
            return (Criteria) this;
        }

        public Criteria andUsePlanGreaterThan(String value) {
            addCriterion("use_plan >", value, "usePlan");
            return (Criteria) this;
        }

        public Criteria andUsePlanGreaterThanOrEqualTo(String value) {
            addCriterion("use_plan >=", value, "usePlan");
            return (Criteria) this;
        }

        public Criteria andUsePlanLessThan(String value) {
            addCriterion("use_plan <", value, "usePlan");
            return (Criteria) this;
        }

        public Criteria andUsePlanLessThanOrEqualTo(String value) {
            addCriterion("use_plan <=", value, "usePlan");
            return (Criteria) this;
        }
        
        public Criteria andUsePlanLike(String value) {
            addCriterion("use_plan like", value, "usePlan");
            return (Criteria) this;
        }

        public Criteria andUsePlanNotLike(String value) {
            addCriterion("use_plan not like", value, "usePlan");
            return (Criteria) this;
        }

        public Criteria andUsePlanIn(List<String> values) {
            addCriterion("use_plan in", values, "usePlan");
            return (Criteria) this;
        }

        public Criteria andUsePlanNotIn(List<String> values) {
            addCriterion("use_plan not in", values, "usePlan");
            return (Criteria) this;
        }

        public Criteria andUsePlanBetween(String value1, String value2) {
            addCriterion("use_plan between", value1, value2, "usePlan");
            return (Criteria) this;
        }

        public Criteria andUsePlanNotBetween(String value1, String value2) {
            addCriterion("use_plan not between", value1, value2, "usePlan");
            return (Criteria) this;
        }
			
		public Criteria andRemainingLeaseIsNull() {
            addCriterion("remaining_lease is null");
            return (Criteria) this;
        }
        
        public Criteria andRemainingLeaseIsNotNull() {
            addCriterion("remaining_lease is not null");
            return (Criteria) this;
        }
        
        public Criteria andRemainingLeaseEqualTo(String value) {
            addCriterion("remaining_lease =", value, "remainingLease");
            return (Criteria) this;
        }

        public Criteria andRemainingLeaseNotEqualTo(String value) {
            addCriterion("remaining_lease <>", value, "remainingLease");
            return (Criteria) this;
        }

        public Criteria andRemainingLeaseGreaterThan(String value) {
            addCriterion("remaining_lease >", value, "remainingLease");
            return (Criteria) this;
        }

        public Criteria andRemainingLeaseGreaterThanOrEqualTo(String value) {
            addCriterion("remaining_lease >=", value, "remainingLease");
            return (Criteria) this;
        }

        public Criteria andRemainingLeaseLessThan(String value) {
            addCriterion("remaining_lease <", value, "remainingLease");
            return (Criteria) this;
        }

        public Criteria andRemainingLeaseLessThanOrEqualTo(String value) {
            addCriterion("remaining_lease <=", value, "remainingLease");
            return (Criteria) this;
        }
        
        public Criteria andRemainingLeaseLike(String value) {
            addCriterion("remaining_lease like", value, "remainingLease");
            return (Criteria) this;
        }

        public Criteria andRemainingLeaseNotLike(String value) {
            addCriterion("remaining_lease not like", value, "remainingLease");
            return (Criteria) this;
        }

        public Criteria andRemainingLeaseIn(List<String> values) {
            addCriterion("remaining_lease in", values, "remainingLease");
            return (Criteria) this;
        }

        public Criteria andRemainingLeaseNotIn(List<String> values) {
            addCriterion("remaining_lease not in", values, "remainingLease");
            return (Criteria) this;
        }

        public Criteria andRemainingLeaseBetween(String value1, String value2) {
            addCriterion("remaining_lease between", value1, value2, "remainingLease");
            return (Criteria) this;
        }

        public Criteria andRemainingLeaseNotBetween(String value1, String value2) {
            addCriterion("remaining_lease not between", value1, value2, "remainingLease");
            return (Criteria) this;
        }
			
		public Criteria andParkingCategoryIsNull() {
            addCriterion("parking_category is null");
            return (Criteria) this;
        }
        
        public Criteria andParkingCategoryIsNotNull() {
            addCriterion("parking_category is not null");
            return (Criteria) this;
        }
        
        public Criteria andParkingCategoryEqualTo(String value) {
            addCriterion("parking_category =", value, "parkingCategory");
            return (Criteria) this;
        }

        public Criteria andParkingCategoryNotEqualTo(String value) {
            addCriterion("parking_category <>", value, "parkingCategory");
            return (Criteria) this;
        }

        public Criteria andParkingCategoryGreaterThan(String value) {
            addCriterion("parking_category >", value, "parkingCategory");
            return (Criteria) this;
        }

        public Criteria andParkingCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("parking_category >=", value, "parkingCategory");
            return (Criteria) this;
        }

        public Criteria andParkingCategoryLessThan(String value) {
            addCriterion("parking_category <", value, "parkingCategory");
            return (Criteria) this;
        }

        public Criteria andParkingCategoryLessThanOrEqualTo(String value) {
            addCriterion("parking_category <=", value, "parkingCategory");
            return (Criteria) this;
        }
        
        public Criteria andParkingCategoryLike(String value) {
            addCriterion("parking_category like", value, "parkingCategory");
            return (Criteria) this;
        }

        public Criteria andParkingCategoryNotLike(String value) {
            addCriterion("parking_category not like", value, "parkingCategory");
            return (Criteria) this;
        }

        public Criteria andParkingCategoryIn(List<String> values) {
            addCriterion("parking_category in", values, "parkingCategory");
            return (Criteria) this;
        }

        public Criteria andParkingCategoryNotIn(List<String> values) {
            addCriterion("parking_category not in", values, "parkingCategory");
            return (Criteria) this;
        }

        public Criteria andParkingCategoryBetween(String value1, String value2) {
            addCriterion("parking_category between", value1, value2, "parkingCategory");
            return (Criteria) this;
        }

        public Criteria andParkingCategoryNotBetween(String value1, String value2) {
            addCriterion("parking_category not between", value1, value2, "parkingCategory");
            return (Criteria) this;
        }
			
		public Criteria andSquarePriceIsNull() {
            addCriterion("square_price is null");
            return (Criteria) this;
        }
        
        public Criteria andSquarePriceIsNotNull() {
            addCriterion("square_price is not null");
            return (Criteria) this;
        }
        
        public Criteria andSquarePriceEqualTo(String value) {
            addCriterion("square_price =", value, "squarePrice");
            return (Criteria) this;
        }

        public Criteria andSquarePriceNotEqualTo(String value) {
            addCriterion("square_price <>", value, "squarePrice");
            return (Criteria) this;
        }

        public Criteria andSquarePriceGreaterThan(String value) {
            addCriterion("square_price >", value, "squarePrice");
            return (Criteria) this;
        }

        public Criteria andSquarePriceGreaterThanOrEqualTo(String value) {
            addCriterion("square_price >=", value, "squarePrice");
            return (Criteria) this;
        }

        public Criteria andSquarePriceLessThan(String value) {
            addCriterion("square_price <", value, "squarePrice");
            return (Criteria) this;
        }

        public Criteria andSquarePriceLessThanOrEqualTo(String value) {
            addCriterion("square_price <=", value, "squarePrice");
            return (Criteria) this;
        }
        
        public Criteria andSquarePriceLike(String value) {
            addCriterion("square_price like", value, "squarePrice");
            return (Criteria) this;
        }

        public Criteria andSquarePriceNotLike(String value) {
            addCriterion("square_price not like", value, "squarePrice");
            return (Criteria) this;
        }

        public Criteria andSquarePriceIn(List<String> values) {
            addCriterion("square_price in", values, "squarePrice");
            return (Criteria) this;
        }

        public Criteria andSquarePriceNotIn(List<String> values) {
            addCriterion("square_price not in", values, "squarePrice");
            return (Criteria) this;
        }

        public Criteria andSquarePriceBetween(String value1, String value2) {
            addCriterion("square_price between", value1, value2, "squarePrice");
            return (Criteria) this;
        }

        public Criteria andSquarePriceNotBetween(String value1, String value2) {
            addCriterion("square_price not between", value1, value2, "squarePrice");
            return (Criteria) this;
        }
			
		public Criteria andAveragePriceIsNull() {
            addCriterion("average_price is null");
            return (Criteria) this;
        }
        
        public Criteria andAveragePriceIsNotNull() {
            addCriterion("average_price is not null");
            return (Criteria) this;
        }
        
        public Criteria andAveragePriceEqualTo(BigDecimal value) {
            addCriterion("average_price =", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotEqualTo(BigDecimal value) {
            addCriterion("average_price <>", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceGreaterThan(BigDecimal value) {
            addCriterion("average_price >", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("average_price >=", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceLessThan(BigDecimal value) {
            addCriterion("average_price <", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("average_price <=", value, "averagePrice");
            return (Criteria) this;
        }
        
        public Criteria andAveragePriceIn(List<BigDecimal> values) {
            addCriterion("average_price in", values, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotIn(List<BigDecimal> values) {
            addCriterion("average_price not in", values, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average_price between", value1, value2, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("average_price not between", value1, value2, "averagePrice");
            return (Criteria) this;
        }
			
		public Criteria andTruckSpaceTypeIsNull() {
            addCriterion("truck_space_type is null");
            return (Criteria) this;
        }
        
        public Criteria andTruckSpaceTypeIsNotNull() {
            addCriterion("truck_space_type is not null");
            return (Criteria) this;
        }
        
        public Criteria andTruckSpaceTypeEqualTo(String value) {
            addCriterion("truck_space_type =", value, "truckSpaceType");
            return (Criteria) this;
        }

        public Criteria andTruckSpaceTypeNotEqualTo(String value) {
            addCriterion("truck_space_type <>", value, "truckSpaceType");
            return (Criteria) this;
        }

        public Criteria andTruckSpaceTypeGreaterThan(String value) {
            addCriterion("truck_space_type >", value, "truckSpaceType");
            return (Criteria) this;
        }

        public Criteria andTruckSpaceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("truck_space_type >=", value, "truckSpaceType");
            return (Criteria) this;
        }

        public Criteria andTruckSpaceTypeLessThan(String value) {
            addCriterion("truck_space_type <", value, "truckSpaceType");
            return (Criteria) this;
        }

        public Criteria andTruckSpaceTypeLessThanOrEqualTo(String value) {
            addCriterion("truck_space_type <=", value, "truckSpaceType");
            return (Criteria) this;
        }
        
        public Criteria andTruckSpaceTypeLike(String value) {
            addCriterion("truck_space_type like", value, "truckSpaceType");
            return (Criteria) this;
        }

        public Criteria andTruckSpaceTypeNotLike(String value) {
            addCriterion("truck_space_type not like", value, "truckSpaceType");
            return (Criteria) this;
        }

        public Criteria andTruckSpaceTypeIn(List<String> values) {
            addCriterion("truck_space_type in", values, "truckSpaceType");
            return (Criteria) this;
        }

        public Criteria andTruckSpaceTypeNotIn(List<String> values) {
            addCriterion("truck_space_type not in", values, "truckSpaceType");
            return (Criteria) this;
        }

        public Criteria andTruckSpaceTypeBetween(String value1, String value2) {
            addCriterion("truck_space_type between", value1, value2, "truckSpaceType");
            return (Criteria) this;
        }

        public Criteria andTruckSpaceTypeNotBetween(String value1, String value2) {
            addCriterion("truck_space_type not between", value1, value2, "truckSpaceType");
            return (Criteria) this;
        }
			
		public Criteria andSellStatusIsNull() {
            addCriterion("sell_status is null");
            return (Criteria) this;
        }
        
        public Criteria andSellStatusIsNotNull() {
            addCriterion("sell_status is not null");
            return (Criteria) this;
        }
        
        public Criteria andSellStatusEqualTo(Integer value) {
            addCriterion("sell_status =", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusNotEqualTo(Integer value) {
            addCriterion("sell_status <>", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusGreaterThan(Integer value) {
            addCriterion("sell_status >", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_status >=", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusLessThan(Integer value) {
            addCriterion("sell_status <", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sell_status <=", value, "sellStatus");
            return (Criteria) this;
        }
        
        public Criteria andSellStatusIn(List<Integer> values) {
            addCriterion("sell_status in", values, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusNotIn(List<Integer> values) {
            addCriterion("sell_status not in", values, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusBetween(Integer value1, Integer value2) {
            addCriterion("sell_status between", value1, value2, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_status not between", value1, value2, "sellStatus");
            return (Criteria) this;
        }
			
		public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }
        
        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }
        
        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }
        
        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }
			
		public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }
        
        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }
        
        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }
        
        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }
			
		public Criteria andSignLabelIsNull() {
            addCriterion("sign_label is null");
            return (Criteria) this;
        }
        
        public Criteria andSignLabelIsNotNull() {
            addCriterion("sign_label is not null");
            return (Criteria) this;
        }
        
        public Criteria andSignLabelEqualTo(String value) {
            addCriterion("sign_label =", value, "signLabel");
            return (Criteria) this;
        }

        public Criteria andSignLabelNotEqualTo(String value) {
            addCriterion("sign_label <>", value, "signLabel");
            return (Criteria) this;
        }

        public Criteria andSignLabelGreaterThan(String value) {
            addCriterion("sign_label >", value, "signLabel");
            return (Criteria) this;
        }

        public Criteria andSignLabelGreaterThanOrEqualTo(String value) {
            addCriterion("sign_label >=", value, "signLabel");
            return (Criteria) this;
        }

        public Criteria andSignLabelLessThan(String value) {
            addCriterion("sign_label <", value, "signLabel");
            return (Criteria) this;
        }

        public Criteria andSignLabelLessThanOrEqualTo(String value) {
            addCriterion("sign_label <=", value, "signLabel");
            return (Criteria) this;
        }
        
        public Criteria andSignLabelLike(String value) {
            addCriterion("sign_label like", value, "signLabel");
            return (Criteria) this;
        }

        public Criteria andSignLabelNotLike(String value) {
            addCriterion("sign_label not like", value, "signLabel");
            return (Criteria) this;
        }

        public Criteria andSignLabelIn(List<String> values) {
            addCriterion("sign_label in", values, "signLabel");
            return (Criteria) this;
        }

        public Criteria andSignLabelNotIn(List<String> values) {
            addCriterion("sign_label not in", values, "signLabel");
            return (Criteria) this;
        }

        public Criteria andSignLabelBetween(String value1, String value2) {
            addCriterion("sign_label between", value1, value2, "signLabel");
            return (Criteria) this;
        }

        public Criteria andSignLabelNotBetween(String value1, String value2) {
            addCriterion("sign_label not between", value1, value2, "signLabel");
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
			
		public Criteria andStickyTimeIsNull() {
            addCriterion("sticky_time is null");
            return (Criteria) this;
        }
        
        public Criteria andStickyTimeIsNotNull() {
            addCriterion("sticky_time is not null");
            return (Criteria) this;
        }
        
        public Criteria andStickyTimeEqualTo(Date value) {
            addCriterion("sticky_time =", value, "stickyTime");
            return (Criteria) this;
        }

        public Criteria andStickyTimeNotEqualTo(Date value) {
            addCriterion("sticky_time <>", value, "stickyTime");
            return (Criteria) this;
        }

        public Criteria andStickyTimeGreaterThan(Date value) {
            addCriterion("sticky_time >", value, "stickyTime");
            return (Criteria) this;
        }

        public Criteria andStickyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sticky_time >=", value, "stickyTime");
            return (Criteria) this;
        }

        public Criteria andStickyTimeLessThan(Date value) {
            addCriterion("sticky_time <", value, "stickyTime");
            return (Criteria) this;
        }

        public Criteria andStickyTimeLessThanOrEqualTo(Date value) {
            addCriterion("sticky_time <=", value, "stickyTime");
            return (Criteria) this;
        }
        
        public Criteria andStickyTimeIn(List<Date> values) {
            addCriterion("sticky_time in", values, "stickyTime");
            return (Criteria) this;
        }

        public Criteria andStickyTimeNotIn(List<Date> values) {
            addCriterion("sticky_time not in", values, "stickyTime");
            return (Criteria) this;
        }

        public Criteria andStickyTimeBetween(Date value1, Date value2) {
            addCriterion("sticky_time between", value1, value2, "stickyTime");
            return (Criteria) this;
        }

        public Criteria andStickyTimeNotBetween(Date value1, Date value2) {
            addCriterion("sticky_time not between", value1, value2, "stickyTime");
            return (Criteria) this;
        }

        public Criteria orListingFeaturesIdsLike(List<String> ids) {
//            if (ids != null && ids.size() == 1) {
//                addCriterion(" listing_features_ids like ", " '%" + ids.get(0)+ "%' ", "listingFeaturesIds");
//                return (Criteria) this;
//            } else {
//                StringBuilder sb2 = new StringBuilder();
//                for (int i = 0; i <ids.size() ; i++) {
//                    if(i==0){
//                        sb2.append("listing_features_ids LIKE '%").append(ids.get(i)).append("%' ");
//                    }else {
//                        sb2.append(" or listing_features_ids LIKE '%").append(ids.get(i)).append("%' ");
//                    }
//                }
//                addCriterion("(" + sb2.toString() + ")");
//                return (Criteria) this;
//            }

            if(ids!=null && ids.size()==1) {
                addCriterion("listing_features_ids like '%" +ids.get(0) +"%' ");
            }else {

                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i <ids.size() ; i++) {
                    if(i == 0){
                        sb2.append("listing_features_ids LIKE '%").append(ids.get(i)).append("%' ");
                    }else {
                        sb2.append(" or listing_features_ids LIKE '%").append(ids.get(i)).append("%' ");
                    }
                }
                addCriterion(" ("+sb2.toString()+") ");
            }
            return (Criteria) this;
        }
    }
	
	/**
     * This class corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
     */
	public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
    
    /**
     * This class corresponds to the database table HouseResource
     *
     * @date 2020-03-19 20:32:50
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