package org.java.practice.lintcode;

import java.util.Random;

/**
 * Created by 晋阳 on 2017/12/31.
 */
public class DropEggs {

    public static void main(String[] args) throws Exception {

        //二分法查找，效率低
        System.out.println(dropEggs(100));

        //分析得出一元二次方程，解方程即可
        System.out.println(equation(2147483647));

        //网上这帮人也太厉害了吧，畜生吧
        System.out.println(dropEggsStandard(100));
    }

    /**
     * 思路：
     * 代码不长但比较难理解的题，优化最坏情况，用第一个鸡蛋判断区间，第二个鸡蛋判断层数，每增加一层区间，该区间的层数就减一，可记住做法
     * @param n
     * @return
     */
    public static int dropEggsStandard(int n) {
        //该区间的层数
        long ans = 0;
        //区间数
        int count = 0;
        while (ans < n) {
            count++;
            ans = ans + count;
        }

        return count;
    }

    public static int equation(int n) throws Exception {
        // write your code here
        double deltaSqrt = Math.sqrt(8 * (double)n + 1);
        int result1 = (int) Math.ceil((-deltaSqrt - 1) / 2);
        if (result1 > 0) {
            return result1;
        }
        int result2 = (int) Math.ceil((deltaSqrt - 1) / 2);
        if (result2 > 0) {
            return result2;
        }
        return 0;
    }

    public static int dropEggs(int n) {
        // write your code here
        int time = 0;
        int half = n / 2;
        int k = new Random().nextInt(n - 1) + 1;
        if (half >= k) {//broke
            for (int i = 1;i<=half;i++) {
                time++;
                if (i == k) {
                    break;
                }
            }
        } else {
            for (int i=half+1;i<=n;i++) {
                time++;
                if (i == k) {
                    break;
                }
            }
        }
        return time;
    }
}
