package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.extractfoundation;

import java.util.ArrayList;
import java.util.List;

import com.ztesoft.zsmart.bss.newbilling.base.v8.utils.ValidateUtil;
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
    public void put(List<T> tList) {
        if (ValidateUtil.validateNotEmpty(tList)) {
            int volume = tList.size();// 103
            int indexBlockSize = 50;
            if (volume <= indexBlockSize) {
                int index = 1;
                Long start = IndexBlockKeyExplain.getKey(tList.get(0));
                Long end = IndexBlockKeyExplain.getKey(tList.get(volume - 1));
                this.put(index, start, end, tList);
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
                    this.put(index, start, end, tsTobePut);
                }
                int index = indexVolume;// 3
                List<T> tsTobePut = new ArrayList<>();
                Long start = IndexBlockKeyExplain.getKey(tList.get((index - 1) * indexBlockSize));// 100
                Long end = IndexBlockKeyExplain.getKey(tList.get(volume - 1));// 102
                for (int m = (index - 1) * indexBlockSize; m <= volume - 1; m++) {
                    tsTobePut.add(tList.get(m));
                }
                this.put(index, start, end, tsTobePut);
            }
        }
    }

    private void put(int index, Long start, Long end, List<T> tList) {
        IndexItem<T> indexItem = new IndexItem<T>();
        indexItem.setIndex(index);
        indexItem.setStart(start);
        indexItem.setEnd(end);
        indexItem.setT(tList);
        indexItemList.add(indexItem);
    }

    @Override
    public void clean() {
        indexItemList.clear();
    }

}
