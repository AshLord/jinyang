package org.java.practice.lintcode;

/**
 * Created by 晋阳 on 2017/12/31.
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
