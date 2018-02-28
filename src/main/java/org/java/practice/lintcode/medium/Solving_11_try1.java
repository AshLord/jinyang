package org.java.practice.lintcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author yang.jin
 * date: 28/02/2018
 * desc:
 */
public class Solving_11_try1 implements 二叉查找树中搜索区间{

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);

        Solving_11_try1 test = new Solving_11_try1();
        List<Integer> list = test.searchRange(root, 10, 22);
        for (Integer in : list) {
            System.out.println(in);
        }

    }

    /**
     * 如果有 k1 = 10 和 k2 = 22, 你的程序应该返回 [12, 20, 22]
     */
    @Override
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int i = 0;
        while (i<list.size()) {
            if (list.get(i).left != null) {
                list.add(list.get(i).left);
            }
            if (list.get(i).right != null) {
                list.add(list.get(i).right);
            }
            i++;
        }

        List<Integer> results = new ArrayList<>();
        for (TreeNode node : list) {
            if (node.val >= k1 && node.val <= k2) {
                results.add(node.val);
            }
        }
        results.sort(Comparator.comparingInt(o -> o));
        return results;
    }
}
