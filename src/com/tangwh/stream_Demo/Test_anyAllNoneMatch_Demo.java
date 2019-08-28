package com.tangwh.stream_Demo;

import java.util.ArrayList;
import java.util.List;

public class Test_anyAllNoneMatch_Demo {

    public static void main(String[] args) {
        testMatch();

    }
    private static void testMatch(){
        Student s1 = new Student(1, "李现1", 18, "浙江1");
        Student s2 = new Student(2, "曜1", 16, "西安1");
        Student s3 = new Student(3, "王一博1", 17, "湖北1");
        Student s4 = new Student(4, "阿波1", 20, "浙江1");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

           // anyMatch:Stream中"任意一个"元素复合传入的predicate  返回true;
        boolean anyMatch = students.stream().anyMatch(s -> "西安1".equals(s.getAddress()));
        if (anyMatch){
            System.out.println("有西安人");
        }
        //allMatch：Stream中"全部元素"符合传入的predicate 返回 true;
        boolean allMatch = students.stream().allMatch(s -> s.getAge() >= 15);
        if (allMatch){
            System.out.println("所有的学生都年满15周岁");
        }
        //noneMatch：Stream中"没有一个元素"符合传入的predicate 返回true;
        boolean noneMatch = students.stream().noneMatch(s -> "阿波".equals(s.getName()));
        if (noneMatch){
            System.out.println("没有叫杨洋的同学");
        }


    }


}
