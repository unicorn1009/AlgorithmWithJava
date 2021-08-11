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
        ListNode slow = head;
        ListNode fast = head;
        while (true){
            if (fast.next == null || fast.next.next == null)
                return false;
            else
                fast = fast.next.next;

            if (slow.val == fast.val)
                return true;
            else
                slow = slow.next;
        }
    }
}
