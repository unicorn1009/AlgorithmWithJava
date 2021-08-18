package com.unicorn.jzofferll;

/**
 * <p>
 *
 *     15
 * [1,2,3,4,5]
 * </p>
 * Created on 2021-8-12.
 *
 * @author Unicorn
 */
public class JZ008 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(5, new int[]{1,2,3,4,5}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0;
        int curSum = 0, ans = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            curSum = curSum + nums[right];
            if (curSum >= target){
                // 满足条件， 左指针右移
                while (left <= right){
                    if (curSum - nums[left] >= target){
                        curSum = curSum-nums[left];
                        left++;
                    }else {
                        ans = Math.min(ans, right-left+1);
                        break;
                    }
                }
                if (ans == 1) return ans;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 简化代码
    public int minSubArrayLen1(int s, int[] nums) {
        int left = 0, right = 0;
        int curSum = 0, ans = Integer.MAX_VALUE;
        while (right < nums.length) {
            curSum += nums[right++];
            while (curSum >= s) {
                ans = Math.min(ans, right - left);
                curSum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
