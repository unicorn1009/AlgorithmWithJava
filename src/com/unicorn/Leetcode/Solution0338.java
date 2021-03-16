package com.unicorn.Leetcode;

import java.util.Arrays;

/**
 * <p>
 *     338.  比特位计数
 *     给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * </p>
 * Created on 2021/3/16 0016
 *
 * @author Unicorn
 */
public class Solution0338 {
    public static void main(String[] args) {
        int[] countBits = countBits(5);
        System.out.println(Arrays.toString(countBits));
    }
    public static int[] countBits(int num) {
        int[] bits = new int[num+1];
        bits[0] = 0;
        if (num == 0) return bits;
        bits[1] = 1;
        for (int i = 2; i <= num; i++) {
            bits[i] = bits[i&(i-1)]+1;
        }
        return bits;
    }
}
