package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;
import com.unicorn.util.TreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>
 *     剑指 Offer 32 - II. 从上到下打印二叉树 II
 *     从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * </p>
 *
 * @author unicorn
 * @create 2021-03-17 11:45 下午
 */
public class JZ032_2 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.genCompleteBTree(new int[]{1, 2, 3, 4, 5});
        System.out.println(levelOrder(treeNode));
    }

    // 深度遍历
    // TODO

    // 层序遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        List<List<Integer>> ans = new ArrayList<>();

        // 使用两个队列
        Deque<TreeNode> queue1 = new ArrayDeque<>();
        Deque<TreeNode> queue2 = new ArrayDeque<>();
        boolean one = true; // 从队列1出队列
        queue1.addLast(root);
        List<Integer> line = new ArrayList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            if (one){
                TreeNode node = queue1.removeFirst();
                line.add(node.val);
                if (queue1.isEmpty()){
                    one = false;
                    ans.add(new ArrayList<>(line));
                    line.clear();
                }
                if (node.left!=null){
                    queue2.addLast(node.left);
                }
                if (node.right != null){
                    queue2.addLast(node.right);
                }
            }else {
                // 此时queue1空, queue2不空
                TreeNode node = queue2.removeFirst();
                line.add(node.val);
                if (queue2.isEmpty()){
                    one = true;
                    ans.add(new ArrayList<>(line));
                    line.clear();
                }
                if (node.left!=null){
                    queue1.addLast(node.left);
                }
                if (node.right != null){
                    queue1.addLast(node.right);
                }
            }
        }

        return ans;
    }
}
