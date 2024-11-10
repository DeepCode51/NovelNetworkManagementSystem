package com.ykjzone.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BannerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BannerExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andImage_urlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImage_urlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImage_urlEqualTo(String value) {
            addCriterion("image_url =", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImage_urlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImage_urlGreaterThan(String value) {
            addCriterion("image_url >", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImage_urlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImage_urlLessThan(String value) {
            addCriterion("image_url <", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImage_urlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImage_urlLike(String value) {
            addCriterion("image_url like", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImage_urlNotLike(String value) {
            addCriterion("image_url not like", value, "image_url");
            return (Criteria) this;
        }

        public Criteria andImage_urlIn(List<String> values) {
            addCriterion("image_url in", values, "image_url");
            return (Criteria) this;
        }

        public Criteria andImage_urlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "image_url");
            return (Criteria) this;
        }

        public Criteria andImage_urlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "image_url");
            return (Criteria) this;
        }

        public Criteria andImage_urlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "image_url");
            return (Criteria) this;
        }

        public Criteria andLink_toIsNull() {
            addCriterion("link_to is null");
            return (Criteria) this;
        }

        public Criteria andLink_toIsNotNull() {
            addCriterion("link_to is not null");
            return (Criteria) this;
        }

        public Criteria andLink_toEqualTo(String value) {
            addCriterion("link_to =", value, "link_to");
            return (Criteria) this;
        }

        public Criteria andLink_toNotEqualTo(String value) {
            addCriterion("link_to <>", value, "link_to");
            return (Criteria) this;
        }

        public Criteria andLink_toGreaterThan(String value) {
            addCriterion("link_to >", value, "link_to");
            return (Criteria) this;
        }

        public Criteria andLink_toGreaterThanOrEqualTo(String value) {
            addCriterion("link_to >=", value, "link_to");
            return (Criteria) this;
        }

        public Criteria andLink_toLessThan(String value) {
            addCriterion("link_to <", value, "link_to");
            return (Criteria) this;
        }

        public Criteria andLink_toLessThanOrEqualTo(String value) {
            addCriterion("link_to <=", value, "link_to");
            return (Criteria) this;
        }

        public Criteria andLink_toLike(String value) {
            addCriterion("link_to like", value, "link_to");
            return (Criteria) this;
        }

        public Criteria andLink_toNotLike(String value) {
            addCriterion("link_to not like", value, "link_to");
            return (Criteria) this;
        }

        public Criteria andLink_toIn(List<String> values) {
            addCriterion("link_to in", values, "link_to");
            return (Criteria) this;
        }

        public Criteria andLink_toNotIn(List<String> values) {
            addCriterion("link_to not in", values, "link_to");
            return (Criteria) this;
        }

        public Criteria andLink_toBetween(String value1, String value2) {
            addCriterion("link_to between", value1, value2, "link_to");
            return (Criteria) this;
        }

        public Criteria andLink_toNotBetween(String value1, String value2) {
            addCriterion("link_to not between", value1, value2, "link_to");
            return (Criteria) this;
        }

        public Criteria andPub_timeIsNull() {
            addCriterion("pub_time is null");
            return (Criteria) this;
        }

        public Criteria andPub_timeIsNotNull() {
            addCriterion("pub_time is not null");
            return (Criteria) this;
        }

        public Criteria andPub_timeEqualTo(Date value) {
            addCriterion("pub_time =", value, "pub_time");
            return (Criteria) this;
        }

        public Criteria andPub_timeNotEqualTo(Date value) {
            addCriterion("pub_time <>", value, "pub_time");
            return (Criteria) this;
        }

        public Criteria andPub_timeGreaterThan(Date value) {
            addCriterion("pub_time >", value, "pub_time");
            return (Criteria) this;
        }

        public Criteria andPub_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("pub_time >=", value, "pub_time");
            return (Criteria) this;
        }

        public Criteria andPub_timeLessThan(Date value) {
            addCriterion("pub_time <", value, "pub_time");
            return (Criteria) this;
        }

        public Criteria andPub_timeLessThanOrEqualTo(Date value) {
            addCriterion("pub_time <=", value, "pub_time");
            return (Criteria) this;
        }

        public Criteria andPub_timeIn(List<Date> values) {
            addCriterion("pub_time in", values, "pub_time");
            return (Criteria) this;
        }

        public Criteria andPub_timeNotIn(List<Date> values) {
            addCriterion("pub_time not in", values, "pub_time");
            return (Criteria) this;
        }

        public Criteria andPub_timeBetween(Date value1, Date value2) {
            addCriterion("pub_time between", value1, value2, "pub_time");
            return (Criteria) this;
        }

        public Criteria andPub_timeNotBetween(Date value1, Date value2) {
            addCriterion("pub_time not between", value1, value2, "pub_time");
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