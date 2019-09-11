package com.tangwh.reflect_Demo;


import javax.sound.midi.SoundbankResource;
import java.lang.reflect.Field;

/**
 * 操作类中的属性
 */
public class PersonClass_Main {


    public static void main(String[] args) {
        //通过Class 对象 来操作Person.Class
        try {
            Class clazz = Class.forName("com.tangwh.reflect_Demo.Person");
            // 创建对象
            Person person = (Person) clazz.newInstance();
            // 获取私有属性name
            Field nameValue = clazz.getDeclaredField("name");
            System.out.println(nameValue.getName());
            // 设置私有属性 允许被操作
            nameValue.setAccessible(true);
            // 给私有属性赋值
            nameValue.set(person,"唐维豪");
            System.out.println(person);
            // get 获取私有属性
            String name = (String) nameValue.get(person);
            System.out.println(name);


//            // 获取属性  首先 属性共有的  属性名知道
//            Field nameValue = clazz.getField("name");
//            // 获取属性 首先 属性共有的  不知道属性名 获取全部的属性名包括继承关系
////            Field[] fields = clazz.getFields();
////            for (Field field : fields) {
////                System.out.println(field.getName());
////            }
//            // 通过属性赋值
//            nameValue.set(person,"唐维豪");
//            System.out.println(person);
//            //取值
//            String name =(String) nameValue.get(person);
//            System.out.println(name);


//            // 获取属性名
            // 获取属性  首先 属性共有的  属性名知道
      //      Field nameValue = clazz.getField("name");
//            String nameName = nameValue.getName();
//            System.out.println("属性名:" + nameName);
//
//            // 获取属性的修饰符
//            int modifiers = nameValue.getModifiers();
//            System.out.println("属性修饰符:" + modifiers);
//            // 获取属性的类型
//            Class nameType = nameValue.getType();
//            System.out.println("属性的类型" + nameType.getName());
//            // 0.获取到类后 创建对象
//            Person person = (Person) clazz.newInstance();
//            System.out.println(person);


//                  1. 获取 特征修饰符
//            每一个修饰符 用一个整数来进行表示
//            0开始---0 1 2 4 8 16 32 64 128 256 512
//            0--默认不写  1--public  2--private  4--protected
//            8--static   16--final  32--synchronized  64volatile
//            128--transient  256--native  512--interface  1024--abstract
//            int modifiers = clazz.getModifiers();
//            System.out.println("权限特征"+modifiers);
//
//            // 2. 获取名字
//            String clazzName = clazz.getName();// 类全名 (包括报名)
//            String simpleName = clazz.getSimpleName();// 只是类名
//            System.out.println("类的全名:"+clazzName);
//            System.out.println("类型名:"+simpleName);
//
//
//            //3. 获取类所在的包
//            Package aPackage = clazz.getPackage();
//            String name = aPackage.getName();
//
//            System.out.println("包名为"+name);
//
//
//            //4. 获取父类的名字
//            Class superclass = clazz.getSuperclass();
//            System.out.println("父类的名字为:"+superclass.getName());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


}


