package cn.neu.edu.wlg.leetcode;

import cn.neu.edu.wlg.offer.util.TreeNode;

/*
    题目：从前序和中序遍历序列构造二叉树
    思路：
        1. 根据先序遍历确定根节点，然后根据中序遍历查找根节点的值确定左右子树
        2. 递归左右子树
 */
public class LeetCode105 {

    public static void main(String[] args) {
        LeetCode105 leetCode105 = new LeetCode105();
        int [] preorder = {1, 2, 3};
        int [] inorder = {2, 1, 3};
        System.out.println(leetCode105.buildTree(preorder, inorder));
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createBinaryTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode createBinaryTree(int[] preorder, int rootIndex, int[] inorder, int inorderLeft, int inorderRight) {
        if (inorderLeft > inorderRight) {
            return null;
        }
        int rootValue = preorder[rootIndex]; // 根节点的值
        TreeNode root = new TreeNode(rootValue);
        int rootInorder = -1; // 根节点在中序遍历中的位置
        for (int i = inorderLeft; i <= inorderRight; ++i) {
            if (rootValue == inorder[i]) {
                rootInorder = i;
                break;
            }
        }
        root.left = createBinaryTree(preorder, rootIndex + 1, inorder, inorderLeft, rootInorder - 1);
        root.right = createBinaryTree(preorder, rootIndex + rootInorder - inorderLeft + 1, inorder, rootInorder + 1, inorderRight);
        return root;
    }
}