package com.leetcode.solutions.crashcourse;

public class BinarySearch {

    public static void main(String[] args) {
        int result = binarySearch(new int[]{1, 3, 5, 7, 9, 11}, 7);
        System.out.println(result);
    }

    static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
