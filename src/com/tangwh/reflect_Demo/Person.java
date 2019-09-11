package com.tangwh.reflect_Demo;

public class Person  extends Animal {

    //利用反射技术实现了一个IOC 对象由别人来创建 创建同时自动注入属性信息
    //自动注入属性的信息--->String字符串 产生一个注解 携带这些信息


    // 自己定义的注解
    //@MyAnnotation_Test({"twh", "18"})
    private String name;
    public Integer age;
    public String sex;

    @MyAnnotation_Test({"唐维豪","18","男"})
    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    // @MyAnnotation_Test("我")
    public void eat() {

        System.out.println("我是Person吃饭得方法");
    }
}
