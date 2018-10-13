package com.ice.leetcode;

public class MergeSortedArray {

    public static void main(String[] args){
        int[] nums1 = {3,2,1,5,6,4};
        quickSort(nums1,0,nums1.length-1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m;i<m+n;i++){
            nums1[i] = nums2[i-m];
        }
        quickSort(nums1,0,m+n-1);
        for (int num:nums1
             ) {
            System.out.println(num);
        }
    }

    public static void quickSort(int[] arr,int left,int right){

        int i = left;
        int j = right;
        int flag=i;
        while(i<j){
            while(arr[j]>=arr[flag]&&i<j)
                j--;
            while(arr[i]<=arr[flag]&&i<j)
                i++;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        int temp = arr[flag];
        arr[flag] = arr[i];
        arr[i] = temp;
        if(i>left)
            quickSort(arr,left,i-1);
        if(j<right)
            quickSort(arr,i+1,right);
    }
}
