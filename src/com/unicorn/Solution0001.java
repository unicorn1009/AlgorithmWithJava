package com.unicorn;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 * Created on 2021/5/31.
 *
 * @author Unicorn
 */
public class Solution0001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
