package com.tangwh.thread_Demo.deadlock;

/**
 * 死锁:多个线程互相抱着对方需要的资源 然后然后形成僵持
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 =new Makeup(0, "灰姑娘");
        Makeup g2 =new Makeup(1, "白雪公主");
        g1.start();
        g2.start();
    }
}

/**
 * 口红
 */
class Lipstick {

}

//镜子
class Mirror {

}

class Makeup extends Thread {

    // 需要的资源只有一份 用static来保证
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();


    int choice; // 选择
    String girlName; // 需要化妆的人

    Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;

    }

    @Override
    public void run() {
        makeup();
        // 化妆
    }

    //互相持有对方的资源
    private  void makeup(){
        if (choice==0){
            // 获得口红的锁
            synchronized (lipstick){
                System.out.println(this.girlName+"获得口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            // 一秒后 想获得镜子
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");

            }
        }else {
            // 获得镜子的锁
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 2秒后 想获得口红

            }
            synchronized (lipstick){
                System.out.println(this.girlName+"获得想获得口红的锁");

            }
        }

    }
}