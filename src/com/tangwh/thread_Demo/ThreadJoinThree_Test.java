package com.tangwh.thread_Demo;
/**
 *  线程三
 */
public class ThreadJoinThree_Test extends  Thread {
    private ThreadJoinTwo_Test two;

    public ThreadJoinThree_Test(ThreadJoinTwo_Test two) {
        this.two = two;
    }

    @Override
    public void run() {
        // 在 two 执行时   one 等待时候 Three锁定 two

        System.out.println(" Thread Three 启动");
        synchronized(two){
            System.out.println("Two 被锁定");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Two 被释放");
        }

        System.out.println(" Thread Three 停止");
    }
}
