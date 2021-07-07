package com.unicorn.niuke.排序;

import com.unicorn.Leetcode.ListNode;

/**
 * <p>
 *     给定一个无序单链表，实现单链表的排序(按升序排序)。
 *     思路:链表归并排序
 * </p>
 * Created on 2021/04/19 14:16
 *
 * @author Unicorn
 */
public class 单链表排序 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1);
        System.out.println(o1.hashCode() );
        System.out.println(o2);
        System.out.println(o2.hashCode() );
    }
    public ListNode sortInList (ListNode head) {
        // write code here
        return head;
    }

    private void mergeSortInList(ListNode left, ListNode right){
        ListNode midNode = getMid(left, right);
        mergeSortInList(left, midNode);
        mergeSortInList(midNode.next, right);
        merge(left, midNode, right);
    }

    private void merge(ListNode left,ListNode midNode, ListNode right) {

    }


    // 快慢指针找链表中点
    private ListNode getMid(ListNode left, ListNode right){
        ListNode fast = left, slow = left;
        while (fast != right && fast.next != right){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
