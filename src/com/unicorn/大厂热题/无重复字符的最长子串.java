package com.unicorn.大厂热题;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *     3. 无重复字符的最长子串
 *     给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * </p>
 * Created on 2021-7-13.
 *
 * @author Unicorn
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String x  = "pwwkew";
        System.out.println(lengthOfLongestSubstring(x));
        System.out.println(lengthOfLongestSubstring1(x));
    }

    // 滑动窗口 O(n)
    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> occ = new HashSet<Character>();  // 包含窗口内所有字符
        int endIndex = 0;
        int maxLen = 0;
        // 窗口大小为[i, endIndex]
        for (int i = 0; i < s.length(); i++) {
            while (endIndex < s.length() && !occ.contains(s.charAt(endIndex))){
                // 窗口扩大
                occ.add(s.charAt(endIndex));
                endIndex++;
            }
            // 跳出了while, 即出现与窗口内重复的字符
            // 窗口缩小(i++)
            maxLen =Math.max(occ.size(), maxLen);
            occ.remove(s.charAt(i));
        }

        return maxLen;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1){
            return s.length();
        }
        int startIndex = 0;
        int maxLen = 1;
        for (int endIndex = 1; endIndex < s.length(); endIndex++) {
            int tempLen = 1;
            for (int i = startIndex; i < endIndex ; i++) {
                if (s.charAt(i) == s.charAt(endIndex)){
                    startIndex = i+1;
                    break;
                }else {
                    tempLen++;
                }
            }
            maxLen = Math.max(maxLen, tempLen);
        }
        return maxLen;
    }


}
