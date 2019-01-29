package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ztesoft.zsmart.bss.newbilling.invoicing.infrastructure.dao.inv.IIrcParamDAO;
import com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.extractfoundation.AbstractQQC;
import com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.model.IrcParam;

/**
 * < this is an EXP for QQCStructureMap ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/28 <br>
 */
@Component("IrcParamQQC")
public class IrcParamQQC extends AbstractQQC<IrcParam> {

    public IrcParam get(Long ircParamId) {
        IrcParam ret;
        ret = qqcStructure.get(ircParamId);
        if (null == ret && !loaded) {
            reload();
        }
        ret = qqcStructure.get(ircParamId);
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
        List<IrcParam> ircParams = ircParamDAO.selectAllEffIrcParam();
        for (IrcParam ircParam : ircParams) {
            qqcStructure.put(ircParam.getIrcParamId(), ircParam);
        }
    }
}
