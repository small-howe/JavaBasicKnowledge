package com.tangwh.stream_Demo;

import java.util.Arrays;
import java.util.List;

/**
 * 聚合
 */
public class Test_reduce {
    public static void main(String[] args) {

        restReduce();

    }
    private static void restReduce(){
        List<String> list = Arrays.asList("欢","迎","你");


        String appendStr = list.stream().reduce("北京", (a, b) -> a + b);

        System.out.println(appendStr);
    }
}
