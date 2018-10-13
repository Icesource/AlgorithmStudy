package com.ice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionTwoArrayII {
    public static void main(String[] args){
        int arr1[] = {4,9,5};
        int arr2[] = {9,4,9,8,4};
        intersect(arr1,arr2);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums1) {
            if(map.get(i)==null)
                map.put(i,1);
            else {
                int temp = map.get(i);
                map.put(i, temp+1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if (map.get(i)!=null && map.get(i) > 0) {
                result.add(i);
                int temp = map.get(i)-1;
                map.put(i,temp);
            }
        }
        int[] resultArr = new int[result.size()];
        for (int i = 0;i<result.size();i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;

    }
}
