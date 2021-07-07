package com.unicorn.mianshijindian.链表;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.util.ListNodeUtil;

/**
 * <p>
 * </p>
 * Created on 2021/6/22.
 *
 * @author Unicorn
 */
public class MS0206 {
    public static void main(String[] args) {
        MS0206 ms0206 = new MS0206();
        ListNode node = ListNodeUtil.GenListNodeByList(new int[]{2});
        System.out.println(ms0206.isPalindrome(node));
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        // 快慢指针,一个走一步,一个走两步,一个走到尾部,一个走到正中间
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 走到了中后节点
        ListNode revHead = reverseListNode(slow);
        while (revHead != null){
            if (head.val != revHead.val)
                return false;
            head = head.next;
            revHead = revHead.next;
        }
        return true;
    }

    private ListNode reverseListNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode reversedNode = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return reversedNode;
    }
}
