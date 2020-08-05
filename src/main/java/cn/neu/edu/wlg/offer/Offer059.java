package cn.neu.edu.wlg.offer;

import cn.neu.edu.wlg.offer.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Offer059 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (null == pRoot) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(pRoot);
        int i = treeDepth(pRoot); // 表明第几层
        int oddEven = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            int deep = treeDepth(temp);
            if (deep == i) {
                result.add(temp.val);
            } else {
                --i;
                ArrayList<Integer> arrayList  = (ArrayList<Integer>) result.clone();
                if (0 == oddEven) {
                    oddEven = 1;
//                    arrayList = (ArrayList<Integer>) result.clone();
                } else {
                    Collections.reverse(arrayList);
                    oddEven = 0;
                }
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
            if (1 == oddEven) {
                Collections.reverse(arrayList);
            }
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
