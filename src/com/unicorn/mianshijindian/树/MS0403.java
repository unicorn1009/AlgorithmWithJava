package com.unicorn.mianshijindian.树;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.Leetcode.TreeNode;
import com.unicorn.util.TreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>
 *     面试题 04.03. 特定深度节点链表
 *     给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *     例如:
 *     输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * </p>
 * Created on 2021/7/5.
 *
 * @author Unicorn
 */
public class MS0403 {
    public static void main(String[] args) {
        TreeNode tree = TreeUtil.getTree(new Integer[]{null});
        TreeUtil.showTree(tree);
        ListNode[] listNodes = listOfDepth(tree);
        for (ListNode listNode : listNodes) {
            System.out.println(listNode);
        }
    }

    public static ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null)
            return new ListNode[0];
        // 思路，一行出完队,则统计下一行的个数(队列长度)
        List<ListNode> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(tree);
        int n = 1;
        ListNode dummyHead = new ListNode(-1);
        ListNode moveNode = dummyHead;
        while (!queue.isEmpty()){
            TreeNode remove = queue.removeFirst();
            moveNode.next = new ListNode(remove.val);
            moveNode = moveNode.next;
            if (remove.left != null)
                queue.addLast(remove.left);
            if (remove.right != null)
                queue.addLast(remove.right);
            n--;

            if (n == 0){
                // n == 0时,一层出完
                ans.add(dummyHead.next);
                dummyHead.next = null;
                moveNode = dummyHead;
                n = queue.size();
            }
        }

        return ans.toArray(new ListNode[0]);
    }

}
