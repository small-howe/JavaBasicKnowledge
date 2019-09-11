package com.tangwh.reflect_Demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PersonConstructor_Main {

    public static void main(String[] args) {

        // 获取class 类
        Class<Person> personClass = Person.class;

        try {
            // 查找构造方法
            Constructor<Person> constructor = personClass.getConstructor(String.class,Integer.class);
            // 执行构造方法
            Person person = constructor.newInstance("name",15);
            System.out.println(person);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
