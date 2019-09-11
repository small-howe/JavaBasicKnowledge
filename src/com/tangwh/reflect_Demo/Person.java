package com.tangwh.reflect_Demo;

public class Person  extends Animal{

//    public Person(){
//
//        System.out.println("无参构造");
//    }
    public Person(String name,Integer age){
        this.name=name;
        this.age=age;
    }

    private String name;
    public int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void eat(){

        System.out.println("我是Person吃饭得方法");
    }
    public String eat(String name){

        System.out.println("我是Person带参数得方法");

        return name;
    }

    private void testPrivate(){

        System.out.println("Person的私密的方法");
    }
}
