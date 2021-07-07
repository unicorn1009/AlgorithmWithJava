package com.unicorn.niuke.数组;

/**
 * <p>
 *     请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）
 * </p>
 * Created on 2021/04/27 19:26
 *
 * @author Unicorn
 */
public class 斐波那契数列 {
    public int Fibonacci(int n) {
        if (n <= 0) return n;
        int[] dp = new int[2];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
}
