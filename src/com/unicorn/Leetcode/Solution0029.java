package com.unicorn.Leetcode;

/**
 * <p>
 *     29. 两数相除
 *     给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *     示例:
 *     10 / 3 = 3
 *     7 / -3 = -2
 * </p>
 * Created on 2021-8-9.
 *
 * @author Unicorn
 */
public class Solution0029 {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648 ,-1));
    }

    public static int divide(int dividend, int divisor) {
        // 特殊情况处理
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        // 将两数都转为正整数处理
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int ans = 0;
        int shift = 31;
        // a 每次减去 b移shift位, 相当于 a - b * 2^shift
        while (a >= b){
            while (a < b << shift){
                shift--;
            }
            a -= b << shift;
            ans += 1 << shift;
        }
        return isNegative ? -ans : ans;
    }
}
