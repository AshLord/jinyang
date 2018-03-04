package org.java.practice.lintcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yang.jin
 * date: 02/03/2018
 * desc:给定一个数字列表，返回其所有可能的排列。
 */
public class 全排列 {

    /**
     * [1,2,3]v
     * [1,3,2]v
     * [2,1,3]v
     * [2,3,1]v
     * [3,1,2]v
     * [3,2,1]v
     */
    public static void main(String[] args) {
        全排列 test = new 全排列();
        System.out.println(test.permute(new int[]{1, 2, 3}));
        System.out.println(test.permute2(new int[]{1, 2, 3}));
        System.out.println(test.permute3(new int[]{1, 2, 3}));
        System.out.println(test.permute4(new int[]{1, 2, 3}));
    }

    /**
     * 深度优先搜索
     * 时间 O(N) 空间 O(N) 递归栈
     * @param nums
     * @return
     */
    public List<List<Integer>> permute4(int[] nums) {
        res2 = new LinkedList<List<Integer>>();
        used = new boolean[nums.length];
        List<Integer> tmp = new LinkedList<Integer>();
        this.nums = nums;
        helper(tmp);
        return res2;
    }

    List<List<Integer>> res2;
    boolean[] used;
    int[] nums;

    private void helper(List<Integer> tmp){
        if(tmp.size() == nums.length){
            List<Integer> list = new LinkedList<Integer>(tmp);
            res2.add(list);
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

    /**
     * 交换法
     * 时间 O(N^2) 空间 O(N) 递归栈
     * @param nums
     * @return
     */
    public List<List<Integer>> permute3(int[] nums) {
        res = new LinkedList<List<Integer>>();
        helper(nums, 0);
        return res;
    }

    List<List<Integer>> res;

    public void helper(int[] nums, int i){
        // 找到转置完成后的解，将其存入列表中
        if(i == nums.length - 1){
            List<Integer> list = new LinkedList<Integer>();
            for(int j = 0; j < nums.length; j++){
                list.add(nums[j]);
            }
            res.add(list);
        }
        // 将当前位置的数跟后面的数交换，并搜索解
        for(int j = i; j < nums.length; j++){
            swap(nums, i , j);
            helper(nums, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 解法2，网上找的，没咋看懂
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        //定义了两个用于递归的参数
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //定义了一个标记是否访问过的数组
        int[] visited = new int[nums.length];
        //参数：(层数k,总层数n，ret，temp，数组候选解，访问标志）
        recursion(0, nums.length, ret, temp, nums, visited);

        return ret;
    }

    static public void recursion(int k, int n, List<List<Integer>> ret, List<Integer> temp, int[] nums, int[] visited) {
        //如果temp有n个元素，ret中没有
        if (k == n && !ret.contains(temp)) {
            ret.add(new ArrayList<Integer>(temp));//ret就添加
        }

        if (k > n)//退出条件限制递归层数
        {
            return;
        } else {
            for (int i = 0; i < n; i++) {
                int candidate = nums[i];//取出一个候选解
                if (visited[i] == 0)//如果没有被访问过
                {
                    temp.add(candidate);//temp添加
                    visited[i] = 1;//标记访问
                    recursion(k + 1, n, ret, temp, nums, visited);//递归
                    visited[i] = 0;//撤销访问标记
                    temp.remove(temp.size() - 1);//撤销上次添加
                }
            }
        }
    }

    /**
     * 解法1
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<Integer> src = new ArrayList<>();
        for (int num : nums) {
            src.add(num);
        }

        TreeNode root = new TreeNode(0, null);
        permute0(src, root);

        List<List<Integer>> results = new ArrayList<>();
        for (TreeNode leaf : leafs) {
            List<Integer> result = new ArrayList<>();
            while (leaf.parent != null) {
                result.add(leaf.val);
                leaf = leaf.parent;
            }
            results.add(result);
        }
        return results;
    }

    private List<TreeNode> leafs = new ArrayList<>();

    public void permute0(List<Integer> src, TreeNode node) {

        if (src.size() == 0) {
            leafs.add(node);
            return;
        }
        for (int i = 0; i < src.size(); i++) {
            node.sonList.add(new TreeNode(src.get(i), node));
            List<Integer> dest = new ArrayList<>(src);
            dest.remove(i);
            permute0(dest, node.sonList.get(i));
        }
    }

    static class TreeNode {
        public int val;
        public List<TreeNode> sonList;
        public TreeNode parent;

        public TreeNode(int val, TreeNode parent) {
            this.val = val;
            this.sonList = new ArrayList<>();
            this.parent = parent;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public List<TreeNode> getSonList() {
            return sonList;
        }

        public void setSonList(List<TreeNode> sonList) {
            this.sonList = sonList;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }
    }
}
