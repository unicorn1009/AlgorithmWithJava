package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;
import com.unicorn.util.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     剑指 Offer 07. 重建二叉树
 * </p>
 * Created on 2021/03/29 09:44
 *
 * @author Unicorn
 */
public class JZ007 {
    public static void main(String[] args) {
        TreeNode treeNode = new JZ007().buildTree(new int[]{3,5}, new int[]{5, 3});
        TreeUtil.showTree(treeNode);
    }
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return preBuildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);

    }

    private TreeNode preBuildTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right){
        if (in_left > in_right) return null;

        TreeNode root = new TreeNode(preorder[pre_left]);
        Integer in_index = map.get(preorder[pre_left]);

        int left_count = in_index - in_left;

        root.left = preBuildTree(preorder, inorder, pre_left+1, pre_left+left_count, in_left, in_index-1);
        root.right = preBuildTree(preorder, inorder, pre_left+left_count+1, pre_right, in_index+1, in_right);
        return root;
    }
}
