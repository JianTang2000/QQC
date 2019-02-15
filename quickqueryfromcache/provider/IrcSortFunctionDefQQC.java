package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ztesoft.zsmart.bss.newbilling.invoicing.infrastructure.dao.inv.IIrcParamDAO;
import com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.extractfoundation.AbstractQQC;
import com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.model.IrcSortFunctionDefParam;

/**
 * < BEECH ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/2/11 <br>
 */
@Component("IrcSortFunctionDefQQC")
public class IrcSortFunctionDefQQC extends AbstractQQC<IrcSortFunctionDefParam> {

    public IrcSortFunctionDefParam get(Long functionId) {
        IrcSortFunctionDefParam ret;
        ret = qqcStructure.get(functionId);
        if (null == ret && !loaded) {
            reload();
        }
        ret = qqcStructure.get(functionId);
        return ret;
    }

    /**
     * < return 'M'or'I' ><br>
     * < HOW to choose? ><br>
     * < see explanation of QQCMap & QQCIndex ><br>
     */
    @Override
    protected String initialize() {
        return "M";
    }

    @Autowired
    IIrcParamDAO ircParamDAO;

    @Override
    protected void load() {
        List<IrcSortFunctionDefParam> params = ircParamDAO.selectAllIrcSortFunctionDef();
        for (IrcSortFunctionDefParam internal : params) {
            qqcStructure.put(internal.getFunctionId(), internal);
        }

    }
}
