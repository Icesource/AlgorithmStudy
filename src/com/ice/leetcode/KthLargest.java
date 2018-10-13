package com.ice.leetcode;

public class KthLargest {
    public static void main(String args[]){
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int i =findKthLargest(arr,4);
        System.out.println(i);
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = -1;
        int left = 0;
        int right = nums.length-1;
        n = quickSort(nums,left,right);
        if((nums.length-n)==k) return nums[n];
        while((nums.length-n)!=k){
            if((nums.length-n)<k){
                right = n-1;
                n = quickSort(nums,left,right);
            }
            if((nums.length-n)>k){
                left = n+1;
                n = quickSort(nums,left,right);
            }
        }
        return nums[n];
    }

    public static int quickSort(int arr[],int left,int right){
        int i = left;
        int j = right;
        int flag = arr[i];
        while(i!=j){
            while(arr[j]>=flag&&i<j){
                j--;
            }
            while(arr[i]<=flag&&i<j){
                i++;
            }
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[left] = arr[i];
        arr[i] = flag;
        return i;
//        if(i>left) quickSort(arr,left,i-1);
//        if(j<right) quickSort(arr,j+1,right);
    }
}
