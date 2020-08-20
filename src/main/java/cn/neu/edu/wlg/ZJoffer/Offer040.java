package cn.neu.edu.wlg.ZJoffer;

/*
    题目：数组中只出现一次的数字
    思路：
        异或运算 - 任何一个数字异或自身都等于0，任何一个数字异或0都等于自身
        找到结果中第一个为1的一位，在这一位将数组划分为两个子数组
 */
public class Offer040 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (null == array || array.length < 2) {
            return;
        }
        int xorResult = array[0];
        // 异或运算
        for (int i = 1; i < array.length; ++i) {
            xorResult ^= array[i];
        }
        if (0 == xorResult) {
            return;
        }
        int temp = 1;
        // 找到结果中第一个为1的一位，在这一位将数组划分为两个子数组
        while (0 != xorResult) {
            if (1 == (xorResult & 1)) {
                break;
            }
            temp = temp << 1;
            xorResult = xorResult >> 1;
        }
        for (int arr : array) {
            if (0 == (arr & temp)) {
                num1[0] ^= arr;
            } else {
                num2[0] ^= arr;
            }
        }
    }
}
