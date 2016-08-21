package com.leetcode.canConstruct;

/**
 * Created by mletter1 on 8/21/16.
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
//      canConstruct("a", "b") -> false
//      canConstruct("aa", "ab") -> false
//      canConstruct("aa", "aab") -> true
        System.out.println(" solution = [" + solution.canConstruct("a", "b") + ", "+
          solution.canConstruct("aa", "ab") + ", "+ solution.canConstruct("aa", "aab") +"] should == [false, false, true]");
    }
}
