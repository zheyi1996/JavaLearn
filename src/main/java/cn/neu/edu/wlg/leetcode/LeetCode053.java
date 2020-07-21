package cn.neu.edu.wlg.leetcode;

/*
    题目：最大子序和
    思路：
        1. 设计状态，设计转移
        2. 假设所有数都不相同
        3. 设计思路：(重点是以Ax结尾)
            f(x)为以Ax结尾的最大和子序列，答案为max{f(x)}
            f(x) = max {f(x-1) + Ax, Ax}
        4. 示例
            [-2,1,-3,4,-1,2,1,-5,4] 中 [4,-1,2,1] 的和最大，为6
            f(0) = -2 = f(0)
            f(1) = 1 = max(f(0) + A1, A1)
            f(2) = -2 = max(f(1) A2 + A2)

 */
public class LeetCode053 {

    public int maxSubArray(int[] nums) {
//        if (null == nums || 0 == nums.length) {
//            return 0;
//        }
        Integer [] f = new Integer[nums.length];
        f[0] = nums[0];
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            maxNum = f[i] > maxNum ? f[i] : maxNum;
        }
        return maxNum;
    }
}
