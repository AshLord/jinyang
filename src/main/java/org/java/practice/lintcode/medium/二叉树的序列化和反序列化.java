package org.java.practice.lintcode.medium;

/**
 * 设计一个算法，并编写代码来序列化和反序列化二叉树。将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。
 * 如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构。
 */
public interface 二叉树的序列化和反序列化 {

    String serialize(TreeNode root);

    TreeNode deserialize(String data);

    class TreeNode {
        public int val;
        public TreeNode left,right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

    }
}
