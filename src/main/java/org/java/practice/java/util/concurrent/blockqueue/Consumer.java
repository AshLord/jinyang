package org.java.practice.java.util.concurrent.blockqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String temp = queue.take();
            System.out.println("消费者：" + temp + ";队列长度："+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
