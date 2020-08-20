package cn.neu.edu.wlg.ZJoffer;

/*
    题目：矩阵覆盖
    思路：
        2 * 3   3
        2 * 4
        2 * 5
 */
public class Offer010 {

    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        }
        if (target <= 2) {
            return target;
        }
        int [] arr = new int[target + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= target; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[target];
    }
}
