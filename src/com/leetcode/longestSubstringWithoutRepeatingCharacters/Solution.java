package com.leetcode.longestSubstringWithoutRepeatingCharacters;

/**
 * Created by mletter1 on 9/11/16.
 */
public class Solution {
  private boolean[] hashTable = new boolean[256];
  private void reset(){
    for(int i = 0; i < hashTable.length; i++) hashTable[i] = false;
  }
  public int lengthOfLongestSubstring(String s) {
    char temp = 0;
    int highVal = 0;
    int count = 0;
    for(int i = 0; i< s.length(); i++){
      for(int j = i; j < s.length(); j++){
        temp = s.charAt(j);
        if(!hashTable[temp]){
          hashTable[temp] = true;
          count++;
        }else{
          break;
        }
      }
      this.reset();
      if(count >= highVal){
        highVal = count;
      }
      count = 0;
    }
    return highVal;
  }
}
