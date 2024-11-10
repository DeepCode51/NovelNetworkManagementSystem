package com.ykjzone.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andLast_loginIsNull() {
            addCriterion("last_login is null");
            return (Criteria) this;
        }

        public Criteria andLast_loginIsNotNull() {
            addCriterion("last_login is not null");
            return (Criteria) this;
        }

        public Criteria andLast_loginEqualTo(Date value) {
            addCriterion("last_login =", value, "last_login");
            return (Criteria) this;
        }

        public Criteria andLast_loginNotEqualTo(Date value) {
            addCriterion("last_login <>", value, "last_login");
            return (Criteria) this;
        }

        public Criteria andLast_loginGreaterThan(Date value) {
            addCriterion("last_login >", value, "last_login");
            return (Criteria) this;
        }

        public Criteria andLast_loginGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login >=", value, "last_login");
            return (Criteria) this;
        }

        public Criteria andLast_loginLessThan(Date value) {
            addCriterion("last_login <", value, "last_login");
            return (Criteria) this;
        }

        public Criteria andLast_loginLessThanOrEqualTo(Date value) {
            addCriterion("last_login <=", value, "last_login");
            return (Criteria) this;
        }

        public Criteria andLast_loginIn(List<Date> values) {
            addCriterion("last_login in", values, "last_login");
            return (Criteria) this;
        }

        public Criteria andLast_loginNotIn(List<Date> values) {
            addCriterion("last_login not in", values, "last_login");
            return (Criteria) this;
        }

        public Criteria andLast_loginBetween(Date value1, Date value2) {
            addCriterion("last_login between", value1, value2, "last_login");
            return (Criteria) this;
        }

        public Criteria andLast_loginNotBetween(Date value1, Date value2) {
            addCriterion("last_login not between", value1, value2, "last_login");
            return (Criteria) this;
        }

        public Criteria andIs_superuserIsNull() {
            addCriterion("is_superuser is null");
            return (Criteria) this;
        }

        public Criteria andIs_superuserIsNotNull() {
            addCriterion("is_superuser is not null");
            return (Criteria) this;
        }

        public Criteria andIs_superuserEqualTo(Boolean value) {
            addCriterion("is_superuser =", value, "is_superuser");
            return (Criteria) this;
        }

        public Criteria andIs_superuserNotEqualTo(Boolean value) {
            addCriterion("is_superuser <>", value, "is_superuser");
            return (Criteria) this;
        }

        public Criteria andIs_superuserGreaterThan(Boolean value) {
            addCriterion("is_superuser >", value, "is_superuser");
            return (Criteria) this;
        }

        public Criteria andIs_superuserGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_superuser >=", value, "is_superuser");
            return (Criteria) this;
        }

        public Criteria andIs_superuserLessThan(Boolean value) {
            addCriterion("is_superuser <", value, "is_superuser");
            return (Criteria) this;
        }

        public Criteria andIs_superuserLessThanOrEqualTo(Boolean value) {
            addCriterion("is_superuser <=", value, "is_superuser");
            return (Criteria) this;
        }

        public Criteria andIs_superuserIn(List<Boolean> values) {
            addCriterion("is_superuser in", values, "is_superuser");
            return (Criteria) this;
        }

        public Criteria andIs_superuserNotIn(List<Boolean> values) {
            addCriterion("is_superuser not in", values, "is_superuser");
            return (Criteria) this;
        }

        public Criteria andIs_superuserBetween(Boolean value1, Boolean value2) {
            addCriterion("is_superuser between", value1, value2, "is_superuser");
            return (Criteria) this;
        }

        public Criteria andIs_superuserNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_superuser not between", value1, value2, "is_superuser");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andIs_activeIsNull() {
            addCriterion("is_active is null");
            return (Criteria) this;
        }

        public Criteria andIs_activeIsNotNull() {
            addCriterion("is_active is not null");
            return (Criteria) this;
        }

        public Criteria andIs_activeEqualTo(Boolean value) {
            addCriterion("is_active =", value, "is_active");
            return (Criteria) this;
        }

        public Criteria andIs_activeNotEqualTo(Boolean value) {
            addCriterion("is_active <>", value, "is_active");
            return (Criteria) this;
        }

        public Criteria andIs_activeGreaterThan(Boolean value) {
            addCriterion("is_active >", value, "is_active");
            return (Criteria) this;
        }

        public Criteria andIs_activeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_active >=", value, "is_active");
            return (Criteria) this;
        }

        public Criteria andIs_activeLessThan(Boolean value) {
            addCriterion("is_active <", value, "is_active");
            return (Criteria) this;
        }

        public Criteria andIs_activeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_active <=", value, "is_active");
            return (Criteria) this;
        }

        public Criteria andIs_activeIn(List<Boolean> values) {
            addCriterion("is_active in", values, "is_active");
            return (Criteria) this;
        }

        public Criteria andIs_activeNotIn(List<Boolean> values) {
            addCriterion("is_active not in", values, "is_active");
            return (Criteria) this;
        }

        public Criteria andIs_activeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_active between", value1, value2, "is_active");
            return (Criteria) this;
        }

        public Criteria andIs_activeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_active not between", value1, value2, "is_active");
            return (Criteria) this;
        }

        public Criteria andIs_authorIsNull() {
            addCriterion("is_author is null");
            return (Criteria) this;
        }

        public Criteria andIs_authorIsNotNull() {
            addCriterion("is_author is not null");
            return (Criteria) this;
        }

        public Criteria andIs_authorEqualTo(Boolean value) {
            addCriterion("is_author =", value, "is_author");
            return (Criteria) this;
        }

        public Criteria andIs_authorNotEqualTo(Boolean value) {
            addCriterion("is_author <>", value, "is_author");
            return (Criteria) this;
        }

        public Criteria andIs_authorGreaterThan(Boolean value) {
            addCriterion("is_author >", value, "is_author");
            return (Criteria) this;
        }

        public Criteria andIs_authorGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_author >=", value, "is_author");
            return (Criteria) this;
        }

        public Criteria andIs_authorLessThan(Boolean value) {
            addCriterion("is_author <", value, "is_author");
            return (Criteria) this;
        }

        public Criteria andIs_authorLessThanOrEqualTo(Boolean value) {
            addCriterion("is_author <=", value, "is_author");
            return (Criteria) this;
        }

        public Criteria andIs_authorIn(List<Boolean> values) {
            addCriterion("is_author in", values, "is_author");
            return (Criteria) this;
        }

        public Criteria andIs_authorNotIn(List<Boolean> values) {
            addCriterion("is_author not in", values, "is_author");
            return (Criteria) this;
        }

        public Criteria andIs_authorBetween(Boolean value1, Boolean value2) {
            addCriterion("is_author between", value1, value2, "is_author");
            return (Criteria) this;
        }

        public Criteria andIs_authorNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_author not between", value1, value2, "is_author");
            return (Criteria) this;
        }

        public Criteria andIs_staffIsNull() {
            addCriterion("is_staff is null");
            return (Criteria) this;
        }

        public Criteria andIs_staffIsNotNull() {
            addCriterion("is_staff is not null");
            return (Criteria) this;
        }

        public Criteria andIs_staffEqualTo(Boolean value) {
            addCriterion("is_staff =", value, "is_staff");
            return (Criteria) this;
        }

        public Criteria andIs_staffNotEqualTo(Boolean value) {
            addCriterion("is_staff <>", value, "is_staff");
            return (Criteria) this;
        }

        public Criteria andIs_staffGreaterThan(Boolean value) {
            addCriterion("is_staff >", value, "is_staff");
            return (Criteria) this;
        }

        public Criteria andIs_staffGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_staff >=", value, "is_staff");
            return (Criteria) this;
        }

        public Criteria andIs_staffLessThan(Boolean value) {
            addCriterion("is_staff <", value, "is_staff");
            return (Criteria) this;
        }

        public Criteria andIs_staffLessThanOrEqualTo(Boolean value) {
            addCriterion("is_staff <=", value, "is_staff");
            return (Criteria) this;
        }

        public Criteria andIs_staffIn(List<Boolean> values) {
            addCriterion("is_staff in", values, "is_staff");
            return (Criteria) this;
        }

        public Criteria andIs_staffNotIn(List<Boolean> values) {
            addCriterion("is_staff not in", values, "is_staff");
            return (Criteria) this;
        }

        public Criteria andIs_staffBetween(Boolean value1, Boolean value2) {
            addCriterion("is_staff between", value1, value2, "is_staff");
            return (Criteria) this;
        }

        public Criteria andIs_staffNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_staff not between", value1, value2, "is_staff");
            return (Criteria) this;
        }

        public Criteria andDate_joinedIsNull() {
            addCriterion("date_joined is null");
            return (Criteria) this;
        }

        public Criteria andDate_joinedIsNotNull() {
            addCriterion("date_joined is not null");
            return (Criteria) this;
        }

        public Criteria andDate_joinedEqualTo(Date value) {
            addCriterionForJDBCDate("date_joined =", value, "date_joined");
            return (Criteria) this;
        }

        public Criteria andDate_joinedNotEqualTo(Date value) {
            addCriterionForJDBCDate("date_joined <>", value, "date_joined");
            return (Criteria) this;
        }

        public Criteria andDate_joinedGreaterThan(Date value) {
            addCriterionForJDBCDate("date_joined >", value, "date_joined");
            return (Criteria) this;
        }

        public Criteria andDate_joinedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date_joined >=", value, "date_joined");
            return (Criteria) this;
        }

        public Criteria andDate_joinedLessThan(Date value) {
            addCriterionForJDBCDate("date_joined <", value, "date_joined");
            return (Criteria) this;
        }

        public Criteria andDate_joinedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date_joined <=", value, "date_joined");
            return (Criteria) this;
        }

        public Criteria andDate_joinedIn(List<Date> values) {
            addCriterionForJDBCDate("date_joined in", values, "date_joined");
            return (Criteria) this;
        }

        public Criteria andDate_joinedNotIn(List<Date> values) {
            addCriterionForJDBCDate("date_joined not in", values, "date_joined");
            return (Criteria) this;
        }

        public Criteria andDate_joinedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date_joined between", value1, value2, "date_joined");
            return (Criteria) this;
        }

        public Criteria andDate_joinedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date_joined not between", value1, value2, "date_joined");
            return (Criteria) this;
        }

        public Criteria andPen_nameIsNull() {
            addCriterion("pen_name is null");
            return (Criteria) this;
        }

        public Criteria andPen_nameIsNotNull() {
            addCriterion("pen_name is not null");
            return (Criteria) this;
        }

        public Criteria andPen_nameEqualTo(String value) {
            addCriterion("pen_name =", value, "pen_name");
            return (Criteria) this;
        }

        public Criteria andPen_nameNotEqualTo(String value) {
            addCriterion("pen_name <>", value, "pen_name");
            return (Criteria) this;
        }

        public Criteria andPen_nameGreaterThan(String value) {
            addCriterion("pen_name >", value, "pen_name");
            return (Criteria) this;
        }

        public Criteria andPen_nameGreaterThanOrEqualTo(String value) {
            addCriterion("pen_name >=", value, "pen_name");
            return (Criteria) this;
        }

        public Criteria andPen_nameLessThan(String value) {
            addCriterion("pen_name <", value, "pen_name");
            return (Criteria) this;
        }

        public Criteria andPen_nameLessThanOrEqualTo(String value) {
            addCriterion("pen_name <=", value, "pen_name");
            return (Criteria) this;
        }

        public Criteria andPen_nameLike(String value) {
            addCriterion("pen_name like", value, "pen_name");
            return (Criteria) this;
        }

        public Criteria andPen_nameNotLike(String value) {
            addCriterion("pen_name not like", value, "pen_name");
            return (Criteria) this;
        }

        public Criteria andPen_nameIn(List<String> values) {
            addCriterion("pen_name in", values, "pen_name");
            return (Criteria) this;
        }

        public Criteria andPen_nameNotIn(List<String> values) {
            addCriterion("pen_name not in", values, "pen_name");
            return (Criteria) this;
        }

        public Criteria andPen_nameBetween(String value1, String value2) {
            addCriterion("pen_name between", value1, value2, "pen_name");
            return (Criteria) this;
        }

        public Criteria andPen_nameNotBetween(String value1, String value2) {
            addCriterion("pen_name not between", value1, value2, "pen_name");
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