package com.ice.leetcode;


public class SortColors {
    // 三路快排解决问题
    public void sortColors(int[] nums) {
        int zero = -1;         // nums[0...zero]==0
        int two = nums.length; //nums[two...n-1]==2
        for (int i = 0; i < two;) {
            if(nums[i]==0){
                int temp = nums[++zero];
                nums[zero] = nums[i];
                nums[i++] = temp;
            }else if(nums[i]==1){
                i++;
            }else{
                assert nums[i]==2;
                int temp = nums[--two];
                nums[two] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
