package com.unicorn.jzoffer;

import com.unicorn.Leetcode.TreeNode;
import com.unicorn.util.TreeUtil;

/**
 * <p>
 *     剑指 Offer 36. 二叉搜索树与双向链表
 * </p>
 * Created on 2021-7-30.
 *
 * @author Unicorn
 */
public class JZ036_1 {

    public static void main(String[] args) {
        JZ036_1 jz036_1 = new JZ036_1();
        TreeNode treeNode = TreeUtil.genCompleteBTree(new int[]{4, 2, 5, 1, 3});
        TreeNode node = jz036_1.treeToDoublyList(treeNode);
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        dfs(root);
        return head;
    }

    private TreeNode head;
    private TreeNode pre;

    private void dfs(TreeNode cur){
        if (cur == null) return;
        dfs(cur.left);
//        System.out.println(cur.val);
        if (pre != null)
            pre.right = cur;
        else
            head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
