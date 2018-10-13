package com.ice.leetcode;

import java.util.Stack;

public class ValidBrackets {
    public static void main(String[] args){
        String test = "()";
        System.out.println(isValid(test));
    }

    public static boolean isValid(String s){
        Stack<String> stack = new Stack<String>();
        for(int i =0;i<s.length();i++){
            String temp = s.substring(i,i+1);
            if(temp.equals("}")||temp.equals("]")||temp.equals(")")){
                if(stack.empty()){
                    return false;
                }
                while (!stack.empty()){
                    String top = stack.peek();
                    stack.pop();
                    if((top.equals("{")||top.equals("[")||top.equals("("))){
                        if(!matchBrackets(top,temp)){
                            return false;
                        }else {
                            break;
                        }
                    }
                }
            }else {
                stack.push(temp);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean matchBrackets(String a,String b){
        if(
                (a.equals("{")&&b.equals("}"))
                || (a.equals("[")&&b.equals("]"))
                || (a.equals("(")&&b.equals(")"))
                ){
            return true;
        }
        return false;
    }
}
