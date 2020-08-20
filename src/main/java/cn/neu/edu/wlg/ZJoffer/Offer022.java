package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    题目：从上往下打印二叉树
    思路：
        宽度优先搜索
        使用队列存放节点，打印节点，然后将其左右子节点存入队列
    知识点：
        LinkedList实现了Queue
 */
public class Offer022 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(12);
//        root.left = left1;
//        root.right = right1;
//        left1.left = new TreeNode(7);
//        left1.right = new TreeNode(4);
        Offer022 offer022 = new Offer022();
        ArrayList<Integer> allresult = offer022.PrintFromTopToBottom(root);
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (null == root) {
            return arrayList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            arrayList.add(treeNode.val);
            if (null != treeNode.left) {
                queue.add(treeNode.left);
            }
            if (null != treeNode.right) {
                queue.add(treeNode.right);
            }
        }
        return arrayList;
    }
}
