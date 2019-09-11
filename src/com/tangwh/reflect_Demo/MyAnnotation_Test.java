package com.tangwh.reflect_Demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({FIELD, METHOD, CONSTRUCTOR, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation_Test {

    String[] value() ;

}
