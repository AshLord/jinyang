package org.java.practice.java.collection;

import java.util.HashMap;

/**
 * Created by 晋阳 on 2017/12/17.
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Game Of Thrones");
        hashMap.put(2, "Redemption Of ShaneShawk");
        hashMap.put(2, "Limp Bizkit");

        String value = hashMap.get(2);
        System.out.println(value);
    }
}
