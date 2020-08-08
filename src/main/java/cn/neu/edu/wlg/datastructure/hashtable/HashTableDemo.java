package cn.neu.edu.wlg.datastructure.hashtable;

public class HashTableDemo {
}

// 表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;
    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
// 创建EmpLinkedList,表示链表
class EmpLinkedList {
    // 头指针，指向第一个Emp
    private Emp head; // 默认为null
    // 添加雇员到链表
    public void add(Emp emp) {
        if (null == head) {
            head = emp;
            return;
        }
    }
}
