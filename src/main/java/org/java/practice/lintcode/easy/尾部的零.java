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
        //long val = 5555550000000L;
        long val = 15;
        //long val = 100000;
        //long val = 103992;
        //System.out.println(test.trailingZeros(val));
        System.out.println("-----------------------");
        System.out.println(test.trailingZeros2(val));
        System.out.println("-----------------------");
        System.out.println(test.trailingZeros3(val));

    }

    /**
     * 哎，最终还是取看了网上的思路，原来思路是分解质因数！
     * 最终问题就转化成了求n因式分解后有多个个数字5！！
     * @param n
     * @return
     */
    public long trailingZeros3(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }

    /**
     * 第四次尝试：根据数学归纳法，发现问题规模n和尾部0个数的关系！
     * return n/5;错误，当n的规模大于100时，便不再适用！
     *
     * 第五次尝试：通过数学归纳法，终于发现规律：n/5^1+n/5^2+...+n/5^(位数-1)
     * 妈个巴子的还是不对！
     *
     * 第六次尝试：终于发现终极规律：n/5^1+n/5^2+...+n/5^(log5(n))
     * 妈了个巴子的还是不对！但是不知道为什么！总感觉应该没问题了啊！当n规模达到10位数的时候，就开始出问题了，神奇！！
     *
     * @param n
     * @return
     */
    public long trailingZeros2(long n) {
        int ans = 0;
        double total = Math.log(n) / Math.log(5);
        for (int i=1;i<=total;i++) {
            ans += n / Math.pow(5, i);
        }
        return ans;
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
