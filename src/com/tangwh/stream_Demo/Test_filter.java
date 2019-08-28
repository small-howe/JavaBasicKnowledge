package com.tangwh.stream_Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream - filter   筛选
 */
public class Test_filter {

    public static void main(String[] args) {

        Student s1 = new Student(1, "李现", 18, "浙江");
        Student s2 = new Student(2, "曜", 16, "西安");
        Student s3 = new Student(3, "王一博", 17, "湖北");
        Student s4 = new Student(4, "阿波", 20, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        List<Student> list = testFilter(students);
        for (Student student : list) {
            System.out.println(student);
        }
    }

    /**
     * 集合的筛选
     * @param students
     * @return
     */
    private static List<Student> testFilter(List<Student> students) {


        //筛选 年龄大于17的学生
        //return students.stream().filter(s -> s.getAge() > 17).collect(Collectors.toList());
           //筛选住在浙江的学生
     return    students.stream().filter(s -> s.getAddress()=="浙江").collect(Collectors.toList());

    }
}
