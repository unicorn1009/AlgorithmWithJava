package com.unicorn.Leetcode;

/**
 * <p>
 *     32. 最长有效括号
 *     给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * </p>
 * Created on 2021-8-5.
 *
 * @author Unicorn
 */
public class Solution0032 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()())"));
    }
    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                dp[i] = 0;
            }else { // ')'
                if (i > 0 && s.charAt(i-1) == '('){
                    if (i-2>=0)
                        dp[i] = dp[i-2] + 2;
                    else
                        dp[i] =  2;
                }else if (i > 0 && s.charAt(i-1) == ')'){   // ....))
                    // 判断 i-dp[i-1]-1 是否是'('
                    if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '('){
                        if (i-dp[i-1]-2 >= 0)
                            dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2];
                        else
                            dp[i] = dp[i-1] + 2;
                    }else {
                        dp[i] = 0;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
