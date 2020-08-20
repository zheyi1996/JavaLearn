package cn.neu.edu.wlg.ZJoffer;

/*
    题目：构建数组
    思路：
        思路一：总乘积除以A[i] -- 不能除0 ×
            B[0] = A[1]*A[2]*...A[n-1]
            B[1] = A[0]* A[2]*A[3]*...*A[n-1] -- 少乘以A[1]
            B[2] = A[0]*A[1]* A[3]*...*A[n-1] -- 少乘以A[2]
            B[3] = A[0]*A[1]*A[2]* A[4]...*A[n-1] -- 少乘以A[3]
            ...
            B[n-1] = A[0]*A[1]*...*A[n-2]
        思路二：两层for循环
        思路三：思路一，二结合，只有当0 == A[i]的时候才使用两层for循环
    算法步骤：
        1. 算出A数组的总乘积
        2. 求B数组
 */
public class Offer051 {

    public int[] multiply(int[] A) {
        if (null == A || 0 == A.length) {
            return null;
        }
        int [] B = new int[A.length];
        int mulNums = A[0];
        B[0] = 1;
        for (int i = 1; i < A.length; ++i) {
            mulNums *= A[i];
            B[i] = 1;
        }
        for (int i = 0; i < A.length; ++i) {
            if (0 != A[i]) { // 不能除0
                B[i] = mulNums / A[i];
            } else {
                for (int j = 0; j < A.length; ++j) {
                    if (j != i) {
                        B[i] *= A[j];
                    }
                }
            }
        }
        return B;
    }
}
