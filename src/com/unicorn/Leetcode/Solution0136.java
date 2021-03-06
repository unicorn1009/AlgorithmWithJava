package com.unicorn.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     136. 只出现一次的数字
 *     给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * </p>
 * Created on 2021/2/28.
 *
 * @author Unicorn
 */
public class Solution0136 {
    public static void main(String[] args) {
        int[] arr = {2,5,2};
        Solution0136 aaa = new Solution0136();
        System.out.println(aaa.singleNumber1(arr));
    }

    public int result;
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }

        map.forEach((key, value) -> {
            if (value == 1){
                result = key;
            }
        });
        return result;
    }

    // 不使用额外空间的方法: 异或运算
    public int singleNumber1(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
