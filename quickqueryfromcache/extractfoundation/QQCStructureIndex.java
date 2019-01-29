package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.extractfoundation;

import java.util.ArrayList;
import java.util.List;

import com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.annotation.IndexBlockKeyExplain;

/**
 * < you can choose to use this structure when there is not any unique ID of the data ><br>
 * < ordering of the data is required ><br>
 * < T MUST use @IndexBlockKey ><br>
 * < there are PUBLIC functions provided below ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/28 <br>
 */
public class QQCStructureIndex<T> implements QQCStructure<T> {

    /**
     * < see IndexItem >
     */
    public List<IndexItem<T>> indexItemList = new ArrayList<>();

    @Override
    @Deprecated
    public List<T> get(String regex) {
        return null;
    }

    @Override
    public List<T> get(Object key) {
        List<T> ret = new ArrayList<>();
        Long keyLong = (Long) key;
        for (IndexItem<T> indexItem : indexItemList) {
            if (keyLong.longValue() <= indexItem.getEnd() && keyLong.longValue() >= indexItem.getStart()) {
                for (T t : indexItem.getT()) {
                    Long keyFromT = IndexBlockKeyExplain.getKey(t);
                    if (keyFromT.longValue() == keyLong.longValue()) {
                        ret.add(t);
                    }
                }
            }
        }
        return ret;
    }

    @Override
    @Deprecated
    public void put(Object key, T t) {

    }

    @Override
    public void put(int index, Long start, Long end, List<T> tList) {
        IndexItem<T> indexItem = new IndexItem<T>();
        indexItem.setIndex(index);
        indexItem.setStart(start);
        indexItem.setT(tList);
        indexItemList.add(indexItem);
    }

    @Override
    public void clean() {
        indexItemList.clear();
    }

}
