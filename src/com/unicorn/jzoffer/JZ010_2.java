package com.unicorn.jzoffer;

/*
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */

public class JZ010_2 {
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] nums = new long[2];
        nums[0] = 1;
        nums[1] = 2;
        for (int i = 3; i <= n; i++) {
            long res = (nums[0] + nums[1])%1000000007;
            nums[0] = nums[1];
            nums[1] = res;
        }
        return (int)(nums[1]);
    }
}
