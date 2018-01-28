package org.java.practice.java.util.concurrent.blockqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        //不设置的话，LinkedBlockingQueue默认capacity为Integer.MAX_VALUE
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);

        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);

        List<Thread> producerThreads = new ArrayList<>();
        List<Thread> consumerThreads = new ArrayList<>();
        for (int i=0;i<5;i++) {
            producerThreads.add(new Thread(producer, "" + (i + 1)));
            consumerThreads.add(new Thread(consumer));
        }
        producerThreads.forEach(Thread::start);
        Thread.sleep(1000);
        consumerThreads.forEach(Thread::start);

    }
}
