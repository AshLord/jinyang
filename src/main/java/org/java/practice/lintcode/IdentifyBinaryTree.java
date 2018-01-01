package org.java.practice.lintcode;

/**
 * Created by 晋阳 on 2017/12/31.
 * 判断二叉树是否相等
 */
public class IdentifyBinaryTree {

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(1);
        TreeNode rootALeft = new TreeNode(2);
        TreeNode rootARight = new TreeNode(2);
        TreeNode rootALeftLeft = new TreeNode(4);
        rootA.setLeft(rootALeft);
        rootA.setRight(rootARight);
        rootALeft.setLeft(rootALeftLeft);

        TreeNode rootB = new TreeNode(1);
        TreeNode rootBLeft = new TreeNode(2);
        TreeNode rootBRight = new TreeNode(3);
        TreeNode rootBLeftRight = new TreeNode(4);
        rootB.setLeft(rootBLeft);
        rootB.setRight(rootBRight);
        rootBLeft.setRight(rootBLeftRight);

        System.out.println(isIdentical(rootA, rootB));
    }

    public static boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if (a == null) {
            if (b == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (b == null) {
                return false;
            }
        }
        if (a.val != b.val) {
            return false;
        }
        if (a.left != null) {
            if (b.left != null) {
                if (!isIdentical(a.left, b.left)) {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if (b.left != null) {
                return false;
            }
        }

        if (a.right != null) {
            if (b.right != null) {
                if (!isIdentical(a.right, b.right)) {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if (b.right != null) {
                return false;
            }
        }
        return true;
    }
}
