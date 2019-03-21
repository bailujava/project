package tv.buka.pojo;

import java.util.ArrayList;
import java.util.List;

public class SsOrganizationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SsOrganizationExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumIsNull() {
            addCriterion("user_phone_num is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumIsNotNull() {
            addCriterion("user_phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumEqualTo(String value) {
            addCriterion("user_phone_num =", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumNotEqualTo(String value) {
            addCriterion("user_phone_num <>", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumGreaterThan(String value) {
            addCriterion("user_phone_num >", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone_num >=", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumLessThan(String value) {
            addCriterion("user_phone_num <", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("user_phone_num <=", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumLike(String value) {
            addCriterion("user_phone_num like", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumNotLike(String value) {
            addCriterion("user_phone_num not like", value, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumIn(List<String> values) {
            addCriterion("user_phone_num in", values, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumNotIn(List<String> values) {
            addCriterion("user_phone_num not in", values, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumBetween(String value1, String value2) {
            addCriterion("user_phone_num between", value1, value2, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNumNotBetween(String value1, String value2) {
            addCriterion("user_phone_num not between", value1, value2, "userPhoneNum");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNull() {
            addCriterion("user_nickname is null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNotNull() {
            addCriterion("user_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameEqualTo(String value) {
            addCriterion("user_nickname =", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotEqualTo(String value) {
            addCriterion("user_nickname <>", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThan(String value) {
            addCriterion("user_nickname >", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nickname >=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThan(String value) {
            addCriterion("user_nickname <", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThanOrEqualTo(String value) {
            addCriterion("user_nickname <=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLike(String value) {
            addCriterion("user_nickname like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotLike(String value) {
            addCriterion("user_nickname not like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIn(List<String> values) {
            addCriterion("user_nickname in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotIn(List<String> values) {
            addCriterion("user_nickname not in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameBetween(String value1, String value2) {
            addCriterion("user_nickname between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotBetween(String value1, String value2) {
            addCriterion("user_nickname not between", value1, value2, "userNickname");
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

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStartTermIsNull() {
            addCriterion("start_term is null");
            return (Criteria) this;
        }

        public Criteria andStartTermIsNotNull() {
            addCriterion("start_term is not null");
            return (Criteria) this;
        }

        public Criteria andStartTermEqualTo(Long value) {
            addCriterion("start_term =", value, "startTerm");
            return (Criteria) this;
        }

        public Criteria andStartTermNotEqualTo(Long value) {
            addCriterion("start_term <>", value, "startTerm");
            return (Criteria) this;
        }

        public Criteria andStartTermGreaterThan(Long value) {
            addCriterion("start_term >", value, "startTerm");
            return (Criteria) this;
        }

        public Criteria andStartTermGreaterThanOrEqualTo(Long value) {
            addCriterion("start_term >=", value, "startTerm");
            return (Criteria) this;
        }

        public Criteria andStartTermLessThan(Long value) {
            addCriterion("start_term <", value, "startTerm");
            return (Criteria) this;
        }

        public Criteria andStartTermLessThanOrEqualTo(Long value) {
            addCriterion("start_term <=", value, "startTerm");
            return (Criteria) this;
        }

        public Criteria andStartTermIn(List<Long> values) {
            addCriterion("start_term in", values, "startTerm");
            return (Criteria) this;
        }

        public Criteria andStartTermNotIn(List<Long> values) {
            addCriterion("start_term not in", values, "startTerm");
            return (Criteria) this;
        }

        public Criteria andStartTermBetween(Long value1, Long value2) {
            addCriterion("start_term between", value1, value2, "startTerm");
            return (Criteria) this;
        }

        public Criteria andStartTermNotBetween(Long value1, Long value2) {
            addCriterion("start_term not between", value1, value2, "startTerm");
            return (Criteria) this;
        }

        public Criteria andEndTermIsNull() {
            addCriterion("end_term is null");
            return (Criteria) this;
        }

        public Criteria andEndTermIsNotNull() {
            addCriterion("end_term is not null");
            return (Criteria) this;
        }

        public Criteria andEndTermEqualTo(Long value) {
            addCriterion("end_term =", value, "endTerm");
            return (Criteria) this;
        }

        public Criteria andEndTermNotEqualTo(Long value) {
            addCriterion("end_term <>", value, "endTerm");
            return (Criteria) this;
        }

        public Criteria andEndTermGreaterThan(Long value) {
            addCriterion("end_term >", value, "endTerm");
            return (Criteria) this;
        }

        public Criteria andEndTermGreaterThanOrEqualTo(Long value) {
            addCriterion("end_term >=", value, "endTerm");
            return (Criteria) this;
        }

        public Criteria andEndTermLessThan(Long value) {
            addCriterion("end_term <", value, "endTerm");
            return (Criteria) this;
        }

        public Criteria andEndTermLessThanOrEqualTo(Long value) {
            addCriterion("end_term <=", value, "endTerm");
            return (Criteria) this;
        }

        public Criteria andEndTermIn(List<Long> values) {
            addCriterion("end_term in", values, "endTerm");
            return (Criteria) this;
        }

        public Criteria andEndTermNotIn(List<Long> values) {
            addCriterion("end_term not in", values, "endTerm");
            return (Criteria) this;
        }

        public Criteria andEndTermBetween(Long value1, Long value2) {
            addCriterion("end_term between", value1, value2, "endTerm");
            return (Criteria) this;
        }

        public Criteria andEndTermNotBetween(Long value1, Long value2) {
            addCriterion("end_term not between", value1, value2, "endTerm");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andDtPermissionIsNull() {
            addCriterion("dt_permission is null");
            return (Criteria) this;
        }

        public Criteria andDtPermissionIsNotNull() {
            addCriterion("dt_permission is not null");
            return (Criteria) this;
        }

        public Criteria andDtPermissionEqualTo(Byte value) {
            addCriterion("dt_permission =", value, "dtPermission");
            return (Criteria) this;
        }

        public Criteria andDtPermissionNotEqualTo(Byte value) {
            addCriterion("dt_permission <>", value, "dtPermission");
            return (Criteria) this;
        }

        public Criteria andDtPermissionGreaterThan(Byte value) {
            addCriterion("dt_permission >", value, "dtPermission");
            return (Criteria) this;
        }

        public Criteria andDtPermissionGreaterThanOrEqualTo(Byte value) {
            addCriterion("dt_permission >=", value, "dtPermission");
            return (Criteria) this;
        }

        public Criteria andDtPermissionLessThan(Byte value) {
            addCriterion("dt_permission <", value, "dtPermission");
            return (Criteria) this;
        }

        public Criteria andDtPermissionLessThanOrEqualTo(Byte value) {
            addCriterion("dt_permission <=", value, "dtPermission");
            return (Criteria) this;
        }

        public Criteria andDtPermissionIn(List<Byte> values) {
            addCriterion("dt_permission in", values, "dtPermission");
            return (Criteria) this;
        }

        public Criteria andDtPermissionNotIn(List<Byte> values) {
            addCriterion("dt_permission not in", values, "dtPermission");
            return (Criteria) this;
        }

        public Criteria andDtPermissionBetween(Byte value1, Byte value2) {
            addCriterion("dt_permission between", value1, value2, "dtPermission");
            return (Criteria) this;
        }

        public Criteria andDtPermissionNotBetween(Byte value1, Byte value2) {
            addCriterion("dt_permission not between", value1, value2, "dtPermission");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Byte value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Byte value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Byte value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Byte value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Byte value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Byte value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Byte> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Byte> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Byte value1, Byte value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Byte value1, Byte value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
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