//package cn.neu.edu.wlg.writtenExamination;
//
//import java.util.Scanner;
//
//public class HuaWei003 {
//
//    static int max = 0;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n + 1];
//        Node root;
//        for(int i = 0; i < n; ++i) {
//            int id = scanner.nextInt();
//            int weight = scanner.nextInt();
//            int left  = scanner.nextInt();
//            int right = scanner.nextInt();
//            if(0 == i) {
//                 root = new Node(id, weight);
//            }
//        }
//        prefixSum(root, 0);
//        traverse(root);
//        return max;
//    }
//
//    static class Node {
//        int id;
//        int weight;
//        Node lchild;
//        Node rchild;
//        Node parent;
//
//        public Node(int id, int weight) {
//            this.id = id;
//            this.weight = weight;
//        }
//    }
//
//    static void prefixSum(Node node, int parent) {
//        if (node == null) return;
//        node.weight ^= parent;
//        prefixSum(node.lchild, node.weight);
//        prefixSum(node.rchild, node.weight);
//    }
//
//    static void traverse(Node node) {
//        if (node == null) return;
//        downSum(node, node.lchild);
//        downSum(node, node.rchild);
//        traverse(node.lchild);
//        traverse(node.rchild);
//    }
//
//    static void downSum(Node start, Node end) {
//        if (end == null) return;
//        max = Math.max(max, start.parent.weight ^ end.weight);
//        downSum(start, end.lchild);
//        downSum(start, end.rchild);
//    }
//}