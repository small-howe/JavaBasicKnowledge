package com.tangwh.reflect_Demo;


import javax.sound.midi.SoundbankResource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 注解 之应用
 */
public class Annotation_Test {

    public static void main(String[] args) {
        try {
            // 解析 Person类中 方法上面的注解
            // 首先 获取 Person 的对应类
            Class<?> aClass = Class.forName("com.tangwh.reflect_Demo.Person");
            // 再 获取类中的方法
            Method eat = aClass.getMethod("eat");
            // 获取到方法之后 再获取方法上面的注解
            Annotation annotation =eat.getAnnotation(MyAnnotation_Test.class);
           // 利用反射机制 来获取value 方法 注解对应的那个类
            Class<? extends Annotation> aClass1 = annotation.getClass();
            // 通过注解对应的那个类 找到value方法
            Method value = aClass1.getMethod("value");
            // 执行那个方法
            String[] invoke = (String[]) value.invoke(annotation);
            for (String s : invoke) {
                System.out.println(s);
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        // 解析Person 类种 属性上面的注解
//        try {
//        //解析属性的: 解析Person属性上面的注解
//        //1.通过 Person 对应的类
//        Class<Person> personClass = Person.class;
//        // 通过 personClass 获取属性
//        Field name = personClass.getDeclaredField("name");
//        // 通过属性名 name 来获取上面的注解
//        Annotation annotation = name.getAnnotation(MyAnnotation_Test.class);
//        // 利用反射执行 value 方法   注解对应的那个类
//        Class<? extends Annotation> aClass = annotation.getClass();
//        // 通过aClass 类 找到value 的方法
//        Method value = aClass.getMethod("value");
//        // 执行value 方法  参数 ：方法所属的对象 方法执行时的参数
//        String[] invoke = (String[]) value.invoke(annotation);
//            for (String s : invoke) {
//                System.out.println(s);
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//



//        // 正常的对象调用:   通过Field 获取上面的注解  参数 是 注解名的Class
//        MyAnnotation_Test annotation = name.getAnnotation(MyAnnotation_Test.class);
//        // 执行 注解中的value方法
//        String[] value = annotation.value();
//        System.out.println(value[0]);


//        @SuppressWarnings("unused")
//        String str = "abc";
//
//          // 读取test.properties文件
//        Properties pro = new Properties();
//        try {
//            pro.load(new FileReader("E:\\IdeaProjects\\javaBasicKnowledge\\src\\com\\tangwh\\reflect_Demo\\test.properties"));
//            Enumeration<?> enumeration = pro.propertyNames();
//          while (enumeration.hasMoreElements()){
//              String keys = (String)enumeration.nextElement();
//              pro.getProperty(keys);
//
//          }
//
//
//            Object key = pro.get("key");
//            System.out.println(key);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
