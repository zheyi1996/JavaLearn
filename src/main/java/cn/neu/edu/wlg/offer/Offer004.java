package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.TreeNode;

/*
    思路：
        递归，根据先序遍历确定根节点，根据中序遍历确定左右子树
    盲点：
        1. Java 二叉树
            class TreeNode {
                int val;
                TreeNode left;
                TreeNode right;
                TreeNode(int val) {
                    val = val;
                }
            }
 */
public class Offer004 {

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = re(pre, 0, pre.length-1, in, 0 , in.length-1);
        return root;
    }
    public TreeNode re(int [] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; ++i) { // 寻找中序遍历中的根节点，确定左右子树
            if (in[i] == pre[startPre]) {
                root.left = re(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = re(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }
}

