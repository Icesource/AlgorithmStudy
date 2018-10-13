package com.ice.leetcode;

import com.ice.datatype.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDumSortedList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(3);
        deleteDuplicates(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head ==null) return null;
        if(head.next == null) return head;
        Set<Integer> set = new HashSet<>();
        ListNode temp = new ListNode(-1);
        temp.next = head;
        while (temp!=null&&temp.next!=null){
            ListNode next = temp.next;
            if(set.contains(next.val))
                temp.next = temp.next.next;
            else{
                set.add(next.val);
                temp = temp.next;
            }
        }

        return head;
    }
}
