package cn.neu.edu.wlg.NC;

import cn.neu.edu.wlg.ZJoffer.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/*
    题目：二叉树的层序遍历
    思路：
        1. 使用队列进行层序遍历
        2. 记录每层需要取出的节点数量 -- 每轮入队数量
 */
public class NC015 {
    public static int floor = 0;
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        if(null == root) {
            return arr;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        queue.offer(root);
        int nums; // 记录每层需要取出的节点数量
        while(!queue.isEmpty()) {
            nums = queue.size();
            for(int i = 1 ; i <= nums; ++i) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(null != node.left) {
                    queue.add(node.left);
                }
                if(null != node.right) {
                    queue.add(node.right);
                }
            }
            arr.add((ArrayList<Integer>) temp.clone());
            temp.clear();
        }
        return arr;
    }
}
