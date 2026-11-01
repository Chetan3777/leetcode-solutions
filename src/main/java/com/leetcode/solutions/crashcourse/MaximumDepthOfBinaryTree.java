package com.leetcode.solutions.crashcourse;

import com.leetcode.solutions.crashcourse.tree.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int maxDepth = maxDepth(treeNode);
        System.out.println("Maximum depth: " + maxDepth);
    }

    static int maxDepth(TreeNode root) {
        if (root == null) return 0;              // base case: nothing here
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
