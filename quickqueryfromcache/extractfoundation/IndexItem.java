package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.extractfoundation;

import java.util.List;

/**
 * < an index ><br>
 * <what is the index here? you can see https://www.cnblogs.com/ciyeer/p/9067048.html>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/28 <br>
 */
public class IndexItem<T> {

    private int index;

    private Long start;

    private Long end;

    /**
     * < a block >
     */
    private List<T> t;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public List<T> getT() {
        return t;
    }

    public void setT(List<T> t) {
        this.t = t;
    }
}
