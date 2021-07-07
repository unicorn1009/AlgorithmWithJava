package com.unicorn.Leetcode;

/**
 * <p>
 *     147. 对链表进行插入排序
 * </p>
 * Created on 2021/04/19 16:16
 *
 * @author Unicorn
 */
public class Solution0147 {
    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(4, node1);
        ListNode node = insertionSortList(head);
        // 4 2 1 3
        System.out.println(node);
    }
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1, head);
        ListNode sorted = head;
        ListNode cur = sorted.next;
        while (cur != null){
            if (sorted.val <= cur.val){
                sorted = sorted.next;
                cur = cur.next;
                continue;
            }
            sorted.next = cur.next;
            ListNode p = newHead;
            while (p.next != sorted){
                if (p.next.val < cur.val){
                    p = p.next;
                }else {
                    break;
                }
            }
            cur.next = p.next;
            p.next = cur;
            cur = sorted.next;
        }
        return newHead.next;
    }
}
