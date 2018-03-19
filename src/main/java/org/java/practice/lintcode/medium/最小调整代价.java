package org.java.practice.lintcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.jin
 * date: 19/03/2018
 * desc: 动态规划题 我现在脑子疼，动态规划这种，真是特么牛逼，难成这逼样了，我也是服，想操翻它结果被摁在地板上反操，舒服了
 */
public class 最小调整代价 {
    public static void main(String[] args) {
        最小调整代价 test = new 最小调整代价();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);
        System.out.println(test.MinAdjustmentCost(list,1));
    }

    /**
     * 给一个整数数组，调整每个数的大小，使得相邻的两个数的差不大于一个给定的整数target，调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。
     * 你可以假设数组中每个整数都是正整数，且小于等于100。
     * 对于数组[1, 4, 2, 3]和target=1，最小的调整方案是调整为[2, 3, 2, 3]，调整代价之和是2。返回2。
     * @param A
     * @param target
     * @return
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        // 第一步 状态转移矩阵 dp[i][j] = A中第i个数改为数字j的代价
        int[][] dp = new int[A.size()][101];
        // 第二步 初始化状态矩阵
        for (int i=1;i<=101;i++) {
            dp[0][i] = Math.abs(A.get(0) - i);
        }
        // 第三步 状态转移方程 dp[i][j] = min( dp[i][j], 第i个元素和j的差绝对值 + min（dp[i-1][j-target],......,dp[i-1][j+target]） )

    }
}
