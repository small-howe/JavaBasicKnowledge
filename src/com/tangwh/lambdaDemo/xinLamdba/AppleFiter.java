package com.tangwh.lambdaDemo.xinLamdba;

/**
 * 被@FunctionalInterface修饰且只有一个抽象方法，若没被注解修饰，但是只有一个抽象方法，这样也是可以的
 */
@FunctionalInterface
public interface AppleFiter {

    boolean fifter(Apple apple);
}
