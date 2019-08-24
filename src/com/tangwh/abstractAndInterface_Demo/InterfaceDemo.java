package com.tangwh.abstractAndInterface_Demo;

public interface InterfaceDemo {

    // 接口不能继承别的类  最抽象的一个
    //抽象类 ----->直接多实现   ------> 接口可以
    //具体类 ----->直接多实现    ------>  接口不可以(必须将接口中的方法具体化  自己变成抽象类)
    // 接口  ---->多继承直接多实现 ------> 接口  可以

    // 接口中 属性默认的访问修饰符为: public static final …………
    String name="sad";


    //只定义规则  不描述具体过程
     void test();

    // jdk1.8 之后
    default void tests(){ }


}
