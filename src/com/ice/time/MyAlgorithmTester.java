package com.ice.time;

import static java.lang.Math.min;

public class MyAlgorithmTester {

    // O(logN),二分法查找
    public static int binarySearch(int arr[], int n, int target) {

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    // O(N),从数组中寻找最大值
    public static int findMax(int arr[], int n) {

        assert (n > 0);

        int res = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > res)
                res = arr[i];

        return res;
    }

    // O(NlogN) 归并排序
    private static void __merge(int arr[], int l, int mid, int r, int aux[]) {

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j];
                j++;
            } else if (j > r) {
                arr[k] = aux[i];
                i++;
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }
        }
    }

    public static void mergeSort(int arr[],int n){
        int[] aux = new int[n];
        for(int i = 0;i<n;i++){
            aux[i] = arr[i];
        }
        for(int sz = 1;sz<n;sz+=sz){
            for(int i = 0;i<n;i+=sz+sz){
                __merge(arr,i,i+sz-1,min(i+sz+sz-1,n-1),aux);
            }
        }
        return;
    }


    // O(N^2)
    public static void selectionSort(int arr[],int n){

        for(int i =0;i<n;i++){
            int minIndex = i;
            for(int j = i+1;j<n;j++){
                if(arr[j]<arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        return;
    }
}

