package com.unicorn.jzofferll;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *      剑指 Offer II 011. 0 和 1 个数相同的子数组
 * </p>
 * Created on 2021-8-13.
 *
 * @author Unicorn
 */
public class JZ011 {
    public static void main(String[] args) { 
        System.out.println(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0}));
    }

    public static int findMaxLength(int[] nums) {
        if (nums[0] == 0){
            nums[0] = -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0){
                nums[i] = nums[i-1]-1;
            }else {
                nums[i] = nums[i-1]+1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) ans = Math.max(ans, i+1);
            if (map.containsKey(nums[i])){
                ans = Math.max(ans, i - map.get(nums[i]));
            }else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
