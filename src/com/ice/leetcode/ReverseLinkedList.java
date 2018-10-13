package com.ice.leetcode;

import com.ice.datatype.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode pre = null, cur = head, next = head.next;
        while (cur != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            if(next!=null){
                next = next.next;
            }
        }
        return pre;
    }
}
