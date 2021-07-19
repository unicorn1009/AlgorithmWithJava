package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     TODO
 *     90. 子集 II
 *     给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 解集 不能 包含重复的子集。
 *     返回的解集中，子集可以按 任意顺序 排列
 *
 * Created on 2021/03/31 21:24
 *
 * @author Unicorn
 */
public class Solution0090 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 2, 4};
        List<List<Integer>> ans = new Solution0090().subsetsWithDup(ints);
        System.out.println(ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int depth = 0; depth <= len; depth++)
            dfs(nums, depth, path, ans, 0);
        return ans;
    }


    private void dfs(int[] nums, int depth, List<Integer> path, List<List<Integer>> ans, int index) {
        if (depth == 0){
            // 数量够了
            ans.add(new ArrayList<>(path));
            return;
        }
        // 数量不够
        for (int i = index; i < nums.length; i++) {
            // 关键是下面这个if continue
            // TODO 这个剪枝太妙了!
            if (i > index && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            dfs(nums, depth-1, path, ans, i+1);
            path.remove(path.size()-1);

        }
    }
}
