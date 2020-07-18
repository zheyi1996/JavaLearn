package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.ListNode;

/*
    题目：合并两个排序的链表
    思路：
    知识点：
        1. list赋值为null后不能增加新的结点
        2. 先给next赋值，再指向next就可以实现指针的移动

 */
public class Offer016 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newList = new ListNode(-1);
        ListNode dummy = newList;
        while (null != list1 && null != list2) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                dummy = dummy.next;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                dummy = dummy.next;
                list2 = list2.next;
            }
        }
        while (null != list1) {
            dummy.next = list1;
            dummy = dummy.next;
            list1 = list1.next;
        }
        while (null != list2) {
            dummy.next = list2;
            dummy = dummy.next;
            list2 = list2.next;
        }
        return newList.next;
    }
}
