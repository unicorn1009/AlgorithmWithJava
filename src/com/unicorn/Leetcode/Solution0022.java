package com.unicorn.Leetcode;

import java.util.*;

/**
 * <p>
 * </p>
 * Created on 2021-01-29.
 *
 * @author Unicorn
 */
public class Solution0022 {
    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> hashSet = new ArrayList<>();
        addBracket("", '(', n, hashSet);
        hashSet.forEach(s -> System.out.println(s));
        return hashSet;
    }

    private static boolean Filter(String s) {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < s.length(); j++) {
            // 遇到左括号入栈, 遇到右括号出栈
            if (s.charAt(j) == '(') {
                stack.push(s.charAt(j));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private static boolean Filter2(String s){
        if (s.startsWith("(") && s.endsWith(")")){
            int left= 0;
            int right = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '('){
                    left++;
                }else {
                    right++;
                }
            }
            if (left == right) return true;
            else return false;
        }
        return false;
    }

    public static void addBracket(String s,char c, int n, List<String> result){
        s += c;
        if (s.length() == n<<1){
            if (Filter2(s)){
                result.add(s);
            }
            return;
        }
        addBracket(s, '(', n, result);
        addBracket(s, ')', n, result);
    }
}
