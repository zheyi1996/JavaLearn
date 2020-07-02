package cn.neu.edu.wlg.datastructure.linkedList;

public class TestSingleLinkedList {

    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead('A');
        singleLinkedList.addHead('B');
        singleLinkedList.addHead('C');
        singleLinkedList.display();
        singleLinkedList.delete('B');
        singleLinkedList.display();
        System.out.println(singleLinkedList.find("B"));
    }
}
