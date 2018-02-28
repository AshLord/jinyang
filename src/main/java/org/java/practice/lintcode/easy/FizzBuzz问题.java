package org.java.practice.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.jin
 * date: 28/02/2018
 * desc:
 */
public class FizzBuzz问题 {

    /**
     给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：

     如果这个数被3整除，打印fizz.
     如果这个数被5整除，打印buzz.
     如果这个数能同时被3和5整除，打印fizz buzz.
     */
    public static void main(String[] args) {
        FizzBuzz问题 test = new FizzBuzz问题();
        List<String> list = test.fizzBuzz(15);
        for (String str : list) {
            System.out.print(str+" ");
        }
    }

    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> list = new ArrayList<>();
        for (int i=1;i<=n;i++) {
            boolean isFizz = false;
            boolean isBuzz = false;
            StringBuilder a = new StringBuilder();
            if (i % 3 == 0) {
                a.append("fizz");
                isFizz = true;
            }
            if (i % 5 == 0) {
                if (isFizz) {
                    a.append(" buzz");
                } else {
                    a.append("buzz");
                }
                isBuzz = true;
            }
            if (!isFizz && !isBuzz) {
                a.append(i);
            }
            list.add(a.toString());
        }
        return list;
    }
}
