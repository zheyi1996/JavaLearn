package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.ListNode;

/*
    题目： 反转链表
    思路：后插改前插

 */
public class Offer015 {

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
}
