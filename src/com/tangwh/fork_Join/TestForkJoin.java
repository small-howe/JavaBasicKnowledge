package com.tangwh.fork_Join;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @PROJECT_NAME: javaBasicKnowledge
 * @DESCRIPTION:
 * @USER: Howe
 * @DATE: 2020/7/12 22:40
 */
public class TestForkJoin {


    /**
     * ForkJoin 框架测试
     */
    @Test
    public void test01() {
        Instant start = Instant.now();
        // 线程池
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 1000000000L);

        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();

        System.out.println("耗费时间" + Duration.between(start, end).toMillis());
    }


    /**
     * 普通for 循环
     */
    @Test
    public void test02() {
        Instant start = Instant.now();
        long sum = 0L;

        for (int i = 0; i <= 1000000000L; i++) {
            sum += i;
        }

        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费时间" + Duration.between(start, end).toMillis());
    }

    /**
     * Java8并行流
     */
    @Test
    public void test03() {
        Instant start = Instant.now();
        LongStream.rangeClosed(0, 1000000000L)
                .parallel()// 并行流
                .reduce(0, Long::sum);

        Instant end = Instant.now();
        System.out.println("耗费时间" + Duration.between(start, end).toMillis());
    }
}
