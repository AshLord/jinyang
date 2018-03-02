package org.java.practice.lintcode.easy;

import java.util.Arrays;

/**
 * @author yang.jin
 * date: 28/02/2018
 * desc:
 */
public class 二分查找 {

    public static void main(String[] args) {
        二分查找 test = new 二分查找();

        //int[] nums = {1, 2, 3, 3, 4, 5, 10};
        int[] nums = {3, 4, 5, 8, 8, 8, 8, 10, 13, 14};
        System.out.println(test.binarySearch2(nums, 6));
    }

    /**
     * 给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1。
     */
    @Deprecated(forRemoval = true)
    public int binarySearch(int[] nums, int target) {
        // write your code here
        return Arrays.binarySearch(nums,0,nums.length-1,target);
    }

    public int binarySearch2(int[] nums, int target) {
        // write your code here
        return binarySearch0(nums, 0, nums.length - 1, target);
    }

    public int binarySearch0(int[] nums,int begin,int end,int target) {
        if (begin == end) {
            if (nums[end] == target) {
                return end;
            } else {
                return -1;
            }
        }
        int mid = (begin + end) >>> 1;
        if (target < nums[mid]) {
            return binarySearch0(nums, begin, mid-1, target);
        } else if (target > nums[mid]) {
            return binarySearch0(nums, mid+1, end, target);
        } else {
            for (int i = mid;i>0;i--) {
                if (nums[mid] != nums[i - 1]) {
                    return i;
                }
            }
        }
        throw new IllegalStateException();
    }
}
