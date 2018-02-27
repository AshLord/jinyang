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
        /*String serialResult = test.serialize(root2);
        System.out.println(serialResult);
        System.out.println(test.deserialize(serialResult));*/

        /////////////////////////////////////////////////////////
        String serial = "{1,2,3,11,#,4,5,#,#,6,7,#,10,#,#,8,9,#,#,12,13,#,#,#,#,#,14}";
        TreeNode root3 = test.deserialize(serial);
        System.out.println(test.serialize(root3));

    }

    @Override
    public String serialize(TreeNode root) {
        // write your code here
        // 边界
        if (root == null) return "{}";

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int notNull = 0;
        while (true) {

            if (list.get(notNull) == null) {
                break;
            }

            list.add(list.get(notNull).left);
            list.add(list.get(notNull).right);

            while (notNull < list.size()-1) {
                if (list.get(notNull + 1) == null) {
                    notNull++;
                } else {
                    notNull++;
                    break;
                }
            }
        }
        //删除末尾多余的空元素
        for (int i=list.size();i>0;i--) {
            if (list.get(i - 1) == null) {
                list.remove(i - 1);
            } else {
                break;
            }
        }
        //序列化
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (TreeNode node : list) {
            sb.append(node==null?"#":node.val).append(",");
        }
        return sb.substring(0, sb.length() - 1) + "}";
    }

    @Override
    public TreeNode deserialize(String data) {
        // write your code here
        if (!data.contains(",")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int parent = 0;
        boolean left = true;
        for (int i = 1;i<vals.length;i++) {
            if (left) {
                if (!vals[i].equals("#")) {
                    list.get(parent).left = new TreeNode(Integer.valueOf(vals[i]));
                }
                list.add(list.get(parent).left);
                left = false;
            } else {
                if (!vals[i].equals("#")) {
                    list.get(parent).right = new TreeNode(Integer.valueOf(vals[i]));
                }
                list.add(list.get(parent).right);
                left = true;
                while (parent < list.size()) {
                    if (vals[parent+1].equals("#")) {
                        parent++;
                    } else {
                        parent++;
                        break;
                    }
                }
            }
        }
        return root;
    }
}
