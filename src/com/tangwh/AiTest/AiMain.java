package com.tangwh.AiTest;

import java.util.Scanner;

public class AiMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true){
            str =  sc.next();
            str = str.replaceAll("吗？", "");
            str = str.replaceAll("？", "!");
            str = str.replaceAll("？", "!");
            System.out.println(str);
        }
    }
}
