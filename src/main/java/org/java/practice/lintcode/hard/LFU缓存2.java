package org.java.practice.lintcode.hard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author yang.jin
 * date: 14/03/2018
 * desc:
 */
public class LFU缓存2 {
    private Map<String, Node> cache = null;
    private int capacity = 0;
    private int used = 0;

    public LFU缓存2(int capacity) {
        cache = new HashMap<String, Node>(capacity, 0.75f);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(String.valueOf(key));
        if (node == null) {
            return -1;
        }
        node.useCount++;
        node.lastGetTime = System.nanoTime();
        return node.value;
    }

    public void set(int key, int value) {
        Node n = cache.get(String.valueOf(key));
        if (n != null) {
            n.useCount ++;
            n.lastGetTime = System.nanoTime();
            n.value = value;
            return;
        }else{
            Node node = new Node();
            node.value = value;
            node.useCount = 0;
            node.lastGetTime = System.nanoTime();
            if(this.capacity == 0)return;
            if (used < this.capacity) {
                used ++;
                cache.put(String.valueOf(key), node);
            } else {
                removeLast();
                cache.put(String.valueOf(key), node);
            }
        }
    }

    // 淘汰最少使用的缓存
    private void removeLast() {
        int minCount = Integer.MAX_VALUE;
        long getTime = System.nanoTime();
        String t = null;

        Iterator<String> it = cache.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            Node node = cache.get(key);
            if(node.useCount < minCount || (node.useCount == minCount && node.lastGetTime < getTime)){
                t = key;
                minCount = node.useCount;
                getTime = node.lastGetTime;
            }
        }
        cache.remove(t);

    }
    public class Node {
        public int value;
        public int useCount;
        public long lastGetTime;
    }
}
