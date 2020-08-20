package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.TreeNode;

/*
    题目：对称的二叉树
    思路：左子树的左节点 == 右边子树右节点
            8
        3       3
    3      4 4      3
    知识点：
        1. null判断
        2. 是整数还是字符型
        3. 递归返回值最开始的有效
 */
public class Offer058 {

    boolean isSymmetrical(TreeNode pRoot) {
        if (null == pRoot) {
            return true;
        }
        return judgeSymmetrical(pRoot.left, pRoot.right);
    }
    private boolean judgeSymmetrical(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if(isOneNull(left, right)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return judgeSymmetrical(left.left, right.right) && judgeSymmetrical(left.right, right.left);
    }
    private boolean isOneNull (TreeNode left, TreeNode right) {
        if ((null == left && null != right) || (null != left && null == right)) {
            return true;
        }
        return false;
    }
}
