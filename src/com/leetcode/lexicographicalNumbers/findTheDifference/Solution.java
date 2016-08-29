package com.leetcode.lexicographicalNumbers.findTheDifference;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by mletter1 on 8/28/16.
 */
public class Solution {
  private ArrayList list = new ArrayList();

  /**
   * input 100 output [1, 10, 100, 1000, 101, 102, 103, 104, 105, 106,
   *                    107, 108, 109, 11, 110, 111, 112,......]
   * @param n number to print list of
   * @return list in lexigraphical order <n is inclusive>
   */
  public List<Integer> lexicalOrder(int n) {
    for(int i=1; i < 10 && i<= n; i++){
      list.add(i);
      builder(i,n);
    }
    return list;
  }
  public void builder(int i,int n){
    int next=0;
    for(int j=0; j<10;j++){
      next = ((i*10)+j);
      if(next > n) return;
      list.add(next);
      builder(next,n);
    }
  }
}
