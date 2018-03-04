package org.java.practice.lintcode.medium;

import java.util.*;

/**
 * @author yang.jin
 * date: 04/03/2018
 * desc:给定一个含不同整数的集合，返回其所有的子集
 * 子集中的元素排列必须是非降序的，解集必须不包含重复的子集
 */
public class 子集 {

    public static void main(String[] args) {
        子集 test = new 子集();
        System.out.println(test.subsets(new int[]{1, 2, 3}));
    }

    /**
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        this.nums = nums;
        //todo 因为有递增的要求，所有遍历递归的情况：以1开头的所有子集，以2开头的所有子集......
        return res;
    }
    private int[] nums;
    private List<List<Integer>> res;
}
