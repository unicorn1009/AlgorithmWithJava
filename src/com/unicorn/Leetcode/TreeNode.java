package com.unicorn.Leetcode;

/**
 * <p>
 * </p>
 * Created on 2021/2/27.
 *
 * @author Unicorn
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
