package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.ListNode;

/*
    题目：两个链表的公共子节点
    思路：
        1. 遍历得到两个链表的长度
        2. 长度做差，长的链表先走长度差个节点
        3. 两个链表走到第一个相等的节点就是两两链表的第一个公共子节点
 */
public class Offer036 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (null == pHead1 || null == pHead2) {
            return null;
        }
        int leng1 = 0;
        int leng2 = 0;
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        while (null != temp1) {
            ++leng1;
            temp1 = temp1.next;
        }
        while (null != temp2) {
            ++leng2;
            temp2 = temp2.next;
        }
        int leng = Math.abs(leng1 - leng2);
        if (leng1 > leng2) {
            for (int i = 0; i < leng; ++i) {
                pHead1 = pHead1.next;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        } else if (leng1 < leng2) {
            for (int i = 0; i < leng; ++i) {
                pHead2 = pHead2.next;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        } else {
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        }
    }
}
