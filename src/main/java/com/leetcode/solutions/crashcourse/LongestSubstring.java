package com.leetcode.solutions.crashcourse;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        var len = lengthOfLongestSubstring1("pwwkew");
        System.out.println(len);
    }

    static int lengthOfLongestSubstring(String s) {
        // Implementation for finding the length of the longest substring without repeating characters

        int best = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (!seen.add(s.charAt(j))) break;      // add() returns false if already present
                best = Math.max(best, j - i + 1);
            }
        }
        return best;
    }

    static int lengthOfLongestSubstring1(String s) {
        int left = 0, best = 0;
        Set<Character> window = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))){
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
