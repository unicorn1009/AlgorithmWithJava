package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;
import com.unicorn.util.ArrayUtil;

import java.util.*;

/**
 * <p>
 *     剑指 Offer 32 - I. 从上到下打印二叉树
 * </p>
 * Created on 2021/3/16 0016
 *
 * @author Unicorn
 */
public class JZ032_1 {

    // 使用队列
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        queue.addLast(root);
        ans.add(root.val);
        while (!queue.isEmpty()){
            TreeNode outNode = queue.removeFirst();
            if (outNode.left != null){
                ans.add(outNode.left.val);
                queue.addLast(outNode.left);
            }
            if (outNode.right != null){
                ans.add(outNode.right.val);
                queue.addLast(outNode.right);
            }
        }
        return ArrayUtil.ListToIntArray(ans);
    }
}
