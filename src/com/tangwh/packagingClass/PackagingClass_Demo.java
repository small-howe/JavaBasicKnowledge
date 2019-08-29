package com.tangwh.packagingClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

/**
 * 包装类 测试
 */
public class PackagingClass_Demo {
    public static void main(String[] args) {

        System.out.println(Math.ceil(1.4));// 2.0  找最近的整数 向上取整
        System.out.println(Math.floor(1.4));//1.0  找最近的整数  向下取整
        System.out.println(Math.rint(1.4));//2.0   临近的整数  如果两边距离一样 取偶数
        System.out.println(Math.round(1.4));// 四舍五入

        System.out.println("-----------------------------Random------------------------------");
        Random random = new Random();
        int nextInt = random.nextInt();
        System.out.println(nextInt);


        int anInt = random.nextInt(10);// 0~10
        System.out.println(anInt);

        //5.0~~~10.09
        float v = (random.nextInt(6) )+ 5 + random.nextFloat();
        System.out.println(v);

        System.out.println("----------------------------System-------------------------------");
        //返回当前系统时间与计算机元年之间的毫秒差
        //1970-1-1  00:80:00
        long time = System.currentTimeMillis();
        System.out.println(time);

        System.out.println("---------------------------Date--------------------------------");
        Date date1 = new Date(1545364985172L);//15分钟之前的时间
        Date date2 = new Date();//默认就是用当前的系统时间构建的date对象
        System.out.println(date2);//重写了toString  格林威治格式Fri Dec 21 12:12:12 CST 2018

        boolean x = date1.before(date2);//date1是否在date2之前
        boolean y = date1.after(date2);//date1是否在date2之后
        System.out.println(x+""+y);

        System.out.println("-----------------------SimpleDateFormat------------------------------------");
        //2018-12-21 12:19:16
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String vs = sdf.format(date1);//通过sdf对象将date1格式化成你描述的样子
        System.out.println(vs);

        System.out.println("-----------------------Calendar------------------------------------");


        Calendar calendar = Calendar.getInstance();//系统当前时间的calendar对象
        //java.util.GregorianCalendar[name=value,name=value]
        System.out.println(calendar);
        calendar.set(Calendar.YEAR,2015);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);//从0开始数
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year+"--"+month+"--"+day);


        System.out.println("-----------------------TimeZone------------------------------------");

        TimeZone tz = calendar.getTimeZone();
        //TimeZone tz = TimeZone.getDefault();
        System.out.println(tz);
        System.out.println(tz.getID());
        System.out.println(tz.getDisplayName());
    }
}
