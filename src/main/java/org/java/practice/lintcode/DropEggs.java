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
