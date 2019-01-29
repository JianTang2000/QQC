package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.extractfoundation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * < you can choose to use this structure when there is an UNIQUE ID of the data ><br>
 * < ordering of the data is NOT required ><br>
 * < there are PUBLIC functions provided below ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/28 <br>
 */
public class QQCStructureMap<T> implements QQCStructure<T> {
    /**
     * < a simple HashMap will be quick and strong enough here >
     */
    private Map<Object, T> qqcMap = new HashMap<>();

    @Override
    @Deprecated
    public List<T> get(String regex) {
        return null;
    }

    @Override
    public T get(Object key) {
        return qqcMap.get(key);
    }

    @Override
    public void put(Object key, T t) {
        qqcMap.put(key, t);

    }

    @Override
    @Deprecated
    public void put(int index, Long start, Long end, List<T> tList) {

    }

    @Override
    public void clean() {
        qqcMap.clear();
    }
}
