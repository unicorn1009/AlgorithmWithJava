package com.unicorn.Leetcode;

import com.unicorn.util.ArrayUtil;

/**
 * <p>
 *     27. 移除元素
 * </p>
 * Created on 2021/04/19 15:43
 *
 * @author Unicorn
 */
public class Solution0027 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int i = new Solution0027().removeElement(arr, 2);
        ArrayUtil.printArray1D(arr);
    }
    public int removeElement(int[] nums, int val) {
        int i = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != val){
                i++;
                swap(nums, k, i);
            }
        }
        return i+1;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
