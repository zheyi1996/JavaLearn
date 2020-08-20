package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.TreeNode;

/*
    题目：二叉树的镜像
    思路：遍历二叉树，交换二叉树的左右子树
 */
public class Offer018 {

    public void Mirror(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
