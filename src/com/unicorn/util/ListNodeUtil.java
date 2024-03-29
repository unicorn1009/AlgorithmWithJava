package com.unicorn.util;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 * </p>
 * Created on 2021/3/18.
 *
 * @author Unicorn
 */
public class ListNodeUtil {
    public static void main(String[] args) {
        ListNode node = GenIncrList(10);
        System.out.println(node);
    }

    /**
     * 生成递增链表
     * @param n 链表长度
     * @return 链表头结点
     */
    public static ListNode GenIncrList(int n){
        if (n == 0) return null;
        ListNode root = new ListNode(1);
        ListNode node = root;
        for (int i = 2; i <= n; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return root;
    }

    /**
     * 生成与给定数组顺序一致的单链表
     * @param arr 数组 如 new int[]{3,2,1}
     * @return 链表头结点
     */
    public static ListNode GenListNodeByList(int[] arr){
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return head;
    }

    /**
     * 反转链表(递归法)
     * @param head 要反转的链表头结点
     * @return 反转后链表的头结点
     */
    public static ListNode RecurReverseList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode rev = RecurReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }


    /**
     * 反转链表(三指针法, 空间复杂度O(1))
     * @param head 要反转的链表头结点
     * @return 反转后链表的头结点
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode back = null;
        while (cur.next != null){
            back = cur.next;
            cur.next = pre;
            pre = cur;
            cur = back;
        }
        cur.next = pre;
        return cur;
    }

    /**
     * 反转链表非递归版本
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 反转链表递归版本
     * @param head
     * @return
     */
    public static ListNode reverseList_recur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    /**
     * 获取链表的中间节点(中右)
     * @param head
     * @return
     */
    public static ListNode getRightMidNode(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 获取链表的中间节点(左中), 待验证
     * @param head
     * @return
     */
    public static ListNode getLeftMidNode(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
