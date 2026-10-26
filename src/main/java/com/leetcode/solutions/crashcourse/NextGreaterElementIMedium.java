package com.leetcode.solutions.crashcourse;

import java.util.*;

public class NextGreaterElementIMedium {

    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        Arrays.fill(answer, -1);

        for(int i = 0; i < nums1.length; i++){
            answer = findNextGreaterElement(nums2, nums1[i], answer);
        }
        return answer;
    }

    int[] findNextGreaterElement(int[] nums2, int startingPoint, int[] answer){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }

        Deque<Integer> stack = new ArrayDeque<>();

        int indexOfStartingPoint = map.get(startingPoint);
        for(int j = indexOfStartingPoint; j < nums2.length; j++){
            while(!stack.isEmpty() && nums2[j] > stack.peek()){
                answer[j] = stack.peek();
            }
            stack.push(nums2[j]);

        }
        return answer;
    }
}
