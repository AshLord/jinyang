package org.java.practice.java.util.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 晋阳 on 2017/12/17.
 */
public class ReadWriteLockTest {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();
    private Object value = "value";

    public Object handleRead() throws InterruptedException {
        try {
            readLock.lock();
            Thread.sleep(1000);
            return value;
        }finally{
            readLock.unlock();
        }
    }
    public Object handleWrite() throws InterruptedException {
        try {
            writeLock.lock();
            Thread.sleep(1000);
            return value;
        }finally{
            writeLock.unlock();
        }
    }

}
