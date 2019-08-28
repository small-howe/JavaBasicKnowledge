package com.tangwh.stream_Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 集合排序(指定排序规则)
 */
public class Test_sorted {

    public static void main(String[] args) {
    testSorted2();

    }
    /**
     * 简单集合排序 (默认排序)
     */
    private static void testSorted(){
        List<String> list = Arrays.asList("111","333","222","555","444");

        list.stream().sorted().forEach(System.out::println);


    }
    /**
     * 集合排序(指定排序规则)
     */
    private static void testSorted2(){

        Student s1 = new Student(1, "李现2", 18, "浙江");
        Student s2 = new Student(2, "曜2", 16, "西安");
        Student s3 = new Student(3, "王一博2", 17, "湖北");
        Student s4 = new Student(4, "阿波2", 20, "浙江");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        /**
         * 按照id 和 年龄 一起排序
         */
        students.stream().sorted((stu1,stu2)->Integer.compare(stu2.getId(), stu1.getId()))
                .sorted((stu1,stu2)->Integer.compare(stu2.getAge(), stu1.getAge()))
                .forEach(System.out::println);

    }


}
