package cn.neu.edu.wlg.leetcode;

/*
    题目：最长上升子序列
    思路：
        1. 设计状态，设计转移
        2. 假设所有数都不相同
        3. 设计思路：
            f(x)为以Ax结尾的LIS长度，答案为max{f(x)}
            f(x) = max {f(p)} + 1 (p < x, Ap < Ax)
        4. 示例
            [10,9,2,5,3,7,101,18]
            f(0) = 1
            f(1) = 1
            f(2) = 1
            f(3) = 2
            f(4) = 2
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        Integer[] f = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            f[i] = 1;
        }
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            result = Math.max(result, f[i]);
        }
        return result;
    }
}
