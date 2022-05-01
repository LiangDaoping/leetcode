package com.code.leetcode.code7二叉树.code5二叉树层序遍历登场;


import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_102二叉树的层序遍历 {

    public static void main(String[] args) {
        Integer[] root = new Integer[]{3,9,20,null,null,15,7};
        TreeNode treeNode = initMyTreeNode(root);
        System.out.println(levelOrder1(treeNode));//[[3],[9,20],[15,7]]

        root = new Integer[]{1};
        treeNode = initMyTreeNode(root);
        System.out.println(levelOrder1(treeNode));//[[1]]

        root = new Integer[]{};
        treeNode = initMyTreeNode(root);
        System.out.println(levelOrder1(treeNode));//[]

    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        checkFun(ans, root, 0);
        return ans;
    }

    public static void checkFun(List<List<Integer>> ans, TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;
        if (ans.size() < deep) {
            List<Integer> item = new ArrayList<>();
            ans.add(item);
        }
        ans.get(deep - 1).add(node.val);

        checkFun(ans, node.left, deep);
        checkFun(ans, node.right, deep);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            while (len-- > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            ans.add(list);
        }
        return ans;
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
        if (node == null || node.length == 0) return null;
        // todo 递归构建树
        // todo 栈构建树
        return initMyTreeNode(node, 0);
    }

    public static TreeNode initMyTreeNode(Integer[] node, int index) {
        if (index >= node.length) return null;
        if (node[index] == null) return null;
        TreeNode treeNode = new TreeNode(node[index]);
        treeNode.left = initMyTreeNode(node, index * 2 + 1);
        treeNode.right = initMyTreeNode(node, index * 2 + 2);
        return treeNode;
    }




}
