package com.tangwh.stream_Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  集合去重
 */
public class Test_distinct {

    public static void main(String[] args) {

       testDisstinct1();

    }

    /**
     * 简单字符串 去重(基本类型)
     */
    private static void testDisstinct(){

        // 简单字符串 的去重
     List<String> list = Arrays.asList("111","222","333","111","222");

     list.stream().distinct().forEach(System.out::println);


    }

    /**
     * 集合去重(引用对象)
     */
    private static void testDisstinct1(){
        //引用对象去重 引用对象要实现hashCode 和 equals 方法 否则去重无效
        Student s1 = new Student(1, "李现", 18, "浙江1");
        Student s2 = new Student(2, "曜", 16, "西安1");
        Student s3 = new Student(3, "王一博", 17, "湖北1");
        Student s4 = new Student(4, "阿波", 20, "浙江1");
        Student s5 = new Student(3, "王一博", 17, "湖北1");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        students.stream().distinct().forEach(System.out::println);

    }
}
