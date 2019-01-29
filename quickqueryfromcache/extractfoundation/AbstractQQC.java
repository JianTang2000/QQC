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

    /**
     * < tList MUST be ordering ASC >
     */
    protected void put(List<T> tList) {
        if (ValidateUtil.validateNotEmpty(tList)) {
            int volume = tList.size();// 103
            int indexBlockSize = 50;
            if (volume <= indexBlockSize) {
                int index = 1;
                Long start = IndexBlockKeyExplain.getKey(tList.get(0));
                Long end = IndexBlockKeyExplain.getKey(tList.get(volume - 1));
                qqcStructure.put(index, start, end, tList);
            }
            else {
                int indexVolume = volume / indexBlockSize + (volume % indexBlockSize == 0 ? 0 : 1);// 3
                for (int i = 1; i < indexVolume; i++) {
                    int index = i;// 2
                    List<T> tsTobePut = new ArrayList<>();
                    Long start = IndexBlockKeyExplain.getKey(tList.get((index - 1) * indexBlockSize));// 50
                    Long end = IndexBlockKeyExplain.getKey(tList.get(index * indexBlockSize - 1));// 99
                    for (int m = (index - 1) * indexBlockSize; i <= index * indexBlockSize - 1; i++) {
                        tsTobePut.add(tList.get(m));
                    }
                    qqcStructure.put(index, start, end, tsTobePut);
                }
                int index = indexVolume;// 3
                List<T> tsTobePut = new ArrayList<>();
                Long start = IndexBlockKeyExplain.getKey(tList.get((index - 1) * indexBlockSize));// 100
                Long end = IndexBlockKeyExplain.getKey(tList.get(volume - 1));// 102
                for (int m = (index - 1) * indexBlockSize; m <= volume - 1; m++) {
                    tsTobePut.add(tList.get(m));
                }
                qqcStructure.put(index, start, end, tsTobePut);
            }
        }
    }
}
