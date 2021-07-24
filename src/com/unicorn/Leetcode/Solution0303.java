package com.unicorn.Leetcode;

/**
 * <p>
 *     303. 区域和检索 - 数组不可变
 * </p>
 * Created on 2021-7-20.
 *
 * @author Unicorn
 */
public class Solution0303 {

    public static void main(String[] args) {

    }


    class NumArray {

        private int[] arr;

        public NumArray(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] = nums[i]+nums[i-1];
            }
            this.arr = nums;
        }

        public int sumRange(int left, int right) {
            if (left > 0)
                return this.arr[right] - this.arr[left-1];
            else
                return this.arr[right];
        }
    }
}
