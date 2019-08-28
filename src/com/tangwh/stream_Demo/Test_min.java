package com.tangwh.stream_Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 求最小值Min  求最大值 Max
 */
public class Test_min {
    public static void main(String[] args) {
        testMin();
    }

    /**
     * 求集合元素中最小的元素
     */
    private static void testMin(){
        Student s1 = new Student(1, "李现", 20, "浙江");
        Student s2 = new Student(2, "曜", 14, "西安");
        Student s3 = new Student(3, "王一博", 19, "湖北");
        Student s4 = new Student(4, "阿波", 22, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);


        Student mins = students.stream().min((stu1, stu2) -> Integer.compare(stu1.getAge(), stu2.getAge())).get();
        System.out.println(mins);

    }
}
