package com.unicorn.Leetcode;

import java.util.*;

/**
 * <p>
 *     234. 回文链表
 * </p>
 * Created on 2021/3/16 0016
 *
 * @author Unicorn
 */
public class Solution0234 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome(node1));
    }

    public static boolean isPalindrome1(ListNode head) {
        if (head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseNode = slow.next;
        slow.next = null;
        ListNode reversedHead = reverse(reverseNode);
        while (reversedHead != null){
            if (reversedHead.val != head.val){
                return false;
            }
            reversedHead = reversedHead.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head){
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

    // 使用额外空间存
    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        int count = 0;
        while (node!=null) {
            list.add(node.val);
            node = node.next;
            count++;
        }

        for (int i = 0; i < count/2; i++) {
            if (list.get(i) != list.get(count-i-1))
                return false;
        }
        return true;
    }
}
