package cn.neu.edu.wlg.offer;

import java.util.Stack;

/*
    题目：栈的压入、弹出序列
    思路：辅助栈
 */
public class Offer021 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (null == pushA || null == popA) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }
        if (0 == pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; ++i) {
            stack.push(pushA[i]);
            while (!stack.isEmpty()) {
                int temp = stack.pop();
                if (popA[j] == temp) {
                    ++j;
                    continue;
                } else {
                    stack.push(temp);
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}
