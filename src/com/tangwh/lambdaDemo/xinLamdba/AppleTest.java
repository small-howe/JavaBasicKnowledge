package com.tangwh.lambdaDemo.xinLamdba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * 需求1 找到颜色为红色的苹果。
 */
public class AppleTest {

    /**
     * 需求1 找到颜色为红色的苹果。
     */
    public static void main(String[] args) {

        // 变成集合
        List<Apple> list = Arrays.asList(new Apple("green",10),new Apple("red",20),new Apple("green",30));


        // 最终的结果
        List<Apple> result = new ArrayList<>();
/**
         声明我们自己的函数式接口的规则 则不用Lamdba则是如下这个丑样子
        AppleFiter fiter = new AppleFiter() {
            @Override
            public boolean fifter(final Apple apple) {
                return "red".equals(apple.getColor());
            }
        };

         * 而lamdba简单一句话 param ->body
          箭头左侧apple代表filter接口的入参，是Apple类型的，这里省略了类型，写全的话是Apple apple。
         而箭头右侧则是接口的规则，资深的人一眼就发现了，这是策略模式的一种写法。的确如此。
         */

        AppleFiter fiter = apple ->"red".equals(apple.getColor());
        for ( Apple apple : list) {
            //filter.filter(apple)则是验证apple是否是上述规则（红色），因为filter返回的boolean
            if (fiter.fifter(apple)){
                result.add(apple);
            }
        }
        System.out.println(result);
    }



}
