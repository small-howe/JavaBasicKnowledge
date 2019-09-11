package com.tangwh.SpringIoc;

public class SpringTest {
    public static void main(String[] args) {
        // 创建一个Question对象 讲对象的控制权交给MySpring别人 IOC
        MySpring mySpring =new MySpring();
//        Question question = (Question) mySpring.getBean("com.tangwh.SpringIoc.Question");
//
//        System.out.println(question);

       User user = (User) mySpring.getBean("com.tangwh.SpringIoc.User");
        System.out.println(user);
    }
}
