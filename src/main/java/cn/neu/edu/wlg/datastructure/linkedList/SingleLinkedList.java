package cn.neu.edu.wlg.datastructure.linkedList;

public class SingleLinkedList {

    private int size; //链表的节点个数
    private ListNode head; //头节点 -- 指向头结点的句柄

    public SingleLinkedList() {
        this.size = 0;
        this.head = null;
    }

    //链表的节点
    private class ListNode {

        private Object data; //节点数据
        private ListNode next; //指向下个节点的指针--指向下个节点的句柄
        public  ListNode(Object data) {
            this.data = data;
        }
    }

    //在表头添加元素
    public Object addHead(Object obj) {

        ListNode newHead = new ListNode(obj);
        if(this.size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    //在表头删除元素
    public  Object deleteHead() {

        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素
    public ListNode find(Object obj) {

        ListNode current = head;
        int tempSize = size;
        while(tempSize > 0) {

            if(obj.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    //删除指定元素
    public boolean delete(Object value) {
        if(size == 0) {
            return false;
        }
        ListNode previous = head;
        ListNode current = head;
        while(current.data != value) { //先找出要删除的节点
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
                    System.out.print("[" + current.data);
                    isFirst = false;
                } else {
                    //链表中间数据
                    System.out.print("->" + current.data);
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
















