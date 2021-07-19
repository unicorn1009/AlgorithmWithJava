package com.unicorn.mianshijindian.链表;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     面试题 02.08. 环路检测(找入环节点)
 *     给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * </p>
 * Created on 2021/7/4.
 *
 * @author Unicorn
 */
public class MS0208 {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(-4);
        ListNode node0 = new ListNode(0, node4);
        ListNode node2 = new ListNode(2, node0);
        ListNode node3 = new ListNode(3, node2);
        node4.next = node2;

        ListNode node = detectCycle(node3);
        System.out.println(node);


    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode n1 = head.next;
        ListNode n2 = head.next.next;
        while (n1 != null && n2 != null && n2.next != null  && n1 != n2){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        if (n1 == null || n2 == null || n2.next == null){
            return null;
        }
        // n1 == n2
        n1 = head;
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;





    }
}
