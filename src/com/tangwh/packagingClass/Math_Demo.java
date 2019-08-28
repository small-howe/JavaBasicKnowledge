package com.tangwh.packagingClass;

import java.util.Random;

public class Math_Demo {
    public static void main(String[] args) {

        System.out.println(Math.ceil(1.4));// 2.0  找最近的整数 向上取整
        System.out.println(Math.floor(1.4));//1.0  找最近的整数  向下取整
        System.out.println(Math.rint(1.4));//2.0   临近的整数  如果两边距离一样 取偶数
        System.out.println(Math.round(1.4));// 四舍五入

        Random random = new Random();
        int nextInt = random.nextInt();
        System.out.println(nextInt);


        int anInt = random.nextInt(10);// 0~10
        System.out.println(anInt);

        //5.0~~~10.09
        float v = (random.nextInt(6) )+ 5 + random.nextFloat();
        System.out.println(v);
    }
}
