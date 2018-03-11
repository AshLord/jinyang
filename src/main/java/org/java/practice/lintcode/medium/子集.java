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
        //List<List<Integer>> anss = test.subsets(new int[]{1, 2, 3});
        List<List<Integer>> anss = test.subsets(new int[]{0, 3, 5, 7, 9});
        for (List<Integer> ans : anss) {
            System.out.println(ans);
        }
    }

    private boolean[] used;
    private int eles;
    private int[] nums;
    private List<List<Integer>> res;

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
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new boolean[nums.length];
        this.res = new ArrayList<>();
        for (eles = 0;eles<=nums.length;eles++) {
            List<Integer> tmp = new ArrayList<>();
            helper(tmp,0);
        }
        return res;
    }

    public void helper(List<Integer> tmp,int begin) {
        if (tmp.size() == eles) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=begin;i<nums.length;i++) {
            if (used[i]) {
                continue;
            }
            tmp.add(nums[i]);
            used[i] = true;
            helper(tmp,begin+i);
            used[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}
