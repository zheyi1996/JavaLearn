package cn.neu.edu.wlg.NC;

import cn.neu.edu.wlg.leetcode.util.ListNode;

import java.util.*;
public class NC051 {

    public static void main(String[] args) {
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode3.next = new ListNode(5);
        arr.add(listNode1);
        arr.add(listNode2);
        arr.add(listNode3);
        ListNode listNode = mergeKLists(arr);
        while(null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        while(1 != lists.size()) {
            ArrayList<ListNode> temp = new ArrayList<>();
            for(int i = 0, j = lists.size() - 1; i < lists.size() / 2; ++i, --j) {
                temp.add(mergeTwoLists(lists.get(i), lists.get(j)));
            }
            if(1 == (lists.size() % 2)) {
                temp.add(lists.get(lists.size() / 2));
            }
            lists = null;
            lists = (ArrayList<ListNode>)temp.clone();
        }
        return lists.get(0);
    }
    public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        ListNode l = new ListNode(-1);
        ListNode temp = l;
        while(null != l1 && null != l2) {
            if(l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = (null != l1) ? l1 : l2;
        return l.next;
    }
}