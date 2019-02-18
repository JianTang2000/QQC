package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.annotation;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ztesoft.zsmart.core.log.ZSmartLogger;

/**
 * < 这里可以改一下，不使用注解而是让dot继承实现getKey方法，这样不用反射我想应该会快一些，但是我懒得写了 ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/28 <br>
 */
public class IndexBlockKeyExplain {

    private static final ZSmartLogger logger = ZSmartLogger.getLogger(IndexBlockKeyExplain.class);

    public static Long getKey(Object object) {
        if (object == null) {
            logger.error("run IndexBlockKeyExplain.getKey but found input parameter is NULL!");
            return null;
        }
        Long ret = null;
        int timesOfIndexBlockKey = 0;
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(IndexBlockKey.class)) {
                timesOfIndexBlockKey++;
                ret = (Long) getProperty(object, field.getName());
            }
        }
        if (timesOfIndexBlockKey == 0) {
            logger.error("found NO @IndexBlockKey from {}!", object.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
            return null;
        }
        if (timesOfIndexBlockKey == 1) {
            return ret;
        }
        else {
            logger.error("found >1 @IndexBlockKey from {}!", object.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
            return null;
        }

    }

    private static <T> T getProperty(Object beanObj, String property) {
        PropertyDescriptor pd = null;
        try {
            pd = new PropertyDescriptor(property, beanObj.getClass());
        }
        catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
        Method getMethod = pd.getReadMethod();
        try {
            return (T) getMethod.invoke(beanObj);
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
