package cn.neu.edu.wlg.leetcode;

import cn.neu.edu.wlg.leetcode.util.ListNode;

public class LeetCode025 {

    public static void main(String[] args) {
        LeetCode025 leetCode025 = new LeetCode025();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        System.out.println(leetCode025.reverseKGroup(head, 3));
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            throw new NullPointerException("链表为null");
        }
        ListNode newHead = new ListNode(-1);
        ListNode temp1 = head;
        ListNode temp2 = newHead;
        int length = 0;
        while (null != temp1) {
            ++length;
            temp1 = temp1.next;
        }
        temp1 = head;
        int i = 0;
        while(null != temp1) {
            ++i;
            ListNode temp;
            if (i > length - (length % k)) {
                temp = temp1;
                temp1 = temp1.next; // 重要
                temp2.next = temp;
                temp2 = temp2.next;
            } else {
                temp = temp2.next;
                temp2.next = temp1;
                temp1 = temp1.next; // 重要!!!
                temp2.next.next = temp;
                if (i % k == 0) {
                    for (int j = 0; j < k; ++j) {
                        temp2 = temp2.next;
                    }
                }
            }
        }
        return newHead.next;
    }
}
