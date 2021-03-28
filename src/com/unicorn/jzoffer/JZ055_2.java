package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;

/**
 * <p>
 *     剑指 Offer 55 - II. 平衡二叉树
 *     输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * </p>
 * Created on 2021/03/25 09:56
 *
 * @author Unicorn
 */
public class JZ055_2 {
    public static void main(String[] args) {
        System.out.println(new JZ055_2().isBalanced(null));
    }
    public boolean isBalanced(TreeNode root) {
        int i = treeHeight(root);
        return i != -1;

    }

    private int treeHeight(TreeNode node){
        if (node == null) return 0;

        int leftHeight = treeHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = treeHeight(node.right);
        if (rightHeight == -1) return -1;
        return Math.abs(leftHeight-rightHeight)<=1 ? Math.max(leftHeight, rightHeight)+1 : -1;
    }
}
