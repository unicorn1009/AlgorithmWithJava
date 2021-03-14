package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;

/**
 * <p>
 *     剑指 Offer 27. 二叉树的镜像
 *      请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * </p>
 * Created on 2021/3/13.
 *
 * @author Unicorn
 */

public class JZ027 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }
}
