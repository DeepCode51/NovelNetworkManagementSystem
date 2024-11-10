package com.ykjzone.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChapterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChapterExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
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

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andWords_numIsNull() {
            addCriterion("words_num is null");
            return (Criteria) this;
        }

        public Criteria andWords_numIsNotNull() {
            addCriterion("words_num is not null");
            return (Criteria) this;
        }

        public Criteria andWords_numEqualTo(Integer value) {
            addCriterion("words_num =", value, "words_num");
            return (Criteria) this;
        }

        public Criteria andWords_numNotEqualTo(Integer value) {
            addCriterion("words_num <>", value, "words_num");
            return (Criteria) this;
        }

        public Criteria andWords_numGreaterThan(Integer value) {
            addCriterion("words_num >", value, "words_num");
            return (Criteria) this;
        }

        public Criteria andWords_numGreaterThanOrEqualTo(Integer value) {
            addCriterion("words_num >=", value, "words_num");
            return (Criteria) this;
        }

        public Criteria andWords_numLessThan(Integer value) {
            addCriterion("words_num <", value, "words_num");
            return (Criteria) this;
        }

        public Criteria andWords_numLessThanOrEqualTo(Integer value) {
            addCriterion("words_num <=", value, "words_num");
            return (Criteria) this;
        }

        public Criteria andWords_numIn(List<Integer> values) {
            addCriterion("words_num in", values, "words_num");
            return (Criteria) this;
        }

        public Criteria andWords_numNotIn(List<Integer> values) {
            addCriterion("words_num not in", values, "words_num");
            return (Criteria) this;
        }

        public Criteria andWords_numBetween(Integer value1, Integer value2) {
            addCriterion("words_num between", value1, value2, "words_num");
            return (Criteria) this;
        }

        public Criteria andWords_numNotBetween(Integer value1, Integer value2) {
            addCriterion("words_num not between", value1, value2, "words_num");
            return (Criteria) this;
        }

        public Criteria andNovel_idIsNull() {
            addCriterion("novel_id is null");
            return (Criteria) this;
        }

        public Criteria andNovel_idIsNotNull() {
            addCriterion("novel_id is not null");
            return (Criteria) this;
        }

        public Criteria andNovel_idEqualTo(String value) {
            addCriterion("novel_id =", value, "novel_id");
            return (Criteria) this;
        }

        public Criteria andNovel_idNotEqualTo(String value) {
            addCriterion("novel_id <>", value, "novel_id");
            return (Criteria) this;
        }

        public Criteria andNovel_idGreaterThan(String value) {
            addCriterion("novel_id >", value, "novel_id");
            return (Criteria) this;
        }

        public Criteria andNovel_idGreaterThanOrEqualTo(String value) {
            addCriterion("novel_id >=", value, "novel_id");
            return (Criteria) this;
        }

        public Criteria andNovel_idLessThan(String value) {
            addCriterion("novel_id <", value, "novel_id");
            return (Criteria) this;
        }

        public Criteria andNovel_idLessThanOrEqualTo(String value) {
            addCriterion("novel_id <=", value, "novel_id");
            return (Criteria) this;
        }

        public Criteria andNovel_idLike(String value) {
            addCriterion("novel_id like", value, "novel_id");
            return (Criteria) this;
        }

        public Criteria andNovel_idNotLike(String value) {
            addCriterion("novel_id not like", value, "novel_id");
            return (Criteria) this;
        }

        public Criteria andNovel_idIn(List<String> values) {
            addCriterion("novel_id in", values, "novel_id");
            return (Criteria) this;
        }

        public Criteria andNovel_idNotIn(List<String> values) {
            addCriterion("novel_id not in", values, "novel_id");
            return (Criteria) this;
        }

        public Criteria andNovel_idBetween(String value1, String value2) {
            addCriterion("novel_id between", value1, value2, "novel_id");
            return (Criteria) this;
        }

        public Criteria andNovel_idNotBetween(String value1, String value2) {
            addCriterion("novel_id not between", value1, value2, "novel_id");
            return (Criteria) this;
        }

        public Criteria andPub_dateIsNull() {
            addCriterion("pub_date is null");
            return (Criteria) this;
        }

        public Criteria andPub_dateIsNotNull() {
            addCriterion("pub_date is not null");
            return (Criteria) this;
        }

        public Criteria andPub_dateEqualTo(Date value) {
            addCriterion("pub_date =", value, "pub_date");
            return (Criteria) this;
        }

        public Criteria andPub_dateNotEqualTo(Date value) {
            addCriterion("pub_date <>", value, "pub_date");
            return (Criteria) this;
        }

        public Criteria andPub_dateGreaterThan(Date value) {
            addCriterion("pub_date >", value, "pub_date");
            return (Criteria) this;
        }

        public Criteria andPub_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("pub_date >=", value, "pub_date");
            return (Criteria) this;
        }

        public Criteria andPub_dateLessThan(Date value) {
            addCriterion("pub_date <", value, "pub_date");
            return (Criteria) this;
        }

        public Criteria andPub_dateLessThanOrEqualTo(Date value) {
            addCriterion("pub_date <=", value, "pub_date");
            return (Criteria) this;
        }

        public Criteria andPub_dateIn(List<Date> values) {
            addCriterion("pub_date in", values, "pub_date");
            return (Criteria) this;
        }

        public Criteria andPub_dateNotIn(List<Date> values) {
            addCriterion("pub_date not in", values, "pub_date");
            return (Criteria) this;
        }

        public Criteria andPub_dateBetween(Date value1, Date value2) {
            addCriterion("pub_date between", value1, value2, "pub_date");
            return (Criteria) this;
        }

        public Criteria andPub_dateNotBetween(Date value1, Date value2) {
            addCriterion("pub_date not between", value1, value2, "pub_date");
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