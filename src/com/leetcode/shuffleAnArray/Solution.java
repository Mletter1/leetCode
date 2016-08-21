package com.leetcode.shuffleAnArray;
import java.util.Arrays;
import java.util.Random;
/**
 * Created by mletter1 on 8/21/16.
 */
public class Solution {
    private Random rand;
    private int [] nums;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] usedIndexes = new int[nums.length];
        Arrays.fill(usedIndexes, -1);
        int[] returnArray = new int[nums.length];
        for(int i = 0; i<nums.length;i++){
            boolean checking=true;
            int randNum = 0;
            while(checking){
                randNum = rand.nextInt(usedIndexes.length);
                checking = false;
                for(int j = 0; j<usedIndexes.length; j++){
                    if(randNum == usedIndexes[j]){
                        checking = true;
                    }
                }
            }
            usedIndexes[i] = randNum;
            returnArray[i] = this.nums[randNum];
        }
        return returnArray;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */