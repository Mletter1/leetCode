package com.leetcode.kthSmallestElementInASortedMatrix;

/**
 * Created by mletter1 on 9/4/16.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 5;
        matrix[0][2] = 9;
        matrix[1][0] = 10;
        matrix[1][1] = 11;
        matrix[1][2] = 13;
        matrix[2][0] = 12;
        matrix[2][1] = 13;
        matrix[2][2] = 15;
        assert(solution.kthSmallest(matrix, 8) == 13);
        System.out.println(" solution = [" + solution.kthSmallest(matrix, 8) +"] should == [13]");
    }
}
