package com.ice.leetcode;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args){
        int nums[] = new int[]{-2,0,1,1,2};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<nums.length-2;i++){
            int target = 0 - nums[i];
            int m = i+1,n = nums.length-1;
            while(m<n){
                if(nums[m]+nums[n]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[m]);
                    list.add(nums[n]);
                    set.add(list);
                    m++;
                    n--;
                }else{
                    if((nums[m]+nums[n])<target) m++;
                    else n--;
                }
            }
        }
        for (List<Integer> l:set) {
            result.add(l);
        }
        return result;
    }
}
