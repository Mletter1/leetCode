package com.leetcode.findTheDifference;

/**
 * Created by mletter1 on 8/28/16.
 */
public class Solution {
  public char findTheDifference(String s, String t) {
    int first = 0;
    int second = 0;
    for(int i = 0; i < s.length(); i++){
      first += (int)s.charAt(i);
      second += (int)t.charAt(i);
    }
    second += (int)t.charAt(s.length());
    // System.out.println(first +" "+ second);
    return (char)(second - first);
  }
}
