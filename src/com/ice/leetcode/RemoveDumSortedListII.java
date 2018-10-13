package com.ice.leetcode;

import com.ice.datatype.ListNode;

public class RemoveDumSortedListII {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);

        deleteDuplicates(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre,cur,next;
        pre = dummyNode; cur = pre.next;
        while (cur!=null&&cur.next!=null){
            next = cur.next;
            if(next.val == cur.val){
                while(next!=null&&next.val==cur.val){
                    next = next.next;
                }
                pre.next = next;
                cur = next;
            }else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
