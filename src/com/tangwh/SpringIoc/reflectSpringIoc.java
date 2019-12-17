package com.tangwh.SpringIoc;

import com.tangwh.reflect_Demo.MyAnnotation_Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflectSpringIoc {
    // 设计一个方法 给一个类名  对象内部的属性名存值

    public Object getBean(String className){
        Object obj =null;
        try {
            // 通过传进来的className 来找到对应的类   要求类的全名
            Class<?> aClass = Class.forName(className);
            // 通过aClass 创建空的对象
            //aClass.newInstance();
            // 找无参构造方法
            Constructor<?> constructor = aClass.getConstructor();
            obj = constructor.newInstance();
            // 创建对象后  将对象中的所有属性进行赋值DI  值——> 文件   注解
            //  值-->文件  好处在于代码包装起来.jar不能修改 文件还可以修改
            //    .xml     不好在于开发的时候  源代码和配置文件不在一起  读取/修改比较麻烦
            //  值-->注解  好处在于开发的时候方便  源代码和注解在一起  读取/调整时候比较容易
            //     @     不好在于代码包装起来后  注解内携带的信息不能修改

            //  首先获取属性的值---->类的无参数构造方法之上
            Annotation a = constructor.getAnnotation(MyAnnotation_Test.class);
            // 获取a 注解携带的信息
            Class<? extends Annotation> aClass1 = a.getClass();
            Method value = aClass1.getMethod("value");
            String[] invoke = (String[])value.invoke(a);

            // 将 invoke 的值 赋值
            // 寻找属性的set方法
            // 寻找全部属性
            Field[] fields = aClass.getDeclaredFields();
            for (int i =0; i<fields.length; i++) {
                // 获取每个属性名字
                String name = fields[i].getName();
                // 处理set 方法 截取属性的一个字母 并变大写
                String firstLetter = name.substring(0, 1).toUpperCase();
                // 再截取 除首字母 后 其余的字母 最后进行拼接
                String otherLetter = name.substring(1);
              // 进行拼接 set开头
                StringBuilder builder = new StringBuilder("set");
                builder.append(firstLetter);
                builder.append(otherLetter);

                // 通过处理好的Set名字 找到对应的Set方法
                // 参数 类型 所对应类的Class
                Class<?> type = fields[i].getType();
                Method method = aClass.getMethod(builder.toString(), type);
                // 找到set 方法进行赋值
                //需要将注解内读取到的String类型的值 转化成属性类型对应的值
                // 参数： 对象
                method.invoke(obj,type.getConstructor(String.class).newInstance(invoke[i]));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return obj;
    }


}
