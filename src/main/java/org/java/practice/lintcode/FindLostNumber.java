package org.java.practice.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 晋阳 on 2018/1/6.
 * 给一个由 1 - n 的整数随机组成的一个字符串序列，其中丢失了一个整数，请找到它。
 * 样例
 给出 n = 20, str = 19201234567891011121314151618
 丢失的数是 17 ，返回这个数。
 */
public class FindLostNumber {

    public static void main(String[] args) {
        int n = 20;
        String string = "19201234567891011121314151618";

        int n1 = 28;
        String string1 = "111098654327128213127262524232120191817161514";
        switch (2) {
            case 0:
                //第一种实现方式：
                System.out.println(findMissing1(n1,string1));
                break;
            case 1:
                //第二种实现方式：
                System.out.println(findMissing(n,string));
                break;
            case 2:
                int[] nums = {0,1,3};
                System.out.println(findMissingSimple(nums));
                break;
            default:
                return;
        }

    }

    private static int findMissingSimple(int[] nums) {
        int sum = 0;
        int total = 0;
        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
            total += i+1;
        }
        return total - sum;
    }

    /**
     * 第三种思路，深度优先搜索
     * @param n
     * @param str
     * @return
     */
    static int ans;
    private static int findMissing(int n, String str) {
        //边界情况
        if (str == null || str.length() == 0) {
            return n;
        }
        //构建一个总数从0到n的搜索标记
        boolean[] flag = new boolean[n + 1];
        //递归实现深度优先搜索
        findHelper(flag, n, 0, 0, str);
        return ans;
    }

    /**
     *
     * @param flag
     * @param n
     * @param sum
     * @param index
     * @param str
     * 19201234567891011121314151618 n = 20
     */
    public static void findHelper(boolean[] flag, int n,int sum, int index, String str) {
        System.out.println("开始遍历 sum = "+sum+" index = "+index);
        if (index == str.length()) {
            ans = (n + 1) * n / 2 - sum;
            System.out.println("ans = "+ans);
            return;
        }
        //连续的两位字符，判断哪个满足条件
        for (int i = 1; i <= 2; i++) {
            int num = Integer.parseInt(str.substring(index, index + i));
            System.out.println("num = "+num);
            if (num == 0) {
                //遇到0，必然和前一位构成一个元素
                break;
            }
            if (num <= n && !flag[num]) {
                flag[num] = true;
                System.out.println("flag["+num+"]设为true");
                findHelper(flag, n, sum + num, index + 1 + i - 1, str);
                flag[num] = false;
                System.out.println("flag["+num+"]设为false");
            }
            //在最后一个字符位置就不需要遍历两字符的情况了  + 找到之后就不需要继续找
            if (index == str.length() - 1 || ans != 0) {
                System.out.println(num+"找到之后就不需要继续找");
                break;
            }
        }
    }


    /**
     * 第一种思路：
     * 从n开始从后往前遍历，每遍历一个数就从string中删除
     * 3 5 35 假如缺失35，但是如果把前2个紧挨的元素poll出去了，也会导致结果错误
     *
     * 第二种思路：
     * 把字符串转化成数组，和完整的数组比对，两个数组的差值就是少的值
     * 12 21 算出差值怎么确认哪个是真缺的数呢？ 可以用String.indexOf(string)来判断
     * 1 2 12 21 如果缺失的是12，前两个元素紧挨，indexOf也不能判断
     * 2 1 12 21 这种情况，缺失的是21，这种又该怎么办？ 实际上，这是这道题目的bug！
     * 我既可以说没有12，是1和2，也可以说没有21，是2和1！
     * @param n
     * @param str
     * @return
     */
    private static int findMissing1(int n, String str) {
        //生成一个完整的字符串
        //这里要用StringBuilder，比StringBuffer效率高
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=n;i++) {
            sb.append(i);
        }

        //生成两个计数数组，每个计数数组包含0-9这十个数字
        int[][] array = new int[2][10];
        //第一个数组存非完整字符串的统计结果
        for (int i=0;i<str.length();i++) {
            // 0 的ASCII码是 48
            array[0][str.charAt(i)-48] += 1;
        }
        //第二个数组存完整字符串的统计结果
        for (int i=0;i<sb.length();i++) {
            array[1][sb.charAt(i)-48] += 1;
        }

        //计算两个数组的差值
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<=9;i++) {
            if (array[1][i] - array[0][i] == 1) {
                list.add(i);
            } else if (array[1][i] - array[0][i] == 2) {
                list.add(i);
                list.add(i);
            }
        }

        if (list.size() == 1) {
            //结果为个位数时，不需要考虑谁前谁后的问题
            return list.get(0);
        } else {
            //结果为两位数时，要考虑谁前谁后
            int result1 = list.get(0) * 10 + list.get(1);
            int result2 = list.get(1) * 10 + list.get(0);
            //如果一个结果超过边界了，则另一个是正确结果
            if (result1 > n) {
                return result2;
            }
            if (result2 > n) {
                return result1;
            }
            //如果两个结果都在合法范围内，则已存在的一个是错误结果，另一个是正确结果
            if (str.contains(String.valueOf(result1))) {
                return result2;
            }
            return result1;
        }
    }

}
