package com.fish.feign.study;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * @author fish
 */
public class Queue {
    /**
     * 栈1用于插入整数
     */
    Stack<Integer> stack1;
    /**
     * 栈2用于删除整数
     */
    Stack<Integer> stack2;
 
    public Queue() {
        //对栈进行初始化
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }
    
    public void appendTail(int value) {
        //栈1压入value
        stack1.push(value);
    }
    
    public int deleteHead() {
        //若栈2为空且栈1不为空时，将栈1中的元素出栈一一压入栈2中
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        //栈1和栈2均为空时返回-1
        if(stack2.isEmpty()){
            return -1;
        }else{
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        //输入：
        //["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
        //[[],[3],[],[],[]]
        //输出：[null,null,3,-1,-1]
    }
}