package cn.neu.edu.wlg.ZJoffer;

/*
    题目：剪绳子
    思路：
        思路一：动态规划
            1. 无后效性 - f(n) 只需要知道 f(i) 和 f(n-i) 的值，至于f(i)和f(n-i)如何得出不用去管
            2. 最有子结构 - f(n) 可以由 f(n) = max{f(i)*f(n-i)}得出，只需要考虑第一刀切了多长
        思路二：贪心算法
            长度>=5时，能剪3就剪3

        2 -> 1 = 1 * 1
        3 -> 2 = 1 * 2
        4 -> 4 = 2 * 2
        5 -> 6 = 2 * 3
        6 -> 9 = 3 * 3
        7 -> 12 = 4 * 3
        8 -> 16 = 4 * 4 ×
        8 -> 18 = 3 * 3 * 2 √
 */
public class Offer067 {

    public static void main(String[] args) {
        Offer067 offer067 = new Offer067();
        System.out.println(offer067.cutRope2(16));
    }
    // 思路一
    /*
        f(2) = 1
        f(3) = 2
        f(4) = 4
     */
    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        int [] f = new int[target + 1];
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        for (int i = 4; i <= target; ++i) {
            for (int j = 1; j <= i / 2; ++j) {
                f[i] = Math.max(f[i], f[j] * f[i - j]);
            }
        }
        return f[target];
    }
    // 思路二
    public int cutRope2(int target) {
        if (target < 2) {
            return 0;
        }
        if (3 == target) {
            return 2;
        }
        if (4 == target) {
            return 4;
        }
        int timeOf3 = target / 3;
        if (1 == (target - timeOf3 * 3)) {
            timeOf3 -= 1;
        }
        int timeOf2 = (target - timeOf3 * 3) / 2;
        return (int)Math.pow(3, timeOf3) * (int)Math.pow(2, timeOf2);
    }
}
