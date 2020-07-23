package cn.neu.edu.wlg.offer;

import java.util.Stack;

public class Offer020 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> assistStack = new Stack<>();
    public void push(int node) {
        int min;
        if (!assistStack.isEmpty()) {
            min = assistStack.peek();
            assistStack.push(min < node ? min : node);
        } else {
            assistStack.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        assistStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return assistStack.peek();
    }
}
