package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.TreeNode;

/*
    题目：树的子结构
    思路：
        1. 在A中找到等于B的根节点的值
        2. 判断以此为节点的子树是不是有和B相同的子树!
    注意点：
        1. 在递归返回中要善用||和&&
            使用||只要递归中返回true那么结果就是true，
            使用&&只要递归中返回一个false那么就是false
        2. 在二叉树的左右子树判断中，要把左右子树分开来看
 */
public class Offer017 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (null == root1 || null == root2) {
            return false;
        }
        if (root1.val == root2.val) {
            // 判断是否为子树
            if(isSubTree(root1, root2)) {
                return true;
            }
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    // 判断root2是否为subRoot1的一部分
    private boolean isSubTree(TreeNode subRoot1, TreeNode root2) {
        if (null == root2) {
            return true;
        }
        if (null == subRoot1) {
            return false;
        }
        if (subRoot1.val != root2.val) {
            return false;
        }
        return isSubTree(subRoot1.left, root2.left) && isSubTree(subRoot1.right, root2.right);
    }
}
