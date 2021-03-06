package com.unicorn.Leetcode;

/**
 * <p>
 * </p>
 * Created on 2021/2/27.
 *
 * @author Unicorn
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
