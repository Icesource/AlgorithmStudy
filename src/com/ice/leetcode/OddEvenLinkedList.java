package com.ice.leetcode;

import com.ice.datatype.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head;
        ListNode evenNode = new ListNode(-1);
        ListNode oddNode = new ListNode(-1);
        ListNode pEvenNode = evenNode;
        ListNode pfirOddNode = oddNode;
        int i = 1;
        while (temp != null){
            if(i%2==0){
                evenNode.next = temp;
                evenNode = evenNode.next;
                temp = temp.next;
                evenNode.next = null;
            }else {
                oddNode.next = temp;
                oddNode = oddNode.next;
                temp = temp.next;
                oddNode.next = null;
            }
            i++;
        }
        oddNode.next = pEvenNode.next;
        head = pfirOddNode.next;
        return head;

    }
}
