package com.tangwh.thread_Demo;

import java.util.concurrent.*;


public class Test_ThreadPool {

    public static void main(String[] args) {


        //有且仅有一个线程工作
        //队列无穷大，慢慢的一个一个来。
        Executors.newSingleThreadExecutor();//简单线程，就一个线程，也太少了
        //和SingleThread线程池逻辑一模一样，只不过这个指定了线程数。
        //队列无穷大。
        Executors.newFixedThreadPool(10);//就这么点线程，任务多了就得堆积
        // 当达到核心线程数之后，就创建新的线程，可以创建无穷多个线程。
        // 新开出来的线程，只要完成了，就销毁。
        Executors.newScheduledThreadPool(10);//安排（任务堆积很多的时候，当有线程完成任务时，居然不复用，居然得先销毁再创建）
        //没有核心线程数，都是临时工，没有正式员工。
        //来了任务就干，干完等一会儿，要是还有活儿就继续干，要是等了一分钟还没有活，就不干了（销毁）
        Executors.newCachedThreadPool();//缓存（不适用与任务间隔比较长（超过一分钟）的清空）

        Executors.newWorkStealingPool();// 不建议使用的，容易引起雪崩效应。适合非常消耗CPU的性能，且非常耗时的操作。如果是任务独享机器，并且很耗费性能，很耗时。

        //Java线程池本质只有一个。
        //无论哪个线程池，都是调用ThreadPoolExecutor线程池创建出来的。
        //为什么不同的线程池会有不同的特性呢？参数不一样。
        //ThreadPoolExecutor使用这个类来进行自定义。
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,120L,TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        //public ThreadPoolExecutor(int corePoolSize,
        //                              int maximumPoolSize,
        //                              long keepAliveTime,
        //                              TimeUnit unit,
        //                              BlockingQueue<Runnable> workQueue,
        //                              ThreadFactory threadFactory,
        //                              RejectedExecutionHandler handler)
        //
        //（1） corePoolSize 核心线程数  10
        //（2） maximumPoolSize 最大线程数 20
        //（3） keepAliveTime 保持活跃的时间 120
        //（4） unit 时间的单位 s
        //（5） workQueue 等待队列
        //（6） threadFactory 创建线程的工厂
        //（7） handler 拒绝策略


        //1. 线程池在刚创建完成的时候，有几个线程？
        //线程池在刚创建出来的时候，里面一个线程都没有。
        //2. 什么时候才会有线程？
        //在我们向线程池提交任务的时候，线程池才会开始创建线程。
        //3. 如果核心线程数是10，最大线程数是20。当我们提交第11个任务的时候（前十个没有结束），线程池会创建新的线程吗？
        // 不会的。线程池创建线程的策略：先把核心线程数填满，然后填满等待队列，等待队列如果满了，就创建新的线程但是总线程数不能大于最大线程数。

        // 银行平时就开三个窗口（核心线程数），今天来的人多，有人需要等待。
        // 等待的人就坐在大厅里，这个大厅就是（等待队列）。
        // 如果大厅坐满了，银行会觉得今天人太多了，我们得多开几个窗口，此时银行会开启更多窗口。
        // 但是不可能大于总得窗口数（最大线程数）。

        // 当银行开启了足够多得窗口之后，大厅中得人数明显开始减少了。
        // 当大厅中的人都办完业务离开,2分钟之后(保持活跃的时间, 单位)，后开的那些窗口，觉得自己任务完成了，就会将窗口关闭。

        // 当银行开启了足够多的窗口之后，大厅中的人数还在增加，并且装不下了。
        // 此时银行会告知后来的人，今天可能办不完业务了（拒绝策略），可以明天再来。

        // 希望有最基本的线程数，任务多的时候，可以创建新的线程。但是还希望，
        // 多创建出来的线程，当任务比较堆积的时候，不要立即销毁，还能够继续执行任务，
        // 当真的完全没有任务的时候再销毁。
        new ThreadPoolExecutor(
                50,
                100,
                120L,
                TimeUnit.SECONDS,
//                new LinkedBlockingQueue(1)
                new SynchronousQueue()
        );
    }
    }
