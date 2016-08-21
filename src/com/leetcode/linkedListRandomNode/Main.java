package com.leetcode.linkedListRandomNode;

/**
 * Created by mletter1 on 8/21/16.
 */
public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Solution solution = new Solution(head);
        System.out.println(" solution = " + solution.getRandom() + " ");
    }
}
