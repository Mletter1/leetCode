package com.leetcode.addTwoNumbers;

/**
 * Created by mletter1 on 9/11/16.
 */
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode ans = new ListNode(0);
    ListNode temp = ans;
    ListNode previous = null;
    int carry = 0;
    while(l1 != null || l2 != null){
      if(l1 != null){
        carry += l1.val;
        l1 = l1.next;
      }
      if(l2 != null){
        carry += l2.val;
        l2 = l2.next;
      }
      temp.val = carry%10;
      temp.next = new ListNode(0);
      previous = temp;
      temp = temp.next;
      carry /= 10;
    }
    if(carry > 0){
      temp.val = carry;
    }else{
      previous.next = null;
    }
    return ans;
  }
}
