package org.java.practice.lintcode.hard;

import java.util.*;

/**
 * Created by 晋阳 on 2018/1/13.
 */
public class 吹气球 {

    public static void main(String[] args) {
        int[] nums0 = {2, 3};
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 1, 5, 10};
        int[] nums3 = {35, 16, 83, 87, 84, 59, 48, 41, 20, 54};
        int[] nums4 = {3, 1, 5, 8};
        switch (2) {
            case 0:
                /**
                 * 第一种思路：错误。
                 * 根据样例发现规律，只要从小到大burst（首尾除外），就能得到结果。
                 * 但事实远非想象那么简单。
                 */
                System.out.println(maxCoinsAttempt(nums2));
                break;
            case 1:
                /**
                 * 第二种思路：递归（时间复杂度和内存限制都超了，该思路的递归实质上是穷举，暴力穷举的时间复杂度是指数级的！）
                 * 每一步尝试burst每一种情况，然后剩下的步骤交给递归方法处理
                 */
                System.out.println(maxCoins(nums2));
                break;
            case 2:
                /**
                 * 第三种思路：动态规划
                 * 网上给出的动态规划答案
                 */
                System.out.println(maxCoinsDp(nums4));
            default:
                break;
        }

    }

    /**
     * 递归到动规的一般转化方法
     * 递归函数有n个参数，就定义一个n维的数组，数组的下标是递归函数参数的取值范围，数组元素的值是递归函数的返回值，
     * 这样就可以从边界值开始， 逐步填充数组，相当于计算递归函数值的逆过程。
     */
    public static int maxCoinsDp(int[] nums) {
        // write your code here
        // 首尾添加两个值为1的元素，方便计算
        int[] nbrs = new int[nums.length + 2];
        nbrs[0] = 1;
        nbrs[nbrs.length - 1] = 1;
        for (int i=0;i<nums.length;i++) {
            nbrs[i + 1] = nums[i];
        }

        // 状态转移矩阵：dp(i,j)表示吹爆所有在区间[i,j]的气球，所能得到的最大分数
        int[][] dp = new int[nbrs.length][nbrs.length];

        int len = nbrs.length - 2;

        //i是左指针与右指针的间隔距离+1
        for(int i=1; i<=len; i++){
            for (int left = 1; left <= len - i + 1; left++) {
                int right = left + i - 1;
                for (int k = left; k <= left + i - 1; k++ ){
                    //假设吹爆第k个气球，那么k-1和k+1个气球变得相邻，不方便转移。那么我们就先吹爆区间[i,k−1]和区间[k+1,j]的所有气球
                    int leftVal = dp[left][k - 1];
                    int rightVal = dp[k + 1][right];
                    //最后再来吹爆第k个气球，那么这样就十分方便转移了
                    int midVal = nbrs[left - 1] * nbrs[k] * nbrs[right + 1];
                    int subAns = leftVal + rightVal + midVal;
                    dp[left][right] = Math.max(dp[left][right],subAns);
                }
            }
        }
        return dp[1][len];
    }

    public static int maxCoins(int[] nums) {
        // write your code here
        // 把数组转化成list
        List<Integer> list = new LinkedList<>();
        for (Integer num : nums) {
            list.add(num);
        }
        return recursive(list);
    }

    public static int recursive(List<Integer> list) {
        int ans = 0;
        for (int i=0;i<list.size();i++) {
            int subAns = 0;
            //边界
            if (list.size() == 1) {
                return list.get(0);
            }
            //当burst第i个的气球时
            if (i == 0) {
                subAns += list.get(i) * list.get(i + 1);
            } else if (i == list.size() - 1) {
                subAns += list.get(i) * list.get(i - 1);
            } else {
                subAns += list.get(i) * list.get(i - 1) * list.get(i + 1);
            }
            List<Integer> sublist = new ArrayList<>();
            sublist.addAll(list);
            sublist.remove(i);
            //递归
            subAns += recursive(sublist);
            ans = Math.max(ans, subAns);

        }
        return ans;
    }

    public static int maxCoinsAttempt(int[] nums) {
        // write your code here
        //边界
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // 把数组转化成list
        List<Integer> list = new LinkedList<>();
        for (Integer num : nums) {
            list.add(num);
        }
        int result = 0;
        //对数组进行排序，方便从小到大burst
        Arrays.sort(nums);
        //开始从小到大burst
        for (Integer num : nums) {
            //开始burst值为num的气球
            for (int i=0;i<list.size();i++) {
                //当burst气球只剩下2个的时候
                if (list.size() <= 2) {
                    break;
                }
                //寻找该num气球在list中的位置
                if (list.get(i).equals(num)) {
                    //找到第一个位置（因为可能存在多个气球num相同的情况）
                    //如果位于两端
                    if (i == 0 || i == list.size() - 1) {
                        //如果位于两端，则继续遍历
                        continue;
                    }
                    //如果位于中间，则burst
                    result += list.get(i) * list.get(i - 1) * list.get(i + 1);
                    System.out.println("burst:"+list.get(i));
                    list.remove(i);
                    i--;
                }
            }
        }
        //只剩下2个气球
        if (list.get(0) > list.get(1)) {
            System.out.println("burst:"+list.get(1));
            System.out.println("burst:"+list.get(0));
            result += list.get(0) * list.get(1) + list.get(0);
        } else {
            System.out.println("burst:"+list.get(0));
            System.out.println("burst:"+list.get(1));
            result += list.get(0) * list.get(1) + list.get(1);
        }
        return result;
    }
}
