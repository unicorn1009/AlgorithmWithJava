package com.unicorn.Leetcode.week;

/**
 * <p>
 * </p>
 * Created on 2021/03/21 10:31
 *
 * @author Unicorn
 */
public class 最大升序子数组和 {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{1,100,1}));
    }
    public static int maxAscendingSum(int[] nums) {
        int ans = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                curSum += nums[i];
            }else {
                // 更新ans
                ans = Math.max(ans, curSum);
                curSum = nums[i];
            }
        }
        ans = Math.max(ans, curSum);
        return ans;
    }
}
