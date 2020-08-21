package cn.neu.edu.wlg.leetcode;

import cn.neu.edu.wlg.leetcode.util.ListNode;

/*
    题目：链表的中间结点
    思路：
        fast指针每次走两步，low指针每次走一步，这样fast指针所走的步数一直时low指针的两倍
        所以low指针一直指向中间结点
 */
public class LeetCode876 {
    public ListNode middleNode(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode low = head;
        ListNode fast = head.next.next;
        while (null != fast && null != fast.next) {
            low = low.next;
            fast = fast.next.next;
        }
        return low.next;
    }
}
