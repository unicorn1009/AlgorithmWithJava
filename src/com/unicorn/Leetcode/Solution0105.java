package com.unicorn.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     105. 从前序与中序遍历序列构造二叉树
 * </p>
 * Created on 2021-8-4.
 *
 * @author Unicorn
 */
public class Solution0105 {
    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode buildTree(int[] pre, int[] in) {
        // 存中序节点索引
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return buildTree(pre, 0, pre.length - 1, 0);
    }

    // 只需要前序，前序中当前子树的左右范围，中序左右范围
    private TreeNode buildTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        // 当前子树的根
        TreeNode root = new TreeNode(pre[preL]);
        // 从中序中找出根的位置
        int inIndex = indexForInOrders.get(root.val);
        // 当前子树中左子树的节点数量
        int leftTreeSize = inIndex - inL;
        // 递归
        root.left = buildTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = buildTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}
