package com.unicorn.mianshijindian.树;

import com.unicorn.Leetcode.TreeNode;

/**
 * <p>
 *     面试题 04.02. 最小高度树
 *     给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *     例如:
 *     给定有序数组: [-10,-3,0,5,9],
 *
 *      一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 * </p>
 * Created on 2021/7/5.
 *
 * @author Unicorn
 */
public class MS0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return genTree(nums, 0, nums.length - 1);
    }

    /**
     * 根据给定数组生成二叉搜索树
     * @return 返回生成树的根节点
     */
    private TreeNode genTree(int[] nums, int left, int right){
        if (left>right)
            return null;
        int mid = (left + right)/2;
        TreeNode curRoot = new TreeNode(nums[mid]);
        curRoot.left = genTree(nums, left, mid-1);
        curRoot.right = genTree(nums, mid+1, right);
        return curRoot;
    }
}
