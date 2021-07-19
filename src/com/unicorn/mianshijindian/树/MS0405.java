package com.unicorn.mianshijindian.树;

import com.sun.org.apache.bcel.internal.generic.FADD;
import com.unicorn.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     面试题 04.05. 合法二叉搜索树
 *     实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * </p>
 * Created on 2021-7-7.
 *
 * @author Unicorn
 */
public class MS0405 {

    public boolean isValidBST1(TreeNode root) {
        return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean isValidBST1(TreeNode node, long min, long max) {
        if (node == null)
            return true;
        // 先序遍历

        if (node.val <= min || node.val >= max)
            return false;

        return isValidBST1(node.left, min, node.val) && isValidBST1(node.right, node.val, max);
    }


    private List<Integer> values;

    public boolean isValidBST(TreeNode root) {

        values = new ArrayList<>();
        dfs(root);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) <= values.get(i-1))
                return false;
        }
        return true;
    }
    // 二叉搜索用中序
    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        values.add(root.val);
        dfs(root.right);
    }

}
