package com.ice.leetcode;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0,j = numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                break;
            }
            if(numbers[i]+numbers[j]>target){
                j--;
            }
            if(numbers[i]+numbers[j]<target){
                i++;
            }
        }
        return new int[]{++i,++j};
    }
}
