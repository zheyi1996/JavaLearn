package cn.neu.edu.wlg.base.hashMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LRUTest {
    public static void main(String[] args) {
        int[][] operators = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int[] result = LRU(operators, 3);
        for(int i = 0; i < result.length; ++i) {
            System.out.println(result[i]);
        }
    }
    public static int[] LRU (int[][] operators, int k) {
        // write code here
        int resultLength = 0;
        for(int[] operator : operators) {
            if(2 == operator[0]) {
                ++resultLength;
            }
        }
        int[] results = new int[resultLength];
        int index = 0;
        LRUCache cache = new LRUCache(k);
        List<Integer> resultList = new LinkedList<>();
        for(int[] operator : operators) {
            switch(operator[0]) {
                case 1:
                    cache.put(operator[1], operator[2]);
                    break;
                case 2:
                    Integer value = cache.get(operator[1]);
                    results[index++] = value == null ? -1 : value;
            }
        }
        return results;
    }
}
// 双向链表节点类
class Node {
    public int key, val;
    public Node prev, next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class DoubleList {
    // 头尾虚节点
    private Node head, tail;
    // 链表元素个数
    private int size;
    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    // 在链表尾部添加节点node
    public void addLast(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        ++size;
    }
    // 删除链表中node节点
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        --size;
    }
    // 删除链表中第一个节点，并返回该节点
    public Node removeFirst() {
        if(head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }
    // 返回链表长度
    public int size() {
        return size;
    }
}
class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    // 将某个key提升为最近使用的
    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }
    // 添加最近使用的元素
    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }
    // 删除某一个key
    private void deleteKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    // 删除最久未使用的元素
    private void removeLeastRecently() {
        Node deleteNode = cache.removeFirst();
        int deleteKey = deleteNode.key;
        map.remove(deleteKey);
    }
    // get方法
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }
    // put方法
    public void put(int key, int val) {
        if(map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, val);
            return;
        }
        if(capacity == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, val);
    }
}