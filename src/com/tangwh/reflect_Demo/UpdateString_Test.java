package com.tangwh.reflect_Demo;

import java.lang.reflect.Field;

public class UpdateString_Test {
    public static void main(String[] args) {
        String str = new String("abc");
        System.out.println("未修改前的" + str);
        // 利用反射机制 去访问私有属性 修改String 的值 虽然不合理
        // 1.获取String 对应Class
        Class<String> stringClass = String.class;
        try {
            // 2.通过stringClass 获取Value属性
            Field value = stringClass.getDeclaredField("value");
            // 3. 设置私有属性允许被修改
            value.setAccessible(true);
            // 4. 获取value 属性内存地址
            // private final char[] value={'a','b','c'};
            char[] temp = (char[]) value.get(str);
            temp[0] = '唐';
            temp[1] = '维';
            temp[2] = '豪';
            // 最终输出
            System.out.println("未修改后的" + str);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
