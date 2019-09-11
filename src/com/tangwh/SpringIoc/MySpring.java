package com.tangwh.SpringIoc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MySpring {


    // 设计方法 帮我们创建对象
    // 参数  String 类型
    // 返回值  Object
    public Object getBean(String className){
        // 获取方法传进来的参数相对应的类
        Object instance =null;
        Scanner input =new Scanner(System.in);
        System.out.println("请给"+className+"属性赋值");
        try {
            Class<?> aClass = Class.forName(className);
            // 通过 类创建对象
            instance = aClass.newInstance();
            // 在这里可以做Di 依赖注入 给属性赋值 set
            // 找到每一个对象所有中的set方法 给属性 赋值
            // 先通过 aClass  找寻类中所有 私有属性——> 获取每一个属性的名字——>set属性
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
              // 获取属性名
                String name = declaredField.getName();
                // 手动拼接 属性所对应的set 属性 setTitle  属性的首字符变大写
                String toUpperCase = name.substring(0, 1).toUpperCase();
                // 截取除首字母大写外的字母
                String substring = name.substring(1);
                StringBuilder sb =new StringBuilder("set");
                sb.append(toUpperCase);
                sb.append(substring);
                // 通过处理好的set方法名 找寻类中的方法  参数类型为属性中的类型 获取每一个属性中的类型
                Class<?> type = declaredField.getType();//获取属性类型
                Method method = aClass.getMethod(sb.toString(), type);
                // 找到了对应的set方法 进行赋值
                System.out.println("请给"+sb+"属性赋值:");
                String nextLine = input.nextLine();
                //需要执行属性对应的set方法 给属性赋值 方法就结束啦
                //属性的值现在接收过来 (Scanner 文件内读取) 全都是String类型
                //执行set方法的时候 方法需要的值不一定都是String类型  Integer Float ... 属性类型的值
                //如何将所有的String类型的值--->转化成属性类型的值
                //Integer包装类  八个包装类有七个都含有带String的构造方法
                //  new Integer(String) new Float(String)  new String(String)
                //可以利用包装类带String的构造方法处理  属性类型对应的带String参数的构造方法
                Constructor<?> constructor = type.getConstructor(String.class);
                method.invoke(instance,constructor.newInstance(nextLine));


            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return instance;


    }

}
