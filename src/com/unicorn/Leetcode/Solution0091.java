package com.unicorn.Leetcode;

/**
 * <p>
 * 91. 解码方法
 * 思路 : 动规
 * 1. 如果当前数字可以与前一数字组合形成字母,则以当前数字结束的子串最大组合可能为(不与前一数字组合的可能)+(与前一数字组合的可能) = pre+prePre
 * 2. 如果当前数字不可以与前一数字组合形成字母, 则以当前数字结束的子串最大组合可能为pre
 * 当前数字为0或者上一数字为0需要特殊考虑
 * </p>
 *
 * @author unicorn
 * @create 2021-04-21 10:12 上午
 */
public class Solution0091 {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] ans = new int[s.length()];
        ans[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '0'){
                if (s.charAt(i-1) != '1' && s.charAt(i-1) != '2'){
                    return 0;
                }else {
                    // 当前数字为0,则只能与上一数组组合,即上一数字只能与当前0组合,上一数字的动规结果需更改为单独成组的结果
                    if (i>=2)
                        ans[i-1] = ans[i-2];
                    ans[i] = ans[i-1];
                }
            }else { // 当前数字不为0
                if (s.charAt(i-1) == '0'){
                    // 如果上一个数字为0
                    ans[i] = ans[i-1];
                }else {
                    // 上一数字不为0
                    int zuhe = Integer.parseInt(s.substring(i - 1, i + 1));
                    if (zuhe >= 1 && zuhe <= 26){
                        // 可组合
                        if (i>=2)
                            ans[i] = ans[i-1]+ans[i-2];
                        else
                            ans[i] = ans[i-1]+1;
                    }else {
                        ans[i] = ans[i-1];
                    }
                }
            }
        }
        return ans[s.length()-1];
    }
}
