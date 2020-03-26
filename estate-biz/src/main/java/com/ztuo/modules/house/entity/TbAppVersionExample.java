package com.ztuo.modules.house.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbAppVersionExample implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
	protected String orderByClause;
	
    /**
     * This field corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
	protected boolean distinct;
	
	/**
     * This field corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
	protected List<Criteria> oredCriteria;
	
	/**
     * This method corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
	public TbAppVersionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    /**
     * This method corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    /**
     * This method corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
    public String getOrderByClause() {
        return orderByClause;
    }
    
    /**
     * This method corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    
    /**
     * This method corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
    public boolean isDistinct() {
        return distinct;
    }
    
    /**
     * This method corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    
    /**
     * This method corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    
    /**
     * This method corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    
    /**
     * This method corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */   
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    /**
     * This method corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    
    /**
     * This method corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
	
	/**
     * This class corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
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
			
		public Criteria andAppCateIsNull() {
            addCriterion("app_cate is null");
            return (Criteria) this;
        }
        
        public Criteria andAppCateIsNotNull() {
            addCriterion("app_cate is not null");
            return (Criteria) this;
        }
        
        public Criteria andAppCateEqualTo(String value) {
            addCriterion("app_cate =", value, "appCate");
            return (Criteria) this;
        }

        public Criteria andAppCateNotEqualTo(String value) {
            addCriterion("app_cate <>", value, "appCate");
            return (Criteria) this;
        }

        public Criteria andAppCateGreaterThan(String value) {
            addCriterion("app_cate >", value, "appCate");
            return (Criteria) this;
        }

        public Criteria andAppCateGreaterThanOrEqualTo(String value) {
            addCriterion("app_cate >=", value, "appCate");
            return (Criteria) this;
        }

        public Criteria andAppCateLessThan(String value) {
            addCriterion("app_cate <", value, "appCate");
            return (Criteria) this;
        }

        public Criteria andAppCateLessThanOrEqualTo(String value) {
            addCriterion("app_cate <=", value, "appCate");
            return (Criteria) this;
        }
        
        public Criteria andAppCateLike(String value) {
            addCriterion("app_cate like", value, "appCate");
            return (Criteria) this;
        }

        public Criteria andAppCateNotLike(String value) {
            addCriterion("app_cate not like", value, "appCate");
            return (Criteria) this;
        }

        public Criteria andAppCateIn(List<String> values) {
            addCriterion("app_cate in", values, "appCate");
            return (Criteria) this;
        }

        public Criteria andAppCateNotIn(List<String> values) {
            addCriterion("app_cate not in", values, "appCate");
            return (Criteria) this;
        }

        public Criteria andAppCateBetween(String value1, String value2) {
            addCriterion("app_cate between", value1, value2, "appCate");
            return (Criteria) this;
        }

        public Criteria andAppCateNotBetween(String value1, String value2) {
            addCriterion("app_cate not between", value1, value2, "appCate");
            return (Criteria) this;
        }
			
		public Criteria andAppVersionIsNull() {
            addCriterion("app_version is null");
            return (Criteria) this;
        }
        
        public Criteria andAppVersionIsNotNull() {
            addCriterion("app_version is not null");
            return (Criteria) this;
        }
        
        public Criteria andAppVersionEqualTo(String value) {
            addCriterion("app_version =", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotEqualTo(String value) {
            addCriterion("app_version <>", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThan(String value) {
            addCriterion("app_version >", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThanOrEqualTo(String value) {
            addCriterion("app_version >=", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThan(String value) {
            addCriterion("app_version <", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThanOrEqualTo(String value) {
            addCriterion("app_version <=", value, "appVersion");
            return (Criteria) this;
        }
        
        public Criteria andAppVersionLike(String value) {
            addCriterion("app_version like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotLike(String value) {
            addCriterion("app_version not like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionIn(List<String> values) {
            addCriterion("app_version in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotIn(List<String> values) {
            addCriterion("app_version not in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionBetween(String value1, String value2) {
            addCriterion("app_version between", value1, value2, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotBetween(String value1, String value2) {
            addCriterion("app_version not between", value1, value2, "appVersion");
            return (Criteria) this;
        }
			
		public Criteria andAppDownUrlIsNull() {
            addCriterion("app_down_url is null");
            return (Criteria) this;
        }
        
        public Criteria andAppDownUrlIsNotNull() {
            addCriterion("app_down_url is not null");
            return (Criteria) this;
        }
        
        public Criteria andAppDownUrlEqualTo(String value) {
            addCriterion("app_down_url =", value, "appDownUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownUrlNotEqualTo(String value) {
            addCriterion("app_down_url <>", value, "appDownUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownUrlGreaterThan(String value) {
            addCriterion("app_down_url >", value, "appDownUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownUrlGreaterThanOrEqualTo(String value) {
            addCriterion("app_down_url >=", value, "appDownUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownUrlLessThan(String value) {
            addCriterion("app_down_url <", value, "appDownUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownUrlLessThanOrEqualTo(String value) {
            addCriterion("app_down_url <=", value, "appDownUrl");
            return (Criteria) this;
        }
        
        public Criteria andAppDownUrlLike(String value) {
            addCriterion("app_down_url like", value, "appDownUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownUrlNotLike(String value) {
            addCriterion("app_down_url not like", value, "appDownUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownUrlIn(List<String> values) {
            addCriterion("app_down_url in", values, "appDownUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownUrlNotIn(List<String> values) {
            addCriterion("app_down_url not in", values, "appDownUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownUrlBetween(String value1, String value2) {
            addCriterion("app_down_url between", value1, value2, "appDownUrl");
            return (Criteria) this;
        }

        public Criteria andAppDownUrlNotBetween(String value1, String value2) {
            addCriterion("app_down_url not between", value1, value2, "appDownUrl");
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
			
		public Criteria andAppUpgradeContentIsNull() {
            addCriterion("app_upgrade_content is null");
            return (Criteria) this;
        }
        
        public Criteria andAppUpgradeContentIsNotNull() {
            addCriterion("app_upgrade_content is not null");
            return (Criteria) this;
        }
        
        public Criteria andAppUpgradeContentEqualTo(String value) {
            addCriterion("app_upgrade_content =", value, "appUpgradeContent");
            return (Criteria) this;
        }

        public Criteria andAppUpgradeContentNotEqualTo(String value) {
            addCriterion("app_upgrade_content <>", value, "appUpgradeContent");
            return (Criteria) this;
        }

        public Criteria andAppUpgradeContentGreaterThan(String value) {
            addCriterion("app_upgrade_content >", value, "appUpgradeContent");
            return (Criteria) this;
        }

        public Criteria andAppUpgradeContentGreaterThanOrEqualTo(String value) {
            addCriterion("app_upgrade_content >=", value, "appUpgradeContent");
            return (Criteria) this;
        }

        public Criteria andAppUpgradeContentLessThan(String value) {
            addCriterion("app_upgrade_content <", value, "appUpgradeContent");
            return (Criteria) this;
        }

        public Criteria andAppUpgradeContentLessThanOrEqualTo(String value) {
            addCriterion("app_upgrade_content <=", value, "appUpgradeContent");
            return (Criteria) this;
        }
        
        public Criteria andAppUpgradeContentLike(String value) {
            addCriterion("app_upgrade_content like", value, "appUpgradeContent");
            return (Criteria) this;
        }

        public Criteria andAppUpgradeContentNotLike(String value) {
            addCriterion("app_upgrade_content not like", value, "appUpgradeContent");
            return (Criteria) this;
        }

        public Criteria andAppUpgradeContentIn(List<String> values) {
            addCriterion("app_upgrade_content in", values, "appUpgradeContent");
            return (Criteria) this;
        }

        public Criteria andAppUpgradeContentNotIn(List<String> values) {
            addCriterion("app_upgrade_content not in", values, "appUpgradeContent");
            return (Criteria) this;
        }

        public Criteria andAppUpgradeContentBetween(String value1, String value2) {
            addCriterion("app_upgrade_content between", value1, value2, "appUpgradeContent");
            return (Criteria) this;
        }

        public Criteria andAppUpgradeContentNotBetween(String value1, String value2) {
            addCriterion("app_upgrade_content not between", value1, value2, "appUpgradeContent");
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
     * This class corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
     */
	public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
    
    /**
     * This class corresponds to the database table TbAppVersion
     *
     * @date 2019-07-13 10:22:13
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