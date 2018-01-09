package org.java.practice.lintcode;

/**
 * Created by 晋阳 on 2018/1/7.
 */
public class TimeComplexity {

    public static void main(String[] args) {
        int count1 = 0;
        int count2 = 0;
        int x = 91;
        int y = 100;
        while (y > 0) {
            if (x > 100) {
                count1++;
                x = x - 10;
                y--;
            } else {
                count2++;
                x++;
            }
        }
        System.out.println("if语句执行次数："+count1);
        System.out.println("else语句执行次数："+count2);
    }
}
