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

    // TODO 反转链表 O(n) 和 O(1)

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
