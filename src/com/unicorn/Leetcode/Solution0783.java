package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *     783. 二叉搜索树节点最小距离
 * </p>
 *
 * @author unicorn
 * @create 2021-04-13 10:29 下午
 */
public class Solution0783 {
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<>();
        dfs(root, nums);
        Collections.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < nums.size(); i++) {
            minDiff = Math.min(minDiff, Math.abs(nums.get(i)-nums.get(i-1)));
        }
        return minDiff;
    }

    public void dfs(TreeNode node, List<Integer> nums){
        if (node==null) return;

        nums.add(node.val);
        dfs(node.left, nums);
        dfs(node.right, nums);
    }
}
