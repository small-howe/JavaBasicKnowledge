package com.tangwh.thread_Demo.juc;

import java.util.concurrent.CopyOnWriteArrayList;

// 测试JUC安全
public class TestJuc {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
        for (int i = 0; i < 10000; i++) {
            new Thread(
                    ()->{
                        list.add(Thread.currentThread().getName());
                    }
            ).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
