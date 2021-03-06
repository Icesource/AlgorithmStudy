package com.ice.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

   // @return the single integer that this NestedInteger holds, if it holds a single integer
   // Return null if this NestedInteger holds a nested list
   public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
   // Return null if this NestedInteger holds a single integer
   public List<NestedInteger> getList();

}


public class FlattenNestedListIterator implements Iterator {

    private List<NestedInteger> list;
    private List<Integer> result = new ArrayList<>();
    int pos = 0;


    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        list = nestedList;
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(list.get(0));

        while (!stack.isEmpty()){
            NestedInteger top = stack.pop();
            if(top.isInteger()){
                result.add(top.getInteger());
            }else{
                List<NestedInteger> temp =  top.getList();
                for (NestedInteger nested: temp) {
                    stack.push(nested);
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return (pos+1)>result.size();
    }

    @Override
    public Object next() {
        return result.get(pos++);
    }
}
