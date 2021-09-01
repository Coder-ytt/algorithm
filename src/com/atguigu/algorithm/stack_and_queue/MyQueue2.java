package com.atguigu.algorithm.stack_and_queue;

import java.util.Stack;

//用两个栈实现
public class MyQueue2 {
    //定义两个栈
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //入队方法
    public void push(int x){
       stack1.push(x);
    }

    //出队方法
    public int pop(){
        //1.如果stack2为空，则把 stack1中的弹出压入
        if(stack2.isEmpty()){
           while (!stack1.isEmpty()){
               stack2.push(stack1.pop());
           }
        }
        //2.弹出stack2栈顶元素就行
        return stack2.pop();
    }

    //获取队首元素方法
    public int peek(){
        //1.如果stack2为空，则把 stack1中的弹出压入
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        //2.返回stack2栈顶元素就行
        return stack2.peek();
    }

    //判空
    public boolean empty(){
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
