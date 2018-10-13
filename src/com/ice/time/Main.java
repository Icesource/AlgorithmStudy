package com.ice.time;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args){
        for(int i =10;i<=24;i++){
            int n = (int) pow(2,i);
            int[] arr = MyUtil.generateRandomArray(n,0,100000000);

            long startTime=System.currentTimeMillis();
            MyAlgorithmTester.selectionSort(arr,n);
            long endTime=System.currentTimeMillis();//记录结束时间

            System.out.print("data size 2^"+i+" = "+n);
            System.out.println("\tTime cost:"+(double)((endTime-startTime)/1000));
        }
    }
}

