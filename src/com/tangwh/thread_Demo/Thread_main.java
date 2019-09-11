package com.tangwh.thread_Demo;

import javax.print.Doc;

/**
 * 线程测试
 */
public class Thread_main {
    public static void main(String[] args) {


//        Warehouse warehouse = new Warehouse(); // 里面有一个ArryaList对象 线程非安全
//        ProducerModel_Test pro = new ProducerModel_Test(warehouse); // 生产者
//        pro.setPriority(10);// 设置线程级别
//
//        ConsumerModel_Test co = new ConsumerModel_Test(warehouse); // 消费者
//         ConsumerModel_Test co1 = new ConsumerModel_Test(warehouse); // 消费者
//        pro.start();
//        co.start();
//
//        co1.start();

//ThreadJoinOne_Test one = new ThreadJoinOne_Test();
//
//one.start();


        Chopsticks_Test cho1 = new Chopsticks_Test(1);
        Chopsticks_Test cho2 = new Chopsticks_Test(2);
        Chopsticks_Test cho3 = new Chopsticks_Test(3);
        Chopsticks_Test cho4 = new Chopsticks_Test(4);

        Doctor_Test d1 = new Doctor_Test("博士1", cho2, cho1,0);
        Doctor_Test d2 = new Doctor_Test("博士2", cho3, cho2,3000);
        Doctor_Test d3 = new Doctor_Test("博士3", cho4, cho3,0);
        Doctor_Test d4 = new Doctor_Test("博士4", cho1, cho4,3000);

        d1.start();
        d2.start();
        d3.start();
        d4.start();











//        // 创建一个线程
//        Thread_Test ts = new Thread_Test("邓超");
//        Thread_Test ts1 = new Thread_Test("贝贝");
//        Thread_Test ts2 = new Thread_Test("李晨");
//        // 调用start 方法  让线程进入就绪状态
//        // 实现 Runnable   要想执行 start 方法必须 让 Thread 把对象包装起来
//        Thread th = new Thread(ts);
//        Thread th1 = new Thread(ts1);
//        Thread th2 = new Thread(ts2);
//        th.start();
//        th1.start();
//        th2.start();


//       ts.start(); // 从 Thread 类中继承过来的
//        ts1.start();
//        ts2.start();

//        ts.run(); //如果调用了 run 方法就不是多线程了
//        ts1.run();
//        ts2.run();

    }
}
