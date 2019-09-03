package com.tangwh.String_Demo;

import java.util.Scanner;

/**
 * 正则表达式
 */
public class Regular_Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = input.nextLine();
        //判断输入的str 字符串内容是否满足什么样的格式
        boolean matches = str.matches("a[abc]");// 第一个必须是 a  第二个在 a b c 选一个

        System.out.println(matches);


    }
}
