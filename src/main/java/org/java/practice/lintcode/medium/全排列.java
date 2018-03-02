package org.java.practice.lintcode.medium;

import org.java.practice.design.pattern.structural.composite.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yang.jin
 * date: 02/03/2018
 * desc:给定一个数字列表，返回其所有可能的排列。
 */
public class 全排列 {

    /**
     [1,2,3]
     [1,3,2]
     [2,1,3]
     [2,3,1]
     [3,1,2]
     [3,2,1]
     */
    public static void main(String[] args) {
        全排列 test = new 全排列();
        test.permute(new int[]{1, 2, 3});

    }

    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<Integer> src = new ArrayList<>();
        for (int num : nums) {
            src.add(num);
        }

        TreeNode root = new TreeNode(0);
        permute0(src, root);

        return null;
    }

    public void permute0(List<Integer> src,TreeNode node) {

        for (int i=0;i<src.size();i++) {
            node.sonList.add(new TreeNode(src.get(i)));
            List<Integer> dest = new ArrayList<>(src);
            dest.remove(i);
            permute0(dest,node.sonList.get(i));
        }
    }

    static class TreeNode {
        public int val;
        public List<TreeNode> sonList;

        public TreeNode(int val) {
            this.val = val;
            this.sonList = new ArrayList<>();
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
    }
}
