package com.leetcode.twoSum;

/**
 * Created by mletter1 on 8/6/16.
 */
public class Solution {
    /**
     * Takes an array and returns the two indexes that
     * add up to equal the target
     * @param nums int[]
     * @param target int
     * @return int[]
     */
    public int[] twoSum(int[] nums, int target) {
        int[] x = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    x[0]=i;
                    x[1]=j;
                    return x;
                }
            }
        }
        x[0]=0;
        x[1]=1;
        return x;
    }
}
