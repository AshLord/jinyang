package org.java.practice.lintcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solving_7_try2 implements 二叉树的序列化和反序列化 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        二叉树的序列化和反序列化 test = new Solving_7_try2();
        System.out.println(test.serialize(root));
    }

    public String serialize(TreeNode root) {
        // write your code here
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int notNull = 0;
        boolean run = true;
        while (run) {
            TreeNode left = list.get(notNull).left;
            TreeNode right = list.get(notNull).right;
            if (left == null && right == null) {
                //左右子节点都为空，说明是叶子节点
                if (list.get(notNull + 1) == null) {
                    //叶子节点的下一节点为空，说明应该结束了
                    run = false;
                    continue;
                } else {
                    notNull++;
                    continue;
                }
            }

            list.add(left);
            list.add(right);

            int cycles = 0;
            while (true) {
                if (list.get(notNull + 1) == null) {
                    notNull++;
                } else {
                    notNull++;
                    break;
                }
                cycles++;
                if (cycles == 3) {
                    break;
                }
            }
        }
        //删除末尾多余的空元素
        if (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        //序列化
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (TreeNode node : list) {
            sb.append(node==null?"#":node.val).append(",");
        }
        return sb.substring(0, sb.length() - 1) + "}";
    }

    public TreeNode deserialize(String data) {
        // write your code here
        return null;
    }
}
