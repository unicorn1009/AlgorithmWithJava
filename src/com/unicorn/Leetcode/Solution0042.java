package com.unicorn.Leetcode;

/**
 * <p>
 *     42. 接雨水
 * </p>
 * Created on 2021-8-4.
 *
 * @author Unicorn
 */
public class Solution0042 {
    public static void main(String[] args) {
        Solution0042 solution0042 = new Solution0042();
        System.out.println(solution0042.trap3(new int[]{4,2,0,3,2,5}));
    }

    // 方法一 : 暴力
    public int trap1(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length-1; i++) {
            int leftMaxHi = findMax(height, 0, i);
            int rightMaxHi = findMax(height, i+1, height.length-1);
            int cur = Math.min(leftMaxHi, rightMaxHi) - height[i];
            if (cur>0) ans += cur;
        }
        return ans;
    }

    // 在[left, right]区间找最大值
    private int findMax(int[] arr, int left, int right) {
        int ret = arr[left];
        while (left <= right){
            ret = Math.max(ret, arr[left]);
            left++;
        }
        return ret;
    }

    // 方法二, 动归, 思路与上面暴力一样, 但是我们用两个数组先记录下num[i]左右的最大值
    public int trap2(int[] height) {
        int n = height.length; if (n <= 1) return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        // 记录num[i]左边最大值(包含i)
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        // 记录num[i]右边最大值(包含i)
        rightMax[n -1] = height[n -1];
        for (int i = n -2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        // 求结果
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    // 优化方法二
    public int trap3(int[] height) {
        int n = height.length; if (n <= 1) return 0;
        int[] rightMax = new int[n];

        rightMax[n -1] = height[n -1];
        for (int i = n -2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int ans = 0;
        int leftMax = height[0];
        for (int i = 1; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            ans += Math.min(leftMax, rightMax[i]) - height[i];
        }
        return ans;
    }

}
