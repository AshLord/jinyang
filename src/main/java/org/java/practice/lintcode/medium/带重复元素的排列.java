package org.java.practice.lintcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author yang.jin
 * date: 04/03/2018
 * desc:
 */
public class 带重复元素的排列 {

    public static void main(String[] args) {
        带重复元素的排列 test = new 带重复元素的排列();

        System.out.println(test.permuteUnique(new int[]{1,2,2}));
    }

    /**
     [1,2,2],
     [2,1,2],
     [2,2,1]
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        set = new HashSet<List<Integer>>();
        used = new boolean[nums.length];
        List<Integer> tmp = new LinkedList<Integer>();
        this.nums = nums;
        helper(tmp);
        return new LinkedList<>(set);
    }
    Set<List<Integer>> set;
    boolean[] used;
    int[] nums;
    private void helper(List<Integer> tmp){
        if(tmp.size() == nums.length){
            List<Integer> list = new LinkedList<Integer>(tmp);
            set.add(list);
        } else {
            for(int idx = 0; idx < nums.length; idx++){
                // 遇到已经加过的元素就跳过
                if(used[idx]){
                    continue;
                }
                // 加入该元素后继续搜索
                used[idx] = true;
                tmp.add(nums[idx]);
                helper(tmp);
                tmp.remove(tmp.size()-1);
                used[idx] = false;
            }
        }
    }
}
