package com.ice.leetcode;

public class LSWReaptingChara {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        for (int f = 0; f < freq.length; f++) {
            freq[f] = 0;
        }
        int i = 0, j = -1;
        int result = 0;
        while (i < s.length()) {
            if (j < s.length() - 1 && freq[s.charAt(j + 1)] == 0) {
                freq[s.charAt(++j)]++;
            }else{
                freq[s.charAt(i++)]--;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}
