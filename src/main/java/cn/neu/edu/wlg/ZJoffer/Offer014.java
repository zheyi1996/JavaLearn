package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.ListNode;

/*
    题目：链表中倒数第k个结点
    思路：
        倒数第k个数与倒数第一个数之间相差k-1步，所以让两个指针走，
        一个指针先走k-1步，另一个指针再同时走，那么第一个指针走到最后一个节点时，第二个指针就指向倒数第k个数
        如果第一个指针走的过程中发现没有k个节点(.next == null)，则直接返回null

 */
public class Offer014 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (null == head || k <= 0) {
            return null;
        }
        ListNode list1 = head;
        ListNode list2 = head;
        for (int i = 1; i <= k - 1; ++i) {
            if (list1.next == null) {
                return null;
            }
            list1 = list1.next;
        }
        while (list1.next != null) {
            list1 = list1.next;
            list2 = list2.next;
        }
        return list2;
    }
}
