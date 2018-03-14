package org.java.practice.lintcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yang.jin
 * date: 14/03/2018
 * desc:
 */
public class LFU缓存 {
    public static void main(String[] args) {
        LFU缓存 lfu = new LFU缓存(3);
        /*lfu.set(2,2);
        lfu.set(1,1);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(2));
        lfu.set(3,3);
        lfu.set(4,4);
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(4));*/

        /*lfu.set(1, 10);
        lfu.set(2, 20);
        lfu.set(3, 30);
        lfu.get(1);
        lfu.set(4, 40);
        lfu.get(4);
        lfu.get(3);
        lfu.get(2);
        lfu.get(1);
        lfu.set(5, 50);
        lfu.get(1);
        lfu.get(2);
        lfu.get(3);
        lfu.get(4);
        lfu.get(5);*/

        lfu.set(1,1);
        lfu.set(2,2);
        lfu.set(3,3);
        lfu.get(1);
        lfu.get(2);
        lfu.get(3);
        lfu.set(4,4);
        lfu.get(1);
        lfu.get(2);
        lfu.get(3);
        lfu.get(4);
    }

    HashMap<Integer, Integer> cache;
    HashMap<Integer,Integer> count;
    HashMap<Integer,Integer> time;
    int cap;
    int version;

    public LFU缓存(int capacity) {
        // do intialization if necessary
        cache = new HashMap<>();
        count = new HashMap<>();
        time = new HashMap<>();
        cap = capacity;
        version = 0;
    }

    public void set(int key, int value) {
        // write your code here
        if (cache.size() == cap) {
            if (cache.containsKey(key)) {
                cache.put(key, value);
            } else {
                //根据LFU原则删除使用频率最少的元素
                int minCount = Integer.MAX_VALUE;
                for (Integer c : count.values()) {
                    if (c < minCount) {
                        minCount = c;
                    }
                }
                List<Integer> minKeys = new ArrayList<>();
                for (Integer k : count.keySet()) {
                    if (count.get(k) == minCount) {
                        minKeys.add(k);
                    }
                }
                //当频率最少使用的元素不止一个时，根据LRU原则删除时间最久未使用的元素
                int minKey = minKeys.get(0);
                for (Integer mk : minKeys) {
                    if (time.get(mk) < time.get(minKey)) {
                        minKey = mk;
                    }
                }
                count.remove(minKey);
                cache.remove(minKey);
                time.remove(minKey);
                //腾出空间set新元素
                cache.put(key, value);
                count.put(key, 0);
            }
        } else {
            if (cache.containsKey(key)) {
                cache.put(key, value);
            } else {
                cache.put(key, value);
                count.put(key, 0);
            }
        }
        time.put(key,version++);
    }

    public int get(int key) {
        // write your code here
        if (count.containsKey(key)) {
            count.put(key, count.get(key) + 1);
        }
        time.put(key,version++);
        System.out.print(cache.getOrDefault(key, -1)+" ");
        return cache.getOrDefault(key, -1);
    }
}
