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
        // 计算左子树的高度
        int leftHeight = treeHeight(node.left);
        // 如果左子树高度为-1, 说明左子树不平衡
        if (leftHeight == -1) return -1;
        // 计算右子树的高度
        int rightHeight = treeHeight(node.right);
        // 如果右子树高度为-1, 说明右子树不平衡
        if (rightHeight == -1) return -1;
        // 如果左子树右子树的高度差不超过1, 则返回最大高度, 超过1则返回-1表示不平衡
        return Math.abs(leftHeight-rightHeight)<=1 ? Math.max(leftHeight, rightHeight)+1 : -1;
    }
}
