package cn.neu.edu.wlg.ZJoffer;

/*
    题目：青蛙跳台阶
    思路：斐波那契数列
        1. 写几个例子，然后猜测可能是斐波那契数列
            1 1
            2 2
            3 3
            4 5
        2. 逆向思维(思维) - 从第n层向下怎么跳
            f(n) = f(n-1) + f(n-2)
 */
public class Offer008 {

    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }
}
