package com.atguigu.algorithm.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

//用一个队列来实现自定义栈
public class MyStack2 {
    //定义一个队列
    Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<>();
    }

    //push方法
    public void push(int x){
        //1.首先记录当前队列的大小
        int l = queue.size();
        //2.将当前元素进行入队
        queue.offer(x);
        //3.将以前的元素进行出队再入队
        for (int i = 0; i <l ; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop(){
        return queue.poll();
    }

    public int top(){
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }
}
