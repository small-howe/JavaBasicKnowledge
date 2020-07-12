package com.tangwh.newJava8.newDate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestSteam {
    public static void main(String[] args) {
        List<Integer> integerList= Arrays.asList(20,30,40,50,60);

        Map<Boolean,List<Integer>> acclect = integerList.stream().collect(Collectors.partitioningBy(r -> r >40));

        System.out.println(acclect.get(true));

        System.out.println(acclect.get(false));
    }
}
