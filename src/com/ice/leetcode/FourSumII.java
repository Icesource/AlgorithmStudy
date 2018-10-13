package com.ice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<A.length;i++){
            for(int j = 0;j<B.length;j++){
                map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        for(int i = 0;i<C.length;i++){
            for(int j = 0;j<D.length;j++){
                if(map.containsKey(0-C[i]-D[j])){
                    result+=map.get(0-C[i]-D[j]);
                }
            }
        }
        return result;
    }
}
