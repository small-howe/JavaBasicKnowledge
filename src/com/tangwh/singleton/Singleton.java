
package com.tangwh.singleton;
/**
 * 设计模式之 单例模式
 */
public class Singleton {

    //  通过我的设计只能让这个类创建一个对象

    //1. 让无参构造变成私有 保证外面改变不可随便创建
    private Singleton(){};
    //2. 保证只能被创建一次
    // 属性
    // 方法:
    // 构造方法
    // 块
    private static Singleton singleton = new Singleton();



    public static Singleton getSingleton(){
        return singleton;
    }


}
