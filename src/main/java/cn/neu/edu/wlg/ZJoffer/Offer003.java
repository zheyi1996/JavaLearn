package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/*
    思路：
        1. 遍历链表，并使用Stack存放节点
        2. 取出Stack节点，并将值存放到ArrayList<Integer>
    盲点：
        1. 泛型 -- 参数化类型
            1. 泛型方法
                * 类型参数声明部分在方法返回类型之前
                * 类型参数能够被用来声明返回值类型
                * 类型参数只能代表引用类型，不能是原始类型(int,double,char等)
            2. 有界类型参数 - 限制传递到一个类型参数的类型种类范围 <T extends Comparable<T>>
            3. 泛型类 - 在类名后面添加类型参数声明
            4. 类型通配符(约定)
                * ?表示不确定的java类型
                * T(type)表示一个具体的java类型
                * K V(key, value)表示java键值中的Key Value
                * E(element)表示Element
        2. Java链表
            class ListNode {
                int val;
                ListNode next; // next是List一个属性
                ListNode(int x) { // 通过此构造方法赋值
                    val = x;
            }
        3. ArrayList -- Java集合
}
 */
public class Offer003 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (null == listNode) {
            return result;
        }
        ListNode next = listNode;
        Stack<ListNode> stack = new Stack<ListNode>();
        while(null != next) {
            stack.push(next);
            next = next.next;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop().val);
        }
        return result;
    }
}

