package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.ListNode;

/*
    题目： 反转链表
    思路：后插改前插

 */
public class Offer015 {

    public static void main(String[] args) {
        Offer015 offer015 = new Offer015();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
//        temp = temp.next;
//        temp.next = new ListNode(4);
//        temp = temp.next;
//        temp.next = new ListNode(5);
        System.out.println(offer015.ReverseList2(head));
    }
    public ListNode ReverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode newHead = null;
        ListNode next = head;
        while (null != next) {
            ListNode temp = next;
            next = next.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }

    public ListNode ReverseList2(ListNode head) {
        if (null == head) {
            return null;
        }

        // 主要内容
        if (null == head.next) { // 巧妙
            return head;
        }
        // 理解递归函数ReverseList2(head.next)我们要理解为在面对一个已经实现反转的链表
        /*
            1 -> 2 <- 3 <- 4
                 |
                null
        */
        ListNode temp = ReverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
