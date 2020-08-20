package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.TreeNode;

/*
    题目：二叉搜索树的第k小节点
    思路：
        中序遍历二叉树，遍历到第k个节点返回值
    步骤：
        1. 设置全局变量 count = 0
        2. 创建递归函数getKthNode(TreeNode pRoot, int k)
            2.1 如果节点为null,则return；
            2.2 遍历改节点的左子树
            2.3 count加1，判断count是否等于k，如果等于k，则找到倒数第k小的节点，使用全局变量root记录之
    注意：
        1. 边界条件，pRoot不能为null,k 不能小于等于0
    知识点1：
        理解递归二叉树：
            想象面前有一颗树，你要数清楚这棵树有多少个节点（分叉点+叶子），有三种数法：
                数法1：数一个节点，就记一次，叫前序遍历，有一个根节点，记录下来（输出），然后变成数左边的树和右边的树，
                数法2：先把左边的数完，再数根，再数右边，这叫中序遍历，先数到最左边的叶子节点，再数最左边叶子节点的父节点，再数该父节点的右边最左边的叶子
                数法3：先数叶子，再数根，这叫后序遍历，第一个数的是最左边的叶子节点，然后数该节点父节点右边最左边的节点，数完了右边所有节点，再数该父节点
            递归的思想就是解决相似问题经常用到的：树就是具有相似性的特点，树本身是一棵树，树的左边和右边也分别是一棵树，所有就可以用递归思想来解决。
 */
public class Offer062 {

    int count = 0;
    TreeNode root = null;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (null == pRoot || k <= 0) {
            return null;
        }
        getKthNode(pRoot, k);
        return root;
    }
    private void getKthNode(TreeNode pRoot, int k) {
        if (null == pRoot) {
            return;
        }
        getKthNode(pRoot.left, k);
        ++count;
        if (count == k) {
            root = pRoot;
        }
        getKthNode(pRoot.right, k);
    }
}
