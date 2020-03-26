package com.ztuo.modules.house.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;  
import java.util.Iterator;
import java.util.List;

public class UserAgreementExample implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
	protected String orderByClause;
	
    /**
     * This field corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
	protected boolean distinct;
	
	/**
     * This field corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
	protected List<Criteria> oredCriteria;
	
	/**
     * This method corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
	public UserAgreementExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    /**
     * This method corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    /**
     * This method corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
    public String getOrderByClause() {
        return orderByClause;
    }
    
    /**
     * This method corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    
    /**
     * This method corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
    public boolean isDistinct() {
        return distinct;
    }
    
    /**
     * This method corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    
    /**
     * This method corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    
    /**
     * This method corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    
    /**
     * This method corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */   
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    /**
     * This method corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    
    /**
     * This method corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
	
	/**
     * This class corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
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
			
		public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }
        
        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }
        
        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }
        
        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
			
		public Criteria andAgreementTypeIsNull() {
            addCriterion("agreement_type is null");
            return (Criteria) this;
        }
        
        public Criteria andAgreementTypeIsNotNull() {
            addCriterion("agreement_type is not null");
            return (Criteria) this;
        }
        
        public Criteria andAgreementTypeEqualTo(String value) {
            addCriterion("agreement_type =", value, "agreementType");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeNotEqualTo(String value) {
            addCriterion("agreement_type <>", value, "agreementType");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeGreaterThan(String value) {
            addCriterion("agreement_type >", value, "agreementType");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_type >=", value, "agreementType");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeLessThan(String value) {
            addCriterion("agreement_type <", value, "agreementType");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeLessThanOrEqualTo(String value) {
            addCriterion("agreement_type <=", value, "agreementType");
            return (Criteria) this;
        }
        
        public Criteria andAgreementTypeLike(String value) {
            addCriterion("agreement_type like", value, "agreementType");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeNotLike(String value) {
            addCriterion("agreement_type not like", value, "agreementType");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeIn(List<String> values) {
            addCriterion("agreement_type in", values, "agreementType");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeNotIn(List<String> values) {
            addCriterion("agreement_type not in", values, "agreementType");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeBetween(String value1, String value2) {
            addCriterion("agreement_type between", value1, value2, "agreementType");
            return (Criteria) this;
        }

        public Criteria andAgreementTypeNotBetween(String value1, String value2) {
            addCriterion("agreement_type not between", value1, value2, "agreementType");
            return (Criteria) this;
        }
			
		public Criteria andAgreementNameIsNull() {
            addCriterion("agreement_name is null");
            return (Criteria) this;
        }
        
        public Criteria andAgreementNameIsNotNull() {
            addCriterion("agreement_name is not null");
            return (Criteria) this;
        }
        
        public Criteria andAgreementNameEqualTo(String value) {
            addCriterion("agreement_name =", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameNotEqualTo(String value) {
            addCriterion("agreement_name <>", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameGreaterThan(String value) {
            addCriterion("agreement_name >", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_name >=", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameLessThan(String value) {
            addCriterion("agreement_name <", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameLessThanOrEqualTo(String value) {
            addCriterion("agreement_name <=", value, "agreementName");
            return (Criteria) this;
        }
        
        public Criteria andAgreementNameLike(String value) {
            addCriterion("agreement_name like", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameNotLike(String value) {
            addCriterion("agreement_name not like", value, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameIn(List<String> values) {
            addCriterion("agreement_name in", values, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameNotIn(List<String> values) {
            addCriterion("agreement_name not in", values, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameBetween(String value1, String value2) {
            addCriterion("agreement_name between", value1, value2, "agreementName");
            return (Criteria) this;
        }

        public Criteria andAgreementNameNotBetween(String value1, String value2) {
            addCriterion("agreement_name not between", value1, value2, "agreementName");
            return (Criteria) this;
        }
			
		public Criteria andAgreementDescIsNull() {
            addCriterion("agreement_desc is null");
            return (Criteria) this;
        }
        
        public Criteria andAgreementDescIsNotNull() {
            addCriterion("agreement_desc is not null");
            return (Criteria) this;
        }
        
        public Criteria andAgreementDescEqualTo(String value) {
            addCriterion("agreement_desc =", value, "agreementDesc");
            return (Criteria) this;
        }

        public Criteria andAgreementDescNotEqualTo(String value) {
            addCriterion("agreement_desc <>", value, "agreementDesc");
            return (Criteria) this;
        }

        public Criteria andAgreementDescGreaterThan(String value) {
            addCriterion("agreement_desc >", value, "agreementDesc");
            return (Criteria) this;
        }

        public Criteria andAgreementDescGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_desc >=", value, "agreementDesc");
            return (Criteria) this;
        }

        public Criteria andAgreementDescLessThan(String value) {
            addCriterion("agreement_desc <", value, "agreementDesc");
            return (Criteria) this;
        }

        public Criteria andAgreementDescLessThanOrEqualTo(String value) {
            addCriterion("agreement_desc <=", value, "agreementDesc");
            return (Criteria) this;
        }
        
        public Criteria andAgreementDescLike(String value) {
            addCriterion("agreement_desc like", value, "agreementDesc");
            return (Criteria) this;
        }

        public Criteria andAgreementDescNotLike(String value) {
            addCriterion("agreement_desc not like", value, "agreementDesc");
            return (Criteria) this;
        }

        public Criteria andAgreementDescIn(List<String> values) {
            addCriterion("agreement_desc in", values, "agreementDesc");
            return (Criteria) this;
        }

        public Criteria andAgreementDescNotIn(List<String> values) {
            addCriterion("agreement_desc not in", values, "agreementDesc");
            return (Criteria) this;
        }

        public Criteria andAgreementDescBetween(String value1, String value2) {
            addCriterion("agreement_desc between", value1, value2, "agreementDesc");
            return (Criteria) this;
        }

        public Criteria andAgreementDescNotBetween(String value1, String value2) {
            addCriterion("agreement_desc not between", value1, value2, "agreementDesc");
            return (Criteria) this;
        }
			
		public Criteria andAgreementAddressIsNull() {
            addCriterion("agreement_address is null");
            return (Criteria) this;
        }
        
        public Criteria andAgreementAddressIsNotNull() {
            addCriterion("agreement_address is not null");
            return (Criteria) this;
        }
        
        public Criteria andAgreementAddressEqualTo(String value) {
            addCriterion("agreement_address =", value, "agreementAddress");
            return (Criteria) this;
        }

        public Criteria andAgreementAddressNotEqualTo(String value) {
            addCriterion("agreement_address <>", value, "agreementAddress");
            return (Criteria) this;
        }

        public Criteria andAgreementAddressGreaterThan(String value) {
            addCriterion("agreement_address >", value, "agreementAddress");
            return (Criteria) this;
        }

        public Criteria andAgreementAddressGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_address >=", value, "agreementAddress");
            return (Criteria) this;
        }

        public Criteria andAgreementAddressLessThan(String value) {
            addCriterion("agreement_address <", value, "agreementAddress");
            return (Criteria) this;
        }

        public Criteria andAgreementAddressLessThanOrEqualTo(String value) {
            addCriterion("agreement_address <=", value, "agreementAddress");
            return (Criteria) this;
        }
        
        public Criteria andAgreementAddressLike(String value) {
            addCriterion("agreement_address like", value, "agreementAddress");
            return (Criteria) this;
        }

        public Criteria andAgreementAddressNotLike(String value) {
            addCriterion("agreement_address not like", value, "agreementAddress");
            return (Criteria) this;
        }

        public Criteria andAgreementAddressIn(List<String> values) {
            addCriterion("agreement_address in", values, "agreementAddress");
            return (Criteria) this;
        }

        public Criteria andAgreementAddressNotIn(List<String> values) {
            addCriterion("agreement_address not in", values, "agreementAddress");
            return (Criteria) this;
        }

        public Criteria andAgreementAddressBetween(String value1, String value2) {
            addCriterion("agreement_address between", value1, value2, "agreementAddress");
            return (Criteria) this;
        }

        public Criteria andAgreementAddressNotBetween(String value1, String value2) {
            addCriterion("agreement_address not between", value1, value2, "agreementAddress");
            return (Criteria) this;
        }
			
		public Criteria andAgreementContentIsNull() {
            addCriterion("agreement_content is null");
            return (Criteria) this;
        }
        
        public Criteria andAgreementContentIsNotNull() {
            addCriterion("agreement_content is not null");
            return (Criteria) this;
        }
        
        public Criteria andAgreementContentEqualTo(String value) {
            addCriterion("agreement_content =", value, "agreementContent");
            return (Criteria) this;
        }

        public Criteria andAgreementContentNotEqualTo(String value) {
            addCriterion("agreement_content <>", value, "agreementContent");
            return (Criteria) this;
        }

        public Criteria andAgreementContentGreaterThan(String value) {
            addCriterion("agreement_content >", value, "agreementContent");
            return (Criteria) this;
        }

        public Criteria andAgreementContentGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_content >=", value, "agreementContent");
            return (Criteria) this;
        }

        public Criteria andAgreementContentLessThan(String value) {
            addCriterion("agreement_content <", value, "agreementContent");
            return (Criteria) this;
        }

        public Criteria andAgreementContentLessThanOrEqualTo(String value) {
            addCriterion("agreement_content <=", value, "agreementContent");
            return (Criteria) this;
        }
        
        public Criteria andAgreementContentLike(String value) {
            addCriterion("agreement_content like", value, "agreementContent");
            return (Criteria) this;
        }

        public Criteria andAgreementContentNotLike(String value) {
            addCriterion("agreement_content not like", value, "agreementContent");
            return (Criteria) this;
        }

        public Criteria andAgreementContentIn(List<String> values) {
            addCriterion("agreement_content in", values, "agreementContent");
            return (Criteria) this;
        }

        public Criteria andAgreementContentNotIn(List<String> values) {
            addCriterion("agreement_content not in", values, "agreementContent");
            return (Criteria) this;
        }

        public Criteria andAgreementContentBetween(String value1, String value2) {
            addCriterion("agreement_content between", value1, value2, "agreementContent");
            return (Criteria) this;
        }

        public Criteria andAgreementContentNotBetween(String value1, String value2) {
            addCriterion("agreement_content not between", value1, value2, "agreementContent");
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
     * This class corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
     */
	public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
    
    /**
     * This class corresponds to the database table UserAgreement
     *
     * @date 2020-03-14 15:35:10
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