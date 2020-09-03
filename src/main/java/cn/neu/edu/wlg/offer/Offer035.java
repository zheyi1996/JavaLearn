package cn.neu.edu.wlg.offer;

/*
    题目：数组中的逆序对
    思路：
        思路一：最朴素的暴力求解法 -- 时间上不能通过
        思路二：在暴力基础上剪枝
        3 2 1 -> 3
 */
public class Offer035 {

    public int InversePairs(int [] array) {
        if (null == array || 0 == array.length) {
            return 0;
        }
        int p = 0;
        for (int i = 0; i < array.length; ++i) {
            for (int j = i; j < array.length; ++j) {
                if (array[i] > array[j]) {
                    ++p;
                    p = p % 1000000007;
                }
            }
        }
        return p;
    }
}
