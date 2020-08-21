package cn.neu.edu.wlg.writtenExamination;

import cn.neu.edu.wlg.leetcode.LeetCode025;
import cn.neu.edu.wlg.leetcode.util.ListNode;

public class ByteDance_2020_8_20 {

    public static void main(String[] args) {
        ByteDance_2020_8_20 byteDance_2020_8_20 = new ByteDance_2020_8_20();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        ListNode newHead = byteDance_2020_8_20.reverseKGroup(head, 3);
        while (null != newHead) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            throw new NullPointerException("链表为null");
        }
        ListNode newHead = new ListNode(-1);
        ListNode temp1 = head;
        ListNode temp2 = newHead;
        int i = 0;
        while(null != temp1) {
            ++i;
            ListNode temp = temp2.next;
            temp2.next = temp1;
            temp1 = temp1.next; // 重要!!!
            temp2.next.next = temp;

            if (i % k == 0) {
                for (int j = 0; j < k; ++j) {
                    temp2 = temp2.next;
                }
            }
        }
        return newHead.next;
    }

//    public ListNode reverseKGroup2(ListNode head, int k) {
//
//    }
}
