package org.java.practice.lintcode.hard;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yang.jin
 * date: 12/03/2018
 * desc: 动态规划
 */
public class 骰子求和1 {
    public static void main(String[] args) {
        骰子求和1 test = new 骰子求和1();
        System.out.println(test.dicesSum(4));
    }

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        long[][] dp = new long[n + 1][6 * n + 1];
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        dp[1][5] = 1;
        dp[1][6] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                long x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0;
                if (j > 1) {
                    x1 = dp[i - 1][j - 1];
                }
                if (j > 2) {
                    x2 = dp[i - 1][j - 2];
                }
                if (j > 3) {
                    x3 = dp[i - 1][j - 3];
                }
                if (j > 4) {
                    x4 = dp[i - 1][j - 4];
                }
                if (j > 5) {
                    x5 = dp[i - 1][j - 5];
                }
                if (j > 6) {
                    x6 = dp[i - 1][j - 6];
                }
                dp[i][j] = x1 + x2 + x3 + x4 + x5 + x6;
            }
        }
        for (long[] e : dp) {
            for (long i : e) {
                String a = String.valueOf(i);
                StringBuilder sb = new StringBuilder();
                sb.append(a);
                for (int r=0;r<6-a.length();r++) {
                    sb.append(" ");
                }
                System.out.print(sb);
            }
            System.out.println();
        }
        List<Map.Entry<Integer, Double>> result = new ArrayList<Map.Entry<Integer, Double>>();
        for (int i = n; i <= 6 * n; i++) {
            AbstractMap.SimpleEntry<Integer, Double> entry = new AbstractMap.SimpleEntry<Integer, Double>(i, dp[n][i] / Math.pow(6, n));
            result.add(entry);
        }
        return result;
    }
}
