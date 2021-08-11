package com.unicorn.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *     3. 无重复字符的最长子串
 * </p>
 *
 * @author unicorn
 * @create 2021-03-24 11:26 下午
 */
public class Solution0003 {
    public static void main(String[] args) {
        System.out.println(new Solution0003().lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int maxLen = 1;
        int preIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = preIndex; j < i; j++) {
                if (s.charAt(j) == c){
                    preIndex = j+1;
                }
            }
            maxLen = Math.max(maxLen, i - preIndex+1);
        }
        return maxLen;
    }

}
