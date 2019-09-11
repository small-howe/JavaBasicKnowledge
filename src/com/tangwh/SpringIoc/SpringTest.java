package com.tangwh.SpringIoc;

import javax.jws.soap.SOAPBinding;

public class SpringTest {
    public static void main(String[] args) {


      // 获取一个User 类型的对象
//        User user = new User();
//        user.setName("唐维豪");
//        user.setAge(18);
       // System.out.println(user.getAge()+"------"+user.getAge());
        //User user = new User("唐维豪",18);
        // 以上都是自己创建

        //获取User对象  不用自己处理 跟别人要
        //对象的创建权利反转(IOC) 赋值(自动DI) 别人处理
        reflectSpringIoc mySpring =new reflectSpringIoc();//管理者 帮我们创建对象 自动赋值
        User user =(User) mySpring.getBean("com.tangwh.SpringIoc.User");
        System.out.println(user.getName()+"------"+user.getAge());


//        // 创建一个Question对象 讲对象的控制权交给MySpring别人 IOC
//        MySpring mySpring =new MySpring();
////        Question question = (Question) mySpring.getBean("com.tangwh.SpringIoc.Question");
////
////        System.out.println(question);
//
//       User user = (User) mySpring.getBean("com.tangwh.SpringIoc.User");
//        System.out.println(user);
    }
}
