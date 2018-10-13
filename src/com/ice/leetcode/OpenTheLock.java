package com.ice.leetcode;

import java.util.*;

public class OpenTheLock {

    public static void main(String[] args) {
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        int count = openLock(deadends, target);
        System.out.println(count);
    }

    public static int openLock(String[] deadends, String target) {

        String start = "0000";
        List<String> visited = new ArrayList<String>();
        visited.add(start);
        Queue<String> queue = new LinkedList<String>();
        int count = 0;

        queue.offer(start);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String top = queue.peek();
                queue.poll();
                List<String> neibors = findNeibors(top);
                for (String neibor:neibors) {
                    if (target.equals(neibor)) {
                        count++;
                        return count;
                    }
                    if (findString(visited, neibor)) {
                        continue;
                    }
                    if (!findString(Arrays.asList(deadends), neibor)) {
                        visited.add(neibor);
                        queue.offer(neibor);
                    }
                }
            }
            count++;
        }

        return -1;
    }

    public static List<String> findNeibors(String s) {
        String temp = s;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] charTemp = temp.toCharArray();
            charTemp[i] = String.valueOf((Integer.parseInt(String.valueOf(charTemp[i])) + 1) % 10).toCharArray()[0];
//            charTemp[i] = (char) ((Integer.parseInt(String.valueOf(charTemp[i])) + 1) % 10);
            result.add(String.valueOf(charTemp));
            charTemp[i] = String.valueOf((Integer.parseInt(String.valueOf(charTemp[i])) + 8) % 10).toCharArray()[0];
            result.add(String.valueOf(charTemp));
        }
        return result;
    }

    public static boolean findString(List<String> tofind, String s) {
        for (String temp : tofind) {
            if (s.equals(temp)) {
                return true;
            }
        }
        return false;
    }
}
