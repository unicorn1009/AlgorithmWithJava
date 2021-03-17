package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     563. 二叉树的坡度
 * </p>
 *
 * @author unicorn
 * @create 2021-03-16 11:55 下午
 */
public class Solution0563 {

    int ret;

    public int findTilt(TreeNode root) {
        tilt(root);
        return ret;
    }

    // 计算树的坡度 = 左子树和-右子树和
    public int tilt(TreeNode node){
        if (node == null) return 0;
        if (node.right == null &&node.left == null) return node.val;
        int left = tilt(node.left);
        int right = tilt(node.right);
        int abs = Math.abs(left-right);
        ret += abs;
        return node.val+left+right;
    }
}
