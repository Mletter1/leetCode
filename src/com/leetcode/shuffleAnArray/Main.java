package com.leetcode.shuffleAnArray;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        int[] input = new int[3];
        input[0] = 3;
        input[1] = 2;
        input[2] = 4;
        Solution solution = new Solution(input);
        int[] answer = solution.shuffle();
        System.out.println("index of solution = [" + answer[0] +", "+ answer[1]+", "+ answer[2]+"] should == [random]");
        answer = solution.reset();
        System.out.println("index of solution = [" + answer[0] +", "+ answer[1]+", "+ answer[2]+"] should == [3, 2, 4]");
    }
}
