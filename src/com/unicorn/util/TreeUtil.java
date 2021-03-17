package com.unicorn.util;

import com.unicorn.Leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * </p>
 * Created on 2021/3/17 0017
 *
 * @author Unicorn
 */
public class TreeUtil {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        genCompleteBTree(root, List.of(2,3,4,5));
        levelOrder(root);
    }


    /**
     * 根据给定列表, 生成一颗完全二叉树
     * @param root 根节点
     * @param list 给定列表
     */
    public static void genCompleteBTree(TreeNode root, List<Integer> list) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty() && count < list.size()) {
            TreeNode lastNode = queue.poll();

            if (count < list.size()) {
                TreeNode left = new TreeNode(list.get(count++));
                lastNode.left = left;
                queue.add(left);
            }
            if (count < list.size()) {

                TreeNode right = new TreeNode(list.get(count++));
                lastNode.right = right;
                queue.add(right);
            }
        }
    }

    /**
     * 根据给定列表, 生成一颗完全二叉树
     * @param arr 给定列表
     * @return  完全二叉树
     */
    public static TreeNode genCompleteBTree(int[] arr) {
        if(arr.length == 1) {
            return new TreeNode(arr[0]);
        }
        List<TreeNode> nodeList = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            nodeList.add(new TreeNode(arr[i]));
        }
        int temp = 0;
        while(temp <= (arr.length - 2) / 2) {  //注意这里，数组的下标是从零开始的
            if(2 * temp + 1 < arr.length) {
                nodeList.get(temp).left = nodeList.get(2 * temp + 1);
            }
            if(2 * temp + 2 < arr.length) {
                nodeList.get(temp).right = nodeList.get(2 * temp + 2);
            }
            temp++;
        }
        return nodeList.get(0);
    }

    /**
     * 对树先序遍历
     * @param root 树根
     */
    public static void preOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 对树中序遍历
     * @param root 树根
     */
    public static void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     * 对树后序遍历
     * @param root 树根
     */
    public static void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    /**
     * 对树层序遍历
     * @param root 树根
     */
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            System.out.println(cur.val);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }

    }

}
