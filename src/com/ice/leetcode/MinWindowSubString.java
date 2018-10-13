package com.ice.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinWindowSubString {
    public static void main(String args[]){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        HashMap<Integer,Integer> target = new HashMap<>();
        for(int i =0;i<t.length();i++){
            if(target.get((int)t.charAt(i))==null){
                target.put((int) t.charAt(i),1);
            }else{
                int temp  = target.get((int)t.charAt(i));
                target.put((int) t.charAt(i),temp+1);
            }
        }

        int freq[] = new int[256];
        for (int i = 0; i < freq.length; i++) freq[i] = 0;

        int i = 0, j = -1;
        int length = Integer.MAX_VALUE;
        String result = "";

        while(i<s.length()){
            if(j<s.length()-1&&!hasFound(freq,target)){
                freq[s.charAt(++j)]++;
            }else{
                freq[s.charAt(i++)]--;
            }

            if(hasFound(freq,target)){
                if(length>j-i+1){
                    length = j-i+1;
                    result = s.substring(i,j+1);
                }
            }
        }
        return result;
    }

    public static boolean hasFound(int[] arr1,HashMap<Integer,Integer> arr2){
        Iterator iter = arr2.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer,Integer> entry = (Map.Entry) iter.next();
            if(arr1[entry.getKey()]<entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
