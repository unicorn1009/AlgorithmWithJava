package com.unicorn.大厂热题;

/**
 * <p>
 *     在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * </p>
 * Created on 2021-8-2.
 *
 * @author Unicorn
 */
public class 数组中重复的数字 {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{6, 1, 2, 0, 3, 5, 3}));
    }
    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                if (nums[nums[i]] == nums[i]){
                    return nums[i];
                }else {
                    swap(nums, i, nums[i]);
                    i--;
                }
            }
        }
        return -1;
    }

    public static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
