package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.ListNode;

/*
    题目：删除链表中重复的结点 - 排序的链表
    思路：
        思路一：找到所有不重复的数字，把不重复的数字串联起来
 */
public class Offer056 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode p = listNode;
        p.next = new ListNode(1);
        p = p.next;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(5);
        Offer056 offer056 = new Offer056();
        offer056.deleteDuplication(listNode);
    }
    public ListNode deleteDuplication(ListNode pHead) {
        if (null == pHead) {
            return null;
        }
        int flag = 0;
        ListNode noRepeatHead = new ListNode(-1);
        boolean isFirst = true;
        // 1 1 2 2 3 4 5
        /*
            1. 先找到两个值不相等的节点，然后判断后一个节点后面是否有相等的节点，没有则添加
         */
        while (null != pHead) { // 找到不重复的节点
            ListNode temp;
            if (!isFirst) { // 第一个节点不和前值比较
                isFirst = false;
            } else {

                while (null != pHead.next && pHead.next.val != pHead.val) { // 找到和前面节点的值不相等的节点
                    pHead = pHead.next;
                }
            }

            if (pHead.next.val != pHead.next.next.val) { // 判断此值是否和后面的节点值相同，不相同则为不重复节点值
                noRepeatHead.next = pHead; // 添加不重复的节点
                pHead = pHead.next.next;
            } else { // 如果相等,则继续
                pHead = pHead.next;
            }
        }
        return pHead;
    }
}
