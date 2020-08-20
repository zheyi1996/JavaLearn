package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.TreeNode;

import java.util.ArrayList;

/*
    题目：二叉搜索树与双向链表
    思路：中根遍历
        思路一：使用ArrayList存放中根遍历的结果

        中序遍历二叉树，创建ArrayList记录中序遍历的结果，然后逐个取出，left和right分别做前后指向的指针
 */
public class Offer026 {

    ArrayList<TreeNode> arrayList = new ArrayList<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (null == pRootOfTree) {
            return null;
        }
        inorderTraversal(pRootOfTree);
        TreeNode head = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); ++i) {
            TreeNode ahead = arrayList.get(i - 1);
            TreeNode behind = arrayList.get(i);
            ahead.right = behind;
            behind.left = ahead;
        }
        return  head;
    }
    private void inorderTraversal(TreeNode pRoot) {
        if (null == pRoot) {
            return;
        }
        inorderTraversal(pRoot.left);
        arrayList.add(pRoot);
        inorderTraversal(pRoot.right);
    }
}
