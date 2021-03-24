package com.unicorn.Leetcode;

import com.unicorn.util.TreeUtil;

/**
 * <p>
 *     114. 二叉树展开为链表
 * </p>
 * Created on 2021/03/24 10:26
 *
 * @author Unicorn
 */
public class Solution0114 {
    public static void main(String[] args) {
//        TreeNode treeNode = TreeUtil.genCompleteBTree(new int[]{1, 2, 3, 4, 5, 6, 7,8});
//        TreeUtil.show(treeNode);
//        System.out.println("===================");
//        new Solution0114().flatten(treeNode);

        Integer[] nums = new Integer[]{1,2,5,3,4,7,null};
        TreeNode node = TreeUtil.getTree(nums);
        TreeUtil.showTree(node);
        System.out.println("===================");
        new Solution0114().flatten(node);
    }
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = null;
        root.left = null;

        TreeNode newHead = new TreeNode(-1);
        newHead.right = root;
        TreeNode point = newHead.right;
        TreeNode temp = dfs(left, point);
        dfs(right, temp);
        TreeUtil.showTree(newHead);
    }

    private TreeNode dfs(TreeNode node, TreeNode point) {
        if (node == null) return point;
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        node.right = null;
        point.right = node;
        point = point.right;
        TreeNode temp = dfs(left, point);
        return dfs(right, temp);
    }

}
