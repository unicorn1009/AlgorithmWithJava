package com.unicorn.niuke.链表;

import com.unicorn.Leetcode.ListNode;
import com.unicorn.util.ListNodeUtil;

/**
 * <p>
 *    思路 : 先快慢指针找到中点, 反转后半部分链表,
 * </p>
 * Created on 2021/04/22 10:19
 *
 * @author Unicorn
 */
public class 判断链表是否为回文链表 {


    public boolean isPail (ListNode head) {
        if (head == null || head.next == null) return true;
        // 快慢指针走到中间
        ListNode rightMidNode = ListNodeUtil.getRightMidNode(head);
        // 反转后半部分链表
        ListNode headBehind = ListNodeUtil.reverseList(rightMidNode);
        while (headBehind != null){
            if (headBehind.val != head.val){
                return false;
            }
            head = head.next;
            headBehind = headBehind.next;
        }
        return true;
    }
}
