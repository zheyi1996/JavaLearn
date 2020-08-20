package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    题目：从上往下打印二叉树
    思路：先遍历二叉树得到二叉树各个结点的深度，然后使用宽度优先搜素遍历二叉树并输出各行
    步骤：
        1. 遍历二叉树得到各结点的深度，记录到一个队列中
        2. 宽度优先遍历二叉树,每到一个结点都将队列中的数弹出并判断二叉树结点的行
    注意点：
        在while循环结束后还需要判断result中是否还存在元素
    知识点：
        1. 宽度优先搜索在将结点加入队列之前，要判断结点是不是null
        2. 队列使用LinkedList来创建,队列插入删除操作的方法为add和remove
        3. ArrayList复制方法 (ArrayList<Integer>) result.clone()，必须要复制之后再添加，否则只是拷贝引用
 */
public class Offer060 {

    public static void main(String[] args) {
        Offer060 offer060 = new Offer060();
        TreeNode root = new TreeNode(8);
        offer060.Print(root);
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (null == pRoot) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(pRoot);
        int i = treeDepth(pRoot); // 节点的深度
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            int deep = treeDepth(temp);
            if (deep == i) {
                result.add(temp.val);
            } else {
                --i;
                ArrayList<Integer> arrayList = (ArrayList<Integer>) result.clone();
                results.add(arrayList);
                result.clear();
                result.add(temp.val);
            }
            if (null != temp.left) {
                queue.add(temp.left);
            }
            if (null != temp.right) {
                queue.add(temp.right);
            }
        }
        if (!result.isEmpty()) {
            ArrayList<Integer> arrayList = (ArrayList<Integer>) result.clone();
            results.add(arrayList);
        }
        return results;
    }
    private int treeDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (left > right ? left : right) + 1;
    }
}
