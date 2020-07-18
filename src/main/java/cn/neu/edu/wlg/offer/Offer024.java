package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.TreeNode;

import java.util.ArrayList;

/*
    题目：二叉树中和为某一值的路径
    思路：递归 - num记录从根节点到叶子节点的路径和
        1. 如果节点为叶子节点，那么num加该节点的值，弹入该节点，然后判断路径和是否等于给定值
        2. 如果不是叶子节点，则遍历该节点的左右节点
        3. num - 该节点的值， 同时弹出该节点
    知识点：
        allResult.add(new ArrayList<Integer>(oneResult));
 */
public class Offer024 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(12);
        root.left = left1;
        root.right = right1;
        left1.left = new TreeNode(7);
        left1.right = new TreeNode(4);
        Offer024 offer024 = new Offer024();
        ArrayList<ArrayList<Integer>> allresult = offer024.FindPath(root, 22);
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> allResult = new ArrayList<ArrayList<Integer>>();
        if (null == root) {
            return allResult;
        }
        ArrayList<Integer> oneResult = new ArrayList<>();
        getSumPath(root, target, allResult, oneResult, 0);
        return allResult;
    }
    public void getSumPath(TreeNode node, int target, ArrayList<ArrayList<Integer>> allResult, ArrayList<Integer> oneResult, int sum) {
        if (null == node) {
            return;
        }
        sum += node.val;
        oneResult.add(node.val);
        if (null == node.left && null == node.right) {
            if (target == sum) { // 叶子节点要有return
                allResult.add(new ArrayList<Integer>(oneResult)); // 不能使用原来的句柄，而要分配新的内存空间
                oneResult.remove(oneResult.size() - 1);
                return;
            }
        }
        getSumPath(node.left, target, allResult, oneResult, sum);
        getSumPath(node.right, target, allResult, oneResult, sum);
//        sum -= node.val;
        oneResult.remove(oneResult.size() - 1);
    }
}
