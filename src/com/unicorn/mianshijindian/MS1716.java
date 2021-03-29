package com.unicorn.mianshijindian;

/**
 * <p>
 *     // 面试题 17.16. 按摩师
 *     一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * </p>
 * Created on 2021/03/26 20:22
 *
 * @author Unicorn
 */
public class MS1716 {
    public static void main(String[] args) {
        System.out.println(new MS1716().massage1(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }

    // O(n^2)
    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        int[] ans = new int[nums.length];

        int max = nums[0];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp =  0;
            for (int j = 0; j < i - 1; j++) {
                temp = Math.max(temp, ans[j]);
            }
            ans[i] = temp + nums[i];
            max = Math.max(max, ans[i]);
        }
        return max;
    }

    // O(n)
    public int massage1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        ans[1] = nums[1];
        int max = Math.max(nums[0], nums[1]);
        int beforeMax = 0;
        for (int i = 2; i < nums.length; i++) {
            beforeMax = Math.max(beforeMax, ans[i-2]);
            ans[i] = beforeMax+nums[i];
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}
