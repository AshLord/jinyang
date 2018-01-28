package org.java.practice.java.util.concurrent.blockqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("生产者："+Thread.currentThread().getName()+ ";队列长度："+queue.size());
            //如果队列是满的话，会阻塞当前线程
            queue.put(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
