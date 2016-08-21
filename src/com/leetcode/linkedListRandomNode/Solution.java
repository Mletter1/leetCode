package com.leetcode.linkedListRandomNode;

/**
 * Created by mletter1 on 8/21/16.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.Random;
public class Solution {
  private int length = 0;
  private	Random r = null;
  private ListNode[] nodes = null;
  /** @param head The linked list's head.
  Note that the head is guaranteed to be not null, so it contains at least one node. */
  public Solution(ListNode head) {
    boolean printing = true;
    ListNode node = null;
    node = head;
    while(printing){
      this.length++;
      if(node.next == null){
        printing = false;
      }else{
        node = node.next;
      }
    }
    this.r = new Random();
    this.nodes = new ListNode[this.length];
    node = head;
    for(int i = 0; i < this.length; i++){
      this.nodes[i]= node;
      node = node.next;
    }
  }

  /** Returns a random node's value. */
  public int getRandom() {
    return this.nodes[r.nextInt(this.length)].val;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
