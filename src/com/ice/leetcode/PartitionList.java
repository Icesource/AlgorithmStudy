package com.ice.leetcode;

import com.ice.datatype.ListNode;

import java.util.LinkedHashMap;

public class PartitionList {
    public static void main(String[] args){
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);
        partition2(head,2);
    }

    public static ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        if(head.next == null) return head;
        if(head.next.next == null){
            if (head.val>=x&&head.next.val<x){
                head.next.next = head;
                head = head.next;
                head.next.next= null;
            }
            return head;
        }
        ListNode l = head;
        while (l.next!=null){
            if(l.next.val<x) l = l.next;
            else{
                ListNode firBigger = l.next;
                ListNode temp = firBigger;
                while (temp.next!=null&&temp.next.val>=x){
                    temp = temp.next;
                }
                if(temp.val>x&&temp.next==null){

                }
                if (temp.next ==null ) return head;
                ListNode firSmaller = temp.next;
                temp.next = temp.next.next;
                l.next = firSmaller;
                firSmaller.next = firBigger;
            }
        }
        return head;
    }

    public static ListNode partition2(ListNode head, int x){
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode phead1 = head1;
        ListNode phead2 = head2;
        ListNode temp = head;
        while (temp!=null){
            if(temp.val<x){
                phead1.next = temp;
                temp = temp.next;
                phead1 = phead1.next;
                phead1.next = null;
            }else{
                phead2.next = temp;
                temp = temp.next;
                phead2 = phead2.next;
                phead2.next = null;
            }
        }
        phead1.next = head2.next;
        head = head1.next;
        return head;
    }
}
