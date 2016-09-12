package com.leetcode.addTwoNumbers;

/**
 * Created by mletter1 on 9/11/16.
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Solution solution = new Solution();

        ListNode sol = solution.addTwoNumbers(l1,l2);
        System.out.println(" solution = [" + sol.val +", " + sol.next.val +", " + sol.next.next.val +"] should == [7, 0, 8]");
    }
}
