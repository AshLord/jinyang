package org.java.practice.lintcode.medium;

import java.util.Arrays;

/**
 * @author yang.jin
 * date: 01/02/2018
 * desc: 在数组中找到第k大的元素
 */
public class 第k大元素 {

    public static void main(String[] args) {
        第k大元素 test = new 第k大元素();
        //int[] nums = {9, 3, 2, 4, 8};
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;

        System.out.println(test.kthLargestElement(k, nums));
    }

    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
