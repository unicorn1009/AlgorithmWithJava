package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;
import com.unicorn.util.TreeUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>
 *     剑指 Offer 37. 序列化二叉树
 * </p>
 * Created on 2021-7-30.
 *
 * @author Unicorn
 */
public class JZ037 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        String serialize = serialize(node5);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize);

    }

    // 层序遍历序列化
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.addLast(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if (node != null){
                sb.append(node.val + " ");
                queue.addLast(node.left);
                queue.addLast(node.right);
            }else {
                sb.append("null ");
            }
        }
        return sb.toString();
    }


    // 反序列化二叉树 : 根据层序遍历重建二叉树
    public static TreeNode deserialize(String data){
        String[] s = data.trim().split(" ");
        if (s.length == 0 || (s.length == 1 && s[0].equals("null"))) return null;
        Integer[] a = new Integer[s.length];

        for (int i = 0; i < s.length; i++) {
            a[i] = !s[i].equals("null") ? Integer.parseInt(s[i]) : null;
        }
        int i=1;
        TreeNode root = new TreeNode(a[0]);  // 根节点
        TreeNode current = null;
        Integer value = null;

        //层序创建二叉树
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(i<a.length) {
            current = queue.poll();//从链表中移除并获取第一个节点
            value = a[i++];
            if(value!=null) {
                TreeNode left =new TreeNode(value);
                current.left = left;
                queue.offer(left); // 在链表尾部 左孩子入队
            }
            value=a[i++];
            if(value!=null) {
                TreeNode right =new TreeNode(value);
                current.right = right;
                queue.offer(right);// 在链表尾部 右孩子入队
            }

        }
        return root;
    }

}
