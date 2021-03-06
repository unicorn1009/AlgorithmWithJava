package com.unicorn.jzoffer;

import java.util.Arrays;

/**
 * <p>
 *     数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *     你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * </p>
 * Created on 2021/3/2.
 *
 * @author Unicorn
 */
public class JZ039 {
    // 排序法
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // 摩尔投票法
    public int majorityElement1(int[] nums) {
        int ret = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                ret = nums[i];
                count ++;
            }else if (nums[i] == ret){
                count ++;
            }else if (nums[i] != ret){
                count --;
            }
        }
        return ret;
    }
}
