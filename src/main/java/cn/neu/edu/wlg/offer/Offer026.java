package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.TreeNode;

/*
    题目：二叉搜索树与双向链表
    思路：中根遍历
        思路一：先将左子树和右子树连起来，再将根节点连起来，可以递归
 */
public class Offer026 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (null == pRootOfTree) {
            return null;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode right = Convert(pRootOfTree.right);
        return  null;
    }
}
