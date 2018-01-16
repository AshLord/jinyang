package org.java.practice.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author yang.jin
 * date: 16/01/2018
 * desc:
 */
public class TestParallelStream {

    public static void main(String[] args) {

        //首先我们创建一个没有重复元素的大表
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        TestParallelStream test = new TestParallelStream();
        new Thread(() -> test.parallelSort(values)).start();
        new Thread(() -> test.serialSort(values)).start();

    }

    public void serialSort(List<String> list) {
        long t0 = System.nanoTime();

        long count = list.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    public void parallelSort(List<String> list) {
        long t0 = System.nanoTime();

        long count = list.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }
}
