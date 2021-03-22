package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    39. 组合总和
    给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。

    candidates中的数字可以无限制重复被选取。

 */
public class Solution0039 {
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        System.out.println(new Solution0039().combinationSum(nums, 7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, target, ans, new ArrayList<>(), 0, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> path, int sum, int index){
        if (sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }else if (sum > target){
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
//            System.out.println(path);
            sum += candidates[i];
            dfs(candidates, target, ans, path, sum, i);
            sum -= candidates[i];
            path.remove(path.size()-1);
        }
    }
}
