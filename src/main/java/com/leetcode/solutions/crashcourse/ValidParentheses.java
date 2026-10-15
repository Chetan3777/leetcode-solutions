package com.leetcode.solutions.crashcourse;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {

    static Map<Character, Character> closingToOpening = Map.of(
        ')', '(',
        '}', '{',
        ']', '['
    );

    public static void main(String[] args) {
        System.out.println(isValidStack("()[]{}"));
        System.out.println(isValidStack("([)]"));
    }

    static boolean isValidStack(String s) {
        // Implementation for checking if the stack is valid
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                var open = stack.pop();
                if (open != closingToOpening.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
