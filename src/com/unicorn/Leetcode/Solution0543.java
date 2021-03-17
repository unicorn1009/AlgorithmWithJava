package com.unicorn.Leetcode;

import com.unicorn.util.TreeUtil;

import java.util.List;

/**
 * <p>
 *     543. 二叉树的直径
 *     给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * </p>
 * Created on 2021/3/16
 *
 * @author Unicorn
 */
public class Solution0543 {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.genCompleteBTree(new int[]{1, 2, 3, 4, 5});
        System.out.println(new Solution0543().diameterOfBinaryTree(root));
    }

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }


    // 返回以node为根的树的最大深度
    private int maxDepth(TreeNode node){
        if (node == null) return 0;
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        ans = Math.max(ans, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }


}
