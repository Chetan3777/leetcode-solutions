package com.leetcode.solutions.crashcourse;

import com.leetcode.solutions.crashcourse.tree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> result = levelOrder(tree);
        System.out.println(result);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.poll();
        System.out.println(deque);
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            answer.add(level);
        }

        return answer;
    }
}
