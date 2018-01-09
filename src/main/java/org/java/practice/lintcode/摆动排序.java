package org.java.practice.lintcode;

import java.util.Arrays;

import static org.java.practice.lintcode.两数组的交集.printArray;

/**
 * Created by 晋阳 on 2018/1/6.
 */
public class 摆动排序 {

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4, 4, 2};
        int[] nums2 = {4, 5, 5, 6}; //expected : 5 6 4 5
        int[] nums3 = {1, 2, 1, 2, 1, 1, 2, 2, 1};
        int[] nums4 = {1, 5, 1, 1, 6, 4};
        switch (4) {
            case 0:
                //允许相邻元素相等
                wiggleSort(nums);
                break;
            case 1:
                //不允许相邻元素相等
                //第一次尝试失败：把前半部分元素正向插入1,3,5... 把后半部分元素正向插入2,4,6...
                //事实证明，都是正向会在末尾冲突，一正向一逆向会在中间冲突
                wiggleSort2(nums2);
                break;
            case 2:
                //排序后，依次从两端交替分发
                wiggleSort3(nums2);
                //也不行：[1,5,1,1,6,4]-->[1,5,4,6,1,1]
                break;
            case 3:
                wiggleSort4(nums2);
                //基于2,2的情况已经可以cover大部分情况了，对特殊边界做下处理
                break;
            case 4:
                //基于3的改进
                wiggleSort5(nums2);
                break;
            default:
                return;
        }
    }

    public static void wiggleSort5(int[] nums) {
        int n = nums.length;
        if(n == 0) return ;
        int[] a = Arrays.copyOfRange(nums,0,n);
        Arrays.sort(a);
        int k = 0 , p = (n-1)/2, q = n-1;
        boolean sign = true;
        //sign控制交替赋值
        while(k < n){
            if(sign) nums[k++]=a[p--];
            else nums[k++]=a[q--];
            sign = !sign;
        }
        printArray(nums);
    }

    public static void wiggleSort4(int[] nums) {
        // write your code here
        //边界
        if (nums.length <= 1) {
            return;
        }
        //先对数组进行排序
        Arrays.sort(nums);

        //取中心轴
        int axis = nums.length / 2;

        //创建结果数组
        int[] result = new int[nums.length];

        //如果数组长度为偶数
        if (nums.length % 2 == 0) {
            //把前半部分元素正向插入1,3,5...
            int j = 0;
            for (int i = 0; i < axis; i++) {
                result[j] = nums[i];
                j = j + 2;
            }
            //把后半部分元素正向插入2,4,6...
            int k = 1;
            for (int i = axis; i < nums.length; i++) {
                result[k] = nums[i];
                k = k + 2;
            }
        }
        //如果数组长度为奇数
        else {
            //把前半部分元素正向插入1,3,5...
            int j = 0;
            for (int i = 0; i <= axis; i++) {
                result[j] = nums[i];
                j = j + 2;
            }
            //把后半部分元素正向插入2,4,6...
            int k = 1;
            for (int i = axis + 1; i < nums.length; i++) {
                result[k] = nums[i];
                k = k + 2;
            }
        }

        //针对特殊边界，例如 4 5 5 6 这样的数组
        for (int i=1;i<nums.length;i++) {

            if (result[i] == result[i - 1]) {
                //假如出现了这种边界情况 4 5 5 6 要想办法转化成 5 6 4 5
                //把6移到第一个5的位置
                int temp = result[i + 1];
                result[i + 1] = result[i - 1];
                result[i - 1] = temp;
                //把4移到第二个5的位置
                int tepo = result[i];
                result[i] = result[i - 2];
                result[i - 2] = tepo;
            }
        }

        System.arraycopy(result,0,nums,0,nums.length);

    }

    public static void wiggleSort(int[] nums) {
        // write your code here
        //先对数组进行排序
        Arrays.sort(nums);

        //然后依次把i和i+1的元素进行交换，就可以得到一个摆动排序
        for (int i=1;i<nums.length-1;i=i+2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }

    }

    public static void wiggleSort2(int[] nums) {
        // write your code here
        //边界
        if (nums.length <= 1) {
            return;
        }
        //先对数组进行排序
        Arrays.sort(nums);

        //取中心轴
        int axis = nums.length / 2;

        //创建结果数组
        int[] result = new int[nums.length];

        //把前半部分元素正向插入1,3,5...
        int j = 0;
        for (int i = 0; i < axis; i++) {
            result[j] = nums[i];
            j = j + 2;
        }
        //把后半部分元素正向插入2,4,6...
        int k = 1;
        for (int i = axis; i < nums.length; i++) {
            result[k] = nums[i];
            k = k + 2;
        }

        System.arraycopy(result,0,nums,0,nums.length);
    }

    public static void wiggleSort3(int[] nums) {

        //创建用于分发的数组
        int[] result = new int[nums.length];

        //前分发指针
        int frontP = 0;
        //后分发指针
        int backP = nums.length-1;
        //对于 4 5 5 6 这样的数组，可以采用从末尾两端交替分发的策略 --> 4 5 6 5
        for (int i=0;i<nums.length;i++) {
            if (i / 2 == 0) {
                result[frontP] = nums[i];
                frontP++;
            } else {
                result[backP] = nums[i];
                backP--;
            }
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
        printArray(nums);
    }
}
