package com.tangwh.reflect_Demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 操作类中的方法
 */
public class PersonMethod_Main {
    public static void main(String[] args) {
                // 获取当前类
        Class<Person> personClass = Person.class;

        try {
            // 创建对象
            Person person  = personClass.newInstance();


            Method testPrivate = personClass.getDeclaredMethod("testPrivate");
            testPrivate.setAccessible(true);
            testPrivate.invoke(person);


//            // 通过personClass 来获取方法  方法参数类型对听得Class来找寻
//            Method eat = personClass.getMethod("eat",String.class);
//
//            // 让方法执行
//            String result = (String) eat.invoke(person, "测试返回值");
//            System.out.println(result);
//
//            // 查找父类的方法
//            Method sleep = personClass.getMethod("sleep");
//            sleep.invoke(person);
//
//            //查找 共有的 所有的方法包括父类
//            Method[] methods = personClass.getMethods();
//
//            for (Method method : methods) {
//                System.out.println(method.getName());
//            }


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


//        // 修饰符
//        int modifiers = eat.getModifiers();
//        // 返回值类型
//        Class<?> returnType = eat.getReturnType();
//        // 获取方法名
//        String name = eat.getName();
//        // 获取参数列表类型
//        Class<?>[] parameterTypes = eat.getParameterTypes();
//        //获取参数 异常
//        Class<?>[] exceptionTypes = eat.getExceptionTypes();

    }
}
