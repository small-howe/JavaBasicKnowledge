package com.tangwh.thread_Demo;

/**
 *  线程类
 */
public class Thread_Test /*extends Thread*/ implements  Runnable {
    String name;



    public Thread_Test(){};
    public Thread_Test(String name) {
        this.name = name;
    }



    // 重写run
    public void run() {

        for (int i =0;i<=100;i++){

            System.out.println(this.name+"跑到了"+i+"米");
        }
    }
}
