package com.atguigu.algorithm.stack_and_queue;

import java.util.Stack;

//用两个栈实现
public class MyQueue {
    //定义两个栈
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //入队方法
    public void push(int x){
        //1.将stack1中的弹出压入stack2中
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //2.将新元素压入stack1
        stack1.push(x);
        //3.将stack2中的元素弹出压入stack1
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    //出队方法
    public int pop(){
        return stack1.pop();
    }

    //获取队首元素方法
    public int peek(){
        return stack1.peek();
    }

    //判空
    public boolean empty(){
        return stack1.isEmpty();
    }
}
