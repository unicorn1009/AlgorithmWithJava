package com.unicorn.mianshijindian.链表;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.util.ListNodeUtil;

/**
 * <p>
 *     面试题 02.04. 分割链表
 *     编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * </p>
 * Created on 2021/7/4.
 *
 * @author Unicorn
 */
public class MS0204 {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.GenListNodeByList(new int[]{1, 4, 3, 2, 5, 2});
        ListNode partition = partition(node, 3);
        System.out.println(partition);
    }
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        // 头插法
        ListNode dummyHead = new ListNode(-1, head);
        ListNode curNode = head.next;
        ListNode preNode = head;
        while (curNode != null){
            if (curNode.val < x){
                // 需要插入到最前头
                ListNode node1 = curNode;
                curNode = curNode.next;
                node1.next = dummyHead.next;
                dummyHead.next = node1;
                preNode.next = curNode;
            }else {
                curNode = curNode.next;
                preNode = preNode.next;
            }
        }
        return dummyHead.next;
    }
}
