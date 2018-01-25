package org.java.practice.lintcode.easy;

/**
 * @author yang.jin
 * date: 25/01/2018
 * desc:给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 */
public class A加B {

    public static void main(String[] args) {
        A加B a加B = new A加B();
        int a = 12, b = 3;
        System.out.println(a加B.aplusb(a, b));
    }

    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        int c = 0,d = 0;
        while((a&b) != 0){//检查a和b之间是否有进位
            c = a^b; //忽略进位相加
            d = (a&b)<<1;//应该进位的值
            a = c;
            b = d;
        }
        return a|b;//没有进位了，直接返回两者|值
    }

    int aplusb2(int a, int b) {
        if((a&b) == 0) {
            return a | b;
        }
        return aplusb(a^b,(a&b)<<1);
    }
}
