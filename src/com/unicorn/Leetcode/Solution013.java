package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     113. 路径总和 II
 *     面试题34. 二叉树中和为某一值的路径
 * </p>
 * Created on 2021/03/30 10:20
 *
 * @author Unicorn
 */
public class Solution013 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        // 回溯
        int curSum = 0;
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> path = new ArrayList<>();
        dfs(root, target, curSum, ans, path);
        return ans;
    }

    private void dfs(TreeNode node, int target, int curSum, List<List<Integer>> ans, List<Integer> path) {
        if (node.left == null && node.right == null){
            if (curSum+node.val == target){
                //找到一个答案
                path.add(node.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size()-1);
                return;
            }else
                return;
        }

        path.add(node.val);
        if (node.left != null)
            dfs(node.left, target,curSum+node.val, ans, path);
        if (node.right != null)
            dfs(node.right, target,curSum+node.val, ans, path);
        path.remove(path.size()-1);
    }

}
