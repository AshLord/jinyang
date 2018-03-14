package org.java.practice.lintcode.hard;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yang.jin
 * date: 14/03/2018
 * desc: 动态规划题
 */
public class 骰子求和2 {
    public static void main(String[] args) {
        骰子求和2 test = new 骰子求和2();
        System.out.println(test.dicesSum(1));
    }

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        List<Map.Entry<Integer, Double>> results = new ArrayList<>();
        double[][] f = new double[n + 1][6 * n + 1];

        for (int i = 1; i <= 6; ++i) {
            f[1][i] = 1.0 / 6;
        }
        // 第 i 个骰子的点数和情况，其情况由前 (i-1) 个 骰子的点数和推出
        for (int i = 2; i <= n; ++i) {
            // i 个骰子的点数和范围，必定为 [i, 6i]，全为1和全为6时，分别取得上下界
            for (int j = i; j <= 6 * i; ++j) {
                // 第 n 个骰子的点数只可能为 1到6
                for (int k = 1; k <= 6; ++k) {
                    // j-k 必须严格大于0 (因为在这题中，由于i和j的实际意义分别为，投掷次数，和点数总和，所以两者的最小值都不可能取到0)
                    if (j > k) {
                        //相应的，前(n-1)个骰子的点数和，就是 j-k，累加是为枚举所有能凑出 点数和为 j 的情况，并将出现概率求和
                        f[i][j] += f[i - 1][j - k];
                    }
                }
                // 在没有除以6之前，表示的是在最后一次掷出k点的情况下，n 次投掷得到的点数和为 j 的概率
                f[i][j] /= 6.0;
            }
        }

        /* 解释下 f[i][j] /= 6.0; 这句代码;
         ** 我觉得是用到了"条件概率公式"，P(A) = P（A|B）* P(B)
         ** 在 f[i][j] 还没有除以6时，它的意思是，在满足第n次掷出k点的情况下，n次总共透出点数和为j的概率，即为P（A|B）
         ** 而掷出k的概率，由于点数 k 在 1~6之间等可能分布，故为 1/6
         ** 所以除以6以后，它才是真正的 P(A)，其实本来该是在  f[i][j] += f[i - 1][j - k]; 句除以6，表示 "每种能凑出点数总和为 j 的情况出现的概率之和"，但既然先只是累加求和，求完和除以6，也是一样的，毕竟乘法有分配律
         **
         */
        //n个骰子点数和范围必为[n,6n]，只要将对应的double数组的元素组成pair压栈返回即可
        for (int i = n; i <= 6 * n; ++i) {
            results.add(new AbstractMap.SimpleEntry<>(i, f[n][i]));
        }

        return results;
    }

    /**
     * 太想当然了，以为答案符合正态分布规律，直接按正态分布去求解，结果自然就错了，这进一步证明了数学归纳法在算法设计中并不可靠！
     * @param n
     * @return
     */
    /*public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        int total = 5 * n + 1;
        int[] sums = new int[total];
        if (n == 1) {
            for (int i=0;i<total;i++) {
                sums[i] = 1;
            }
        } else {
            int mid;
            sums[0] = 1;
            if (total % 2 == 0) {
                mid = total / 2;
                for (int i=1;i<total;i++) {
                    if (i < mid) {
                        sums[i] = sums[i - 1] + 1;
                    } else if (i == mid){
                        sums[i] = sums[i - 1];
                    } else {
                        sums[i] = sums[i - 1] - 1;
                    }
                }
            } else {
                mid = total / 2 + 1;
                for (int i=1;i<total;i++) {
                    if (i < mid) {
                        sums[i] = sums[i - 1] + 1;
                    } else {
                        sums[i] = sums[i - 1] - 1;
                    }
                }
            }
        }
        List<Map.Entry<Integer, Double>> res = new ArrayList<>();
        int deno = (int) Math.pow(6, n);
        for (int i=n;i<=6*n;i++) {
            res.add(new AbstractMap.SimpleEntry<>(i,(double)sums[i-n]/deno));
        }
        return res;
    }*/
}
