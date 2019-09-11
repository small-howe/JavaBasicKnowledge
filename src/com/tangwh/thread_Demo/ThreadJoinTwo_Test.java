package com.tangwh.thread_Demo;
/**
 *  线程二
 */
public class ThreadJoinTwo_Test extends Thread {


    public void run() {
        System.out.println("Thread two 线程启动");
        ThreadJoinThree_Test three = new ThreadJoinThree_Test(this);
        three.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread two 线程停止");
    }
}
