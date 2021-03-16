package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *     剑指 Offer 28. 对称的二叉树
 * </p>
 * Created on 2021/3/15 0015
 *
 * @author Unicorn
 */
public class JZ028 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode11 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode22 = new TreeNode(8);
        root.left = treeNode1;
        root.right = treeNode2;
//        treeNode1.left = treeNode11;
        treeNode2.left = treeNode22;
        System.out.println(new JZ028().isSymmetric(root));
    }

    boolean ret = true;

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<Integer> deque = new LinkedList<>();
        dfs1(root.left, deque);
        dfs2(root.right, deque);
        return ret;
    }

    private void dfs1(TreeNode node, Deque<Integer> deque){
        // 先序
        if (node == null) {
            deque.addLast(-1);
            return;
        };
        deque.addLast(node.val);
        dfs1(node.left, deque);
        dfs1(node.right, deque);
    }

    private void dfs2(TreeNode node, Deque<Integer> deque){
        // 先序
        if (node == null) {
            Integer a = deque.removeFirst();
            if (a != -1){
                this.ret = false;
                return;
            }
            return;
        };
        if (!deque.isEmpty()) {
            Integer first = deque.removeFirst();
            if (first != node.val) {
                this.ret = false;
                return;
            }
        }else {
            this.ret = false;
            return;
        }
        dfs2(node.right, deque);
        dfs2(node.left, deque);
    }
}
