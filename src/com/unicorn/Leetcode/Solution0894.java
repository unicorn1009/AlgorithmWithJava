package com.unicorn.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     894. 所有可能的满二叉树
 * </p>
 * Created on 2021/03/17 20:34
 *
 * @author Unicorn
 */
public class Solution0894 {
    public List<TreeNode> allPossibleFBT(int n) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (n % 2 == 0) return ans;
        int count = 0;
        TreeNode root = new TreeNode(0);
        count++;
        dfs(root, n, count, ans, root);
        return ans;
    }

    private void dfs(TreeNode node, int n, int count, List<TreeNode> ans, TreeNode head) {
        if (count == n-2) {
            TreeNode left = new TreeNode(0);
            TreeNode right = new TreeNode(0);
            node.left = left;
            node.right = right;
            TreeNode newRoot = cloneTree(head);
            ans.add(newRoot);
            node.left = null;
            node.right = null;
            return;
        }
        // 尝试对node建立两个孩子节点
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(0);
        node.left = left;
        node.right = right;

        dfs(node.left, n, count+2, ans, head);
        dfs(node.right, n, count+2, ans, head);
    }

    public TreeNode cloneTree(TreeNode root){
        TreeNode node=null;
        if(root==null) return null;
        node=new TreeNode(root.val);
        node.left=cloneTree(root.left);
        node.right=cloneTree(root.right);

        return node;
    }
}
