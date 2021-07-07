package com.unicorn.util;

import com.unicorn.Leetcode.ListNode;

import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/3/18.
 *
 * @author Unicorn
 */
public class ListNodeUtil {
    public static void main(String[] args) {
        ListNode node = genIncrList(10);
        System.out.println(node);
    }

    /**
     * 生成递增链表
     * @param n 链表长度
     * @return
     */
    public static ListNode genIncrList(int n){
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
     * 根据给定数组生成链表,可包含null
     * @param arr
     * @return
     */
    public static ListNode genListNodeByList(int[] arr){
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
