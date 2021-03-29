package com.unicorn.Leetcode;

import java.util.Arrays;

/**
 * <p>
 * </p>
 * Created on 2021/03/29 09:12
 *
 * @author Unicorn
 */
public class Solution0190 {
    public static void main(String[] args) {
        reverseBits(43261596);
    }
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        boolean[] bits = new boolean[32];
        for (int i = 0; i < 32; i++){
            if ((n&1) == 1) bits[i] = true;
            n >>>= 1;
        }
        int ans = 0;
        for (boolean bit : bits) {
            ans <<= 1;
            if (bit) ans += 1;
        }
        return ans;
    }
}
