package com.unicorn.Leetcode;

import com.unicorn.Leetcode.TreeNode;

import java.util.HashMap;

/**
 * <p>
 * </p>
 * Created on 2021-8-4.
 *
 * @author Unicorn
 */
public class Solution0106 {
    // 缓存中序遍历数组每个值对应的索引
    HashMap<Integer,Integer> indexForInOrders = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 存中序节点索引
        for(int i = 0;i < inorder.length; i++)
            indexForInOrders.put(inorder[i], i);
        return buildTree(postorder ,0, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] postorder, int inL, int postL, int postR) {
        if(postR < postL) return null;
        // 当前子树的根
        TreeNode root = new TreeNode(postorder[postR]);
        // 从中序中找出根的位置
        int inIndex = indexForInOrders.get(root.val);

        root.left = buildTree(postorder ,inL, postL, postL + inIndex - inL - 1);
        root.right = buildTree(postorder ,inIndex + 1, postL + inIndex - inL, postR - 1);
        return root;
    }

}
