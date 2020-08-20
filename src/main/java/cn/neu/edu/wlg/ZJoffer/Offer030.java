package cn.neu.edu.wlg.ZJoffer;

/*
    题目：连续子数组的最大和
    思路：动态规划
        包含Ax节点的最大和f(Ax) = max(f(Ax-1) + Ax, Ax)
 */
public class Offer030 {

    public int FindGreatestSumOfSubArray(int[] array) {
        Integer [] f = new Integer[array.length];
        f[0] = array[0];
        int result = f[0];
        for (int i =1; i < array.length; ++i) {
            f[i] = Math.max(array[i] + f[i - 1], array[i]);
            result = result > f[i] ? result : f[i];
        }
        return result;
    }
}
