package com.tangwh.abstractAndInterface_Demo;

public abstract class Abstract_Demo {

    // 抽象类  -----> 直接单继承 可以 ------> 抽象类
    // 抽象类  -----> 直接单继承 可以 ------> 具体类
    // 具体类  -----> 直接单继承 不可以 ----->抽象类(将父类的抽象方法具体化 或子类也变成抽象类)
    // 抽象类 ------> 内部全部是具体方法-----> 可以
    // 抽象类 ------> 内部全部是抽象方法------> 抽象类抽象到极致 质的变化 ---->接口

    /**
     *  1.可以含有构造放方法(包括 重载)
     *
     *  不能被实例化 创建
     */
    public Abstract_Demo(){ }


    //   1. 抽象类中可以含有属性(和正常类一样)
    private static final String name="sads";


    //2. 抽象类中可以含有一般的方法(和正常类一样)
    public void show(){ }


    //注意：3.抽象类中可以含有抽象方法的
    public abstract  void showDemo();

    /**
     * 可以含有一般的成语块 也可以含有static 静态代码块
     */
    {

    }

}
