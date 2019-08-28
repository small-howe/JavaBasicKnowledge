package com.tangwh.gc_Demo;

public class gc_Test {
    public static void main(String[] args) throws InterruptedException {
        Person p = new Person();
        Thread.sleep(1000);
        p = null;
        System.gc();

        /**
         * 为了能看到 对象回收的效果   重写finalize()方法
         */
        Runtime r = Runtime.getRuntime();
        long maxMemory = r.maxMemory();
        long totalMemory = r.totalMemory();
        long freeMemory = r.freeMemory();
        System.out.println(maxMemory);
        System.out.println(totalMemory);
        System.out.println(freeMemory);

    }
}
