package com.unicorn.niuke.排序;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 *      注意是节点的编号而非节点的数值。
 * </p>
 * Created on 2021/04/20 11:01
 *
 * @author Unicorn
 */
public class 链表的奇偶重排 {
    public static void main(String[] args) {

    }

    public static ListNode oddEvenList (ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode temp2 = head.next;
        while (true){
            if (node1.next.next != null){
                node1.next = node1.next.next;
                node1 = node1.next;
            }
            if (node2.next.next != null){
                node2.next = node2.next.next;
                node2 = node2.next;
            }
            if ((node1.next == null || node1.next.next == null ) && (node2.next == null || node2.next.next == null)){
                if (node1.next != null)
                    node1.next = null;
                if (node2.next != null)
                    node2.next = null;
                break;
            }
        }
        node1.next = temp2;
        return head;
    }

}
