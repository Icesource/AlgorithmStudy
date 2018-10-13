package com.ice.leetcode;

import java.util.Stack;

public class ReversePolishNotation {

    public static void main(String[] args){
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens){
        Stack<String> stack = new Stack<>();

        for(int i =0;i<tokens.length;i++){
            if(isSimbol(tokens[i])){
                int temp1 = Integer.parseInt(stack.pop());
                int temp2 = Integer.parseInt(stack.pop());
                if(tokens[i].equals("+")){
                    stack.push(String.valueOf(temp1+temp2));
                }
                if(tokens[i].equals("-")){
                    stack.push(String.valueOf(temp2-temp1));
                }
                if(tokens[i].equals("*")){
                    stack.push(String.valueOf(temp1*temp2));
                }
                if(tokens[i].equals("/")){
                    stack.push(String.valueOf(temp2/temp1));
                }
            }else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public static boolean isSimbol(String s){
        if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
            return true;
        }
        return false;
    }
}
