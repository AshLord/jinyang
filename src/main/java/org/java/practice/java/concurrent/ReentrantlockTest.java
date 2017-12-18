package org.java.practice.java.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 晋阳 on 2017/12/17.
 */
public class ReentrantlockTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);//实现一个公平锁

        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) { //如果已经被lock，尝试等待5s，看是否可以获得锁，如果5s后仍然无法获得锁则返回false继续执行
                lock.lockInterruptibly();//可以响应中断事件
                try {
                    //操作
                    Condition condition = lock.newCondition();
                    condition.await(5, TimeUnit.SECONDS);

                } finally {
                    lock.unlock();//释放锁
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace(); //当前线程被中断时(interrupt)，会抛InterruptedException
        }
    }
}
