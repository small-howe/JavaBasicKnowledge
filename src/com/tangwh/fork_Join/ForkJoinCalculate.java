package com.tangwh.fork_Join;

import java.util.concurrent.RecursiveTask;

/**
 * @PROJECT_NAME: javaBasicKnowledge
 * @DESCRIPTION: 数的累加  继承RecursiveTask有返回值 RecursiveAction没返回值
 * @USER: Howe
 * @DATE: 2020/7/12 21:32
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

    // 提供序列号

    private static final long serialVersionUID = 134567889L;


    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public ForkJoinCalculate() {
    }

    // 拆分  开始的数(从哪开始累加)
    private long start;
    // 结尾的数 (加到那个数为止?)
    private long end;
   // 1 - 10000个累加
    // 临界值; (最小不可拆分数)
    private static final long THRESHOLD = 10000;

    @Override
    protected Long compute() {

        long length = end - start;

        if (length <= THRESHOLD) {
            // 如果到达临界值 开始 累加
            long sum = 0;
            for (long i = start; i <= end; i++) {
                // 数字累加
                sum += i;
            }
            return sum;
        } else {
            // 拆分子任务 一半一半 拆
            long middle = (start + end) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            // 拆分前半部分
            left.fork(); //拆分成子任务 同时压入线程队列
            //拆分后半部分
            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork(); //拆分子任务 同时压入线程队列
            return left.join() + right.join();
        }

    }
}
