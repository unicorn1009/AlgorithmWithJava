package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;

import java.util.ArrayList;

/**
 * <p>
 *     剑指 Offer 54. 二叉搜索树的第k大节点
 *     给定一棵二叉搜索树，请找出其中第k大的节点。
 * </p>
 * Created on 2021/3/13.
 *
 * @author Unicorn
 */

public class JZ054 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        node3.left = node1;
        node3.right = node4;
        node1.right = node2;
        System.out.println(new JZ054().kthLargest(node3, 1));

    }
    int ans;
    int k;
    // 中序遍历
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return this.ans;
    }

    void dfs(TreeNode node){
        if (node == null) return;
        dfs(node.right);
        this.k --;
        if (this.k == 0){
            this.ans = node.val;
            return;
        }
        dfs(node.left);
    }

}
