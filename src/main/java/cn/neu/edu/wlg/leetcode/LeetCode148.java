package cn.neu.edu.wlg.leetcode;

/*
    题目：排序链表
    思路：归并排序
        1. 找到链表中间节点并断开
        2. 合并有序链表
            4->2
            4->2->1->3
            -1->5->3->4->0
 */
public class LeetCode148 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(1);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = null;
        LeetCode148 leetCode148 = new LeetCode148();

        ListNode result = leetCode148.sortList(head);
        while (null != result) {
            System.out.println(result.val + "->");
            result = result.next;
        }
    }
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        // 找到链表的中间结点
        ListNode mid =  getMiddleNode(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        ListNode sortedList = mergeList(left, right);
        return sortedList;
    }
    // 找到链表中间结点
    private ListNode getMiddleNode(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode low = head;
        ListNode fast = head.next.next;
        while (null != fast && null != fast.next) {
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }
    // 合并两个有序链表
    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode sortedList = new ListNode(-1);
        ListNode temp = sortedList;
        while (null != left && null != right) {
            if (left.val < right.val) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            } else {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        temp.next = null == left ? right : left;
        return sortedList.next;
    }
}
