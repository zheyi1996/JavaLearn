package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.ListNode;

/*
    题目：删除链表中重复的结点 - 排序的链表
    思路：
        思路一：遍历链表，如果一个结点既不等于前一个结点的值，也不等于后一个结点的值，则加入到新链表中

        1 1 2 2 3 4 5 5
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
    // 1 1 2 2 3 4 5 5
    public ListNode deleteDuplication(ListNode pHead) {
        if (null == pHead) {
            return null;
        }
        int flag = 0;
        ListNode noRepeatHead = new ListNode(-1);
        ListNode temp = noRepeatHead;
        ListNode prevNode = pHead;
        ListNode currentNode = prevNode.next;
        if (null == prevNode.next || prevNode.val != prevNode.next.val) {
            temp.next = prevNode;
            temp = temp.next;
        }
        while (null != currentNode) {
            if (currentNode.val != prevNode.val) {
                if (null == currentNode.next) {
                    temp.next = currentNode;
                    temp = temp.next;
                } else if (currentNode.val != currentNode.next.val) {
                    temp.next = currentNode;
                    temp = temp.next;
                }
            }
            prevNode = prevNode.next;
            currentNode = currentNode.next;
        }
        temp.next = null;
        return noRepeatHead.next;
    }
}
