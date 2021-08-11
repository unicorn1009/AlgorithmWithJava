package com.unicorn.Leetcode;

/**
 * <p>
 *     124. 二叉树中的最大路径和
 * </p>
 * Created on 2021-8-4.
 *
 * @author Unicorn
 */
public class Solution0124 {

    private int maxAns = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxAns;
    }

    // 后序递归
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        // 三种情况
        // 1. 路径为左边+当前节点
        // 2. 路径为右边+当前节点
        // 3. 路径为左边+当前节点+右边
        int sum = node.val + left + right;
        // 更新答案
        maxAns = Math.max(maxAns, sum);
        // 返回上一层的结果只能是选择当前节点左右两边的其中一边
        return node.val + Math.max(left, right);
    }
}
