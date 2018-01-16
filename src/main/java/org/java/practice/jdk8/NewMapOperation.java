package org.java.practice.jdk8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang.jin
 * date: 16/01/2018
 * desc:
 */
public class NewMapOperation {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        NewMapOperation test = new NewMapOperation();
        test.newOperations(map);

    }

    public void newOperations(Map<Integer, String> map) {
        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);
        // val33
        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);
        // false
        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);
        // true
        map.computeIfAbsent(3, num -> "bam");
        map.get(3);
        // val33


        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9);
        // val9

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);
        // val9concat
    }
}
