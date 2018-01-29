package org.java.practice.lintcode.medium;

/**
 * @author yang.jin
 * date: 29/01/2018
 * desc: 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
 */
public class 统计数字 {

    public static void main(String[] args) {
        int n = 12;
        int k = 1;
        统计数字 test = new 统计数字();
        System.out.println(test.digitCounts(k, n));
    }

    /**
     * 第一次尝试：首先来个最简单的方法。
     * @param k
     * @param n
     * @return
     */
    public int digitCounts(int k, int n) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<=n;i++) {
            sb.append(i);
        }
        int ans = 0;
        char[] arr = sb.toString().toCharArray();
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == k + 48) {
                ans++;
            }
        }
        return ans;
    }
}
