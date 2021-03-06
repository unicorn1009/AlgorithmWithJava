package com.unicorn.Leetcode;

/**
 * <p>
 *     461. 汉明距离
 *     两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *      给出两个整数 x 和 y，计算它们之间的汉明距离。
 * </p>
 * Created on 2021/2/27.
 *
 * @author Unicorn
 */
public class Solution0461 {
    public static void main(String[] args) {
        new Solution0461().hammingDistance(104,5);
    }
    public int hammingDistance(int x, int y) {
        int r = x^y;
        int ret = 0;
        String s = Integer.toBinaryString(r);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                ret += 1;
            }
        }
        return ret;
    }

    // 更简洁方法 : leetcode官方
    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

}
