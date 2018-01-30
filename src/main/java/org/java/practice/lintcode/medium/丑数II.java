package org.java.practice.lintcode.medium;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author yang.jin
 * date: 30/01/2018
 * desc: 设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
    符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 */
public class 丑数II {

    public static void main(String[] args) {
        丑数II test = new 丑数II();
        System.out.println(test.nthUglyNumber(9));
    }

    /**
     * 第一次尝试：注意max的值必须足够大，才能保证程序的正确性，否则有些比较小的值在范围外，不能包含在内，导致返回结果错误！
     * 但是同时这样的计算量会直接导致时间复杂度超立方阶。
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        // write your code here
        TreeSet<BigDecimal> set = new TreeSet<>();
        //这个值必须足够大才能得到正确结果
        int max = 20;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                for (int k = 0; k < max; k++) {
                    set.add(BigDecimal.valueOf(Math.pow(2, i)).multiply(BigDecimal.valueOf(Math.pow(3, j))).multiply(BigDecimal.valueOf(Math.pow(5, k))));
                }
            }
        }

        Iterator<BigDecimal> iterator = set.iterator();
        System.out.println("set长度："+set.size());
        int count = 0;
        while (iterator.hasNext() && count < n-1) {
            iterator.next();
            count++;
        }

        return iterator.next().intValue();
    }
}
