package com.leetcode.reverseInteger;

/**
 * Created by mletter1 on 9/15/16.
 */
public class Solution {
  public int reverse(int x) {
    long retVal = 0;
    int temp = 0;
    final int MAX = 2147483647;
    final int MIN = -2147483648;
    while (x != 0){
      temp = x % 10;
      retVal = retVal*10 + temp;
      x= x/10;
    }
    if(retVal > MAX || retVal < MIN){
      return 0;
    }
    return (int)retVal;
  }
}
