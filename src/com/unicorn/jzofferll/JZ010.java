package com.unicorn.jzofferll;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     剑指 Offer II 010. 和为 k 的子数组
 * </p>
 * Created on 2021-8-13.
 *
 * @author Unicorn
 */
public class JZ010 {
    public static void main(String[] args) {
        System.out.println(subarraySum1(new int[]{1,2,1,2,1}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        // 求前缀和
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1]+nums[i];
        }
        int ans = 0;
        // map存每个前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 如果当前前缀和==k， 则答案++
            if (num == k) ans++;
            // map中查询是否存在两数之差
            int target = num - k;
            if (map.containsKey(target))
                ans += map.get(target);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;
    }

    // 优化为一个for
    public static int subarraySum1(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int pre =0;
        for (int num : nums) {
            int preSum = num + pre;
            if (preSum == k) ans++;
            int target = preSum - k;
            if (map.containsKey(target)) {
                ans += map.get(target);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            pre = preSum;
        }
        return ans;
    }

}
