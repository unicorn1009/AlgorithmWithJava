package com.unicorn.Leetcode;

/**
 * <p>
 * </p>
 * Created on 2021/2/27.
 *
 * @author Unicorn
 */
public class Solution0617 {

    public static void main(String[] args) {
        new Solution0617().mergeTrees(null, null);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        TreeNode r = merge(root1, root2);
        return r;
    }

    // 合并分别以node1和node2为根的二叉树, 返回合并后的根
    private TreeNode merge(TreeNode node1, TreeNode node2){

        if (node1 == null) return node2;
        if (node2 == null) return node1;

        node1.val += node2.val;
        node1.left = merge(node1.left, node2.left);
        node1.right = merge(node1.right, node2.right);

        return node1;
    }
}
