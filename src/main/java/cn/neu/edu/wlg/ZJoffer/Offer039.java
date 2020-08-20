package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.TreeNode;

/*
    题目：平衡二叉树
    思路一：求树的每个左右子树的深度，确定其差是否超过1
    思路二：后序遍历
 */
public class Offer039 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (null == root) {
            return true;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    private int TreeDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return (left > right ? left : right) + 1;
    }

    // 思路二
    public boolean IsBalanced_Solution2(TreeNode root) {
        boolean [] result = new boolean[] {true};
        isBalanced(root, result);
        return result[0];
    }
    private int isBalanced(TreeNode root, boolean [] result) {
        if (!result[0] || null == root) {
            return 0;
        }
        int left = isBalanced(root.left, result);
        int right = isBalanced(root.right, result);
        if (Math.abs(left - right) > 1) {
           result[0] = false;
        }
        return (left > right ? left : right) + 1;
    }
}
