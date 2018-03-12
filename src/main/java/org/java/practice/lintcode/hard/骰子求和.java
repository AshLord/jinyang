package org.java.practice.lintcode.hard;

import java.util.*;
/**
 * @author yang.jin
 * date: 12/03/2018
 * desc: 空间复杂度超了
 */
public class 骰子求和 {
    public static void main(String[] args) {
        骰子求和 test = new 骰子求和();
        System.out.println(test.dicesSum(3));
    }

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        this.res = new ArrayList<>();
        this.counts = new HashMap<>();
        this.n = n;
        List<Integer> tmp = new ArrayList<>();
        helper(tmp);
        int totalSum = (int) Math.pow(6,n);
        counts.forEach((k,v)-> res.add(new AbstractMap.SimpleEntry<>(k, (double)v/totalSum)));
        return res;
    }

    private int[] dice = {1, 2, 3, 4, 5, 6};
    private List<Map.Entry<Integer, Double>> res = null;
    private Map<Integer, Integer> counts = null;
    private int n = 0;
    public void helper(List<Integer> tmp) {
        if (tmp.size() == n) {
            int sum = 0;
            for (Integer i : tmp) {
                sum += i;
            }
            if (counts.containsKey(sum)) {
                Integer old = counts.get(sum);
                counts.put(sum, old + 1);
            } else {
                counts.put(sum, 1);
            }
            return;
        }
        for (int i=0;i<dice.length;i++) {
            tmp.add(dice[i]);
            helper(tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}
