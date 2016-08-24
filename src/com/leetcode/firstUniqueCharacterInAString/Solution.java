package com.leetcode.firstUniqueCharacterInAString;

/**
 * Created by mletter1 on 8/23/16.
 */
public class Solution {
  /**
   * take a string and return the first
   * value that is not repeated
   */
  public int firstUniqChar(String s) {
    if(s.length() == 1){
      return 0;
    }
    int[] letters = new int[256];
    for(int i = 0; i < s.length(); i++){
      letters[s.charAt(i)]++;
    }
    for(int i = 0; i < s.length(); i++){
      if(letters[s.charAt(i)] == 1){
        return i;
      }
    }
    return -1;
  }
}
