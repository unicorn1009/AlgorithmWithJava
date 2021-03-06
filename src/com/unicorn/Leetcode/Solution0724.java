package com.unicorn.Leetcode;

/**
 * <p>
 * </p>
 * Created on 2021-02-01.
 *
 * @author Unicorn
 */
public class Solution0724 {
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            for (int j = i; j < nums.length; j++) {
                if (j == i) continue;
                right += nums[j];
            }
            if (left == right){
                return i;
            }
        }

        return -1;
    }
    public int pivotIndex2(int[] nums) {
        int sum = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; ++i) {
            if (left == sum - left - nums[i]){
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

    public int pivotIndex3(int[] nums) {
        int sum = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; ++i) {
            if (left*2 + nums[i] == sum){
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
