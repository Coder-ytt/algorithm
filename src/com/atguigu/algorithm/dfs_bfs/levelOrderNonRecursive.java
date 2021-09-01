package com.atguigu.algorithm.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrderNonRecursive {
    public static void levelOrderNonRecursive(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //只要队列不为空，就一直出队入队
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            visit(node);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }

    private static void visit(TreeNode node) {
        System.out.println(node.val);
    }
}
