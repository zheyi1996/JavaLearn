//package cn.neu.edu.wlg.test;
//
//import java.util.Arrays;
//
//public class Add {
//    public static void main(String[] args) {
//        if (null == pHead1 || null == pHead2) {
//            return null;
//        }
//        int leng1 = 0;
//        int leng2 = 0;
//        Node temp1 = pHead1;
//        Node temp2 = pHead2;
//        while (null != temp1) {
//            ++leng1;
//            temp1 = temp1.next;
//        }
//        while (null != temp2) {
//            ++leng2;
//            temp2 = temp2.next;
//        }
//        int leng = Math.abs(leng1 - leng2);
//        Node longerHead = leng1 >= leng2 ? pHead1 : pHead2;
//        Node shorterHead = leng1 < leng2 ? pHead1 : pHead2;
//        for (int i = 0; i < leng; ++i) {
//            longerHead = longerHead.next;
//        }
//        while (longerHead != shorterHead) {
//            longerHead = longerHead.next;
//            shorterHead = shorterHead.next;
//        }
//        return shorterHead;
//    }
//}