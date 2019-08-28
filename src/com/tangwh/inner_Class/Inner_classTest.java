package com.tangwh.inner_Class;

public class Inner_classTest {
    public static void main(String[] args) {

        // 内部类的使用
        /**
         * 内部类属于外部类 (相当于外部类的一个成员 )  需要外部类操作才能使用
         */
        // 外部类
        Inner_classDemo inner_classDemo= new Inner_classDemo();
          // 内部类
        Inner_classDemo.Inner_classDemo1 inner_classDemo1 = inner_classDemo.new Inner_classDemo1();
        // 调用内部类的方法
        inner_classDemo1.testDemo1();


    }
}
