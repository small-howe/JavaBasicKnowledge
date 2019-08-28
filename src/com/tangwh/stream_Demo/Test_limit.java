package com.tangwh.stream_Demo;

import java.util.Arrays;
import java.util.List;

/**
 * 集合Limit(限制返回个数)
 */
public class Test_limit {
    public static void main(String[] args) {

        testLimit();
    }


    /**
     * 集合Limit(限制返回个数)
     */
    private static void testLimit(){
        List<String> list = Arrays.asList("111","333","222","555","444");

        list.stream().limit(2).forEach(System.out::println);

    }

}
