package com.ice.leetcode;

import com.ice.datatype.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode cur = head;

        while (cur!=null){
            pre = helper;
            ListNode next = cur.next;
            while(pre.next!=null && pre.next.val<=cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return helper.next;
    }
}
