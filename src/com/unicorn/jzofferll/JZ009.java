package com.unicorn.jzofferll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     剑指 Offer II 009. 乘积小于 K 的子数组
 *     给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 * </p>
 * Created on 2021-8-13.
 *
 * @author Unicorn
 */
public class JZ009 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }

    // 只输出答案个数
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        int curProd = 1;
        for (int right = 0; right < nums.length; right++) {
            curProd = curProd * nums[right];
            while (curProd >= k && left <= right) curProd = curProd / nums[left++];
            // curProd < k , 窗口内都是答案
            ans += right - left + 1;
        }
        return ans;
    }

    // 输出所有子数组
    public static List<int[]> numSubarrayProductLessThanK1(int[] nums, int k) {
        int left = 0;
        List<int[]> ans = new ArrayList<>();
        int curProd = 1;
        for (int right = 0; right < nums.length; right++) {
            curProd = curProd * nums[right];
            while (curProd >= k && left <= right) curProd = curProd / nums[left++];
            // curProd < k , 窗口内都是答案
            for (int i = left; i <= right; i++) {
                int[] temp = new int[right-i+1];
                System.arraycopy(nums, i, temp, 0 , temp.length);
                ans.add(temp);
            }
        }
        return ans;
    }
}
