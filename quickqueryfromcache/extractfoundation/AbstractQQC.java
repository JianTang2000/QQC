package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.extractfoundation;

import java.util.ArrayList;
import java.util.List;

import com.ztesoft.zsmart.bss.newbilling.base.v8.utils.ValidateUtil;
import com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.annotation.IndexBlockKeyExplain;

/**
 * < WHY called QQC? ><br>
 * < Q-Q-f-C Quick Query from Cache ><br>
 * <br>
 * < Merit: ><br>
 * < 1 data cached in the cache ><br>
 * < 2 searching from cache quickly ><br>
 * < 3 there is always a simple cache structure which is easy to be check out by user ><br>
 * < 4 the UNIQUE ID of the data(such as the PK of an DB Table) tobe cached is NOT necessarily ><br>
 * < 5 fuck off these stupid key level ><br>
 * <br>
 * < How to use? ><br>
 * < AbstractQQC should be extended by a specificQQC which MUST be an implementation of the Singleton(a bean for exp)>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/28 <br>
 */
public abstract class AbstractQQC<T> {

    /**
     * < constructor which is able to new an QQCStructure<T> >
     */
    public AbstractQQC() {
        loaded = false;
        initialize(initialize());
    }

    protected boolean loaded;

    protected QQCStructure<T> qqcStructure;

    /**
     * < return 'M'or'I' ><br>
     * < HOW to choose? ><br>
     * < see explanation of QQCMap & QQCIndex ><br>
     */
    protected abstract String initialize();

    protected void initialize(String type) {
        if (type.equalsIgnoreCase("M")) {
            qqcStructure = new QQCStructureMap<>();
        }
        else {
            qqcStructure = new QQCStructureIndex<>();
        }
    }

    protected abstract void load();

    /**
     * < load into cache when needed! >
     */
    public void reload() {
        synchronized (this) {
            if (!loaded) {
                // situation needed means the first time OR the first time after the scheduling cleaning
                load();
                loaded = true;
            }
        }
    }

    public void cleanThenReload() {
        synchronized (this) {
            loaded = false;
            qqcStructure.clean();
            reload();
        }
    }

}
