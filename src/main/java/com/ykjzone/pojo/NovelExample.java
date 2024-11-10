package com.ykjzone.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NovelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NovelExample() {
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
            criteria.add(new Criterion("n."+condition, value));
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andChapters_numIsNull() {
            addCriterion("chapters_num is null");
            return (Criteria) this;
        }

        public Criteria andChapters_numIsNotNull() {
            addCriterion("chapters_num is not null");
            return (Criteria) this;
        }

        public Criteria andChapters_numEqualTo(Integer value) {
            addCriterion("chapters_num =", value, "chapters_num");
            return (Criteria) this;
        }

        public Criteria andChapters_numNotEqualTo(Integer value) {
            addCriterion("chapters_num <>", value, "chapters_num");
            return (Criteria) this;
        }

        public Criteria andChapters_numGreaterThan(Integer value) {
            addCriterion("chapters_num >", value, "chapters_num");
            return (Criteria) this;
        }

        public Criteria andChapters_numGreaterThanOrEqualTo(Integer value) {
            addCriterion("chapters_num >=", value, "chapters_num");
            return (Criteria) this;
        }

        public Criteria andChapters_numLessThan(Integer value) {
            addCriterion("chapters_num <", value, "chapters_num");
            return (Criteria) this;
        }

        public Criteria andChapters_numLessThanOrEqualTo(Integer value) {
            addCriterion("chapters_num <=", value, "chapters_num");
            return (Criteria) this;
        }

        public Criteria andChapters_numIn(List<Integer> values) {
            addCriterion("chapters_num in", values, "chapters_num");
            return (Criteria) this;
        }

        public Criteria andChapters_numNotIn(List<Integer> values) {
            addCriterion("chapters_num not in", values, "chapters_num");
            return (Criteria) this;
        }

        public Criteria andChapters_numBetween(Integer value1, Integer value2) {
            addCriterion("chapters_num between", value1, value2, "chapters_num");
            return (Criteria) this;
        }

        public Criteria andChapters_numNotBetween(Integer value1, Integer value2) {
            addCriterion("chapters_num not between", value1, value2, "chapters_num");
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andAuthor_idIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthor_idIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthor_idEqualTo(String value) {
            addCriterion("author_id =", value, "author_id");
            return (Criteria) this;
        }

        public Criteria andAuthor_idNotEqualTo(String value) {
            addCriterion("author_id <>", value, "author_id");
            return (Criteria) this;
        }

        public Criteria andAuthor_idGreaterThan(String value) {
            addCriterion("author_id >", value, "author_id");
            return (Criteria) this;
        }

        public Criteria andAuthor_idGreaterThanOrEqualTo(String value) {
            addCriterion("author_id >=", value, "author_id");
            return (Criteria) this;
        }

        public Criteria andAuthor_idLessThan(String value) {
            addCriterion("author_id <", value, "author_id");
            return (Criteria) this;
        }

        public Criteria andAuthor_idLessThanOrEqualTo(String value) {
            addCriterion("author_id <=", value, "author_id");
            return (Criteria) this;
        }

        public Criteria andAuthor_idLike(String value) {
            addCriterion("author_id like", value, "author_id");
            return (Criteria) this;
        }

        public Criteria andAuthor_idNotLike(String value) {
            addCriterion("author_id not like", value, "author_id");
            return (Criteria) this;
        }

        public Criteria andAuthor_idIn(List<String> values) {
            addCriterion("author_id in", values, "author_id");
            return (Criteria) this;
        }

        public Criteria andAuthor_idNotIn(List<String> values) {
            addCriterion("author_id not in", values, "author_id");
            return (Criteria) this;
        }

        public Criteria andAuthor_idBetween(String value1, String value2) {
            addCriterion("author_id between", value1, value2, "author_id");
            return (Criteria) this;
        }

        public Criteria andAuthor_idNotBetween(String value1, String value2) {
            addCriterion("author_id not between", value1, value2, "author_id");
            return (Criteria) this;
        }

        public Criteria andCategory_idIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategory_idIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategory_idEqualTo(Integer value) {
            addCriterion("category_id =", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategory_idNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategory_idGreaterThan(Integer value) {
            addCriterion("category_id >", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategory_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategory_idLessThan(Integer value) {
            addCriterion("category_id <", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategory_idLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategory_idIn(List<Integer> values) {
            addCriterion("category_id in", values, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategory_idNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategory_idBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "category_id");
            return (Criteria) this;
        }

        public Criteria andCategory_idNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "category_id");
            return (Criteria) this;
        }

        public Criteria andCover_urlIsNull() {
            addCriterion("cover_url is null");
            return (Criteria) this;
        }

        public Criteria andCover_urlIsNotNull() {
            addCriterion("cover_url is not null");
            return (Criteria) this;
        }

        public Criteria andCover_urlEqualTo(String value) {
            addCriterion("cover_url =", value, "cover_url");
            return (Criteria) this;
        }

        public Criteria andCover_urlNotEqualTo(String value) {
            addCriterion("cover_url <>", value, "cover_url");
            return (Criteria) this;
        }

        public Criteria andCover_urlGreaterThan(String value) {
            addCriterion("cover_url >", value, "cover_url");
            return (Criteria) this;
        }

        public Criteria andCover_urlGreaterThanOrEqualTo(String value) {
            addCriterion("cover_url >=", value, "cover_url");
            return (Criteria) this;
        }

        public Criteria andCover_urlLessThan(String value) {
            addCriterion("cover_url <", value, "cover_url");
            return (Criteria) this;
        }

        public Criteria andCover_urlLessThanOrEqualTo(String value) {
            addCriterion("cover_url <=", value, "cover_url");
            return (Criteria) this;
        }

        public Criteria andCover_urlLike(String value) {
            addCriterion("cover_url like", value, "cover_url");
            return (Criteria) this;
        }

        public Criteria andCover_urlNotLike(String value) {
            addCriterion("cover_url not like", value, "cover_url");
            return (Criteria) this;
        }

        public Criteria andCover_urlIn(List<String> values) {
            addCriterion("cover_url in", values, "cover_url");
            return (Criteria) this;
        }

        public Criteria andCover_urlNotIn(List<String> values) {
            addCriterion("cover_url not in", values, "cover_url");
            return (Criteria) this;
        }

        public Criteria andCover_urlBetween(String value1, String value2) {
            addCriterion("cover_url between", value1, value2, "cover_url");
            return (Criteria) this;
        }

        public Criteria andCover_urlNotBetween(String value1, String value2) {
            addCriterion("cover_url not between", value1, value2, "cover_url");
            return (Criteria) this;
        }

        public Criteria andIs_completeIsNull() {
            addCriterion("is_complete is null");
            return (Criteria) this;
        }

        public Criteria andIs_completeIsNotNull() {
            addCriterion("is_complete is not null");
            return (Criteria) this;
        }

        public Criteria andIs_completeEqualTo(Boolean value) {
            addCriterion("is_complete =", value, "is_complete");
            return (Criteria) this;
        }

        public Criteria andIs_completeNotEqualTo(Boolean value) {
            addCriterion("is_complete <>", value, "is_complete");
            return (Criteria) this;
        }

        public Criteria andIs_completeGreaterThan(Boolean value) {
            addCriterion("is_complete >", value, "is_complete");
            return (Criteria) this;
        }

        public Criteria andIs_completeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_complete >=", value, "is_complete");
            return (Criteria) this;
        }

        public Criteria andIs_completeLessThan(Boolean value) {
            addCriterion("is_complete <", value, "is_complete");
            return (Criteria) this;
        }

        public Criteria andIs_completeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_complete <=", value, "is_complete");
            return (Criteria) this;
        }

        public Criteria andIs_completeIn(List<Boolean> values) {
            addCriterion("is_complete in", values, "is_complete");
            return (Criteria) this;
        }

        public Criteria andIs_completeNotIn(List<Boolean> values) {
            addCriterion("is_complete not in", values, "is_complete");
            return (Criteria) this;
        }

        public Criteria andIs_completeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complete between", value1, value2, "is_complete");
            return (Criteria) this;
        }

        public Criteria andIs_completeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_complete not between", value1, value2, "is_complete");
            return (Criteria) this;
        }

        public Criteria andIs_recommendIsNull() {
            addCriterion("is_recommend is null");
            return (Criteria) this;
        }

        public Criteria andIs_recommendIsNotNull() {
            addCriterion("is_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andIs_recommendEqualTo(Boolean value) {
            addCriterion("is_recommend =", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendNotEqualTo(Boolean value) {
            addCriterion("is_recommend <>", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendGreaterThan(Boolean value) {
            addCriterion("is_recommend >", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_recommend >=", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendLessThan(Boolean value) {
            addCriterion("is_recommend <", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendLessThanOrEqualTo(Boolean value) {
            addCriterion("is_recommend <=", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendIn(List<Boolean> values) {
            addCriterion("is_recommend in", values, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendNotIn(List<Boolean> values) {
            addCriterion("is_recommend not in", values, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendBetween(Boolean value1, Boolean value2) {
            addCriterion("is_recommend between", value1, value2, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_recommend not between", value1, value2, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andViewsIsNull() {
            addCriterion("views is null");
            return (Criteria) this;
        }

        public Criteria andViewsIsNotNull() {
            addCriterion("views is not null");
            return (Criteria) this;
        }

        public Criteria andViewsEqualTo(Integer value) {
            addCriterion("views =", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotEqualTo(Integer value) {
            addCriterion("views <>", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThan(Integer value) {
            addCriterion("views >", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("views >=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThan(Integer value) {
            addCriterion("views <", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThanOrEqualTo(Integer value) {
            addCriterion("views <=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsIn(List<Integer> values) {
            addCriterion("views in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotIn(List<Integer> values) {
            addCriterion("views not in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsBetween(Integer value1, Integer value2) {
            addCriterion("views between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotBetween(Integer value1, Integer value2) {
            addCriterion("views not between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andTag_idIsNull() {
            addCriterion("tag_id is null");
            return (Criteria) this;
        }

        public Criteria andTag_idIsNotNull() {
            addCriterion("tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andTag_idEqualTo(Integer value) {
            addCriterion("tag_id =", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idNotEqualTo(Integer value) {
            addCriterion("tag_id <>", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idGreaterThan(Integer value) {
            addCriterion("tag_id >", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_id >=", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idLessThan(Integer value) {
            addCriterion("tag_id <", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idLessThanOrEqualTo(Integer value) {
            addCriterion("tag_id <=", value, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idIn(List<Integer> values) {
            addCriterion("tag_id in", values, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idNotIn(List<Integer> values) {
            addCriterion("tag_id not in", values, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idBetween(Integer value1, Integer value2) {
            addCriterion("tag_id between", value1, value2, "tag_id");
            return (Criteria) this;
        }

        public Criteria andTag_idNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_id not between", value1, value2, "tag_id");
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