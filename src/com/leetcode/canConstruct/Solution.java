package com.leetcode.canConstruct;

/**
 * Created by mletter1 on 8/21/16.
 */
public class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    if(ransomNote.length() > magazine.length()){
      return false;
    }
    int foundCount = 0;
    boolean found = false;
    char ransomChar = 'a';
    boolean[] out = new boolean[magazine.length()];

    for(int i = 0; i < ransomNote.length(); i++){
      ransomChar = ransomNote.charAt(i);
      for(int j = 0; j < magazine.length(); j++){
        if(magazine.charAt(j) == ransomChar && !out[j]){
          out[j] = true;
          foundCount++;
          break;
        }
      }
    }
    if(foundCount == ransomNote.length()) return true;
    return false;
  }
}
