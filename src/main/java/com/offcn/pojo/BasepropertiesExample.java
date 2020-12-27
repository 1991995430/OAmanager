package com.offcn.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BasepropertiesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BasepropertiesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBnameIsNull() {
            addCriterion("bname is null");
            return (Criteria) this;
        }

        public Criteria andBnameIsNotNull() {
            addCriterion("bname is not null");
            return (Criteria) this;
        }

        public Criteria andBnameEqualTo(String value) {
            addCriterion("bname =", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotEqualTo(String value) {
            addCriterion("bname <>", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThan(String value) {
            addCriterion("bname >", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThanOrEqualTo(String value) {
            addCriterion("bname >=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThan(String value) {
            addCriterion("bname <", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThanOrEqualTo(String value) {
            addCriterion("bname <=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLike(String value) {
            addCriterion("bname like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotLike(String value) {
            addCriterion("bname not like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameIn(List<String> values) {
            addCriterion("bname in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotIn(List<String> values) {
            addCriterion("bname not in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameBetween(String value1, String value2) {
            addCriterion("bname between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotBetween(String value1, String value2) {
            addCriterion("bname not between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeIsNull() {
            addCriterion("bmodelCode is null");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeIsNotNull() {
            addCriterion("bmodelCode is not null");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeEqualTo(Integer value) {
            addCriterion("bmodelCode =", value, "bmodelcode");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeNotEqualTo(Integer value) {
            addCriterion("bmodelCode <>", value, "bmodelcode");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeGreaterThan(Integer value) {
            addCriterion("bmodelCode >", value, "bmodelcode");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bmodelCode >=", value, "bmodelcode");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeLessThan(Integer value) {
            addCriterion("bmodelCode <", value, "bmodelcode");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeLessThanOrEqualTo(Integer value) {
            addCriterion("bmodelCode <=", value, "bmodelcode");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeIn(List<Integer> values) {
            addCriterion("bmodelCode in", values, "bmodelcode");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeNotIn(List<Integer> values) {
            addCriterion("bmodelCode not in", values, "bmodelcode");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeBetween(Integer value1, Integer value2) {
            addCriterion("bmodelCode between", value1, value2, "bmodelcode");
            return (Criteria) this;
        }

        public Criteria andBmodelcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("bmodelCode not between", value1, value2, "bmodelcode");
            return (Criteria) this;
        }

        public Criteria andBmodelnameIsNull() {
            addCriterion("bmodelName is null");
            return (Criteria) this;
        }

        public Criteria andBmodelnameIsNotNull() {
            addCriterion("bmodelName is not null");
            return (Criteria) this;
        }

        public Criteria andBmodelnameEqualTo(String value) {
            addCriterion("bmodelName =", value, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andBmodelnameNotEqualTo(String value) {
            addCriterion("bmodelName <>", value, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andBmodelnameGreaterThan(String value) {
            addCriterion("bmodelName >", value, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andBmodelnameGreaterThanOrEqualTo(String value) {
            addCriterion("bmodelName >=", value, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andBmodelnameLessThan(String value) {
            addCriterion("bmodelName <", value, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andBmodelnameLessThanOrEqualTo(String value) {
            addCriterion("bmodelName <=", value, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andBmodelnameLike(String value) {
            addCriterion("bmodelName like", value, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andBmodelnameNotLike(String value) {
            addCriterion("bmodelName not like", value, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andBmodelnameIn(List<String> values) {
            addCriterion("bmodelName in", values, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andBmodelnameNotIn(List<String> values) {
            addCriterion("bmodelName not in", values, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andBmodelnameBetween(String value1, String value2) {
            addCriterion("bmodelName between", value1, value2, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andBmodelnameNotBetween(String value1, String value2) {
            addCriterion("bmodelName not between", value1, value2, "bmodelname");
            return (Criteria) this;
        }

        public Criteria andPbidIsNull() {
            addCriterion("pbid is null");
            return (Criteria) this;
        }

        public Criteria andPbidIsNotNull() {
            addCriterion("pbid is not null");
            return (Criteria) this;
        }

        public Criteria andPbidEqualTo(Integer value) {
            addCriterion("pbid =", value, "pbid");
            return (Criteria) this;
        }

        public Criteria andPbidNotEqualTo(Integer value) {
            addCriterion("pbid <>", value, "pbid");
            return (Criteria) this;
        }

        public Criteria andPbidGreaterThan(Integer value) {
            addCriterion("pbid >", value, "pbid");
            return (Criteria) this;
        }

        public Criteria andPbidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pbid >=", value, "pbid");
            return (Criteria) this;
        }

        public Criteria andPbidLessThan(Integer value) {
            addCriterion("pbid <", value, "pbid");
            return (Criteria) this;
        }

        public Criteria andPbidLessThanOrEqualTo(Integer value) {
            addCriterion("pbid <=", value, "pbid");
            return (Criteria) this;
        }

        public Criteria andPbidIn(List<Integer> values) {
            addCriterion("pbid in", values, "pbid");
            return (Criteria) this;
        }

        public Criteria andPbidNotIn(List<Integer> values) {
            addCriterion("pbid not in", values, "pbid");
            return (Criteria) this;
        }

        public Criteria andPbidBetween(Integer value1, Integer value2) {
            addCriterion("pbid between", value1, value2, "pbid");
            return (Criteria) this;
        }

        public Criteria andPbidNotBetween(Integer value1, Integer value2) {
            addCriterion("pbid not between", value1, value2, "pbid");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterionForJDBCDate("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterionForJDBCDate("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterionForJDBCDate("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAdduserIsNull() {
            addCriterion("adduser is null");
            return (Criteria) this;
        }

        public Criteria andAdduserIsNotNull() {
            addCriterion("adduser is not null");
            return (Criteria) this;
        }

        public Criteria andAdduserEqualTo(Integer value) {
            addCriterion("adduser =", value, "adduser");
            return (Criteria) this;
        }

        public Criteria andAdduserNotEqualTo(Integer value) {
            addCriterion("adduser <>", value, "adduser");
            return (Criteria) this;
        }

        public Criteria andAdduserGreaterThan(Integer value) {
            addCriterion("adduser >", value, "adduser");
            return (Criteria) this;
        }

        public Criteria andAdduserGreaterThanOrEqualTo(Integer value) {
            addCriterion("adduser >=", value, "adduser");
            return (Criteria) this;
        }

        public Criteria andAdduserLessThan(Integer value) {
            addCriterion("adduser <", value, "adduser");
            return (Criteria) this;
        }

        public Criteria andAdduserLessThanOrEqualTo(Integer value) {
            addCriterion("adduser <=", value, "adduser");
            return (Criteria) this;
        }

        public Criteria andAdduserIn(List<Integer> values) {
            addCriterion("adduser in", values, "adduser");
            return (Criteria) this;
        }

        public Criteria andAdduserNotIn(List<Integer> values) {
            addCriterion("adduser not in", values, "adduser");
            return (Criteria) this;
        }

        public Criteria andAdduserBetween(Integer value1, Integer value2) {
            addCriterion("adduser between", value1, value2, "adduser");
            return (Criteria) this;
        }

        public Criteria andAdduserNotBetween(Integer value1, Integer value2) {
            addCriterion("adduser not between", value1, value2, "adduser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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