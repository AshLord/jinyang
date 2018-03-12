package org.java.practice.lintcode.medium;

import java.util.*;

/**
 * @author yang.jin
 * date: 12/03/2018
 * desc:
 */
public class 带重复元素的子集 {

    public static void main(String[] args) {
        带重复元素的子集 test = new 带重复元素的子集();
        System.out.println(test.subsetsWithDup(new int[]{1, 2, 2}));
    }

    private boolean[] used;
    private int eles;
    private int[] nums;
    private Set<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new boolean[nums.length];
        this.res = new HashSet<>();
        for (eles = 0;eles<=nums.length;eles++) {
            List<Integer> tmp = new ArrayList<>();
            helper(tmp,0);
        }
        return new ArrayList<>(res);
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
            helper(tmp,i+1);
            used[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}
