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
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

}
