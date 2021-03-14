package com.unicorn.jzoffer;

/*
    剑指 Offer 68 - II. 二叉树的最近公共祖先
 */

import com.unicorn.Leetcode.TreeNode;

public class JZ068_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null)
            return left;
        if (right != null)
            return right;
        if (contains(root, p) && contains(root, q)){
            return root;
        }else
            return null;

    }

    // 以root为根的树中是否包含指定节点node.
    private boolean contains(TreeNode root, TreeNode node){
        if (root == null)
            return false;
        if (root.val == node.val){
            return true;
        }
        return contains(root.left, node) || contains(root.right, node);
    }
}
