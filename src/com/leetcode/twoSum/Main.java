package com.leetcode.twoSum;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[3];
        input[0] = 3;
        input[1] = 2;
        input[2] = 4;
        int target = 6;
        int[] answer = solution.twoSum(input,target);
        System.out.println("index of solution = [" + answer[0] +", "+ answer[1]+"] should == [1,2]");
    }

}
