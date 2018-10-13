package com.ice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Entry> stack = new Stack<Entry>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i ++) {
            if (stack.isEmpty()) {
                stack.push(new Entry(temperatures[i], i));
                continue;
            }
            if (temperatures[i] <= stack.peek().val)
                stack.push(new Entry(temperatures[i], i));
            else {
                int j = 1;
                while (!stack.isEmpty() && temperatures[i] > stack.peek().val) {
                    Entry tmp = stack.pop();
                    res[tmp.index] = i - tmp.index;
                }
                stack.push(new Entry(temperatures[i], i));
            }
        }

        return res;
    }

    private class Entry {

        public int val;
        public int index;

        public Entry(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
