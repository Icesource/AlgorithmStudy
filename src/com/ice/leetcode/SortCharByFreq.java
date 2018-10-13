package com.ice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortCharByFreq {
    public static void main(String[] args){
        String test = "tree";
        frequencySort(test);
    }

    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuffer result = new StringBuffer();
        int temp = -1;
        char tempKey=' ';
        int i = 0;
        while(i<s.length()){
            for (Map.Entry<Character,Integer> entry:map.entrySet()) {
                if(temp<entry.getValue()){
                    tempKey = entry.getKey();
                    temp = entry.getValue();
                }
            }
            map.remove(tempKey);
            while(temp>0){
                result.append(tempKey);
                i++;
                temp--;
            }
        }
        return result.toString();
    }
}
