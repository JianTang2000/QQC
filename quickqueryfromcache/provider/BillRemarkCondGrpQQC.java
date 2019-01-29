package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ztesoft.zsmart.bss.newbilling.invoicing.infrastructure.dao.inv.IIrcParamDAO;
import com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.extractfoundation.AbstractQQC;
import com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.model.BillRemarkCondGrpParam;

/**
 * < this is an EXP for QQCStructureIndex ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/28 <br>
 */
@Component("BillRemarkCondGrpQQC")
public class BillRemarkCondGrpQQC extends AbstractQQC<BillRemarkCondGrpParam> {

    public List<BillRemarkCondGrpParam> get(Long billRemarkId) {
        List<BillRemarkCondGrpParam> ret;
        ret = qqcStructure.get(billRemarkId);
        if (null == ret && !loaded) {
            reload();
        }
        ret = qqcStructure.get(billRemarkId);
        return ret;
    }

    /**
     * < return 'M'or'I' ><br>
     * < HOW to choose? ><br>
     * < see explanation of QQCMap & QQCIndex ><br>
     */
    @Override
    protected String initialize() {
        return "I";
    }

    @Autowired
    IIrcParamDAO ircParamDAO;

    @Override
    protected void load() {
        List<BillRemarkCondGrpParam> ret = ircParamDAO.selectAllBillRemarkCondGrp();
        put(ret);
    }
}
