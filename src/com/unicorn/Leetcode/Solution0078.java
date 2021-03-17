package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *     给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *      解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * </p>
 * Created on 2021/03/17 15:29
 *
 * @author Unicorn
 */
public class Solution0078 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution0078().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(0));    // 空集

        for (int depth = 1; depth <= nums.length; depth++) {
            dfs(nums, ans, depth, new ArrayList<Integer>(), 0);
        }

        return ans;
    }

    // 回溯
    private void dfs(int[] nums, List<List<Integer>> ans, int depth, ArrayList<Integer> path, int index) {
        if (depth == 0){
            ans.add(new ArrayList<>(path));
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, ans, depth-1, path, i+1);
            path.remove(path.size()-1);
        }
    }



}
