package org.java.practice.lintcode.medium;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        System.out.println(test.nthUglyNumber(100));
        System.out.println(test.nthUglyNumber2(599));
        System.out.println(test.nthUglyNumber3(599));
        System.out.println(test.nthUglyNumber4(599));
    }

    /**
     * 结果快出来了
     * @param n
     * @return
     */
    public int nthUglyNumber4(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int i = 0;
        while (i < n) {
            if (ugly[p2] * 2 > ugly[p3] * 3) {
                if (ugly[p5] * 5 > ugly[p3] * 3) {
                    ugly[i+1] = ugly[i] * 3;
                    i++;
                    p3++;
                } else {
                    ugly[i+1] = ugly[i] * 5;
                    i++;
                    p5++;
                }
            } else {
                if (ugly[p5] * 5 > ugly[p2] * 2) {
                    ugly[i+1] = ugly[i] * 2;
                    i++;
                    p2++;
                } else {
                    ugly[i+1] = ugly[i] * 5;
                    i++;
                    p5++;
                }
            }
        }
        return ugly[n - 1];
    }

    /**
     * 第三次尝试：基于第二种可行解法各种花式优化，可是还是复杂度超了
     * @param n
     * @return
     */
    public int nthUglyNumber3(int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int val = 2;
        while (list.size() < n) {
            if (val % 2 != 0 && val % 3 != 0 && val % 5 != 0) {
                val++;
                continue;
            }
            if (val % 7 == 0 || val % 11 == 0 || val % 13 == 0) {
                val++;
                continue;
            }
            int temp = val;
            /*if (list.size() > 5) {
                for (int i=list.size()-1;i>=0;i--) {
                    if (temp % list.get(i) == 0) {
                        temp /= list.get(i);
                    }
                    if (temp <= 5) {
                        break;
                    }
                }
            }*/
            while (temp % 2 == 0) {
                temp /= 2;
            }
            while (temp % 3 == 0) {
                temp /= 3;
            }
            while (temp % 5 == 0) {
                temp /= 5;
            }
            if (temp == 1) {
                list.add(val);
            }
            val++;
        }
        return list.get(list.size()-1);
    }

    /**
     * 第二次尝试，不论数据集多大，都可以得到正确结果。但是时间复杂度还是超了
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        int val = 1;
        while (list.size() < n) {
            int temp = val;
            while (temp % 2 == 0) {
                temp /= 2;
            }
            while (temp % 3 == 0) {
                temp /= 3;
            }
            while (temp % 5 == 0) {
                temp /= 5;
            }
            if (temp == 1) {
                list.add(val);
            }
            val++;
        }
        return list.get(list.size()-1);
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
