package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;

/**
 * <p>
 *      剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * </p>
 * Created on 2021/3/12.
 *
 * @author Unicorn
 */

public class JZ068_1 {
    public static void main(String[] args) {
        System.out.println("1");
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val) return p;
        if (root.val == q.val) return q;
        if (root.val > Math.min(p.val, q.val) && root.val < Math.max(p.val, q.val)){
            return root;
        }else if (root.val < Math.min(p.val, q.val)){
            return lowestCommonAncestor(root.right, p, q);
        }else
            return lowestCommonAncestor(root.left, p, q);
    }
}
