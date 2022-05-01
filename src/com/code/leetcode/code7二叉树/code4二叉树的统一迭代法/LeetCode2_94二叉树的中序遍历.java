package com.code.leetcode.code7二叉树.code4二叉树的统一迭代法;


import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode2_94二叉树的中序遍历 {

    public static void main(String[] args) {
        Integer[] root = new Integer[]{1,null,2,3};
        TreeNode treeNode = initMyTreeNode(root);
        System.out.println(inorderTraversal(treeNode));//[1,3,2]

        root = new Integer[]{};
        treeNode = initMyTreeNode(root);
        System.out.println(inorderTraversal(treeNode));//[]


        root = new Integer[]{1};
        treeNode = initMyTreeNode(root);
        System.out.println(inorderTraversal(treeNode));//[1]

        root = new Integer[]{1,2};
        treeNode = initMyTreeNode(root);
        System.out.println(inorderTraversal(treeNode));//[2,1]


        root = new Integer[]{1,null, 2};
        treeNode = initMyTreeNode(root);
        System.out.println(inorderTraversal(treeNode));//[1,2]

        root = new Integer[]{3,1,2};
        treeNode = initMyTreeNode(root);
        System.out.println(inorderTraversal(treeNode));//[1,3,2]

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            if (node == null) {
                node = deque.pop();
                res.add(node.val);
            } else {
                if (node.right != null) deque.push(node.right);
                deque.push(node);
                deque.push(null);
                if (node.left != null) deque.push(node.left);
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
