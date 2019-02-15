package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.extractfoundation;

import java.util.List;

/**
 * < ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/29 <br>
 */
public interface QQCStructure<T> {

    /**
     * < all T which match regex ><br>
     * < return null when nothing found ><br>
     */
    List<T> get(String regex);

    /**
     * < the T by key(an UNIQUE ID of the data) ><br>
     * < return T when Map, <T> when Index ><br>
     * < return null when nothing found ><br>
     */
    <T> T get(Object key);

    /**
     * < put an key-value ><br>
     * < replace when key exists already ><br>
     */
    void put(Object key, T t);

//    /**
//     * < put key-value >
//     */
//    void put(int index, Long start, Long end, List<T> tList);

    void put(List<T> tList);


    void clean();
}
