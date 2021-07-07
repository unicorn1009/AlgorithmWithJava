package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *      给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 *      将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 *      思路 : 快慢指针取后一半反转链表, 然后合并前后两半
 * </p>
 * Created on 2021/04/21 14:30
 *
 * @author Unicorn
 */
public class 重排链表 {
    public static void main(String[] args) {

        new 重排链表().reorderList(new ListNode(new int[]{1}));
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode preSlow = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            preSlow = preSlow.next;
        }
        preSlow.next = null;
        ListNode head2 = reverseList(slow);
        merge(head, head2);
        System.out.println(head);
    }

    // 合并两条链表, 返回合并后的头结点
    private void merge(ListNode head1, ListNode head2){
        ListNode p = new ListNode(-1);
        ListNode x = p;
        while (head1 != null && head2 != null){
            p.next = head1;
            head1 = head1.next;
            p = p.next;
            p.next = head2;
            head2 = head2.next;
            p = p.next;
        }
        if (head1 != null){
            p.next = head1;
        }

    }

    // 反转链表,返回翻转后的头结点
    private ListNode reverseList(ListNode node){
        if (node == null || node.next == null) return node;
        ListNode node1 = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return node1;
    }
}
