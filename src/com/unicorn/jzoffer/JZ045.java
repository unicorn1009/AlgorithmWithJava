package com.unicorn.jzoffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>
 *     剑指 Offer 45. 把数组排成最小的数
 * </p>
 *
 * @author unicorn
 * @create 2021-07-26 11:25 下午
 */
public class JZ045 {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (int)(Long.valueOf(o1+o2) - Long.valueOf(o2+o1));
            }
        });
        String ans = "";
        for (String num : strings) {
            ans += num;
        }
        return ans;
    }
}
