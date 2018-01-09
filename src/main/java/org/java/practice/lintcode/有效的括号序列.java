package org.java.practice.lintcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 晋阳 on 2017/12/31.
 * 有效的括号序列
 */
public class 有效的括号序列 {

    public static void main(String[] args) {
        String s = "()[]{}";
        String s1 = "{([])[]}(){}";
        printString(s1);
        //解法1：失败，因为没有考虑{([])}的情况
        //System.out.println(isValidParentheses(s));
        //解法2：利用栈操作来实现
        System.out.println(useStack(s1));
    }

    public static boolean useStack(String s) {
        // write your code here
        char[] arr = s.toCharArray();
        if (arr.length % 2 != 0) {
            return false;
        }
        List<Character> stack = new ArrayList<>();
        stack.add(arr[0]);
        for (int i=1;i<arr.length;i++) {
            if (stack.size() == 0) {
                stack.add(arr[i]);
                continue;
            }
            if (stack.get(stack.size()-1) == '(') {
                if (arr[i]==')') {
                    stack.remove(stack.size() - 1);
                } else {
                    stack.add(arr[i]);
                }
            } else if (stack.get(stack.size()-1) == '[') {
                if (arr[i]==']') {
                    stack.remove(stack.size() - 1);
                } else {
                    stack.add(arr[i]);
                }
            } else if (stack.get(stack.size()-1) == '{') {
                if (arr[i]=='}') {
                    stack.remove(stack.size() - 1);
                } else {
                    stack.add(arr[i]);
                }
            } else {
                stack.add(arr[i]);
            }
        }
        return stack.size() == 0;

    }

    public static boolean isValidParentheses(String s) {
        // write your code here
        char[] array = s.toCharArray();
        if (array.length % 2 != 0) {
            return false;
        }
        for (int i = 0;i<array.length;i=i+2) {
            if (array[i] == '(' && array[i+1] != ')') {
                return false;
            }
            if (array[i] == '[' && array[i+1] != ']') {
                return false;
            }
            if (array[i] == '{' && array[i+1] != '}') {
                return false;
            }
        }
        return true;
    }

    private static void printString(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
