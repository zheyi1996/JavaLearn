package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.TreeNode;

import java.util.ArrayList;

/*
        题目：序列化二叉树
        思路：
            思路一：先序遍历
                序列化二叉树：
                    1. 先序遍历二叉树，非空结点，则添加到str中，同时在数字后插入","，然后递归遍历其左右子树
                    2. 如果此节点的左子树或右子数为空，则将#添加到str中
                反序列化二叉树：先序遍历，此节点后面第一个结点是其左节点 ？？？
           思路二：层序遍历
        知识点：
            1. 什么情况下用LinkedList而不用ArrayList？
                数据插入删除操作比较多，但是不会随机访问数据
            2. String.substring(start,end) 截取子字符串
 */
public class Offer061 {

    String Serialize(TreeNode root) {
        if (null == root) {
            return "{}";
        }
        /*
            利用for循环将树中结点全部添加到队列中,其中队列使用for循环ArrayList实现
         */
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); ++i) {
            // 用动态数组的get得到对应下标下的对象来实现queue的表示
            TreeNode node = queue.get(i);
            // 空结点跳过不执行叶子节点添加的操作
            if (null == node) {
                continue;
            }
            // 无需理会当前叶子节点是不是空
            queue.add(node.left);
            queue.add(node.right);
        }
        // 去掉队列结尾的空节点
        while (null == queue.get(queue.size() - 1)) {
            queue.remove(queue.size() - 1);
        }
        // 进行二叉树的序列化
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); ++i) {
            if (null == queue.get(i)) {
                stringBuffer.append(",#");
            } else {
                stringBuffer.append(",");
                stringBuffer.append(queue.get(i).val);
            }
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
    TreeNode Deserialize(String str) {
        // 字符用equals，数值用==
        if (str.equals("{}")) {
            return null;
        }
        // substring(s, e) s,start - include; e,end - exclude
        String[] vals = str.substring(1, str.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        boolean isLeftChild = true;
        int index = 0;
        for (int i = 1; i < vals.length; ++i) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) { // 一个节点的左右孩子都进入到队列之后才开始访问下一个节点
                ++index;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}
