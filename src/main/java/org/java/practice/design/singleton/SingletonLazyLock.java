package org.java.practice.design.singleton;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Desc: 单例模式-读写锁头懒加载
 * Date: 22/11/2017
 *
 * @author yang.jin
 */
public class SingletonLazyLock {
    private static SingletonLazyLock instance = null;
    private SingletonLazyLock(){};

    //加读写锁
    private static ReadWriteLock rwl = new ReentrantReadWriteLock();

    /**
     * 单例模式 懒加载并发
     * @return
     */
    public static SingletonLazyLock getInstance(){
        rwl.readLock().lock();
        try {
            if (null == instance){
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                if(null == instance){
                    instance = new SingletonLazyLock();
                }
                rwl.writeLock().unlock();

            }
            rwl.readLock().lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }

        return instance;
    }
}
