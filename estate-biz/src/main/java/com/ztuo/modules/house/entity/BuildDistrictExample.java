package com.ztuo.modules.house.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;  
import java.util.Iterator;
import java.util.List;

public class BuildDistrictExample implements Serializable{

	private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
	protected String orderByClause;
	
    /**
     * This field corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
	protected boolean distinct;
	
	/**
     * This field corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
	protected List<Criteria> oredCriteria;
	
	/**
     * This method corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
	public BuildDistrictExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    
    /**
     * This method corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    
    /**
     * This method corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
    public String getOrderByClause() {
        return orderByClause;
    }
    
    /**
     * This method corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    
    /**
     * This method corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
    public boolean isDistinct() {
        return distinct;
    }
    
    /**
     * This method corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    
    /**
     * This method corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    
    /**
     * This method corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    
    /**
     * This method corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */   
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    
    /**
     * This method corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    
    /**
     * This method corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
	
	/**
     * This class corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
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
			
		public Criteria andSuperParentNoIsNull() {
            addCriterion("super_parent_no is null");
            return (Criteria) this;
        }
        
        public Criteria andSuperParentNoIsNotNull() {
            addCriterion("super_parent_no is not null");
            return (Criteria) this;
        }
        
        public Criteria andSuperParentNoEqualTo(String value) {
            addCriterion("super_parent_no =", value, "superParentNo");
            return (Criteria) this;
        }

        public Criteria andSuperParentNoNotEqualTo(String value) {
            addCriterion("super_parent_no <>", value, "superParentNo");
            return (Criteria) this;
        }

        public Criteria andSuperParentNoGreaterThan(String value) {
            addCriterion("super_parent_no >", value, "superParentNo");
            return (Criteria) this;
        }

        public Criteria andSuperParentNoGreaterThanOrEqualTo(String value) {
            addCriterion("super_parent_no >=", value, "superParentNo");
            return (Criteria) this;
        }

        public Criteria andSuperParentNoLessThan(String value) {
            addCriterion("super_parent_no <", value, "superParentNo");
            return (Criteria) this;
        }

        public Criteria andSuperParentNoLessThanOrEqualTo(String value) {
            addCriterion("super_parent_no <=", value, "superParentNo");
            return (Criteria) this;
        }
        
        public Criteria andSuperParentNoLike(String value) {
            addCriterion("super_parent_no like", value, "superParentNo");
            return (Criteria) this;
        }

        public Criteria andSuperParentNoNotLike(String value) {
            addCriterion("super_parent_no not like", value, "superParentNo");
            return (Criteria) this;
        }

        public Criteria andSuperParentNoIn(List<String> values) {
            addCriterion("super_parent_no in", values, "superParentNo");
            return (Criteria) this;
        }

        public Criteria andSuperParentNoNotIn(List<String> values) {
            addCriterion("super_parent_no not in", values, "superParentNo");
            return (Criteria) this;
        }

        public Criteria andSuperParentNoBetween(String value1, String value2) {
            addCriterion("super_parent_no between", value1, value2, "superParentNo");
            return (Criteria) this;
        }

        public Criteria andSuperParentNoNotBetween(String value1, String value2) {
            addCriterion("super_parent_no not between", value1, value2, "superParentNo");
            return (Criteria) this;
        }
			
		public Criteria andParentNoIsNull() {
            addCriterion("parent_no is null");
            return (Criteria) this;
        }
        
        public Criteria andParentNoIsNotNull() {
            addCriterion("parent_no is not null");
            return (Criteria) this;
        }
        
        public Criteria andParentNoEqualTo(String value) {
            addCriterion("parent_no =", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotEqualTo(String value) {
            addCriterion("parent_no <>", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoGreaterThan(String value) {
            addCriterion("parent_no >", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoGreaterThanOrEqualTo(String value) {
            addCriterion("parent_no >=", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoLessThan(String value) {
            addCriterion("parent_no <", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoLessThanOrEqualTo(String value) {
            addCriterion("parent_no <=", value, "parentNo");
            return (Criteria) this;
        }
        
        public Criteria andParentNoLike(String value) {
            addCriterion("parent_no like", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotLike(String value) {
            addCriterion("parent_no not like", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoIn(List<String> values) {
            addCriterion("parent_no in", values, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotIn(List<String> values) {
            addCriterion("parent_no not in", values, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoBetween(String value1, String value2) {
            addCriterion("parent_no between", value1, value2, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotBetween(String value1, String value2) {
            addCriterion("parent_no not between", value1, value2, "parentNo");
            return (Criteria) this;
        }
			
		public Criteria andBuildCateIsNull() {
            addCriterion("build_cate is null");
            return (Criteria) this;
        }
        
        public Criteria andBuildCateIsNotNull() {
            addCriterion("build_cate is not null");
            return (Criteria) this;
        }
        
        public Criteria andBuildCateEqualTo(String value) {
            addCriterion("build_cate =", value, "buildCate");
            return (Criteria) this;
        }

        public Criteria andBuildCateNotEqualTo(String value) {
            addCriterion("build_cate <>", value, "buildCate");
            return (Criteria) this;
        }

        public Criteria andBuildCateGreaterThan(String value) {
            addCriterion("build_cate >", value, "buildCate");
            return (Criteria) this;
        }

        public Criteria andBuildCateGreaterThanOrEqualTo(String value) {
            addCriterion("build_cate >=", value, "buildCate");
            return (Criteria) this;
        }

        public Criteria andBuildCateLessThan(String value) {
            addCriterion("build_cate <", value, "buildCate");
            return (Criteria) this;
        }

        public Criteria andBuildCateLessThanOrEqualTo(String value) {
            addCriterion("build_cate <=", value, "buildCate");
            return (Criteria) this;
        }
        
        public Criteria andBuildCateLike(String value) {
            addCriterion("build_cate like", value, "buildCate");
            return (Criteria) this;
        }

        public Criteria andBuildCateNotLike(String value) {
            addCriterion("build_cate not like", value, "buildCate");
            return (Criteria) this;
        }

        public Criteria andBuildCateIn(List<String> values) {
            addCriterion("build_cate in", values, "buildCate");
            return (Criteria) this;
        }

        public Criteria andBuildCateNotIn(List<String> values) {
            addCriterion("build_cate not in", values, "buildCate");
            return (Criteria) this;
        }

        public Criteria andBuildCateBetween(String value1, String value2) {
            addCriterion("build_cate between", value1, value2, "buildCate");
            return (Criteria) this;
        }

        public Criteria andBuildCateNotBetween(String value1, String value2) {
            addCriterion("build_cate not between", value1, value2, "buildCate");
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
			
		public Criteria andApplyNameIsNull() {
            addCriterion("apply_name is null");
            return (Criteria) this;
        }
        
        public Criteria andApplyNameIsNotNull() {
            addCriterion("apply_name is not null");
            return (Criteria) this;
        }
        
        public Criteria andApplyNameEqualTo(String value) {
            addCriterion("apply_name =", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotEqualTo(String value) {
            addCriterion("apply_name <>", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameGreaterThan(String value) {
            addCriterion("apply_name >", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_name >=", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLessThan(String value) {
            addCriterion("apply_name <", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLessThanOrEqualTo(String value) {
            addCriterion("apply_name <=", value, "applyName");
            return (Criteria) this;
        }
        
        public Criteria andApplyNameLike(String value) {
            addCriterion("apply_name like", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotLike(String value) {
            addCriterion("apply_name not like", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameIn(List<String> values) {
            addCriterion("apply_name in", values, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotIn(List<String> values) {
            addCriterion("apply_name not in", values, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameBetween(String value1, String value2) {
            addCriterion("apply_name between", value1, value2, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotBetween(String value1, String value2) {
            addCriterion("apply_name not between", value1, value2, "applyName");
            return (Criteria) this;
        }
			
		public Criteria andBuildStatusIsNull() {
            addCriterion("build_status is null");
            return (Criteria) this;
        }
        
        public Criteria andBuildStatusIsNotNull() {
            addCriterion("build_status is not null");
            return (Criteria) this;
        }
        
        public Criteria andBuildStatusEqualTo(String value) {
            addCriterion("build_status =", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusNotEqualTo(String value) {
            addCriterion("build_status <>", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusGreaterThan(String value) {
            addCriterion("build_status >", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusGreaterThanOrEqualTo(String value) {
            addCriterion("build_status >=", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusLessThan(String value) {
            addCriterion("build_status <", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusLessThanOrEqualTo(String value) {
            addCriterion("build_status <=", value, "buildStatus");
            return (Criteria) this;
        }
        
        public Criteria andBuildStatusLike(String value) {
            addCriterion("build_status like", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusNotLike(String value) {
            addCriterion("build_status not like", value, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusIn(List<String> values) {
            addCriterion("build_status in", values, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusNotIn(List<String> values) {
            addCriterion("build_status not in", values, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusBetween(String value1, String value2) {
            addCriterion("build_status between", value1, value2, "buildStatus");
            return (Criteria) this;
        }

        public Criteria andBuildStatusNotBetween(String value1, String value2) {
            addCriterion("build_status not between", value1, value2, "buildStatus");
            return (Criteria) this;
        }
			
		public Criteria andBuildNameIsNull() {
            addCriterion("build_name is null");
            return (Criteria) this;
        }
        
        public Criteria andBuildNameIsNotNull() {
            addCriterion("build_name is not null");
            return (Criteria) this;
        }
        
        public Criteria andBuildNameEqualTo(String value) {
            addCriterion("build_name =", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotEqualTo(String value) {
            addCriterion("build_name <>", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameGreaterThan(String value) {
            addCriterion("build_name >", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameGreaterThanOrEqualTo(String value) {
            addCriterion("build_name >=", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLessThan(String value) {
            addCriterion("build_name <", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLessThanOrEqualTo(String value) {
            addCriterion("build_name <=", value, "buildName");
            return (Criteria) this;
        }
        
        public Criteria andBuildNameLike(String value) {
            addCriterion("build_name like", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotLike(String value) {
            addCriterion("build_name not like", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameIn(List<String> values) {
            addCriterion("build_name in", values, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotIn(List<String> values) {
            addCriterion("build_name not in", values, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameBetween(String value1, String value2) {
            addCriterion("build_name between", value1, value2, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotBetween(String value1, String value2) {
            addCriterion("build_name not between", value1, value2, "buildName");
            return (Criteria) this;
        }
			
		public Criteria andBuildNameWyIsNull() {
            addCriterion("build_name_wy is null");
            return (Criteria) this;
        }
        
        public Criteria andBuildNameWyIsNotNull() {
            addCriterion("build_name_wy is not null");
            return (Criteria) this;
        }
        
        public Criteria andBuildNameWyEqualTo(String value) {
            addCriterion("build_name_wy =", value, "buildNameWy");
            return (Criteria) this;
        }

        public Criteria andBuildNameWyNotEqualTo(String value) {
            addCriterion("build_name_wy <>", value, "buildNameWy");
            return (Criteria) this;
        }

        public Criteria andBuildNameWyGreaterThan(String value) {
            addCriterion("build_name_wy >", value, "buildNameWy");
            return (Criteria) this;
        }

        public Criteria andBuildNameWyGreaterThanOrEqualTo(String value) {
            addCriterion("build_name_wy >=", value, "buildNameWy");
            return (Criteria) this;
        }

        public Criteria andBuildNameWyLessThan(String value) {
            addCriterion("build_name_wy <", value, "buildNameWy");
            return (Criteria) this;
        }

        public Criteria andBuildNameWyLessThanOrEqualTo(String value) {
            addCriterion("build_name_wy <=", value, "buildNameWy");
            return (Criteria) this;
        }
        
        public Criteria andBuildNameWyLike(String value) {
            addCriterion("build_name_wy like", value, "buildNameWy");
            return (Criteria) this;
        }

        public Criteria andBuildNameWyNotLike(String value) {
            addCriterion("build_name_wy not like", value, "buildNameWy");
            return (Criteria) this;
        }

        public Criteria andBuildNameWyIn(List<String> values) {
            addCriterion("build_name_wy in", values, "buildNameWy");
            return (Criteria) this;
        }

        public Criteria andBuildNameWyNotIn(List<String> values) {
            addCriterion("build_name_wy not in", values, "buildNameWy");
            return (Criteria) this;
        }

        public Criteria andBuildNameWyBetween(String value1, String value2) {
            addCriterion("build_name_wy between", value1, value2, "buildNameWy");
            return (Criteria) this;
        }

        public Criteria andBuildNameWyNotBetween(String value1, String value2) {
            addCriterion("build_name_wy not between", value1, value2, "buildNameWy");
            return (Criteria) this;
        }
			
		public Criteria andDetailAddressIsNull() {
            addCriterion("detail_address is null");
            return (Criteria) this;
        }
        
        public Criteria andDetailAddressIsNotNull() {
            addCriterion("detail_address is not null");
            return (Criteria) this;
        }
        
        public Criteria andDetailAddressEqualTo(String value) {
            addCriterion("detail_address =", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotEqualTo(String value) {
            addCriterion("detail_address <>", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThan(String value) {
            addCriterion("detail_address >", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detail_address >=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThan(String value) {
            addCriterion("detail_address <", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThanOrEqualTo(String value) {
            addCriterion("detail_address <=", value, "detailAddress");
            return (Criteria) this;
        }
        
        public Criteria andDetailAddressLike(String value) {
            addCriterion("detail_address like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotLike(String value) {
            addCriterion("detail_address not like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIn(List<String> values) {
            addCriterion("detail_address in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotIn(List<String> values) {
            addCriterion("detail_address not in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressBetween(String value1, String value2) {
            addCriterion("detail_address between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotBetween(String value1, String value2) {
            addCriterion("detail_address not between", value1, value2, "detailAddress");
            return (Criteria) this;
        }
			
		public Criteria andDetailAddressWyIsNull() {
            addCriterion("detail_address_wy is null");
            return (Criteria) this;
        }
        
        public Criteria andDetailAddressWyIsNotNull() {
            addCriterion("detail_address_wy is not null");
            return (Criteria) this;
        }
        
        public Criteria andDetailAddressWyEqualTo(String value) {
            addCriterion("detail_address_wy =", value, "detailAddressWy");
            return (Criteria) this;
        }

        public Criteria andDetailAddressWyNotEqualTo(String value) {
            addCriterion("detail_address_wy <>", value, "detailAddressWy");
            return (Criteria) this;
        }

        public Criteria andDetailAddressWyGreaterThan(String value) {
            addCriterion("detail_address_wy >", value, "detailAddressWy");
            return (Criteria) this;
        }

        public Criteria andDetailAddressWyGreaterThanOrEqualTo(String value) {
            addCriterion("detail_address_wy >=", value, "detailAddressWy");
            return (Criteria) this;
        }

        public Criteria andDetailAddressWyLessThan(String value) {
            addCriterion("detail_address_wy <", value, "detailAddressWy");
            return (Criteria) this;
        }

        public Criteria andDetailAddressWyLessThanOrEqualTo(String value) {
            addCriterion("detail_address_wy <=", value, "detailAddressWy");
            return (Criteria) this;
        }
        
        public Criteria andDetailAddressWyLike(String value) {
            addCriterion("detail_address_wy like", value, "detailAddressWy");
            return (Criteria) this;
        }

        public Criteria andDetailAddressWyNotLike(String value) {
            addCriterion("detail_address_wy not like", value, "detailAddressWy");
            return (Criteria) this;
        }

        public Criteria andDetailAddressWyIn(List<String> values) {
            addCriterion("detail_address_wy in", values, "detailAddressWy");
            return (Criteria) this;
        }

        public Criteria andDetailAddressWyNotIn(List<String> values) {
            addCriterion("detail_address_wy not in", values, "detailAddressWy");
            return (Criteria) this;
        }

        public Criteria andDetailAddressWyBetween(String value1, String value2) {
            addCriterion("detail_address_wy between", value1, value2, "detailAddressWy");
            return (Criteria) this;
        }

        public Criteria andDetailAddressWyNotBetween(String value1, String value2) {
            addCriterion("detail_address_wy not between", value1, value2, "detailAddressWy");
            return (Criteria) this;
        }
			
		public Criteria andBuildYearsIsNull() {
            addCriterion("build_years is null");
            return (Criteria) this;
        }
        
        public Criteria andBuildYearsIsNotNull() {
            addCriterion("build_years is not null");
            return (Criteria) this;
        }
        
        public Criteria andBuildYearsEqualTo(Integer value) {
            addCriterion("build_years =", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsNotEqualTo(Integer value) {
            addCriterion("build_years <>", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsGreaterThan(Integer value) {
            addCriterion("build_years >", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsGreaterThanOrEqualTo(Integer value) {
            addCriterion("build_years >=", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsLessThan(Integer value) {
            addCriterion("build_years <", value, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsLessThanOrEqualTo(Integer value) {
            addCriterion("build_years <=", value, "buildYears");
            return (Criteria) this;
        }
        
        public Criteria andBuildYearsIn(List<Integer> values) {
            addCriterion("build_years in", values, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsNotIn(List<Integer> values) {
            addCriterion("build_years not in", values, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsBetween(Integer value1, Integer value2) {
            addCriterion("build_years between", value1, value2, "buildYears");
            return (Criteria) this;
        }

        public Criteria andBuildYearsNotBetween(Integer value1, Integer value2) {
            addCriterion("build_years not between", value1, value2, "buildYears");
            return (Criteria) this;
        }
			
		public Criteria andCreateYearsIsNull() {
            addCriterion("create_years is null");
            return (Criteria) this;
        }
        
        public Criteria andCreateYearsIsNotNull() {
            addCriterion("create_years is not null");
            return (Criteria) this;
        }
        
        public Criteria andCreateYearsEqualTo(Integer value) {
            addCriterion("create_years =", value, "createYears");
            return (Criteria) this;
        }

        public Criteria andCreateYearsNotEqualTo(Integer value) {
            addCriterion("create_years <>", value, "createYears");
            return (Criteria) this;
        }

        public Criteria andCreateYearsGreaterThan(Integer value) {
            addCriterion("create_years >", value, "createYears");
            return (Criteria) this;
        }

        public Criteria andCreateYearsGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_years >=", value, "createYears");
            return (Criteria) this;
        }

        public Criteria andCreateYearsLessThan(Integer value) {
            addCriterion("create_years <", value, "createYears");
            return (Criteria) this;
        }

        public Criteria andCreateYearsLessThanOrEqualTo(Integer value) {
            addCriterion("create_years <=", value, "createYears");
            return (Criteria) this;
        }
        
        public Criteria andCreateYearsIn(List<Integer> values) {
            addCriterion("create_years in", values, "createYears");
            return (Criteria) this;
        }

        public Criteria andCreateYearsNotIn(List<Integer> values) {
            addCriterion("create_years not in", values, "createYears");
            return (Criteria) this;
        }

        public Criteria andCreateYearsBetween(Integer value1, Integer value2) {
            addCriterion("create_years between", value1, value2, "createYears");
            return (Criteria) this;
        }

        public Criteria andCreateYearsNotBetween(Integer value1, Integer value2) {
            addCriterion("create_years not between", value1, value2, "createYears");
            return (Criteria) this;
        }
			
		public Criteria andDeveloperIsNull() {
            addCriterion("developer is null");
            return (Criteria) this;
        }
        
        public Criteria andDeveloperIsNotNull() {
            addCriterion("developer is not null");
            return (Criteria) this;
        }
        
        public Criteria andDeveloperEqualTo(String value) {
            addCriterion("developer =", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotEqualTo(String value) {
            addCriterion("developer <>", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperGreaterThan(String value) {
            addCriterion("developer >", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperGreaterThanOrEqualTo(String value) {
            addCriterion("developer >=", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLessThan(String value) {
            addCriterion("developer <", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLessThanOrEqualTo(String value) {
            addCriterion("developer <=", value, "developer");
            return (Criteria) this;
        }
        
        public Criteria andDeveloperLike(String value) {
            addCriterion("developer like", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotLike(String value) {
            addCriterion("developer not like", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperIn(List<String> values) {
            addCriterion("developer in", values, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotIn(List<String> values) {
            addCriterion("developer not in", values, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperBetween(String value1, String value2) {
            addCriterion("developer between", value1, value2, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotBetween(String value1, String value2) {
            addCriterion("developer not between", value1, value2, "developer");
            return (Criteria) this;
        }
			
		public Criteria andDevelopmentIsNull() {
            addCriterion("development is null");
            return (Criteria) this;
        }
        
        public Criteria andDevelopmentIsNotNull() {
            addCriterion("development is not null");
            return (Criteria) this;
        }
        
        public Criteria andDevelopmentEqualTo(String value) {
            addCriterion("development =", value, "development");
            return (Criteria) this;
        }

        public Criteria andDevelopmentNotEqualTo(String value) {
            addCriterion("development <>", value, "development");
            return (Criteria) this;
        }

        public Criteria andDevelopmentGreaterThan(String value) {
            addCriterion("development >", value, "development");
            return (Criteria) this;
        }

        public Criteria andDevelopmentGreaterThanOrEqualTo(String value) {
            addCriterion("development >=", value, "development");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLessThan(String value) {
            addCriterion("development <", value, "development");
            return (Criteria) this;
        }

        public Criteria andDevelopmentLessThanOrEqualTo(String value) {
            addCriterion("development <=", value, "development");
            return (Criteria) this;
        }
        
        public Criteria andDevelopmentLike(String value) {
            addCriterion("development like", value, "development");
            return (Criteria) this;
        }

        public Criteria andDevelopmentNotLike(String value) {
            addCriterion("development not like", value, "development");
            return (Criteria) this;
        }

        public Criteria andDevelopmentIn(List<String> values) {
            addCriterion("development in", values, "development");
            return (Criteria) this;
        }

        public Criteria andDevelopmentNotIn(List<String> values) {
            addCriterion("development not in", values, "development");
            return (Criteria) this;
        }

        public Criteria andDevelopmentBetween(String value1, String value2) {
            addCriterion("development between", value1, value2, "development");
            return (Criteria) this;
        }

        public Criteria andDevelopmentNotBetween(String value1, String value2) {
            addCriterion("development not between", value1, value2, "development");
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
     * This class corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
     */
	public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
    
    /**
     * This class corresponds to the database table BuildDistrict
     *
     * @date 2020-03-04 16:01:03
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