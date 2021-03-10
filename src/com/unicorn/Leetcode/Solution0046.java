package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     46. 全排列
 *     练习回溯法的经典
 *
 * </p>
 * Created on 2021-01-31.
 *
 * @author Unicorn
 */

public class Solution0046 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution0046 solution = new Solution0046();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);

    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, used, len, 0, ans, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums, boolean[] used, int len, int depth, List<List<Integer>> ans, List<Integer> list){
        if (len == depth){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]){
                list.add(nums[i]);
                used[i] = true;
                dfs(nums, used, len, depth+1, ans, list);
                used[i] = false;
                list.remove(Integer.valueOf(nums[i]));
            }
        }
    }
}
