package com.tangwh.lambdaDemo;

/**
 * 推导式Lambda表达式
 */
public class TestLambda1 {


    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();


        // 静态类
        like = new Like2();
        like.lambda();


        // 4.局部内部类
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
  // 局部内部类
        like = new Like3();
        like.lambda();

        // 5.匿名内部类 没有类名 必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();



        // 6.用Lambda 简化
        like =() -> {
            System.out.println("i like lambda5");
        };
        like.lambda();

    }

    // 3. 静态内部类
    static class Like2 implements ILike {

        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }


}

//1.定义一个函数式接口
interface ILike {
    void lambda();
}

//2.实现类
class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }


}


