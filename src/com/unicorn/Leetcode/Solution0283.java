package com.unicorn.Leetcode;

/**
 * <p>
 *     移动零
 * </p>
 * Created on 2021/2/28.
 *
 * @author Unicorn
 */
public class Solution0283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                swap(nums, index, i);
                index++;
            }
        }

    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
