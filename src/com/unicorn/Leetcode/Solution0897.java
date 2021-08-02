package com.unicorn.Leetcode;

import com.unicorn.util.TreeUtil;

/**
 * <p>
 *     897. 递增顺序搜索树
 *     给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 *     使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * </p>
 *
 * @author unicorn
 * @create 2021-04-25 9:36 上午
 */
public class Solution0897 {
    public static void main(String[] args) {
        TreeNode tree = TreeUtil.getTree(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9});
        TreeUtil.showTree(tree);
        TreeNode ret = new Solution0897().increasingBST(tree);
        TreeUtil.showTree(ret);
    }
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode dummyHead = new TreeNode(-1);
        preNode = dummyHead;
        dfs(root);
        return dummyHead.right;
    }

    private TreeNode preNode;

    private void dfs(TreeNode node){
        if (node == null) return;
        dfs(node.left);
        preNode.right = node;
        node.left = null;
        preNode = node;
        dfs(node.right);
    }
}
