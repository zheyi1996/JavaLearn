package cn.neu.edu.wlg.ZJoffer;


/*
    题目：从1加到n
    思路：使用 pow() 和 二进制右移
 */
public class Offer047 {

    public int Sum_Solution(int n) {
        int sum = (int)(Math.pow(n, 2) + n);
        return sum >> 1;
//        return (1 + n) * n / 2;
    }
}
