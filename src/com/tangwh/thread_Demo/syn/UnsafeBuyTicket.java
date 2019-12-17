package com.tangwh.thread_Demo.syn;

/*
   不安全的买票
 */
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        ByTicket byTicket = new ByTicket();

        new Thread(byTicket,"小明").start();
        new Thread(byTicket,"小红").start();
        new Thread(byTicket,"黄牛").start();
    }


}
class ByTicket implements Runnable{

    //票
    private int ticketNums = 10;

    boolean flag =true;

    @Override
    public void run() {
        // 买票
        while (flag){

            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //synchronized 同步方法 锁的是this
    private synchronized void buy() throws InterruptedException {

        // 判断是否有 票
        if (ticketNums <=0){
            flag =false;
            return;
        }
        // 模拟延迟
        Thread.sleep(1000);

        //买票
        System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--);
    }
}
