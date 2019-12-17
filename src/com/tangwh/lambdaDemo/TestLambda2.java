package com.tangwh.lambdaDemo;

public class TestLambda2 {

    public static void main(String[] args) {

        // 局部类
//        class Love implements Ilove{
//
//
//            @Override
//            public void love(int a) {
//                System.out.println("I love you"+a);
//            }
////        }

  //匿名内部类
//        Ilove love = new Ilove() {
//            @Override
//            public void love(int a) {
//                System.out.println("I love you"+a);
//            }
//        };

        //Lambda 简化
//        Ilove ilove = (int a) -> {
//            System.out.println("I love you" + a);
//        };

        //Lambda 再次简化
//        Ilove  ilove = (a)->{
//            System.out.println("I love you" + a);
//        };


        //Lambda 再次简化
//        Ilove  ilove = a->{
//            System.out.println("I love you" + a);
//        };

        //Lambda 再次简化
        Ilove  ilove = a-> System.out.println("I love you" + a);

 // 总结:Lambda 表达式:只能有 一行代码的情况下 才能简化成一行  如果有多行 那么就用代码{} 包裹
        // 前提是接口为函数式接口 函数式接口 : 一个接口下只能由一个 接口
        // 多个参数:多个参数也可以去掉参数类型 要去掉就去掉
        ilove.love(3);


    }

// 静态类

// static class Love implements Ilove{
//
//
//    @Override
//    public void love(int a) {
//        System.out.println("I love you"+a);
//    }
//}

}

interface Ilove {
    void love(int a);
}

 // 外部类
//class Love implements Ilove{
//
//
//    @Override
//    public void love(int a) {
//        System.out.println("I love you"+a);
//    }
//}
