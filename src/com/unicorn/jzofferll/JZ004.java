package com.unicorn.jzofferll;

import java.util.Arrays;

/**
 * <p>
 * 剑指 Offer II 004. 只出现一次的数字
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * </p>
 * Created on 2021-8-10.
 *
 * @author Unicorn
 */
public class JZ004 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, -1, 2}));
    }

    public static int singleNumber(int[] nums) {
        int[] bitCounts = new int[32];
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                if ((num & 1) == 1) {
                    bitCounts[i]++;
                }
                num = num >> 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = ans<<1;
            ans += bitCounts[i] % 3;
        }
        return ans;
    }


}
