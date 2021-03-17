package com.unicorn.Leetcode;

/**
 * <p>
 *     141. 环形链表
 * </p>
 *
 * @author unicorn
 * @create 2021-03-15 9:01 下午
 */
public class Solution0141 {

    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        // 至少两个节点
        ListNode node1 = head;
        ListNode node2 = head;
        while (true){
            if (node2 == null || node2.next == null || node2.next.next == null)
                return false;
            else
                node2 = node2.next.next;

            if (node1.val == node2.val)
                return true;
            else
                node1 = node1.next;
        }
    }
}
