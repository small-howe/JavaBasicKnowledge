package com.tangwh.arithmetic;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{5,2,6,4,12,21,1,56};
        if (array.length == 0){
            System.out.println("数组为空");
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - 1 - i; j++){
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
                }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}
