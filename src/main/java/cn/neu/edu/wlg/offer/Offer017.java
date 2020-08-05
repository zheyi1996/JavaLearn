package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.TreeNode;

/*
    题目：树的子结构
    思路：
        1. 在A中找到等于B的根节点的值
        2. 判断以此为节点的子树是不是有和B相同的子树
 */
public class Offer017 {

    private boolean flag = false;
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (null == root1 || null == root2) {
            return false;
        }
        if (root1.val == root2.val) {
            // 判断是否为子树
            flag = isSubTree(root1, root2);
        }
        if (!flag && null != root1.left) {
            HasSubtree(root1.left, root2);
        }
        if (!flag && null != root1.right) {
            HasSubtree(root1.right, root2);
        }
        return flag;
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
