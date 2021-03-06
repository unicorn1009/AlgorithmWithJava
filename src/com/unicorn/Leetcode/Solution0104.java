package com.unicorn.Leetcode;

/**
 * <p>
 *     104. 二叉树的最大深度
 *     给定一个二叉树，找出其最大深度。
 * </p>
 * Created on 2021/2/28.
 *
 * @author Unicorn
 */
public class Solution0104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null )
            return 1;
        else if (root.left == null){
            return maxDepth(root.right)+1;
        }else if (root.right == null){
            return maxDepth(root.left)+1;
        }else {
            return Math.max(maxDepth(root.right)+1, maxDepth(root.left)+1);
        }
    }
}
