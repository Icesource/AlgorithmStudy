package com.ice.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionTwoArray {
    public static void main(String[] args){
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};
        intersection(arr1,arr2);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for(int i = 0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        Set<Integer> resultSet = new HashSet<Integer>();
        for(int i = 0;i<nums2.length;i++){
            if(set1.contains(nums2[i]))
                resultSet.add(nums2[i]);
        }
        Iterator iter = resultSet.iterator();
        int[] result = new int[resultSet.size()];
        int i = 0;
        while (iter.hasNext()){
            result[i++] = (int) iter.next();        }
        return result;
    }
}
