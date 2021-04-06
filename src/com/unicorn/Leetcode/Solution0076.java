package com.unicorn.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     76. 最小覆盖子串
 * </p>
 * Created on 2021/04/06 21:40
 *
 * @author Unicorn
 */
public class Solution0076 {
    public static void main(String[] args) {

        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";
        System.out.println(minWindow(s1, s2));
    }
    public static String minWindow(String s, String t) {
        Map<Character, Integer> targetCount = new HashMap<>();
        Map<Character, Integer> windowCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetCount.put(t.charAt(i), targetCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        int satCount = 0;   // 当前窗口中满足的字符的个数
        int left = 0, right = 0;
        String ans = s+"a";
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if (targetCount.containsKey(c)){
                // 往窗口中加入该字符
                windowCount.put(c, windowCount.getOrDefault(c,0)+1);
                // 判断该字符个数是否达到要求
                if (targetCount.get(c).equals(windowCount.get(c))){
                    satCount++;

                }
            }

            while (satCount == targetCount.size()){
                // 更新答案
                if (right-left < ans.length()){
                    ans = s.substring(left, right);
                }
                // 窗口中此时包含target所有字符， 开始左端往右移动
                char leftChar = s.charAt(left);
                left++;
                // 移除一个字符后，更新窗口元素，并判断是否需要更新satCount
                if (windowCount.containsKey(leftChar)){
                    windowCount.put(leftChar, windowCount.get(leftChar)-1);
                    if (windowCount.get(leftChar) < targetCount.get(leftChar)){
                        satCount--;
                    }
                }
            }

        }
        return ans.length() == s.length()+1 ? "" : ans;
    }
}
