package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.ListNode;

/*
    题目：两个链表的公共子节点
    思路：
        1. 遍历得到两个链表的长度
        2. 长度做差，长的链表先走长度差步
        3. 两个链表走到第一个相等的节点就是两链表的第一个公共子节点
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
        ListNode longerHead = leng1 >= leng2 ? pHead1 : pHead2;
        ListNode shorterHead = leng1 < leng2 ? pHead1 : pHead2;
        for (int i = 0; i < leng; ++i) {
            longerHead = longerHead.next;
        }
        while (longerHead != shorterHead) {
            longerHead = longerHead.next;
            shorterHead = shorterHead.next;
        }
        return shorterHead;
    }
}
