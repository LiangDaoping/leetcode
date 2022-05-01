package com.code.leetcode.code7二叉树.code4二叉树的统一迭代法;


import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode3_145二叉树的后序遍历 {

    public static void main(String[] args) {
        Integer[] root = new Integer[]{1,null,2,3};
        TreeNode treeNode = initMyTreeNode(root);
        System.out.println(postorderTraversal(treeNode));//[3,2,1]

        root = new Integer[]{};
        treeNode = initMyTreeNode(root);
        System.out.println(postorderTraversal(treeNode));//[]


        root = new Integer[]{1};
        treeNode = initMyTreeNode(root);
        System.out.println(postorderTraversal(treeNode));//[1]

        root = new Integer[]{1,2};
        treeNode = initMyTreeNode(root);
        System.out.println(postorderTraversal(treeNode));//[2,1]


        root = new Integer[]{1,null, 2};
        treeNode = initMyTreeNode(root);
        System.out.println(postorderTraversal(treeNode));//[2,1]

        root = new Integer[]{3,1,2};
        treeNode = initMyTreeNode(root);
        System.out.println(postorderTraversal(treeNode));//[1,2,3]

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pop();
            if (pop == null) {
                pop = deque.pop();
                res.add(pop.val);
            } else {
                deque.push(pop);
                deque.push(null);

                if (pop.right != null) deque.push(pop.right);
                if (pop.left != null) deque.push(pop.left);
            }
        }
        return res;
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
        Queue<TreeNode> queue = new ArrayDeque<>();

        int index = 0;
        TreeNode root = new TreeNode(node[index]);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            index++;
            if (index < node.length && node[index] != null) {
                TreeNode left = new TreeNode(node[index]);
                poll.left = left;
                queue.add(left);
            }
            index++;
            if (index < node.length && node[index] != null) {
                TreeNode right = new TreeNode(node[index]);
                poll.right = right;
                queue.add(right);
            }

        }
        return root;
    }


}
