package com.ice.time;

public class MyUtil {

    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert (n > 0 && rangeL <= rangeR);

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL) + rangeL);
        }
        return arr;
    }

    public static int[] generateOrderedArray(int n) {

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
