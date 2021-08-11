package com.unicorn.jzofferll;

import java.util.Arrays;

/**
 * <p>
 *     剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 *     给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 *     输入: n = 5
 *      输出: [0,1,1,2,1,2]
 * </p>
 * Created on 2021-8-9.
 *
 * @author Unicorn
 */
public class JZ003 {
    public static void main(String[] args) {
        System.out.println(1^5^1^5^3);
    }
    public static int[] countBits(int n) {
        int[] ret = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ret[i] = ret[i>>1];
            if (i % 2 == 1) ret[i]++;
        }
        return ret;
    }
}
