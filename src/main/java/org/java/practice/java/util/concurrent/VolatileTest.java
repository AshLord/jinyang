package org.java.practice.java.util.concurrent;

/**
 * Created by yang.jin on 10/10/2017.
 *
 * Volatile
 * 多线程可见性（多线程不安全）利用空操作指令设置内存栅栏
 * 禁止指令重排序优化
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        //等待所有累加线程都结束
        while (Thread.activeCount() > 1)
            Thread.yield();
        System.out.println(race);
    }

    /**
     * 接下来的代码展示volatile的使用场景
     */
    volatile boolean shutdownRequested;

    public void shutdown() {
        shutdownRequested = true;
    }

    public void doWork() {
        while (!shutdownRequested) {
            //do stuff
        }
    }
}
