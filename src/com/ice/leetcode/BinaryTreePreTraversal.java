package com.ice.leetcode;

import com.ice.datatype.Command;
import com.ice.datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的遍历这里全部是用的非递归方法
 * 这里是通过栈模拟递归时系统栈的状态来做到的非递归算法
 */

public class BinaryTreePreTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while(!stack.isEmpty()){
            Command command = stack.pop();

            if (command.s.equals("print")){
                res.add(command.node.val);
            }else{
                assert command.s.equals("go");
                if(command.node.right!=null) stack.push(new Command("go",command.node.right));
                if(command.node.left!=null) stack.push(new Command("go",command.node.left));
                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }
}
