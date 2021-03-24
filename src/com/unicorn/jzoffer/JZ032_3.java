package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;
import com.unicorn.util.ArrayUtil;
import com.unicorn.util.TreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>
 *     剑指 Offer 32 - III. 从上到下打印二叉树 III
 *     请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * </p>
 * Created on 2021/03/24 20:13
 *
 * @author Unicorn
 */
public class JZ032_3 {
    public static void main(String[] args) {
        JZ032_3 jz032_3 = new JZ032_3();
        Integer[] nodes = new Integer[]{3,9,20,null,null,15,7};
        TreeNode tree = TreeUtil.getTree(nodes);
        TreeUtil.showTree(tree);
        List<List<Integer>> ans = jz032_3.levelOrder(tree);
        System.out.println(ans);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        // 使用两个队列, 一个栈, 从队列1出来的直接输出, 从队列2出来的装入栈中,实现倒序输出
        Deque<TreeNode> queue1 = new ArrayDeque<>();
        Deque<TreeNode> queue2 = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> line = new ArrayList<>(); // 存放一层数据
        queue1.addLast(root);
        int oneOrTwo = 1;
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            if (oneOrTwo == 1){
                // 从队列1出队
                TreeNode node = queue1.removeFirst();
                line.add(node.val);
                if (node.left != null){
                    queue2.addLast(node.left);
                }
                if (node.right != null){
                    queue2.addLast(node.right);
                }
                if (queue1.isEmpty()){
                    // 队列空, 此时一层扫描结束, 保存一层数据
                    ans.add(new ArrayList<>(line));
                    line.clear();
                    oneOrTwo = 2;
                }
            }else {
                // 从队列2出队
                TreeNode node = queue2.removeFirst();
                stack.addFirst(node.val);
                if (node.left != null){
                    queue1.addLast(node.left);
                }
                if (node.right != null){
                    queue1.addLast(node.right);
                }
                if (queue2.isEmpty()){
                    oneOrTwo = 1;
                }
                if (queue2.isEmpty()){
                    // 队列空, 此时一层扫描结束, 从栈中取出所有数据组成一层
                    while (!stack.isEmpty()){
                        line.add(stack.removeFirst());
                    }
                    ans.add(new ArrayList<>(line));
                    line.clear();
                    oneOrTwo = 1;
                }
            }
        }

        return ans;

    }
}
