package com.unicorn.笔试.虾皮.秋招2022;

import java.util.HashMap;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-19 3:58 下午
 */
public class 覆盖子串 {
    public static void main(String[] args) {
        System.out.println(findMinOverrideSubString("abcd", "bc"));
    }

    public static String findMinOverrideSubString(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(char ch : t.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                ////这个得改成equals
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while(valid == need.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    //这个得改成equals
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }

    public static String findMinOverrideSubString1(String source, String target) {
        // write code here

        if (target == null || target.length() == 0) return target;
        int sLen = source.length();
        int tLen = target.length();
        int left = 0;
        while (left < sLen && source.charAt(left) != target.charAt(0))
            left++;
        if (left >= sLen) return "";
        int right = left+1;
        int index = 1;
        while (right < sLen && index <tLen){
            if (source.charAt(right) == target.charAt(index))
                index++;
            right++;
        }
        if (index < tLen) return null;
        return source.substring(left,right);
    }

}
