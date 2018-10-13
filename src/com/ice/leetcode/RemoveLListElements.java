package com.ice.leetcode;

import com.ice.datatype.ListNode;

public class RemoveLListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next!=null){
            if(cur.next.val==val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return dummyNode.next;
    }
}
