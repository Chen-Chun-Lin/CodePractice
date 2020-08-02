package com.ccl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther ccl
 * @create 2020/7/25 18:06
 */
public class Solution02 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        ListNode head = list1;
        list1.next = new ListNode(4);
        list1 = list1.next;
        list1.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        ListNode head2 = list2;
        list2.next = new ListNode(6);
        list2 = list2.next;
        list2.next = new ListNode(4);
        ListNode list = addTwoNumbers(head, head2);
        while (list != null){
            System.out.println(list.val);
            list = list.next;
        }
        //System.out.println(10*(int)Math.pow(10,2));
        //ListNode list2 = new ListNode(5);

        /**
         * 2 -> 4 -> 3) + (5 -> 6 -> 4)
         */
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode p = l1,q=l2,curr = listNode;
        int carry = 0;
        while (p!= null || q!=null){
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;
            int sum = carry + x + y;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return listNode.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }
}
