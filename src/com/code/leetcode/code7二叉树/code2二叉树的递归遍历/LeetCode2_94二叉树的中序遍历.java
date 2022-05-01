package com.code.leetcode.code7二叉树.code2二叉树的递归遍历;


import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode2_94二叉树的中序遍历 {

    public static void main(String[] args) {
        Integer[] root = new Integer[]{1,null,2,3};
        TreeNode treeNode = initMyTreeNode(root);
        System.out.println(inorderTraversal(treeNode));//[1,2,3]  [3, 2, 1]

        root = new Integer[]{};
        treeNode = initMyTreeNode(root);
        System.out.println(inorderTraversal(treeNode));//[]   []


        root = new Integer[]{1};
        treeNode = initMyTreeNode(root);
        System.out.println(inorderTraversal(treeNode));//[1]  [1]

        root = new Integer[]{1,2};
        treeNode = initMyTreeNode(root);
        System.out.println(inorderTraversal(treeNode));//[1,2]    [2,1]


        root = new Integer[]{1,null, 2};
        treeNode = initMyTreeNode(root);
        System.out.println(inorderTraversal(treeNode));//[1,2]    [2,1]
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
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
