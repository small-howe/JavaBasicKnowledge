package com.tangwh.String_Demo;

public class StringBuilder_Test {
    public static void main(String[] args) {

        //无参数构造方法  构建一个默认长度16个空间的对象  char[]
        StringBuilder sb = new StringBuilder();
//
//        利用给定的参数 构建一个自定义长度空间的对象 char[]
//        StringBuilder builder = new StringBuilder(20);
//
//        利用带String参数的构造方法  默认数组长度字符串长度+16个
//        StringBuilder builder1 = new StringBuilder("abc");


//              普通拼接时间:
//                String str = "a";
//        long time1 = System.currentTimeMillis();
//        for(int i=1;i<=200000;i++){
//            //str+="a";//利用+拼接  10030
//            str = str.concat("a"); //5320
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2-time1);


//        StringBuilder builder = new StringBuilder("a");//17
//        long time1 = System.currentTimeMillis();
//        for(int i=1;i<=200000;i++){
//            builder = builder.append("a");//7毫秒
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2-time1);


        //字符串底层char[]的容量 //字符串有效元素个数(长度)
        StringBuilder builder = new StringBuilder("abcdefg");//7+16 capacity
        System.out.println(builder.capacity());//底层那个数组的容量
        System.out.println(builder.length());//长度  有效元素的个数

    }
}
