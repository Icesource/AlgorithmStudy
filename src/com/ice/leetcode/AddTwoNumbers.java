package com.ice.leetcode;

import com.ice.datatype.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1, head2 = l2;
        ListNode result = new ListNode(0);
        ListNode pResult = result;
        ListNode temp1 = head1, temp2 = head2;
        int flag = 0;
        while (!(temp1 == null && temp2 == null)) {
            int temp;
            if (flag == 1) temp = temp1.val + temp2.val + 1;
            else temp = temp1.val + temp2.val;
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp >= 10) {
                result.val = temp - 10;
                flag = 1;
            } else {
                result.val = temp;
                flag = 0;
            }
            if(temp1!=null||temp2!=null){
                result.next = new ListNode(0);
                result = result.next;
            }else{
                if(flag==1) result.next = new ListNode(1);
                else result.next = null;
            }
            if (temp1 == null && temp2 != null) temp1 = new ListNode(0);
            if (temp1 != null && temp2 == null) temp2 = new ListNode(0);
        }
        return pResult;
    }
}
