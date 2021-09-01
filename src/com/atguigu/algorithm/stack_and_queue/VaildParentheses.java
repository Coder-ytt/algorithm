package com.atguigu.algorithm.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

public class VaildParentheses {
    //使用栈
    public boolean isVaild(String s){
        Deque<Character> stack = new LinkedList<>();
        //遍历字符串中所有字符,依次判断
        for (int i = 0; i < s.length(); i++) {
            //获取当前字符
            char c = s.charAt(i);

            //判断当前字符是左括号还是右括号
            //如果是左括号，直接将对应的右括号入栈
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else {
                //如果是右括号,弹栈，判断是否匹配
                if(stack.isEmpty()||stack.pop()!=c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        VaildParentheses vaildParentheses = new VaildParentheses();
        String s = "()[]{}";
        System.out.println(vaildParentheses.isVaild(s));
    }
}
