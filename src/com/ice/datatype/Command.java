package com.ice.datatype;

/**
 * 这里是为了模拟递归的系统栈创建的类
 * 用于二叉树的前中后序非递归遍历算法
 */
public class Command {

    public String s;
    public TreeNode node;

    public Command(String string, TreeNode treeNode){
        s = string;
        node = treeNode;
    }

}
