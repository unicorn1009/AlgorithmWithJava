package com.unicorn.Leetcode;

/**
 * <p>
 * </p>
 * Created on 2021/2/27.
 *
 * @author Unicorn
 */
public class Solution0226 {
    public TreeNode invertTree(TreeNode root) {
        TreeNode r = invert(root);
        return r;
    }

    // 反转以node为根的二叉树, 返回反转后的二叉树的根
    private TreeNode invert(TreeNode node) {
        if (node == null) return null;

        TreeNode right = node.right;
        node.right = node.left;
        node.left = right;
        invert(node.left);
        invert(node.right);
        return node;
    }
}
