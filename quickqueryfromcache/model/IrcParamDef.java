package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.model;

/**
 * < ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/31 <br>
 */
public class IrcParamDef {

    // IRC_PARAM_DEF_ID NUMBER(9,0) not null,
    // IRC_PARAM_DEF_VALUE_TYPE CHAR(1) not null,
    // IRC_PARAM_DEF_VALUE_ID VARCHAR2(120),
    // IRC_PARAM_DEF_NAME VARCHAR2(120),
    // IRC_PARAM_DEF_DESC VARCHAR2(1000),

    private Long ircParamDefId;

    private String ircParamDefValueType;

    private String ircParamDefValueId;

    private String ircParamDefName;

    private String ircParamDefDesc;

    public Long getIrcParamDefId() {
        return ircParamDefId;
    }

    public void setIrcParamDefId(Long ircParamDefId) {
        this.ircParamDefId = ircParamDefId;
    }

    public String getIrcParamDefValueType() {
        return ircParamDefValueType;
    }

    public void setIrcParamDefValueType(String ircParamDefValueType) {
        this.ircParamDefValueType = ircParamDefValueType;
    }

    public String getIrcParamDefValueId() {
        return ircParamDefValueId;
    }

    public void setIrcParamDefValueId(String ircParamDefValueId) {
        this.ircParamDefValueId = ircParamDefValueId;
    }

    public String getIrcParamDefName() {
        return ircParamDefName;
    }

    public void setIrcParamDefName(String ircParamDefName) {
        this.ircParamDefName = ircParamDefName;
    }

    public String getIrcParamDefDesc() {
        return ircParamDefDesc;
    }

    public void setIrcParamDefDesc(String ircParamDefDesc) {
        this.ircParamDefDesc = ircParamDefDesc;
    }
}
