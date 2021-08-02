package com.unicorn.大厂热题;

import com.unicorn.Leetcode.TreeNode;

/**
 * <p>
 * </p>
 *
 * @author unicorn
 * @create 2021-07-22 11:56 上午
 */
public class 最近公共祖先 {


    // 以node为根的子树是否包含p和q, 如果都包含返回当前根节点;如果只含有p,返回p;只含有q返回q;都不含,返回null
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q)
            return node;
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        if (left == null && right == null)
            return null;
        else if (left != null && right != null)
            return node;
        else
            return left!=null?left:right;
    }

    // 方法二,记录父节点


}
