package com.unicorn.Leetcode;

/**
 * <p>
 *     938. 二叉搜索树的范围和
 *     给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * </p>
 * Created on 2021/04/27 09:42
 *
 * @author Unicorn
 */
public class Solution0938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    private int sum;

    private void dfs(TreeNode node, int low, int high){
        if (node == null) return;
        if (node.val >= low && node.val <= high){
            sum += node.val;
        }
        if (node.val > low)
            dfs(node.left, low, high);
        if (node.val < high)
            dfs(node.right, low, high);
    }
}
