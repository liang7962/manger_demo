package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.List;

public class PaycoreJnlsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaycoreJnlsExample() {
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

        public Criteria andOrgNoIsNull() {
            addCriterion("ORG_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrgNoIsNotNull() {
            addCriterion("ORG_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNoEqualTo(String value) {
            addCriterion("ORG_NO =", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotEqualTo(String value) {
            addCriterion("ORG_NO <>", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoGreaterThan(String value) {
            addCriterion("ORG_NO >", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_NO >=", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLessThan(String value) {
            addCriterion("ORG_NO <", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLessThanOrEqualTo(String value) {
            addCriterion("ORG_NO <=", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLike(String value) {
            addCriterion("ORG_NO like", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotLike(String value) {
            addCriterion("ORG_NO not like", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoIn(List<String> values) {
            addCriterion("ORG_NO in", values, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotIn(List<String> values) {
            addCriterion("ORG_NO not in", values, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoBetween(String value1, String value2) {
            addCriterion("ORG_NO between", value1, value2, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotBetween(String value1, String value2) {
            addCriterion("ORG_NO not between", value1, value2, "orgNo");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNull() {
            addCriterion("PAY_NO is null");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNotNull() {
            addCriterion("PAY_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPayNoEqualTo(String value) {
            addCriterion("PAY_NO =", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotEqualTo(String value) {
            addCriterion("PAY_NO <>", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThan(String value) {
            addCriterion("PAY_NO >", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_NO >=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThan(String value) {
            addCriterion("PAY_NO <", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThanOrEqualTo(String value) {
            addCriterion("PAY_NO <=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLike(String value) {
            addCriterion("PAY_NO like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotLike(String value) {
            addCriterion("PAY_NO not like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoIn(List<String> values) {
            addCriterion("PAY_NO in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotIn(List<String> values) {
            addCriterion("PAY_NO not in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoBetween(String value1, String value2) {
            addCriterion("PAY_NO between", value1, value2, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotBetween(String value1, String value2) {
            addCriterion("PAY_NO not between", value1, value2, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNull() {
            addCriterion("PAY_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andPayMethodIsNotNull() {
            addCriterion("PAY_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andPayMethodEqualTo(String value) {
            addCriterion("PAY_METHOD =", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotEqualTo(String value) {
            addCriterion("PAY_METHOD <>", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThan(String value) {
            addCriterion("PAY_METHOD >", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_METHOD >=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThan(String value) {
            addCriterion("PAY_METHOD <", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLessThanOrEqualTo(String value) {
            addCriterion("PAY_METHOD <=", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodLike(String value) {
            addCriterion("PAY_METHOD like", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotLike(String value) {
            addCriterion("PAY_METHOD not like", value, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodIn(List<String> values) {
            addCriterion("PAY_METHOD in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotIn(List<String> values) {
            addCriterion("PAY_METHOD not in", values, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodBetween(String value1, String value2) {
            addCriterion("PAY_METHOD between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andPayMethodNotBetween(String value1, String value2) {
            addCriterion("PAY_METHOD not between", value1, value2, "payMethod");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNull() {
            addCriterion("MERCHANT_NO is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNotNull() {
            addCriterion("MERCHANT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoEqualTo(String value) {
            addCriterion("MERCHANT_NO =", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotEqualTo(String value) {
            addCriterion("MERCHANT_NO <>", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThan(String value) {
            addCriterion("MERCHANT_NO >", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO >=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThan(String value) {
            addCriterion("MERCHANT_NO <", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO <=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLike(String value) {
            addCriterion("MERCHANT_NO like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotLike(String value) {
            addCriterion("MERCHANT_NO not like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIn(List<String> values) {
            addCriterion("MERCHANT_NO in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotIn(List<String> values) {
            addCriterion("MERCHANT_NO not in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO not between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoIsNull() {
            addCriterion("TERMINAL_NO is null");
            return (Criteria) this;
        }

        public Criteria andTerminalNoIsNotNull() {
            addCriterion("TERMINAL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalNoEqualTo(String value) {
            addCriterion("TERMINAL_NO =", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotEqualTo(String value) {
            addCriterion("TERMINAL_NO <>", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoGreaterThan(String value) {
            addCriterion("TERMINAL_NO >", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoGreaterThanOrEqualTo(String value) {
            addCriterion("TERMINAL_NO >=", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoLessThan(String value) {
            addCriterion("TERMINAL_NO <", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoLessThanOrEqualTo(String value) {
            addCriterion("TERMINAL_NO <=", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoLike(String value) {
            addCriterion("TERMINAL_NO like", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotLike(String value) {
            addCriterion("TERMINAL_NO not like", value, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoIn(List<String> values) {
            addCriterion("TERMINAL_NO in", values, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotIn(List<String> values) {
            addCriterion("TERMINAL_NO not in", values, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoBetween(String value1, String value2) {
            addCriterion("TERMINAL_NO between", value1, value2, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andTerminalNoNotBetween(String value1, String value2) {
            addCriterion("TERMINAL_NO not between", value1, value2, "terminalNo");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("AMOUNT like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("AMOUNT not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("NOTIFY_URL is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("NOTIFY_URL is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("NOTIFY_URL =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("NOTIFY_URL <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("NOTIFY_URL >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("NOTIFY_URL >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("NOTIFY_URL <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("NOTIFY_URL <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("NOTIFY_URL like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("NOTIFY_URL not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("NOTIFY_URL in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("NOTIFY_URL not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("NOTIFY_URL between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("NOTIFY_URL not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andDescriptIsNull() {
            addCriterion("DESCRIPT is null");
            return (Criteria) this;
        }

        public Criteria andDescriptIsNotNull() {
            addCriterion("DESCRIPT is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptEqualTo(String value) {
            addCriterion("DESCRIPT =", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotEqualTo(String value) {
            addCriterion("DESCRIPT <>", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptGreaterThan(String value) {
            addCriterion("DESCRIPT >", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPT >=", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLessThan(String value) {
            addCriterion("DESCRIPT <", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPT <=", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLike(String value) {
            addCriterion("DESCRIPT like", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotLike(String value) {
            addCriterion("DESCRIPT not like", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptIn(List<String> values) {
            addCriterion("DESCRIPT in", values, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotIn(List<String> values) {
            addCriterion("DESCRIPT not in", values, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptBetween(String value1, String value2) {
            addCriterion("DESCRIPT between", value1, value2, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotBetween(String value1, String value2) {
            addCriterion("DESCRIPT not between", value1, value2, "descript");
            return (Criteria) this;
        }

        public Criteria andMidIsNull() {
            addCriterion("MID is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("MID is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(String value) {
            addCriterion("MID =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(String value) {
            addCriterion("MID <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(String value) {
            addCriterion("MID >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(String value) {
            addCriterion("MID >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(String value) {
            addCriterion("MID <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(String value) {
            addCriterion("MID <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLike(String value) {
            addCriterion("MID like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotLike(String value) {
            addCriterion("MID not like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<String> values) {
            addCriterion("MID in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<String> values) {
            addCriterion("MID not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(String value1, String value2) {
            addCriterion("MID between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(String value1, String value2) {
            addCriterion("MID not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andTmstampIsNull() {
            addCriterion("TMSTAMP is null");
            return (Criteria) this;
        }

        public Criteria andTmstampIsNotNull() {
            addCriterion("TMSTAMP is not null");
            return (Criteria) this;
        }

        public Criteria andTmstampEqualTo(String value) {
            addCriterion("TMSTAMP =", value, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andTmstampNotEqualTo(String value) {
            addCriterion("TMSTAMP <>", value, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andTmstampGreaterThan(String value) {
            addCriterion("TMSTAMP >", value, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andTmstampGreaterThanOrEqualTo(String value) {
            addCriterion("TMSTAMP >=", value, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andTmstampLessThan(String value) {
            addCriterion("TMSTAMP <", value, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andTmstampLessThanOrEqualTo(String value) {
            addCriterion("TMSTAMP <=", value, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andTmstampLike(String value) {
            addCriterion("TMSTAMP like", value, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andTmstampNotLike(String value) {
            addCriterion("TMSTAMP not like", value, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andTmstampIn(List<String> values) {
            addCriterion("TMSTAMP in", values, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andTmstampNotIn(List<String> values) {
            addCriterion("TMSTAMP not in", values, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andTmstampBetween(String value1, String value2) {
            addCriterion("TMSTAMP between", value1, value2, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andTmstampNotBetween(String value1, String value2) {
            addCriterion("TMSTAMP not between", value1, value2, "tmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampIsNull() {
            addCriterion("R_TMSTAMP is null");
            return (Criteria) this;
        }

        public Criteria andRTmstampIsNotNull() {
            addCriterion("R_TMSTAMP is not null");
            return (Criteria) this;
        }

        public Criteria andRTmstampEqualTo(String value) {
            addCriterion("R_TMSTAMP =", value, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampNotEqualTo(String value) {
            addCriterion("R_TMSTAMP <>", value, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampGreaterThan(String value) {
            addCriterion("R_TMSTAMP >", value, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampGreaterThanOrEqualTo(String value) {
            addCriterion("R_TMSTAMP >=", value, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampLessThan(String value) {
            addCriterion("R_TMSTAMP <", value, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampLessThanOrEqualTo(String value) {
            addCriterion("R_TMSTAMP <=", value, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampLike(String value) {
            addCriterion("R_TMSTAMP like", value, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampNotLike(String value) {
            addCriterion("R_TMSTAMP not like", value, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampIn(List<String> values) {
            addCriterion("R_TMSTAMP in", values, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampNotIn(List<String> values) {
            addCriterion("R_TMSTAMP not in", values, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampBetween(String value1, String value2) {
            addCriterion("R_TMSTAMP between", value1, value2, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andRTmstampNotBetween(String value1, String value2) {
            addCriterion("R_TMSTAMP not between", value1, value2, "rTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampIsNull() {
            addCriterion("N_TMSTAMP is null");
            return (Criteria) this;
        }

        public Criteria andNTmstampIsNotNull() {
            addCriterion("N_TMSTAMP is not null");
            return (Criteria) this;
        }

        public Criteria andNTmstampEqualTo(String value) {
            addCriterion("N_TMSTAMP =", value, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampNotEqualTo(String value) {
            addCriterion("N_TMSTAMP <>", value, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampGreaterThan(String value) {
            addCriterion("N_TMSTAMP >", value, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampGreaterThanOrEqualTo(String value) {
            addCriterion("N_TMSTAMP >=", value, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampLessThan(String value) {
            addCriterion("N_TMSTAMP <", value, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampLessThanOrEqualTo(String value) {
            addCriterion("N_TMSTAMP <=", value, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampLike(String value) {
            addCriterion("N_TMSTAMP like", value, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampNotLike(String value) {
            addCriterion("N_TMSTAMP not like", value, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampIn(List<String> values) {
            addCriterion("N_TMSTAMP in", values, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampNotIn(List<String> values) {
            addCriterion("N_TMSTAMP not in", values, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampBetween(String value1, String value2) {
            addCriterion("N_TMSTAMP between", value1, value2, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andNTmstampNotBetween(String value1, String value2) {
            addCriterion("N_TMSTAMP not between", value1, value2, "nTmstamp");
            return (Criteria) this;
        }

        public Criteria andInstituteIsNull() {
            addCriterion("INSTITUTE is null");
            return (Criteria) this;
        }

        public Criteria andInstituteIsNotNull() {
            addCriterion("INSTITUTE is not null");
            return (Criteria) this;
        }

        public Criteria andInstituteEqualTo(String value) {
            addCriterion("INSTITUTE =", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteNotEqualTo(String value) {
            addCriterion("INSTITUTE <>", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteGreaterThan(String value) {
            addCriterion("INSTITUTE >", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteGreaterThanOrEqualTo(String value) {
            addCriterion("INSTITUTE >=", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteLessThan(String value) {
            addCriterion("INSTITUTE <", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteLessThanOrEqualTo(String value) {
            addCriterion("INSTITUTE <=", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteLike(String value) {
            addCriterion("INSTITUTE like", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteNotLike(String value) {
            addCriterion("INSTITUTE not like", value, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteIn(List<String> values) {
            addCriterion("INSTITUTE in", values, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteNotIn(List<String> values) {
            addCriterion("INSTITUTE not in", values, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteBetween(String value1, String value2) {
            addCriterion("INSTITUTE between", value1, value2, "institute");
            return (Criteria) this;
        }

        public Criteria andInstituteNotBetween(String value1, String value2) {
            addCriterion("INSTITUTE not between", value1, value2, "institute");
            return (Criteria) this;
        }

        public Criteria andPjnlIsNull() {
            addCriterion("PJNL is null");
            return (Criteria) this;
        }

        public Criteria andPjnlIsNotNull() {
            addCriterion("PJNL is not null");
            return (Criteria) this;
        }

        public Criteria andPjnlEqualTo(String value) {
            addCriterion("PJNL =", value, "pjnl");
            return (Criteria) this;
        }

        public Criteria andPjnlNotEqualTo(String value) {
            addCriterion("PJNL <>", value, "pjnl");
            return (Criteria) this;
        }

        public Criteria andPjnlGreaterThan(String value) {
            addCriterion("PJNL >", value, "pjnl");
            return (Criteria) this;
        }

        public Criteria andPjnlGreaterThanOrEqualTo(String value) {
            addCriterion("PJNL >=", value, "pjnl");
            return (Criteria) this;
        }

        public Criteria andPjnlLessThan(String value) {
            addCriterion("PJNL <", value, "pjnl");
            return (Criteria) this;
        }

        public Criteria andPjnlLessThanOrEqualTo(String value) {
            addCriterion("PJNL <=", value, "pjnl");
            return (Criteria) this;
        }

        public Criteria andPjnlLike(String value) {
            addCriterion("PJNL like", value, "pjnl");
            return (Criteria) this;
        }

        public Criteria andPjnlNotLike(String value) {
            addCriterion("PJNL not like", value, "pjnl");
            return (Criteria) this;
        }

        public Criteria andPjnlIn(List<String> values) {
            addCriterion("PJNL in", values, "pjnl");
            return (Criteria) this;
        }

        public Criteria andPjnlNotIn(List<String> values) {
            addCriterion("PJNL not in", values, "pjnl");
            return (Criteria) this;
        }

        public Criteria andPjnlBetween(String value1, String value2) {
            addCriterion("PJNL between", value1, value2, "pjnl");
            return (Criteria) this;
        }

        public Criteria andPjnlNotBetween(String value1, String value2) {
            addCriterion("PJNL not between", value1, value2, "pjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlIsNull() {
            addCriterion("BJNL is null");
            return (Criteria) this;
        }

        public Criteria andBjnlIsNotNull() {
            addCriterion("BJNL is not null");
            return (Criteria) this;
        }

        public Criteria andBjnlEqualTo(String value) {
            addCriterion("BJNL =", value, "bjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlNotEqualTo(String value) {
            addCriterion("BJNL <>", value, "bjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlGreaterThan(String value) {
            addCriterion("BJNL >", value, "bjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlGreaterThanOrEqualTo(String value) {
            addCriterion("BJNL >=", value, "bjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlLessThan(String value) {
            addCriterion("BJNL <", value, "bjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlLessThanOrEqualTo(String value) {
            addCriterion("BJNL <=", value, "bjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlLike(String value) {
            addCriterion("BJNL like", value, "bjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlNotLike(String value) {
            addCriterion("BJNL not like", value, "bjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlIn(List<String> values) {
            addCriterion("BJNL in", values, "bjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlNotIn(List<String> values) {
            addCriterion("BJNL not in", values, "bjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlBetween(String value1, String value2) {
            addCriterion("BJNL between", value1, value2, "bjnl");
            return (Criteria) this;
        }

        public Criteria andBjnlNotBetween(String value1, String value2) {
            addCriterion("BJNL not between", value1, value2, "bjnl");
            return (Criteria) this;
        }

        public Criteria andReplyCodeIsNull() {
            addCriterion("REPLY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andReplyCodeIsNotNull() {
            addCriterion("REPLY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCodeEqualTo(String value) {
            addCriterion("REPLY_CODE =", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeNotEqualTo(String value) {
            addCriterion("REPLY_CODE <>", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeGreaterThan(String value) {
            addCriterion("REPLY_CODE >", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REPLY_CODE >=", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeLessThan(String value) {
            addCriterion("REPLY_CODE <", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeLessThanOrEqualTo(String value) {
            addCriterion("REPLY_CODE <=", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeLike(String value) {
            addCriterion("REPLY_CODE like", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeNotLike(String value) {
            addCriterion("REPLY_CODE not like", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeIn(List<String> values) {
            addCriterion("REPLY_CODE in", values, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeNotIn(List<String> values) {
            addCriterion("REPLY_CODE not in", values, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeBetween(String value1, String value2) {
            addCriterion("REPLY_CODE between", value1, value2, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeNotBetween(String value1, String value2) {
            addCriterion("REPLY_CODE not between", value1, value2, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyMessageIsNull() {
            addCriterion("REPLY_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andReplyMessageIsNotNull() {
            addCriterion("REPLY_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andReplyMessageEqualTo(String value) {
            addCriterion("REPLY_MESSAGE =", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotEqualTo(String value) {
            addCriterion("REPLY_MESSAGE <>", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageGreaterThan(String value) {
            addCriterion("REPLY_MESSAGE >", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageGreaterThanOrEqualTo(String value) {
            addCriterion("REPLY_MESSAGE >=", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageLessThan(String value) {
            addCriterion("REPLY_MESSAGE <", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageLessThanOrEqualTo(String value) {
            addCriterion("REPLY_MESSAGE <=", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageLike(String value) {
            addCriterion("REPLY_MESSAGE like", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotLike(String value) {
            addCriterion("REPLY_MESSAGE not like", value, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageIn(List<String> values) {
            addCriterion("REPLY_MESSAGE in", values, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotIn(List<String> values) {
            addCriterion("REPLY_MESSAGE not in", values, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageBetween(String value1, String value2) {
            addCriterion("REPLY_MESSAGE between", value1, value2, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andReplyMessageNotBetween(String value1, String value2) {
            addCriterion("REPLY_MESSAGE not between", value1, value2, "replyMessage");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNull() {
            addCriterion("TRADE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNotNull() {
            addCriterion("TRADE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusEqualTo(String value) {
            addCriterion("TRADE_STATUS =", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotEqualTo(String value) {
            addCriterion("TRADE_STATUS <>", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThan(String value) {
            addCriterion("TRADE_STATUS >", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("TRADE_STATUS >=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThan(String value) {
            addCriterion("TRADE_STATUS <", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("TRADE_STATUS <=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLike(String value) {
            addCriterion("TRADE_STATUS like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotLike(String value) {
            addCriterion("TRADE_STATUS not like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIn(List<String> values) {
            addCriterion("TRADE_STATUS in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotIn(List<String> values) {
            addCriterion("TRADE_STATUS not in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusBetween(String value1, String value2) {
            addCriterion("TRADE_STATUS between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotBetween(String value1, String value2) {
            addCriterion("TRADE_STATUS not between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andRemain1IsNull() {
            addCriterion("REMAIN1 is null");
            return (Criteria) this;
        }

        public Criteria andRemain1IsNotNull() {
            addCriterion("REMAIN1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemain1EqualTo(String value) {
            addCriterion("REMAIN1 =", value, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain1NotEqualTo(String value) {
            addCriterion("REMAIN1 <>", value, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain1GreaterThan(String value) {
            addCriterion("REMAIN1 >", value, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain1GreaterThanOrEqualTo(String value) {
            addCriterion("REMAIN1 >=", value, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain1LessThan(String value) {
            addCriterion("REMAIN1 <", value, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain1LessThanOrEqualTo(String value) {
            addCriterion("REMAIN1 <=", value, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain1Like(String value) {
            addCriterion("REMAIN1 like", value, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain1NotLike(String value) {
            addCriterion("REMAIN1 not like", value, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain1In(List<String> values) {
            addCriterion("REMAIN1 in", values, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain1NotIn(List<String> values) {
            addCriterion("REMAIN1 not in", values, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain1Between(String value1, String value2) {
            addCriterion("REMAIN1 between", value1, value2, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain1NotBetween(String value1, String value2) {
            addCriterion("REMAIN1 not between", value1, value2, "remain1");
            return (Criteria) this;
        }

        public Criteria andRemain2IsNull() {
            addCriterion("REMAIN2 is null");
            return (Criteria) this;
        }

        public Criteria andRemain2IsNotNull() {
            addCriterion("REMAIN2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemain2EqualTo(String value) {
            addCriterion("REMAIN2 =", value, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain2NotEqualTo(String value) {
            addCriterion("REMAIN2 <>", value, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain2GreaterThan(String value) {
            addCriterion("REMAIN2 >", value, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain2GreaterThanOrEqualTo(String value) {
            addCriterion("REMAIN2 >=", value, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain2LessThan(String value) {
            addCriterion("REMAIN2 <", value, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain2LessThanOrEqualTo(String value) {
            addCriterion("REMAIN2 <=", value, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain2Like(String value) {
            addCriterion("REMAIN2 like", value, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain2NotLike(String value) {
            addCriterion("REMAIN2 not like", value, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain2In(List<String> values) {
            addCriterion("REMAIN2 in", values, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain2NotIn(List<String> values) {
            addCriterion("REMAIN2 not in", values, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain2Between(String value1, String value2) {
            addCriterion("REMAIN2 between", value1, value2, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain2NotBetween(String value1, String value2) {
            addCriterion("REMAIN2 not between", value1, value2, "remain2");
            return (Criteria) this;
        }

        public Criteria andRemain3IsNull() {
            addCriterion("REMAIN3 is null");
            return (Criteria) this;
        }

        public Criteria andRemain3IsNotNull() {
            addCriterion("REMAIN3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemain3EqualTo(String value) {
            addCriterion("REMAIN3 =", value, "remain3");
            return (Criteria) this;
        }

        public Criteria andRemain3NotEqualTo(String value) {
            addCriterion("REMAIN3 <>", value, "remain3");
            return (Criteria) this;
        }

        public Criteria andRemain3GreaterThan(String value) {
            addCriterion("REMAIN3 >", value, "remain3");
            return (Criteria) this;
        }

        public Criteria andRemain3GreaterThanOrEqualTo(String value) {
            addCriterion("REMAIN3 >=", value, "remain3");
            return (Criteria) this;
        }

        public Criteria andRemain3LessThan(String value) {
            addCriterion("REMAIN3 <", value, "remain3");
            return (Criteria) this;
        }

        public Criteria andRemain3LessThanOrEqualTo(String value) {
            addCriterion("REMAIN3 <=", value, "remain3");
            return (Criteria) this;
        }

        public Criteria andRemain3Like(String value) {
            addCriterion("REMAIN3 like", value, "remain3");
            return (Criteria) this;
        }

        public Criteria andRemain3NotLike(String value) {
            addCriterion("REMAIN3 not like", value, "remain3");
            return (Criteria) this;
        }

        public Criteria andRemain3In(List<String> values) {
            addCriterion("REMAIN3 in", values, "remain3");
            return (Criteria) this;
        }

        public Criteria andRemain3NotIn(List<String> values) {
            addCriterion("REMAIN3 not in", values, "remain3");
            return (Criteria) this;
        }

        public Criteria andRemain3Between(String value1, String value2) {
            addCriterion("REMAIN3 between", value1, value2, "remain3");
            return (Criteria) this;
        }

        public Criteria andRemain3NotBetween(String value1, String value2) {
            addCriterion("REMAIN3 not between", value1, value2, "remain3");
            return (Criteria) this;
        }

        public Criteria andRequestDateIsNull() {
            addCriterion("REQUEST_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRequestDateIsNotNull() {
            addCriterion("REQUEST_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRequestDateEqualTo(String value) {
            addCriterion("REQUEST_DATE =", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateNotEqualTo(String value) {
            addCriterion("REQUEST_DATE <>", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateGreaterThan(String value) {
            addCriterion("REQUEST_DATE >", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_DATE >=", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateLessThan(String value) {
            addCriterion("REQUEST_DATE <", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_DATE <=", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateLike(String value) {
            addCriterion("REQUEST_DATE like", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateNotLike(String value) {
            addCriterion("REQUEST_DATE not like", value, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateIn(List<String> values) {
            addCriterion("REQUEST_DATE in", values, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateNotIn(List<String> values) {
            addCriterion("REQUEST_DATE not in", values, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateBetween(String value1, String value2) {
            addCriterion("REQUEST_DATE between", value1, value2, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestDateNotBetween(String value1, String value2) {
            addCriterion("REQUEST_DATE not between", value1, value2, "requestDate");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNull() {
            addCriterion("REQUEST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNotNull() {
            addCriterion("REQUEST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeEqualTo(String value) {
            addCriterion("REQUEST_TIME =", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotEqualTo(String value) {
            addCriterion("REQUEST_TIME <>", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThan(String value) {
            addCriterion("REQUEST_TIME >", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_TIME >=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThan(String value) {
            addCriterion("REQUEST_TIME <", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_TIME <=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLike(String value) {
            addCriterion("REQUEST_TIME like", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotLike(String value) {
            addCriterion("REQUEST_TIME not like", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIn(List<String> values) {
            addCriterion("REQUEST_TIME in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotIn(List<String> values) {
            addCriterion("REQUEST_TIME not in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeBetween(String value1, String value2) {
            addCriterion("REQUEST_TIME between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotBetween(String value1, String value2) {
            addCriterion("REQUEST_TIME not between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andResponseDateIsNull() {
            addCriterion("RESPONSE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andResponseDateIsNotNull() {
            addCriterion("RESPONSE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andResponseDateEqualTo(String value) {
            addCriterion("RESPONSE_DATE =", value, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseDateNotEqualTo(String value) {
            addCriterion("RESPONSE_DATE <>", value, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseDateGreaterThan(String value) {
            addCriterion("RESPONSE_DATE >", value, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseDateGreaterThanOrEqualTo(String value) {
            addCriterion("RESPONSE_DATE >=", value, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseDateLessThan(String value) {
            addCriterion("RESPONSE_DATE <", value, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseDateLessThanOrEqualTo(String value) {
            addCriterion("RESPONSE_DATE <=", value, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseDateLike(String value) {
            addCriterion("RESPONSE_DATE like", value, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseDateNotLike(String value) {
            addCriterion("RESPONSE_DATE not like", value, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseDateIn(List<String> values) {
            addCriterion("RESPONSE_DATE in", values, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseDateNotIn(List<String> values) {
            addCriterion("RESPONSE_DATE not in", values, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseDateBetween(String value1, String value2) {
            addCriterion("RESPONSE_DATE between", value1, value2, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseDateNotBetween(String value1, String value2) {
            addCriterion("RESPONSE_DATE not between", value1, value2, "responseDate");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIsNull() {
            addCriterion("RESPONSE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIsNotNull() {
            addCriterion("RESPONSE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeEqualTo(String value) {
            addCriterion("RESPONSE_TIME =", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotEqualTo(String value) {
            addCriterion("RESPONSE_TIME <>", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThan(String value) {
            addCriterion("RESPONSE_TIME >", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("RESPONSE_TIME >=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThan(String value) {
            addCriterion("RESPONSE_TIME <", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThanOrEqualTo(String value) {
            addCriterion("RESPONSE_TIME <=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLike(String value) {
            addCriterion("RESPONSE_TIME like", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotLike(String value) {
            addCriterion("RESPONSE_TIME not like", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIn(List<String> values) {
            addCriterion("RESPONSE_TIME in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotIn(List<String> values) {
            addCriterion("RESPONSE_TIME not in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeBetween(String value1, String value2) {
            addCriterion("RESPONSE_TIME between", value1, value2, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotBetween(String value1, String value2) {
            addCriterion("RESPONSE_TIME not between", value1, value2, "responseTime");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("FLAG like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("FLAG not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("CHANNEL =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("CHANNEL <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("CHANNEL >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNEL >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("CHANNEL <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("CHANNEL <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("CHANNEL like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("CHANNEL not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("CHANNEL in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("CHANNEL not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("CHANNEL between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("CHANNEL not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlIsNull() {
            addCriterion("ORIG_PJNL is null");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlIsNotNull() {
            addCriterion("ORIG_PJNL is not null");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlEqualTo(String value) {
            addCriterion("ORIG_PJNL =", value, "origPjnl");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlNotEqualTo(String value) {
            addCriterion("ORIG_PJNL <>", value, "origPjnl");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlGreaterThan(String value) {
            addCriterion("ORIG_PJNL >", value, "origPjnl");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlGreaterThanOrEqualTo(String value) {
            addCriterion("ORIG_PJNL >=", value, "origPjnl");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlLessThan(String value) {
            addCriterion("ORIG_PJNL <", value, "origPjnl");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlLessThanOrEqualTo(String value) {
            addCriterion("ORIG_PJNL <=", value, "origPjnl");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlLike(String value) {
            addCriterion("ORIG_PJNL like", value, "origPjnl");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlNotLike(String value) {
            addCriterion("ORIG_PJNL not like", value, "origPjnl");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlIn(List<String> values) {
            addCriterion("ORIG_PJNL in", values, "origPjnl");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlNotIn(List<String> values) {
            addCriterion("ORIG_PJNL not in", values, "origPjnl");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlBetween(String value1, String value2) {
            addCriterion("ORIG_PJNL between", value1, value2, "origPjnl");
            return (Criteria) this;
        }

        public Criteria andOrigPjnlNotBetween(String value1, String value2) {
            addCriterion("ORIG_PJNL not between", value1, value2, "origPjnl");
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