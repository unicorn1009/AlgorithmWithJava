package com.unicorn.mianshijindian.树;

import com.unicorn.Leetcode.TreeNode;

/**
 * <p>
 *     面试题 04.08. 首个共同祖先
 *     设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。
 *     例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 *
 *     3
 *    / \
 *   5   1
 *  / \ / \
 * 6  2 0  8
 *   / \
 *  7   4
 *
 *  输出: 5
 * </p>
 * Created on 2021-7-7.
 *
 * @author Unicorn
 */
public class MS0408 {
    public static void main(String[] args) {
        int a=10;
        int b = a++ + ++a+a--;
        System.out.println(a);
        System.out.println(b);
    }

    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    // node节点为根的子树中是否包含p节点或q节点
    private boolean dfs(TreeNode node, TreeNode p, TreeNode q){
        if (node == null)
            return false;
        boolean lson = dfs(node.left, p, q);
        boolean rson = dfs(node.right, p, q);
        if ((lson && rson) || ((node == p || node == q) && (lson || rson))){
            this.ans = node;
        }
        return lson || rson || node == p || node == q;
    }
}
