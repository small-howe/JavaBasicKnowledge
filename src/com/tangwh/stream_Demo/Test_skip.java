package com.tangwh.stream_Demo;

import java.util.Arrays;
import java.util.List;

/**
 * 删除
 */
public class Test_skip {
    public static void main(String[] args) {


     testSkip();

    }

    /**
     * 集合skip 删除前n个元素
     */
    private static void testSkip(){
        List<String> list = Arrays.asList("111","333","222","555","444");

        list.stream().skip(2).forEach(System.out::println);


    }
}
