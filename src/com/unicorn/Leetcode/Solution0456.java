package com.unicorn.Leetcode;

/**
 * <p>
 *     456. 132模式
 * </p>
 * Created on 2021/03/24 08:58
 *
 * @author Unicorn
 */
public class Solution0456 {
    public boolean find132pattern(int[] nums) {
        int minNum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minNum){
                minNum = nums[i];
            }else if (nums[i] > minNum){
                // 找到一个比前面最小的数子更大的数
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] > minNum && nums[j] < nums[i]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
