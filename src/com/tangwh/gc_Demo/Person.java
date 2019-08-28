package com.tangwh.gc_Demo;

public class Person {
    public Person(){
        System.out.println("Person被创建了 ");
    }

    public void finalize(){


        System.out.println("Persion对象被回收了");
    }
}
