package org.java.practice.lintcode.medium;

/**
 * @author yang.jin
 * date: 20/03/2018
 * desc: 动态规划题
 */
public class 背包问题 {
    public static void main(String[] args) {
        背包问题 test = new 背包问题();
        //test.backPack(11, new int[]{2, 3, 5, 7});
        test.backPack2(11, new int[]{2, 3, 5, 7});
    }

    /**
     * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
     * 如果有4个物品[2, 3, 5, 7]
     * 如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。
     * 如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。
     *
     * @param m
     * @param A
     * @return
     */
    public int backPack(int m, int[] A) {
        int[][] dp = new int[A.length][m + 1];//动态规划矩阵
        for (int i = 0; i < A.length; i++) {//背包空间为0时，不管要放第几个物品，可装满的背包空间为0.
            dp[i][0] = 0;
        }
        for (int j = 1; j < m + 1; j++) {
            if (A[0] <= j) {//当第0个物品的空间小于等于当前背包空间j时
                dp[0][j] = A[0];//背包可装满的最大空间是第0个物品的体积
            } else {//当第0个物品的空间大于当前背包空间j时
                dp[0][j] = 0;//背包可装满的最大空间是0
            }
            for (int i = 1; i < A.length; i++) {//当放第1个到第A.length-1个物品时
                if (A[i] > j) {//若该物品所占空间大于背包总空间（无论怎样腾背包空间，该物品无法放入背包
                    dp[i][j] = dp[i - 1][j];//背包可装满的最大空间不变
                } else {//若该物品所占空间小于等于背包总空间,则需将背包空间腾出至少A[i]后，将该物品放入。放入新物品后背包最大可装满空间可能更大，也可能变小大，取大值作为背包空间为j且放第i个物品时可以有的最大可装满空间。
                    dp[i][j] = Math.max(dp[i - 1][j - A[i]] + A[i], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length - 1][m];
    }

    /**
     * 我的牛逼解法
     * @param m
     * @param A
     * @return
     */
    public int backPack2(int m, int[] A) {
        // write your code here

        //状态转移矩阵 dp[i][j] = 当有前i个物品，背包容量为j时，可放入的最大容量
        int[][] dp = new int[A.length][m + 1];
        //初始化状态转移矩阵
        for (int i=0;i<=m;i++) {
            if (A[0] <= i) {
                dp[0][i] = A[0];
            }
        }
        //状态转移方程 dp[i][j] = dp[i][k]+A[i]<=j ? max(dp[i-1][k]+A[i]) : break;
        for (int i=1;i<A.length;i++) {
            for (int j=0;j<=m;j++) {
                if (A[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - A[i]] + A[i], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length - 1][m];
    }
}
