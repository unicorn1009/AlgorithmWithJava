package com.unicorn.jzoffer;

/*
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */

public class JZ010_1 {
    public static void main(String[] args) {
        System.out.println(fib1(48));
    }


    // 使用数组
    public static int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[] nums = new long[2];
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            long res = (nums[0] + nums[1])%1000000007;
            nums[0] = nums[1];
            nums[1] = res;
        }
        return (int)(nums[1]);
    }


    // 超时
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fib(n-1) + fib(n-2))%1000000007;
    }

}
