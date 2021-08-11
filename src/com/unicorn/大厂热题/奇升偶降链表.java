package com.unicorn.大厂热题;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.util.ListNodeUtil;

/**
 * <p>
 * </p>
 * Created on 2021-8-4.
 *
 * @author Unicorn
 */
public class 奇升偶降链表 {
    public static void main(String[] args) {
        奇升偶降链表 aaa = new 奇升偶降链表();
        System.out.println(aaa.oddEvenList(ListNodeUtil.GenListNodeByList(new int[]{1, 8, 3, 6, 5, 4, 7, 2})));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 偶数链表头
        ListNode head2 = head.next;
        // 奇数节点指针头
        ListNode odd = head;
        // 偶数节点指针
        ListNode even = head2;
        // 拆分成两个链表
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = null;
        // 反转偶数链表
        ListNode newHead2 = reverse(head2);
        // 链表合并

        return mergeTwoLists(head, newHead2);
    }

    // 合并两个有序链表
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(-1);
        // p指针指向合并后的最后一个节点
        ListNode p = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        p.next = head1 == null ? head2 : head1;
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
