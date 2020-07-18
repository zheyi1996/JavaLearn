package cn.neu.edu.wlg.offer;

/*
    题目：机器人的运动范围
    思路：
        走一遍

 */
public class Offer066 {

    public int movingCount(int threshold, int rows, int cols) {
        int [][] flag = new int[rows][cols];
        return getMovingCount(0, 0, rows, cols, flag, threshold);
    }
    public int getMovingCount(int i, int j, int rows, int cols, int [][] flag, int threshold) {
        if(i < 0 || i >= rows || j < 0 || j >= rows || numSum(i) + numSum(j) > threshold || 1 == flag[i][j]) {
            return 0;
        }
        flag[i][j] = 1;
        return getMovingCount(i - 1, j, rows, cols, flag, threshold)
                + getMovingCount(i + 1, j, rows, cols, flag, threshold)
                + getMovingCount(i, j -1, rows, cols, flag, threshold)
                + getMovingCount(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }
    public int numSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
