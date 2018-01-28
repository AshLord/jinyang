package org.java.practice.java.util.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by 晋阳 on 2017/12/17.
 */
public class SemaphoreLearn {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, true);
        try {
            //尝试获得一个准入的许可。若无法获得，则线程会等待，知道有线程释放一个许可或者当前线程被中断。
            semaphore.acquire();

            //类似于acquire()，但是不会响应中断。
            semaphore.acquireUninterruptibly();

            // 尝试获取，如果成功则为true，否则false。这个方法不会等待，立即返回。
            boolean availableImmediatly = semaphore.tryAcquire();

            // 尝试等5s
            boolean availableAfterFiveSec = semaphore.tryAcquire(5, TimeUnit.SECONDS);

            //用于在现场访问资源结束后，释放一个许可，以使其他等待许可的线程可以进行资源访问。
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
