package org.java.practice.java.concurrent.atomic;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 晋阳 on 2017/12/17.
 */
public class TestAtomic {
    private static final int MAX_THREADS = 3;
    private static final int TASK_COUNT = 3;
    private static final int TARGET_COUNT = 100 * 10000;
    private AtomicInteger acount = new AtomicInteger(0);
    private int count = 0;

    synchronized int inc() {
        return ++count;
    }

    synchronized int getCount() {
        return count;
    }

    public class SyncThread implements Runnable {
        String name;
        long startTime;
        TestAtomic out;

        public SyncThread(TestAtomic o, long startTime) {
            this.out = o;
            this.startTime = startTime;
        }

        @Override
        public void run() {
            int v = out.inc();
            while (v < TARGET_COUNT) {
                v = out.inc();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("SyncThread spend:" + (endTime - startTime) + "ms" + ", v=" + v);
        }
    }

    public class AtomicThread implements Runnable {
        String name;
        long startTime;

        public AtomicThread(long startTime) {
            this.startTime = startTime;
        }

        @Override
        public void run() {
            int v = acount.incrementAndGet();
            while (v < TARGET_COUNT) {
                v = acount.incrementAndGet();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("AtomicThread spend:" + (endTime - startTime) + "ms" + ", v=" + v);
        }
    }

    @Test
    public void testSync() throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long startTime = System.currentTimeMillis();
        SyncThread sync = new SyncThread(this, startTime);
        for (int i = 0; i < TASK_COUNT; i++) {
            exe.submit(sync);
        }
        Thread.sleep(10000);
    }

    @Test
    public void testAtomic() throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
        long startTime = System.currentTimeMillis();
        AtomicThread atomic = new AtomicThread(startTime);
        for (int i = 0; i < TASK_COUNT; i++) {
            exe.submit(atomic);
        }
        Thread.sleep(10000);
    }

    /**
     * 测试结果如下：
     testSync():
     SyncThread spend:201ms, v=1000002
     SyncThread spend:201ms, v=1000000
     SyncThread spend:201ms, v=1000001
     testAtomic():
     AtomicThread spend:43ms, v=1000000
     AtomicThread spend:44ms, v=1000001
     AtomicThread spend:46ms, v=1000002

     相信这样的测试结果将内部锁和非阻塞同步算法的性能差异体现的非常明显。
     因此笔者更推荐直接视同atomic下的这个原子类。
     */
}
