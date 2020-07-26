package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.DNode;
import cn.neu.edu.wlg.offer.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
    题目：链表中环的入口结点
    思路： 需要问清楚一个结点是不是环
        思路一： 不推荐
            1. 使用双向链表辅助空间，逐个遍历单链表并将结点逐个加入到双向链表中
            2. 然后遍历双链表，如果遍历到某个双链表结点并试图将其插入到双链表中时，发现该双链表的pre指针非null，
                则该结点就是环的入口结点，再遍历单链表找到对应的结点即可
        思路二：
            1. 两个指针，一个一次走两步，一个一次走一步，当两指针相交时说明该链表存在环
            2. 从两指针相交处出发，遍历环，计算出环的长度K
            3. 问题已经转换为求链表的倒数第K个结点的问题了
        思路三：遍历链表，将结点放入集合中，如果集合中已经出现了该结点则返回该结点

 */
public class Offer055 {

    // 思路二
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (null == pHead || null == pHead.next) { // 一个结点不能成环
            return null;
        }
        ListNode oneStepList = pHead;
        ListNode twoStepList = pHead.next.next;
        int loopLength = 0;
        // 证明是否成环
        while (null != twoStepList) {
            if (oneStepList.equals(twoStepList)) { // 成环，计算环的长度
                ListNode temp = oneStepList.next;
                ++loopLength;
                while (temp != oneStepList) { // 计算环的长度
                    ++loopLength;
                    temp = temp.next;
                }
                // 求倒数第K个结点
                temp = pHead;
                ListNode result = pHead;
                for (int i = 1; i <= loopLength; ++i) {
                    temp = temp.next;
                }
                while (temp != result) { // 倒数第K个结点!!!
                    temp = temp.next;
                    result = result.next;
                }
                return result;
            } else {
                oneStepList = oneStepList.next;
                twoStepList = twoStepList.next.next;
            }
        }
        return null; // 不成环
    }

    // 思路三
    public ListNode EntryNodeOfLoop3(ListNode pHead) {
        if (null == pHead || null == pHead.next) { // 一个结点不能成环
            return null;
        }
        ListNode temp = pHead;
        Set<ListNode> listNodeSet = new HashSet<>();
        while (null != temp) {
            if (listNodeSet.contains(temp)) {
                return temp;
            } else {
                listNodeSet.add(temp);
            }
            temp = temp.next;
        }
        return null;
    }
}
