package com.unicorn.Leetcode;

/**
 * <p>
 *     213. 打家劫舍 II
 *     这个地方所有的房屋都 围成一圈
 *     如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * </p>
 * Created on 2021/04/05 21:34
 *
 * @author Unicorn
 */
public class Solution0213 {
    public static void main(String[] args) {
        System.out.println(rob1(new int[]{1, 2, 3, 1}));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        else if (len == 1) return nums[0];
        else if (len == 2) return Math.max(nums[0], nums[1]);

        int temp = nums[0];
        nums[0] = 0;
        int one = rob1(nums);
        nums[0] = temp;
        nums[len-1] = 0;
        int two = rob1(nums);
        return Math.max(one, two);
    }

    public static int rob1(int[] nums) {

        int[] dp = new int[3];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[2] = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}
