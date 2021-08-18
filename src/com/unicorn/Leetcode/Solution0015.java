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
        int[] test = new int[]{-4,-4,0,0,1,3,4,4};
        List<List<Integer>> lists = threeSum(test);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            // 如果首元素大于0, 则后面不可能找出两个数的和=-首元素
            if(nums[i] > 0) return ans;
            // 跳过重复解
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                if (nums[l] + nums[r] + nums[i] < 0){
                    ++l;
                }else if (nums[l] + nums[r] + nums[i] > 0){
                    --r;
                }else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                    // 跳过重复解
                    while (l<r && nums[l] == nums[l+1]){
                        ++l;
                    }
                    ++l;
                    while (l<r && nums[r] == nums[r-1]){
                        --r;
                    }
                    --r;
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
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
