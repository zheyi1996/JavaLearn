package cn.neu.edu.wlg.ZJoffer;

/*
    题目：二叉树的下一个结点
    思路：
        1. 如果一个节点有右子树，那么下一个节点就是它右子树中的最左子节点
        2. 如果一个节点没有右子树
            2.1 如果节点是它父节点的左子节点，那么下一个节点就是它的父节点
            2.2 如果节点是它父节点的右子节点，那么就沿着指向父节点的指针一直向上遍历，直到找到一个是它父节点的左子节点的节点，那么这个节点的父节点就是下一个节点。
    知识点：
        1. 访问null的左右子树会报NullPointerException,所以访问一个节点之前，一定要确定其是否为空指针
        2. 有一些判断或循环可能造成没有返回值的情况就会报错
 */
public class Offer057 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (null == pNode) {
            throw new NullPointerException("空指针异常");
        }
        if (null != pNode.right) {
            TreeLinkNode temp = pNode.right;
            while (null != temp.left) {
                temp = temp.left;
            }
            return temp;
        } else {
            if (null != pNode.next && pNode == pNode.next.left) { // 注意判断指针是否为空
                return pNode.next;
            } else {
                TreeLinkNode temp = pNode; // 注意空指针异常问题
                while (null != temp.next) {
                    if (temp == temp.next.left) {
                        return temp.next;
                    }
                    temp = temp.next;
                }
                return null;
            }
        }
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
