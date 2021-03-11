package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;

/**
 * <p>
 *     剑指 Offer 55 - I. 二叉树的深度
 * </p>
 *
 * @author unicorn
 * @create 2021-03-07 10:16 下午
 */
public class JZ055_1 {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    public int depth(TreeNode node){
        if (node == null) return 0;
        if (node.left == null && node.right == null)
            return 1;
        return Math.max(depth(node.left), depth(node.right))+1;
    }
}
