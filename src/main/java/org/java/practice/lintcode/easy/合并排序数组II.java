package org.java.practice.lintcode.easy;

import java.util.Arrays;

import static org.java.practice.algorithm.InsertionSort.printArray;

/**
 * @author yang.jin
 * date: 05/02/2018
 * desc: 合并两个排序的整数数组A和B变成一个新的数组。
 * 给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
 */
public class 合并排序数组II {

    public static void main(String[] args) {
        合并排序数组II test = new 合并排序数组II();
        int[] A = {1,2,3,4};
        int[] B = {2,4,5,6};
        printArray(test.mergeSortedArray(A, B));
        printArray(test.mergeSortedArray1(A, B));
    }

    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int[] ans = new int[A.length + B.length];
        System.arraycopy(A, 0, ans, 0, A.length);
        System.arraycopy(B, 0, ans, A.length, B.length);
        Arrays.sort(ans);
        return ans;
    }

    public int[] mergeSortedArray1(int[] A, int[] B) {
        // write your code here
        int ai = 0;
        int bi = 0;
        int ansi = 0;
        int[] ans = new int[A.length + B.length];
        while (ansi < ans.length) {
            if (ai == A.length) {
                //此时说明A元素已经都添加到ans里面了,剩下的操作只要把剩下的B都填满就OK
                ans[ansi] = B[bi];
                bi++;
            } else if (bi == B.length) {
                //此时说明B元素已经都添加到ans里面了,剩下的操作只要把剩下的A都填满就OK
                ans[ansi] = A[ai];
                ai++;
            } else if (A[ai] < B[bi]) {
                ans[ansi] = A[ai];
                ai++;
            } else {
                ans[ansi] = B[bi];
                bi++;
            }
            ansi++;
        }
        return ans;
    }

}
