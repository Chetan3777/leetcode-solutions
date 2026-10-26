package com.leetcode.solutions.crashcourse;

import com.sun.tools.javac.Main;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] input = new int[]{4, 2, 5, 3, 6};
        int[] result = nextGreaterElement(input);
        if (result != null) {
            for (int num : result) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("No greater element found");
        }
    }

    static int[] nextGreaterElement(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++){
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                answer[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }

        return answer;
    }
}

