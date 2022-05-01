package com.code.leetcode.code7二叉树.code2二叉树的递归遍历;


import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_144二叉树的前序遍历 {

    public static void main(String[] args) {
        Integer[] root = new Integer[]{1,null,2,3};
        TreeNode treeNode = initMyTreeNode(root);
        System.out.println(preorderTraversal(treeNode));//[1,2,3]

        root = new Integer[]{};
        treeNode = initMyTreeNode(root);
        TreeNode treeNode2 = treeNode;
        System.out.println(preorderTraversal(treeNode));//[]


        root = new Integer[]{1};
        treeNode = initMyTreeNode(root);
        System.out.println(preorderTraversal(treeNode));//[1]

        root = new Integer[]{1,2};
        treeNode = initMyTreeNode(root);
        System.out.println(preorderTraversal(treeNode));//[1,2]


        root = new Integer[]{1,null, 2};
        treeNode = initMyTreeNode(root);
        System.out.println(preorderTraversal(treeNode));//[1,2]


        root = new Integer[]{3,1,2};
        treeNode = initMyTreeNode(root);
        System.out.println(preorderTraversal(treeNode));//[3,1,2]

        root = new Integer[]{1,2,3,4,5,6,7};
        treeNode = initMyTreeNode(root);
        System.out.println(preorderTraversal(treeNode));//[3,1,2]

        root = new Integer[]{1,2,3};
        treeNode = initMyTreeNode(root);
        System.out.println(preorderTraversal(treeNode));//[3,1,2]
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {this.val = val; this.left = left; this.right = right;}
    }

    public static TreeNode initMyTreeNode(Integer[] node) {
        if (node.length == 0) return null;
        index = 0;
        return initMyTreeNode(new TreeNode(node[0]), node);
    }

    static int index = 0;
    public static TreeNode initMyTreeNode(TreeNode root, Integer[] node) {
        if (root == null) return root;
        int length = node.length;
        if (index >= length || node[index] == null) return null;


        index++;
        if (index < length && node[index] != null) {
            root.left = new TreeNode(node[index]);
        }

        index++;
        if (index < length && node[index] != null) {
            root.right = new TreeNode(node[index]);
        }

        initMyTreeNode(root.left, node);
        initMyTreeNode(root.right, node);
        return root;
    }

}
