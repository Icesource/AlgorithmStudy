package com.ice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.sqrt;

public class PerfectSquares {

    public static void main(String[] args) {
        int n = 13;
        int count = numSquares(n);
        System.out.println(count);
    }

    public static int numSquares(int n){

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        if(isSquare(n)){
            return 1;
        }
        queue.offer(n);

        while(!queue.isEmpty()){
            int len = queue.size();
            for (int z=0;z<len;z++){
                int top = queue.peek();
                queue.poll();
                for(int i=0;i<=sqrt(top);i++){
                    int m = top-i*i;
                    if(isSquare(m)){
                        count +=2;
                        return count;
                    }
                    if(m==top){
                        continue;
                    }
                    queue.offer(m);
                }
            }
            count++;
        }
        return count;
    }

    public static boolean isSquare(int n){
        double temp = sqrt(n);
        int m = (int) temp;
        return m*m==n;
    }
}
