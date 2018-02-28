package org.java.practice.lintcode.medium;

import java.util.List;

/**
 * @author yang.jin
 * date: 28/02/2018
 * desc:
 */
public interface 二叉查找树中搜索区间 {

    class TreeNode{
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * 给定两个值 k1 和 k2（k1 < k2）和一个二叉查找树的根节点。找到树中所有值在 k1 到 k2 范围内的节点。即打印所有x (k1 <= x <= k2) 其中 x 是二叉查找树的中的节点值。返回所有升序的节点值。
     * @param root
     * @param k1
     * @param k2
     * @return
     */
    List<Integer> searchRange(TreeNode root, int k1, int k2);
}
