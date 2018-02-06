package org.java.practice.lintcode.medium;

import java.util.ArrayList;
import java.util.List;

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
        //root.right.right = new TreeNode(7);

        二叉树的序列化和反序列化 test = new 二叉树的序列化和反序列化();
        System.out.println(test.serialize(root));
        TreeNode deserialize = test.deserialize(test.serialize(root));
        System.out.println(test.serialize(deserialize));
        TreeNode result = test.deserialize("{1,2,#,3,#,4}");
    }

    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{#}";
        }
        if (root.left == null && root.right == null) {
            return "{" + root.val + "}";
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int i = 1;
        int check = 2;
        while (true){
            if (i % 2 == 1) {
                list.add(list.get((i-1)/2)==null?null:list.get((i-1)/2).left);
            } else {
                list.add(list.get((i-1)/2)==null?null:list.get((i-1)/2).right);
            }
            //检查该层是否为最底层
            if (i == Math.pow(2, check) - 2) { //到达检查点
                int children = 0;
                for (int j = (int) Math.pow(2, check - 1) - 1; j <= i; j++) {
                    if (list.get(j) != null) {
                        if (list.get(j).right != null) {
                            children++;
                        }
                        if (list.get(j).left != null) {
                            children++;
                        }
                    }
                }
                if (children == 0) { //说明该层都没有子节点，说明是最底层了
                    break;
                }
                check++;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (TreeNode node : list) {
            sb.append(node==null?"#":node.val).append(",");
        }
        return sb.substring(0, sb.length() - 1) + "}";
    }

    public TreeNode deserialize(String data) {
        // write your code here
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        for (int i=1;i<vals.length;i++) {
            if (!"#".equals(vals[i])) {
                if (i % 2 == 1) { //奇数
                    list.get((i - 1) / 2).left = new TreeNode(Integer.valueOf(vals[i]));
                    list.add(list.get((i - 1) / 2).left);
                } else {
                    list.get((i - 1) / 2).right = new TreeNode(Integer.valueOf(vals[i]));
                    list.add(list.get((i - 1) / 2).right);
                }
            }
        }
        return root;
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
