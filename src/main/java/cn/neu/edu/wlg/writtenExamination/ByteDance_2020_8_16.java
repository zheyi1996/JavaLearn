package cn.neu.edu.wlg.writtenExamination;

/*
    思路：
        1. 根据先序遍历确定根节点，然后根据中序遍历查找根节点的值确定左右子树
        2. 递归左右子树
        3. 使用 leafNums 记录叶子节点数, 如果在中序遍历中，左右为1的为叶子节点
 */
public class ByteDance_2020_8_16 {

    public static void main(String[] args) {
        ByteDance_2020_8_16 byteDance_2020_8_16 = new ByteDance_2020_8_16();
//        int [] arr1 = {1, 2, 3};
//        int [] arr2 = {2, 1, 3};

//        int [] arr1 = {1, 2, 3, 4};
//        int [] arr2 = {2, 1, 4, 3};

        int [] arr1 = {1, 2};
        int [] arr2 = {2, 1};
        System.out.println(byteDance_2020_8_16.getResult(3, arr1, arr2));
    }
    int leafNums = 0;
    public int getResult(int n, int [] inorderArr, int [] postorderArr) {
        getLeafNums(n, inorderArr, 0, inorderArr.length - 1,postorderArr, 0, postorderArr.length - 1);
        return leafNums;
    }
    public void getLeafNums(int n, int [] inorderArr, int inorderLeft, int inorderRight, int [] postorderArr, int postorderLeft, int postorderRight) {
        if (inorderLeft == inorderRight) {
            ++leafNums;
        }
        int rootValue = inorderArr[inorderLeft]; // 根节点的值
        int rootInPost = -1; // 根节点在中序遍历中的位置
        for (int i = postorderLeft; i <= postorderRight; ++i) {
            if (rootValue == postorderArr[i]) {
                rootInPost = i;
            }
        }
        int leftNums = rootInPost - postorderLeft;
        int rightNums = postorderRight - rootInPost;
        if (leftNums > 0) {
            getLeafNums(n, inorderArr, inorderLeft + 1, inorderLeft + leftNums, postorderArr, postorderLeft, rootInPost - 1);
        }
        if (rightNums > 0) {
            getLeafNums(n, inorderArr, inorderLeft + leftNums + 1, inorderLeft + leftNums + rightNums, postorderArr, rootInPost + 1, postorderRight);
        }
    }
}
