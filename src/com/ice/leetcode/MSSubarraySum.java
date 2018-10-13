package com.ice.leetcode;

public class MSSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = -1;
        int sum = 0;
        int result = nums.length+1;
        while(i<nums.length){
            if(j<nums.length-1&&sum<s){
                sum+=nums[++j];
            }else{
                sum-=nums[i++];
            }
            if(sum>=s)
                result = Math.min(result,j-i+1);
        }
        if(result == nums.length+1){
            result = 0;
        }
        return result;
    }
}
