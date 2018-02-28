package org.java.practice.lintcode.easy;

/**
 * @author yang.jin
 * date: 28/02/2018
 * desc:
 */
public class 字符串查找 {

    public static void main(String[] args) {
        字符串查找 test = new 字符串查找();
        System.out.println(test.strStr("abcdabcdefg", "bcd"));

    }

    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }
        if (source.contains(target)) {
            return source.indexOf(target);
        } else {
            return -1;
        }

    }
}
