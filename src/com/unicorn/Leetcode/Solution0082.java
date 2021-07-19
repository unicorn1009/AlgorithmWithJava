package com.unicorn.Leetcode;

import com.unicorn.util.ListNodeUtil;

/**
 * <p>
 *     82. 删除排序链表中的重复元素 II
 * </p>
 * Created on 2021/03/25 09:32
 *
 * @author Unicorn
 */
public class Solution0082 {
    public static void main(String[] args) {
        ListNode node = ListNodeUtil.GenListNodeByList(new int[]{1});
        System.out.println(new Solution0082().deleteDuplicates(node));
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        // 首先添加一个自定义头结点
        ListNode newHead = new ListNode(-1,head);
        ListNode point1 = newHead;     // 遍历指针
        ListNode point2 = head.next;     // 遍历指针
        boolean del = false;
        while (point2 != null){
            if (point1.next.val == point2.val){
                point2 = point2.next;
                del = true;
            }else {
                if (del){
                    point1.next = point2;
                    del = false;
                    point2 = point2.next;
                }else {
                    point1 = point1.next;
                    point2 = point2.next;
                }
            }

        }
        if (del){
            point1.next = null;
        }
        return newHead.next;
    }
}
