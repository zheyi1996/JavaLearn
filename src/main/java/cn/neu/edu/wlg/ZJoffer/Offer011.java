package cn.neu.edu.wlg.ZJoffer;

/*
    题目：二进制中1的个数
    思路：
        思路一：使用Java方法
        思路二：
    知识点：
        1. Integer.toBinaryString(n) 将十进制整数转换为二进制字符串
        2. String.toCharArray() 将字符串转换为字符数组
 */
public class Offer011 {

    public int NumberOf1(int n) {
        int t = 0;
        char[] ch = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < ch.length; ++i) {
            if (ch[i] == '1') {
                ++t;
            }
        }
        return t;
    }
}
