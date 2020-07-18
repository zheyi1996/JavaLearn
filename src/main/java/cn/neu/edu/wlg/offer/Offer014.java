package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.ListNode;

/*
    题目：链表中倒数第k个结点
    思路：
        两个指针，一个指针先走k-1步，另一个指针再走，第一个指针指到最后一个节点时，第二个指针指向结果
        1 2 3 4 5
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
//        ListNode listNode = list2;
//        listNode.next = null;
//        return listNode;
    }
}
