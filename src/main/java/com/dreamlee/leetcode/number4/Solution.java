package com.dreamlee.leetcode.number4;

import java.util.Stack;

/**
 * @author: DreamLee
 * @date: Created on 21:52 2018/11/13
 * @description:
 * @modified:
 */
public class Solution {

    public static void main(String[] args) {
        String testStr = "(]";
        Solution solution = new Solution();
        boolean isValid = solution.isValid(testStr);
        System.out.println(isValid);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if ('(' == c || '[' == c || '{' == c)
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                else {
                    Character pop = stack.pop();
                    if ('(' == pop && ')' != c)
                        return false;
                    if ('[' == pop && ']' != c)
                        return false;
                    if ('{' == pop && '}' != c)
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
