package com.tangwh.thread_Demo;

/**
 *  线程一
 */
public class ThreadJoinOne_Test extends Thread {


    public void run() {
        System.out.println("Thread one 线程启动");
        ThreadJoinTwo_Test two = new ThreadJoinTwo_Test();


        two.start();
        try {
            two.join(2000);//线程2 加入 线程1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread one 线程停止");

    }
}
