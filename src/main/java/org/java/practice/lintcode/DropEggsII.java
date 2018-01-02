package org.java.practice.lintcode;

/**
 * @author yang.jin
 * date: 02/01/2018
 * desc:There is a building of n floors. If an egg drops from the k th floor or above, it will break. If it‘s dropped from any floor below, it will not break.
You‘re given m eggs, Find k while minimize the number of drops for the worst case. Return the number of drops in the worst case.
Example
Given m = 2, n = 100 return 14
Given m = 2, n = 36 return 8
 */
public class DropEggsII {

    /**
     * 实现思路：
     *  动态规划+递归。用二元数组存储某鸡蛋某层所需的次数。迭代试扔第一个鸡蛋，在某层扔。
     *  1.扔碎了即转为鸡蛋少一个，楼层少一层的子问题。
     *  2.没扔碎即转化为鸡蛋没有少楼层少为上半层那么多的子问题。
     * @param m m个鸡蛋
     * @param n n层楼
     * @return
     */
    public static int dropEggs2(int m, int n) {
        // write your code here
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++){
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int j = 1; j <= n; j++){
            dp[1][j] = j;
        }

        for (int i = 2; i <= m; i++){
            for (int j = 2; j <= n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 1; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j],
                            1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]));
                }
            }
        }
        return dp[m][n];
    }

    public static int anotherThought(int m, int n) {
        // Write your code here
        int[][] state = new int[n + 1][m + 1];
        for (int i = 1; i < m + 1; i++) {
            state[1][i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            state[i][1] = i;
        }
        for (int i = 2; i < n + 1; i++) {//n ---> floor
            for (int j = 2; j < m + 1; j++) {//m ---> eggs
                int min = Integer.MAX_VALUE;
                for (int k = 1; k < i + 1; k++) {
                    min = Math.min(Math.max(state[k - 1][j - 1], state[i - k][j]),min);
                }
                state[i][j] = min + 1;
            }
        }
        return state[n][m];
    }

    public static void main(String[] args) {
        System.out.println(dropEggs2(2, 100));
        System.out.println(anotherThought(2,100));
    }

}
