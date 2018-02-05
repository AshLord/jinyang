package org.java.practice.lintcode.medium;

/**
 * @author yang.jin
 * date: 05/02/2018
 * desc: 设计一个算法，并编写代码来序列化和反序列化二叉树。将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。
 * 如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构。
 */
public class 二叉树的序列化和反序列化 {

    /**
         3
        / \
       9  20
         /  \
        15   7
     给出一个测试数据样例， 二叉树{3,9,20,#,#,15,7}
     * @param args
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        二叉树的序列化和反序列化 test = new 二叉树的序列化和反序列化();
        //System.out.println(test.serialize(root));
        System.out.println(test.serialize0(root));
        //test.deserialize(test.serialize(root));
    }

    public String serialize0(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        sb.append("{" + root.val + ",");
        int depth = findHowDeep(root, 0,0);   //0-start
        int i = 0;
        while (i < depth) {

        }
        return null;
    }

    public int findHowDeep(TreeNode root,int leftDepth,int rightDepth) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = findHowDeep(root.left, leftDepth++,rightDepth);
        }
        if (root.right != null) {
            right = findHowDeep(root.right,leftDepth, rightDepth++);
        }
        return Math.max(left, right);

    }

    /**
     * 第一次尝试：属于深度优先遍历
     */
    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        sb.append("{"+root.val+",");
        recursive(root, sb);
        return sb.toString().substring(0,sb.toString().length()-1)+"}";
    }
    public void recursive(TreeNode node, StringBuilder sb) {
        if (node != null) {
            recursive(node.left, sb.append(node.left != null ? node.left.val + "," : "#,"));
            recursive(node.right, sb.append(node.right != null ? node.right.val + "," : "#,"));
        }
    }

    public TreeNode deserialize(String data) {
        // write your code here
        return null;
    }

    public static class TreeNode {

        public int val;

        public TreeNode left,right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

}
