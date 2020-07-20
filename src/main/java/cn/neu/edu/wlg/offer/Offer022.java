//package cn.neu.edu.wlg.offer;
//
//import cn.neu.edu.wlg.offer.util.TreeNode;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//
///*
//    题目：从上往下打印二叉树
//    思路：
//        宽度优先搜索
//        使用队列存放节点，打印节点，然后将其左右子节点存入队列
//    知识点：
//        LinkedList实现了Queue
// */
//public class Offer022 {
//
//    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        if (null == root) {
//            return arrayList;
//        }
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        TreeNode head = root;
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode treeNode = queue.
////            arrayList.add(head.val);
//            queue.add(head.left);
//            queue.add(head.right);
//        }
//    }
//}
