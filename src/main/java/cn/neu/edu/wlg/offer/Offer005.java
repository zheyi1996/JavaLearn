package cn.neu.edu.wlg.offer;

import java.util.Stack;

/*
    题目：用两个栈来实现队列
    思路：
        push到stack1
        pop的时候，如果stack2为空，则将stack1逐个pop并存入stack2，然后pop顶部元素
        如果stack2非空，则pop顶部元素
    盲点：
        1. pop，移除栈顶对象，并返回
 */
public class Offer005 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }
}
