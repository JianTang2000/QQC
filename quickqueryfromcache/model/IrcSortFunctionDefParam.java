package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.model;

/**
 * < ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/2/11 <br>
 */
public class IrcSortFunctionDefParam {

    // FUNCTION_ID NUMBER(9,0) not null,
    // FUNCTION_NAME VARCHAR2(60) not null,
    // PARAM_NUM NUMBER(3,0) not null,
    // BILLING_PARAM_DEF_ID NUMBER(9,0),
    // BILLING_PARAM_DEF_ID2 NUMBER(9,0),
    // USAGE_FLAG VARCHAR2(10) not null,
    // COMMENTS VARCHAR2(1000),

    private Long functionId;

    private String functionName;

    private Long paramNum;

    private Long billingParamDefId;

    private Long billingParamDefId2;

    private String usageFlag;

    private String comments;

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Long getParamNum() {
        return paramNum;
    }

    public void setParamNum(Long paramNum) {
        this.paramNum = paramNum;
    }

    public Long getBillingParamDefId() {
        return billingParamDefId;
    }

    public void setBillingParamDefId(Long billingParamDefId) {
        this.billingParamDefId = billingParamDefId;
    }

    public Long getBillingParamDefId2() {
        return billingParamDefId2;
    }

    public void setBillingParamDefId2(Long billingParamDefId2) {
        this.billingParamDefId2 = billingParamDefId2;
    }

    public String getUsageFlag() {
        return usageFlag;
    }

    public void setUsageFlag(String usageFlag) {
        this.usageFlag = usageFlag;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
