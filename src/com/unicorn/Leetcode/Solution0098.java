package com.unicorn.Leetcode;

/**
 * <p>
 * </p>
 * Created on 2021-8-4.
 *
 * @author Unicorn
 */
public class Solution0098 {

    private int preNum = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (!left){
            return false;
        }
        if (root.val <= preNum){    // 不满足中序有序规律
            return false;
        }
        preNum = root.val;
        return isValidBST(root.right);
    }
}
