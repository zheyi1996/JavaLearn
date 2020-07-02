package cn.neu.edu.wlg.leetcode;

/*
    1.正序和逆序单链表的建立
        正序中需不断向前移动head指针，逆序中head指针不动而不断移动move指针向后添加节点
    2.保留值和进位值
        保留值是当前两个数对应位上的值加上前一位的进位值再对10取余数
        进位值是当前两个数对应位上的值加上前一位的进位值再除以10
    3.当单链表移动到null时再调用其next属性就会出现空指针异常
 */
public class LeetCode002 {

    public static void main(String[] args) {

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList1.addHead(9);
        singleLinkedList1.addHead(9);

        singleLinkedList2.addHead(1);

//        singleLinkedList1.addHead(7);
//        singleLinkedList1.addHead(4);
//        singleLinkedList1.addHead(2);
//
//        singleLinkedList2.addHead(4);
//        singleLinkedList2.addHead(6);
//        singleLinkedList2.addHead(5);

        Solution solution = new Solution();
        ListNode l3 = solution.addTwoNumbers(singleLinkedList1.head, singleLinkedList2.head);
        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        singleLinkedList3.size = 3;
        singleLinkedList3.head = l3;
        singleLinkedList3.display();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


class SingleLinkedList {

    public int size; //链表的节点个数
    public ListNode head; //头节点 -- 指向头结点的句柄

    public SingleLinkedList() {
        this.size = 0;
        this.head = null;
    }

    //在表头添加元素
    public int addHead(int val) {

        ListNode newHead = new ListNode(val);
        if(this.size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return val;
    }

    //在表头删除元素
    public  int deleteHead() {

        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    //查找指定元素
    public ListNode find(int val) {

        ListNode current = head;
        int tempSize = size;
        while(tempSize > 0) {

            if(val == current.val) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    //删除指定元素
    public boolean delete(int value) {
        if(size == 0) {
            return false;
        }
        ListNode previous = head;
        ListNode current = head;
        while(current.val != value) { //先找出要删除的节点
            if(current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        //如果删除的是第一个节点
        if(current == head) {
            head = current.next;
            size--;
        } else {
            previous.next = current.next;
            size--;
        }
        return true;
    }

    //判断链表是否为空
    public boolean isEmpty() {

        return (this.size == 0);
    }

    //显示节点信息
    public void display() {

        if(size > 0) {
            ListNode current = head;
            int tempSize = size;
            boolean isFirst = true;
            while(tempSize > 0) {
                if(isFirst) { //链表第一个元素
                    System.out.print("[" + current.val);
                    isFirst = false;
                } else {
                    //链表中间数据
                    System.out.print("->" + current.val);
                }
                if(current.next == null) { //链表结尾
                    System.out.println("]");
                }
                current = current.next;
                tempSize--;
            }
        } else {
            System.out.println("[]");
        }
    }

}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode l3Move = null;
        int size = 0;
        int tempValue1;
        int tempValue2;
        int tempValue3;
        int carry = 0; //是否进位
        while(l1 != null || l2 != null) {
            if (l1 == null) {
                tempValue1 = 0;
            } else {
                tempValue1 = l1.val;
            }
            if (l2 == null) {
                tempValue2 = 0;
            } else {
                tempValue2 = l2.val;
            }
            tempValue3 = (tempValue1 + tempValue2 + carry) % 10; //保留值
            ListNode temp = new ListNode(tempValue3);
            if (size == 0) { //以逆序方式建立单链表
                l3 = temp;
                l3Move = temp;
            } else {
                l3Move.next = temp;
                l3Move = temp;
            }
            carry = (tempValue1 + tempValue2 + carry) / 10; //进位值
            size++;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            ListNode temp = new ListNode(1);
            l3Move.next = temp;
        }
        return l3;
    }
}
















