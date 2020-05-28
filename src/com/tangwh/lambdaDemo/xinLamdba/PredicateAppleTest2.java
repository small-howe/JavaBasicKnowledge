package com.tangwh.lambdaDemo.xinLamdba;

import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 核心接口扩展之 Predicate断定型接口 参数T 返回值Boolean
 * 确定类型为T的对象是否满足某约束，并返回boolean的值。boolean test(T t);
 *
 *
 */
public class PredicateAppleTest2 {

    // 需求二: 找到颜色为绿色的苹果 函数式写法
    private static List<Apple> findPredicate(List<Apple> list, Predicate<Apple> predicate){
        // 最终结果
        List<Apple> result = new ArrayList<>();
        for ( Apple apple : list) {
            // 利用Predicate.test(apple)方法进行判定,具体业务需要看调用方，是个策略模式
            if (predicate.test(apple)){

                result.add(apple);
            }

        }
        return result;
    }
    // 调用上面的数据
    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 10), new Apple("red", 20), new Apple("green", 30));
        /*
         * 第二个参数是Predicate的test(Apple)方法：
         * 由于只有一个参数，所以可以省略小括号
         */
        List<Apple> appleList = findPredicate(list, apple -> apple.getColor().equals("green"));
        System.out.println(appleList);

    }
}
