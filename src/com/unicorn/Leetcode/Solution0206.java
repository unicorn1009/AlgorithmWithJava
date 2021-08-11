package com.unicorn.Leetcode;

/**
 * <p>
 *     206. 反转链表
 * </p>
 * Created on 2021/2/21.
 *
 * @author Unicorn
 */
public class Solution0206 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1, 2, 3});
        System.out.println(listNode);
        ListNode newNode = new Solution0206().reverseList(listNode);
        System.out.println(newNode);
    }
    // 递归反转, 空间O(n)
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

    // 法二: 三指针, 空间 O(1)
    public static ListNode reverseList1(ListNode head) {
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


}
