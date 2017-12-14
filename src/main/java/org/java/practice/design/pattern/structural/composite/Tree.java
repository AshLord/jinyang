package org.java.practice.design.pattern.structural.composite;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class Tree {

    /**
     * 使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等。
     */
    TreeNode root = null;

    public Tree(String name) {
        root = new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);
        System.out.println("build the tree finished!");
    }

}
