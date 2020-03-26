package com.ztuo.modules.house.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;  
import java.util.Iterator;
import java.util.List;

public class AdvertisingExample implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
	protected String orderByClause;
	
    /**
     * This field corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
	protected boolean distinct;
	
	/**
     * This field corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
	protected List<Criteria> oredCriteria;
	
	/**
     * This method corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
	public AdvertisingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    /**
     * This method corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    /**
     * This method corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
    public String getOrderByClause() {
        return orderByClause;
    }
    
    /**
     * This method corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    
    /**
     * This method corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
    public boolean isDistinct() {
        return distinct;
    }
    
    /**
     * This method corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    
    /**
     * This method corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    
    /**
     * This method corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    
    /**
     * This method corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */   
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    /**
     * This method corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    
    /**
     * This method corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
	
	/**
     * This class corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
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
			
		public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }
        
        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }
        
        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }
        
        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }
			
		public Criteria andUrlAddressIsNull() {
            addCriterion("url_address is null");
            return (Criteria) this;
        }
        
        public Criteria andUrlAddressIsNotNull() {
            addCriterion("url_address is not null");
            return (Criteria) this;
        }
        
        public Criteria andUrlAddressEqualTo(String value) {
            addCriterion("url_address =", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotEqualTo(String value) {
            addCriterion("url_address <>", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressGreaterThan(String value) {
            addCriterion("url_address >", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressGreaterThanOrEqualTo(String value) {
            addCriterion("url_address >=", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressLessThan(String value) {
            addCriterion("url_address <", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressLessThanOrEqualTo(String value) {
            addCriterion("url_address <=", value, "urlAddress");
            return (Criteria) this;
        }
        
        public Criteria andUrlAddressLike(String value) {
            addCriterion("url_address like", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotLike(String value) {
            addCriterion("url_address not like", value, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressIn(List<String> values) {
            addCriterion("url_address in", values, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotIn(List<String> values) {
            addCriterion("url_address not in", values, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressBetween(String value1, String value2) {
            addCriterion("url_address between", value1, value2, "urlAddress");
            return (Criteria) this;
        }

        public Criteria andUrlAddressNotBetween(String value1, String value2) {
            addCriterion("url_address not between", value1, value2, "urlAddress");
            return (Criteria) this;
        }
			
		public Criteria andSortsIsNull() {
            addCriterion("sorts is null");
            return (Criteria) this;
        }
        
        public Criteria andSortsIsNotNull() {
            addCriterion("sorts is not null");
            return (Criteria) this;
        }
        
        public Criteria andSortsEqualTo(String value) {
            addCriterion("sorts =", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotEqualTo(String value) {
            addCriterion("sorts <>", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThan(String value) {
            addCriterion("sorts >", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsGreaterThanOrEqualTo(String value) {
            addCriterion("sorts >=", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThan(String value) {
            addCriterion("sorts <", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsLessThanOrEqualTo(String value) {
            addCriterion("sorts <=", value, "sorts");
            return (Criteria) this;
        }
        
        public Criteria andSortsLike(String value) {
            addCriterion("sorts like", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotLike(String value) {
            addCriterion("sorts not like", value, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsIn(List<String> values) {
            addCriterion("sorts in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotIn(List<String> values) {
            addCriterion("sorts not in", values, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsBetween(String value1, String value2) {
            addCriterion("sorts between", value1, value2, "sorts");
            return (Criteria) this;
        }

        public Criteria andSortsNotBetween(String value1, String value2) {
            addCriterion("sorts not between", value1, value2, "sorts");
            return (Criteria) this;
        }
			
		public Criteria andEffectTimeIsNull() {
            addCriterion("effect_time is null");
            return (Criteria) this;
        }
        
        public Criteria andEffectTimeIsNotNull() {
            addCriterion("effect_time is not null");
            return (Criteria) this;
        }
        
        public Criteria andEffectTimeEqualTo(Date value) {
            addCriterion("effect_time =", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotEqualTo(Date value) {
            addCriterion("effect_time <>", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeGreaterThan(Date value) {
            addCriterion("effect_time >", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("effect_time >=", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeLessThan(Date value) {
            addCriterion("effect_time <", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeLessThanOrEqualTo(Date value) {
            addCriterion("effect_time <=", value, "effectTime");
            return (Criteria) this;
        }
        
        public Criteria andEffectTimeIn(List<Date> values) {
            addCriterion("effect_time in", values, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotIn(List<Date> values) {
            addCriterion("effect_time not in", values, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeBetween(Date value1, Date value2) {
            addCriterion("effect_time between", value1, value2, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotBetween(Date value1, Date value2) {
            addCriterion("effect_time not between", value1, value2, "effectTime");
            return (Criteria) this;
        }
			
		public Criteria andFailureTimeIsNull() {
            addCriterion("failure_time is null");
            return (Criteria) this;
        }
        
        public Criteria andFailureTimeIsNotNull() {
            addCriterion("failure_time is not null");
            return (Criteria) this;
        }
        
        public Criteria andFailureTimeEqualTo(Date value) {
            addCriterion("failure_time =", value, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeNotEqualTo(Date value) {
            addCriterion("failure_time <>", value, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeGreaterThan(Date value) {
            addCriterion("failure_time >", value, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("failure_time >=", value, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeLessThan(Date value) {
            addCriterion("failure_time <", value, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeLessThanOrEqualTo(Date value) {
            addCriterion("failure_time <=", value, "failureTime");
            return (Criteria) this;
        }
        
        public Criteria andFailureTimeIn(List<Date> values) {
            addCriterion("failure_time in", values, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeNotIn(List<Date> values) {
            addCriterion("failure_time not in", values, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeBetween(Date value1, Date value2) {
            addCriterion("failure_time between", value1, value2, "failureTime");
            return (Criteria) this;
        }

        public Criteria andFailureTimeNotBetween(Date value1, Date value2) {
            addCriterion("failure_time not between", value1, value2, "failureTime");
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
		}
	
	/**
     * This class corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
     */
	public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
    
    /**
     * This class corresponds to the database table Advertising
     *
     * @date 2020-03-03 18:41:23
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