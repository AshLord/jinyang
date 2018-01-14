package org.java.practice.lintcode;

/**
 * Created by 晋阳 on 2018/1/13.
 */
public class 斐波那契数列 {

    public static void main(String[] args) {
        int maxn = 20;
        //递归
        System.out.println(func(maxn));
        //DP
        System.out.println(dpFunc(maxn));
    }

    /**
     * 递归实现
     */
    private static long func(int n) {
        if (n == 0 || n == 1){
            return 1;
        } else {
            return func(n - 1) + func(n - 2);
        }
    }

    /**
     * DP实现
     */
    private static long dpFunc(int n) {

        //构建状态转移矩阵
        long state[] = new long[n+1];

        //初始化状态转移矩阵
        state[0] = 1;
        state[1] = 1;

        //状态转移方程
        for (int i=2;i<=n;i++) {
            state[i] = state[i - 1] + state[i - 2];
        }

        return state[n];
    }
}
