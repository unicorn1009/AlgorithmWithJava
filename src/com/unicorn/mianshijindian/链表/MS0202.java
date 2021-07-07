package com.unicorn.mianshijindian.链表;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.util.ListNodeUtil;

/**
 * <p>
 *     面试题 02.02. 返回倒数第 k 个节点
 *     实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * </p>
 * Created on 2021/6/19.
 *
 * @author Unicorn
 */
public class MS0202 {
    public static void main(String[] args) {
        ListNode list = ListNodeUtil.GenListNodeByList(new int[]{2});
        int i = kthToLast(list, 1);
        System.out.println(i);
    }
    public static int kthToLast(ListNode head, int k) {

        ListNode fast = head;
        // 先让nodej走k步
        while (fast != null && k > 0){
            fast = fast.next;
            k--;
        }
        while (fast != null){
            fast = fast.next;
            head = head.next;
        }
        return head.val;
    }
}
