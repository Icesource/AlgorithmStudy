package com.ice.leetcode;

import com.ice.datatype.ListNode;

public class ReverseLinkedListII {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        reverseBetween(head,1,2);
        System.out.println("123456");
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head.next==null) return head;
        if(m==n) return head;
//        if(n==2&&m==1) {
//            head.next.next = head;
//            head.next = null;
//            return head;
//        }
        ListNode left = head,right = head;
        for(int i = 0;i<m-2;i++) left = left.next;
        for(int i = 0;i<n-1;i++) right = right.next;
        ListNode pre = left.next,next = pre.next;
        ListNode lst = right.next;
        for (int i=0;i<n-m;i++){
            if(next == null){
                break;
            }
            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }
        if(m!=1){
            left.next.next = lst;
            left.next = right;
        }else{
            left.next.next = left;
            left.next = lst;
            return right;
        }
        return head;
    }
}
