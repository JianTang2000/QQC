package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.model;

import java.util.Date;

/**
 * < ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/28 <br>
 */
public class IrcParam {

    // IRC_PARAM_ID NUMBER(9,0) not null,
    // IRC_PARAM_TYPE CHAR(1) not null,
    // IRC_PARAM_DEF_ID NUMBER(9,0),
    // VALUE_STRING VARCHAR2(255) not null,
    // FUNCTION_PARAM1 VARCHAR2(255),
    // FUNCTION_PARAM2 VARCHAR2(255),
    // STAFF_ID NUMBER(6,0),
    // CREATED_DATE DATE not null,
    // STATE CHAR(1) not null
    // constraint CKC_STATE_REF_VALUE check (STATE in ('A','X','H')),
    // STATE_DATE DATE not null,
    // COMMENTS VARCHAR2(255),
    // SP_ID NUMBER(6,0),

    private Long ircParamId;

    private String ircParamType;

    private Long ircParamDefId;

    private String valueString;

    private String functionParam1;

    private String functionParam2;

    private Long staffId;

    private Date createdDate;

    private String state;

    private Date stateDate;

    private String comments;

    private Long spId;

    public Long getIrcParamId() {
        return ircParamId;
    }

    public void setIrcParamId(Long ircParamId) {
        this.ircParamId = ircParamId;
    }

    public String getIrcParamType() {
        return ircParamType;
    }

    public void setIrcParamType(String ircParamType) {
        this.ircParamType = ircParamType;
    }

    public Long getIrcParamDefId() {
        return ircParamDefId;
    }

    public void setIrcParamDefId(Long ircParamDefId) {
        this.ircParamDefId = ircParamDefId;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public String getFunctionParam1() {
        return functionParam1;
    }

    public void setFunctionParam1(String functionParam1) {
        this.functionParam1 = functionParam1;
    }

    public String getFunctionParam2() {
        return functionParam2;
    }

    public void setFunctionParam2(String functionParam2) {
        this.functionParam2 = functionParam2;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }
}
