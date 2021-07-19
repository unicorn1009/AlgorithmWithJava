package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.util.ListNodeUtil;

/**
 * <p>
 * </p>
 * Created on 2021/04/27 09:58
 *
 * @author Unicorn
 */
public class 划分链表 {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.GenListNodeByList(new int[]{1, 4, 3, 2, 5, 2});
        ListNode partition = partition(node, 3);
        System.out.println(partition);
    }
    public static ListNode partition (ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummyHeadOld = new ListNode(-1, head);
        ListNode dummyHead = new ListNode(-1);  // 新链表的假头
        ListNode pre = dummyHeadOld;
        ListNode cur = head;
        ListNode pBig = dummyHeadOld;   // 指向第一个大于等于x的节点
        boolean flag = false;           // 标记是否找到第一个大于等于x的节点
        ListNode p = dummyHead;         // 新链表的连接结点
        while (cur != null){
            if (cur.val < x){
                // 需要将该节点加入新链表
                p.next = cur;
                p = p.next;
                cur = cur.next;
                pre.next = cur;
            }else {
                if (!flag){
                    pBig = cur;
                    flag = true;
                }
                pre = cur;
                cur = cur.next;
            }
        }
        if (flag)
            p.next = pBig;
        return dummyHead.next;
    }
}
