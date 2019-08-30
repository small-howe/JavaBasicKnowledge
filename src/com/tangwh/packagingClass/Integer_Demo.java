package com.tangwh.packagingClass;

import java.math.BigInteger;

import static java.util.concurrent.Executors.newWorkStealingPool;

/**
 * 包装类 测试
 */
public class Integer_Demo {


     // 设计一个方法 给定数字的阶乘  5 = 1*2*3*4
     public BigInteger factorial(int num){
     BigInteger result = new BigInteger("1");
       for (int i=1;i<=num;i++){

           result = result.multiply( new BigInteger(i+""));
       }
     return result;
    }


    public static void main(String[] args) {
        // -------  1.5之前 -----------------
        //  引用数据类型 包装类
        Integer num = new Integer(10);
        //将 num 拆成基本数据类型
        int numInt = num.intValue();


        // ---------1.5之后------------
        Integer num1 = 10;
        int numInts = new Integer(10);


        //---- 1.5 之前 ---
        int StringValue = Integer.parseInt("123");


        //---- 1.5 之之后 ---
        int StringValues = new Integer("123");


        // 笔试题
        Integer i1 = 10;//  true--->如果数字范围超过127false
        Integer i2 = 10;
        Integer i3 = new Integer(10);
        Integer i4 = new Integer(10);
        System.out.println(i1==i2);
        System.out.println(i1==i3);
        System.out.println(i3==i4);

        System.out.println(i1.equals(i2));
        System.out.println(i1.equals(i3));
        System.out.println(i3.equals(i4));

//        1.==与equals()区别
//         ==可以比较基本数据类型  也可以比较引用数据类型  (变量中存储的内容)
//        如果比较基本类型比较是变量中存储的值
//        如果比较引用类型比较是变量中存储的地址引用
//        equals()是Object类中继承过来的方法  每一个引用类型都可以调用
//        默认继承的equals()方法比较与==一致  如果想要改变比较规则 可以重写equals方法
//        由于Integer类就重写了equals() 所以Integer比较的是数值
//        2.考察Integer类加载的时候  自己有一个静态的空间
//        空间内立即加载 Integer类型的数组  内存储256个Integer对象   -128 ~ 127
//        如果我们用的对象范围在这之内Integer i1 = 10;  直接取静态区中找对应的对象
//        如果我们用的对象范围超出了这个Integer i1 = 1000;  会帮我们创建一个新的Integer对象
        Integer_Demo integer_demo = new Integer_Demo();

        BigInteger factorial = integer_demo.factorial(5);
        System.out.println(factorial);



    }
}
