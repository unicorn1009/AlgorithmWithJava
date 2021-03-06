package com.unicorn.Leetcode;

import java.util.Arrays;

/**
 * <p>
 *     169. 多数元素
 *     给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于n/2的元素。
 *     你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * </p>
 * Created on 2021/2/28.
 *
 * @author Unicorn
 */
public class Solution0169 {
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
