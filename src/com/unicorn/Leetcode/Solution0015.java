package com.unicorn.Leetcode;

import java.util.*;

/**
 * <p>
 *     15. 三数之和
 *      -- 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * </p>
 * Created on 2021-01-31.
 *
 * @author Unicorn
 */
public class Solution0015 {
    public static void main(String[] args) {
        int[] test = new int[]{-4,2,2,2,2,2};
        List<List<Integer>> lists = threeSum(test);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> listList = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int sumResult = -nums[i];
            HashMap<Integer, Integer> integers = new HashMap<>();
            for (int j = i; j < nums.length; j++) {
                if (j == i) continue;
                if (integers.containsKey(sumResult-nums[j])){
                    // 找到一组结果, 下标分别是i, j, map中的值
                    Integer[] arr = new Integer[]{-sumResult, nums[j], nums[integers.get(sumResult-nums[j])]};
                    Arrays.sort(arr);
                    listList.add(new ArrayList<>(Arrays.asList(arr)));
                }else {
                    integers.put(nums[j], j);
                }

            }
        }
        ArrayList<List<Integer>> lists = new ArrayList<>(listList);
        return lists;
    }
}
