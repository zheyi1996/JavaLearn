//package cn.neu.edu.wlg.offer;
//
//import cn.neu.edu.wlg.offer.util.TreeNode;
//
///*
//        题目：序列化二叉树
//        思路：
//            思路一：先序遍历
//                序列化二叉树：
//                    1. 先序遍历二叉树，非空结点，则添加到str中，同时在数字后插入","，然后递归遍历其左右子树
//                    2. 如果此节点的左子树或右子数为空，则将#添加到str中
//                反序列化二叉树：先序遍历，此节点后面第一个结点是其左节点 ？？？
//           思路二：层序遍历
// */
//public class Offer061 {
//
//    StringBuffer str = new StringBuffer("");
//    String Serialize(TreeNode root) {
//        if (null == root) {
//            return "#";
//        }
//        getSerialize(root);
//        return str.toString();
//    }
//    TreeNode Deserialize(String str) {
//
//    }
//    private void getSerialize(TreeNode root) {
//        str.append(new StringBuffer(String.valueOf(root.val)));
//        if (null == root.left) {
//            str.append("#");
//        } else {
//            getSerialize(root.left);
//        }
//        if (null == root.right) {
//            str.append("#");
//        } else {
//            Serialize(root.right);
//        }
//    }
//}
