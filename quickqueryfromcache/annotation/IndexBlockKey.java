package com.ztesoft.zsmart.bss.newbilling.invoicing.sortfunction.quickqueryfromcache.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * < this '@IndexBlockKey' must be used above the key of the data(T) when you are going to use QQCIndex><br>
 * < the key of the data(T) MUST be Long Or being able to force to Long ><br>
 *
 * @author tang.jian<br>
 * @CreateDate 2019/1/28 <br>
 */
@Documented
@Inherited
@Target({
    ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)

public @interface IndexBlockKey {

    String errMsg() default "failed to explain @IndexBlockKey";
}
