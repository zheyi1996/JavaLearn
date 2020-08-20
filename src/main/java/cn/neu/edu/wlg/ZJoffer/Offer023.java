package cn.neu.edu.wlg.ZJoffer;

/*
    题目：二叉搜索树得到后续遍历序列
    思路：根据二叉搜索树的特点
        思路一：递归
            1. 后续遍历的最后一个数是二叉搜索树的根结点，也就是数组中的最后一个索引
            2. 在数组中最后一个索引之前分成两部分，一部分都小于它，另一部分都大于它，
            3. 如果发现某个大于它的数组索引后面还有小于它的数，则不是二叉搜索树
            1 2 3 4 5 7 8 9 6
    步骤：
        1. 最后一个结点，然后分成左右两部分
        2. 递归
    知识点：
        1. 二叉搜索树：
            若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
            若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
 */
public class Offer023 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (null == sequence || 0 == sequence.length) {
            return false;
        }
        boolean flag = isBST(sequence, 0, sequence.length - 1);
        return flag;
    }
    private boolean isBST(int [] sequence, int start, int end) {
        int rootValue = sequence[end];
        int leftRoot = start; // 左子树的根节点
        boolean findRight = false; // 发现右子树的值
        for (int i = start; i < end; ++i) {
            if (sequence[i] < rootValue) {
                if (true == findRight){ // 发现了右子树中有小于根的值
                    return false;
                } else {
                    leftRoot = i;
                }
            } else {
                findRight = true;
            }
        }
        boolean leftFlag = true;
        boolean rightFlag = true;
        boolean flag = true;
        if (start < leftRoot) {
            leftFlag = isBST(sequence, start, leftRoot); // 左子树
        }
        if (leftRoot + 1 < end - 1) {
            rightFlag = isBST(sequence, leftRoot + 1, end - 1); // 右子树
        }
        if (false == leftFlag || false == rightFlag) {
            flag = false;
        }
        return flag;
    }
}
