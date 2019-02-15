package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.model;

import com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.annotation.IndexBlockKey;

/**
 * < ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/28 <br>
 */
public class BillRemarkCondGrpParam {

    // BILL_REMARK_ID NUMBER(9,0) not null,
    // GRP_ID NUMBER(3,0) not null,
    // SEQ_NO NUMBER(3,0) not null,
    // L_IRC_PARAM_ID NUMBER(9,0) not null,
    // SORT_OPERATOR CHAR(1) not null,
    // R_IRC_PARAM_ID NUMBER(9,0) not null,
    // SP_ID NUMBER(6,0)

    @IndexBlockKey
    private Long billRemarkId;

    private Long grpId;

    private Long seqId;

    private Long lIrcParamId;

    private String sortOperator;

    private Long rIrcParamId;

    private Long spId;

    public Long getBillRemarkId() {
        return billRemarkId;
    }

    public void setBillRemarkId(Long billRemarkId) {
        this.billRemarkId = billRemarkId;
    }

    public Long getGrpId() {
        return grpId;
    }

    public void setGrpId(Long grpId) {
        this.grpId = grpId;
    }

    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    public Long getlIrcParamId() {
        return lIrcParamId;
    }

    public void setlIrcParamId(Long lIrcParamId) {
        this.lIrcParamId = lIrcParamId;
    }

    public String getSortOperator() {
        return sortOperator;
    }

    public void setSortOperator(String sortOperator) {
        this.sortOperator = sortOperator;
    }

    public Long getSpId() {
        return spId;
    }

    public void setSpId(Long spId) {
        this.spId = spId;
    }

    public Long getrIrcParamId() {
        return rIrcParamId;
    }

    public void setrIrcParamId(Long rIrcParamId) {
        this.rIrcParamId = rIrcParamId;
    }
}
