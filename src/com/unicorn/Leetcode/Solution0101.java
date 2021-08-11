package com.unicorn.Leetcode;

/**
 * <p>
 *     101. 对称二叉树
 * </p>
 * Created on 2021/3/2.
 *
 * @author Unicorn
 */
public class Solution0101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val == node2.val){
            boolean f1 = isSymmetric(node1.left, node2.right);
            boolean f2 = isSymmetric(node1.right, node2.left);
            return f1 && f2;
        }else
            return false;
    }
}
