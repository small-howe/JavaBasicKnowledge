package com.tangwh.stream_Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Map 转换:map就是将对应的元素按照给定的方法进行转换
 *
 */
public class Test_map {

    public static void main(String[] args) {
        Student s1 = new Student(1, "李现1", 18, "浙江");
        Student s2 = new Student(2, "曜1", 16, "西安");
        Student s3 = new Student(3, "王一博1", 17, "湖北");
        Student s4 = new Student(4, "阿波1", 20, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        testMap(students);

    }

    private static void testMap(List<Student> students){
        //在地址面前加上部分信息 只获取地址输出
        List<String> addresses = students.stream().map(s -> "地址:" + s.getAddress()).collect(Collectors.toList());

         //  遍历
        addresses.forEach(a -> System.out.println(a));


    }
}
