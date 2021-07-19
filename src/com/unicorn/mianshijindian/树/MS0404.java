package com.unicorn.mianshijindian.树;

import com.unicorn.Leetcode.TreeNode;
import com.unicorn.util.TreeUtil;

/**
 * <p>
 *     面试题 04.04. 检查平衡性
 *     实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * </p>
 * Created on 2021-7-7.
 *
 * @author Unicorn
 */
public class MS0404 {
    public static void main(String[] args) {
        MS0404 ms0404 = new MS0404();
        TreeNode tree = TreeUtil.getTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(ms0404.isBalanced(tree));
    }
    public boolean isBalanced(TreeNode root) {
        // 后序遍历
        dfs(root);
        return ans;
    }

    private boolean ans = true;
    private int dfs(TreeNode treeNode){
        if (treeNode == null)
            return 0;

        int leftHeight = dfs(treeNode.left);
        int rightHeight = dfs(treeNode.right);
        if (Math.abs(leftHeight-rightHeight)>1)
            ans = false;
        return Math.max(leftHeight, rightHeight)+1;

    }
}
