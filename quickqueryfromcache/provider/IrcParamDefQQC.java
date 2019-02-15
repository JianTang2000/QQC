package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ztesoft.zsmart.bss.newbilling.invoicing.infrastructure.dao.inv.IIrcParamDAO;
import com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.extractfoundation.AbstractQQC;
import com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.model.IrcParamDef;

/**
 * < ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/31 <br>
 */
@Component("IrcParamDefQQC")
public class IrcParamDefQQC extends AbstractQQC<IrcParamDef> {

    public IrcParamDef get(Long ircParamDefId) {
        IrcParamDef ret;
        ret = qqcStructure.get(ircParamDefId);
        if (null == ret && !loaded) {
            reload();
        }
        ret = qqcStructure.get(ircParamDefId);
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
        List<IrcParamDef> ret = ircParamDAO.selectIrcParamDef();
        for (IrcParamDef ircParamDef : ret) {
            qqcStructure.put(ircParamDef.getIrcParamDefId(), ircParamDef);
        }
    }
}
