package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.TreeNode;

/*
    题目：二叉树的深度
    思路：递归
        1. 先判断节点是否为null，为null则返回0
        2. 左子树的深度，右子树的深度的最大值 + 1

 */
public class Offer038 {

    public int TreeDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return (left > right ? left : right) + 1;
    }
}
