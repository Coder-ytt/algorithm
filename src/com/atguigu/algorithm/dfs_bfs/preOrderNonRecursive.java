package com.atguigu.algorithm.dfs_bfs;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class preOrderNonRecursive {
    public static void preOrderNonRecursive(TreeNode root){
        //用一个栈来辅助操作
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();    // 栈顶元素弹出
            visit(node);    // 先访问根
            if (node.right != null) stack.push(node.right);    // 右子树根入栈
            if (node.left != null) stack.push(node.left);    // 左子树根入栈
        }
    }

    private static void visit(TreeNode node) {
        System.out.println(node.val);
    }
}
