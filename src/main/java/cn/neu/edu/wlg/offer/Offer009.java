package cn.neu.edu.wlg.offer;

/*
    题目：变态青蛙跳台阶
    思路：斐波那契数列
        f(n) = f(n-1) + f(n-2) + ... + f(0)
        f(n-1) = f(n-2) + ... + f(0)
        f(n) = 2 * f(n - 1)
 */
public class Offer009 {

    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return 2 * JumpFloor(target - 1);
        }
    }
}
