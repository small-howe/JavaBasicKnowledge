package com.tangwh.thread_Demo;

/**
 * 博士
 */
public class Doctor_Test  extends Thread {
    private String DoctorName;//博士名字

    private Chopsticks_Test left;
    private Chopsticks_Test right;
    private long time;

    public Doctor_Test(String doctorName, Chopsticks_Test left, Chopsticks_Test right,long time) {
        DoctorName = doctorName;
        this.left = left;
        this.right = right;
        this.time =time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized(left) {
            System.out.println(this.DoctorName + "拿起了" + this.left.getNum() + "左手筷子");

            synchronized(right) {
                System.out.println(this.DoctorName + "拿起了" + this.right.getNum() + "右手筷子");

                System.out.println(this.DoctorName+"开始吃饭");
            }

        }
    }
}
