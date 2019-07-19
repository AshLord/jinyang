package org.java.practice.java.util.concurrent;

import org.springframework.scheduling.config.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * TODO
 *
 * @author jinyang
 * @date 2019/3/27 0027.
 */
public class FutureTask {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        ExecutorService exs = Executors.newFixedThreadPool(5);
        try {
            int taskCount = 10;
            List<Integer> list = new ArrayList<>();
            CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(exs);
            for (int i = 0; i < taskCount; i++) {
                completionService.submit(new Task(i + 1));
            }
            for (int i = 0; i < taskCount; i++) {
                Integer result = completionService.take().get();
                System.out.println("任务i==" + result + "完成!" + LocalDate.now());
                list.add(result);
            }
            System.out.println("list = " + Arrays.toString(list.toArray()));
            System.out.println("总耗时=" + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exs.shutdown();
        }
    }

    static class Task implements Callable<Integer> {
        Integer i;

        public Task(Integer i) {
            super();
            this.i = i;
        }

        @Override
        public Integer call() throws Exception {
            if (i == 1) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程：" + Thread.currentThread().getName() + "任务i=" + i + ",执行完成！");
            return i;
        }
    }
}
