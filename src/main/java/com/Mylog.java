package com;

import java.lang.annotation.*;

/**
 * created by liufeng
 * 2018/8/9
 */
@Documented
//@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mylog {
    String fileName() default "";
}
