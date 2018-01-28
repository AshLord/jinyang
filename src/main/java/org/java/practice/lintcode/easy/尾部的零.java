package org.java.practice.lintcode.easy;

import java.math.BigInteger;

/**
 * @author yang.jin
 * date: 25/01/2018
 * desc:
 */
public class 尾部的零 {

    public static void main(String[] args) {
        尾部的零 test = new 尾部的零();
        System.out.println(test.trailingZeros(105));

    }

    /**
     * 第四次尝试：根据数学归纳法，发现问题规模n和尾部0个数的关系！
     * @param n
     * @return
     */
    public long trailingZeros2(long n) {
        return 0;
    }

    /**
     * 第一次尝试：超过long的最大范围之后，答案就已经不准确了
     * 第二次尝试：换成BigInteger试试，这次是可以了，但是。。。lintCode不让用BigInteger类。。。
     * 第三次尝试：强行import java.math.BigInteger; 这次编译是可以了，但是空间复杂度超了
     * @param n
     * @return
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        BigInteger result = BigInteger.ONE;
        for (int i=1;i<=n;i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        char[] resp = String.valueOf(result).toCharArray();
        int ans=0;
        for (int i=resp.length-1;i>=0;i--) {
            if (resp[i] == '0') {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}
