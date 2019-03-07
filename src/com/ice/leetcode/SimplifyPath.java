package com.ice.leetcode;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String test = "/abc/...";
        System.out.println(simplifyPath(test));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i<path.length();){
            while(i<path.length() && path.charAt(i) == '/' ) i++;
            if(i >= path.length()) break;
            int start = i;
            while(i<path.length() && path.charAt(i) != '/') i++;
            int end = i;
            String temp = path.substring(start,end);
            if(temp.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else{
                if(!temp.equals(".")) stack.push(temp);
            }
        }
        if(stack.size() == 0) return "/";
        StringBuffer result = new StringBuffer();
        for(int i = 0; i<stack.size();){
            result.insert(0, "/"+stack.pop());
        }
        return result.toString();
    }
}
