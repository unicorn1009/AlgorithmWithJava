package com.unicorn.Leetcode;

/**
 * <p>
 *     61. 旋转链表
 * </p>
 *
 * @author unicorn
 * @create 2021-03-27 10:37 下午
 */
public class Solution0061 {
    public static void main(String[] args) {

    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return null;
        int temp = k;
        ListNode front = head;
        ListNode back = head;
        int len = 1;    // 链表长度
        while (k > 0){
            back = back.next;
            k--;
            len++;
            if (back.next == null){
                break;
            }
        }
        // 两种情况, back还没走到尾节点, back走到了尾节点
        if (back.next == null){
            // len求出来了
            // 到了尾结点, 说明k >= len
            temp = temp % len;
            if (len == temp)
                return head;
            back = head;
            while (temp > 0){
                back = back.next;
                temp--;
            }
            while (back.next != null){
                front = front.next;
                back = back.next;
            }
            ListNode newHead = front.next;
            front.next = null;
            back.next = head;
            return newHead;

        }else {
            // 还没到尾结点,就走完了k步
            while (back.next != null){
                front = front.next;
                back = back.next;
            }
            ListNode newHead = front.next;
            front.next = null;
            back.next = head;
            return newHead;
        }

    }
}
