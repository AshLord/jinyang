package org.java.practice.java.util.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yang.jin
 * date: 21/12/2017
 * desc:
 */
public class CallableAndFuture {

    public static void main(String[] args) {

        // 新开一个线程，并且可以返回结果
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // 产生一个0~99的伪随机数
                return new Random().nextInt(100);
            }
        };

        // 创建一个Future任务，收集Callable的结果
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try {
            Thread.sleep(5000);// 可能做一些事情
            if (future.isDone()) {
                System.out.println(future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
