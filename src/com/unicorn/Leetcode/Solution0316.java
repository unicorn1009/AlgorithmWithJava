package com.unicorn.Leetcode;

import java.util.*;

/**
 * <p>
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * </p>
 * Created on 2021-7-13.
 *
 * @author Unicorn
 */
public class Solution0316 {

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters1("asadsdasfsadf"));
    }


    public static String removeDuplicateLetters(String s) {
        // 单调栈
        Stack<Character> stack = new Stack<>();
        // 遍历一遍，记录每个字符出现次数
        Map<Character, Integer> charCount = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (charCount.containsKey(s.charAt(i))) {
                charCount.put(s.charAt(i), charCount.get(s.charAt(i)) + 1);
            } else {
                charCount.put(s.charAt(i), 0);
            }
        }
        stack.push(s.charAt(0));
        set.add(s.charAt(0));
        // 遍历第二遍
        for (int i = 1; i < s.length(); i++) {
            char curChar = s.charAt(i);
            // 栈中已存在, 直接丢弃
            if (set.contains(curChar)){
                charCount.put(curChar, charCount.get(curChar) - 1);
            }else {
                // 栈中不存在curChar
                while (!stack.isEmpty() && curChar <= stack.peek() && charCount.get(stack.peek()) > 0) {
                    charCount.put(stack.peek(), charCount.get(stack.peek()) - 1);
                    set.remove(stack.peek());
                    stack.pop();
                }
                stack.push(curChar);
                set.add(curChar);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty())
            ans.insert(0, stack.pop());

        return ans.toString();
    }


    // 使用数组代替Map
    public static String removeDuplicateLetters1(String s) {
        // 单调栈
        Stack<Character> stack = new Stack<>();

        // 遍历一遍，记录每个字符出现次数
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)-'a']++;
        }
        stack.push(s.charAt(0));
        boolean[] inStack = new boolean[26];
        inStack[s.charAt(0) - 'a'] = true;
        // 遍历第二遍
        for (int i = 1; i < s.length(); i++) {
            char curChar = s.charAt(i);
            // 栈中已存在, 直接丢弃
            if (inStack[curChar-'a']){
                charCount[curChar-'a']--;
            }else {
                // 栈中不存在curChar
                while (!stack.isEmpty() && curChar <= stack.peek() && charCount[stack.peek()-'a'] > 1) {
                    charCount[stack.peek()-'a']--;
                    inStack[stack.peek() - 'a'] = false;
                    stack.pop();
                }
                stack.push(curChar);
                inStack[curChar-'a'] = true;
            }
        }

        int c = stack.size();
        char[] aaa = new char[c];

        while (!stack.isEmpty()) {
            aaa[--c] = stack.pop();
        }

        return new String(aaa);
    }

}
