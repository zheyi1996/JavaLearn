package cn.neu.edu.wlg.match;

/*
    题目：牛牛的质数
    链接：https://ac.nowcoder.com/acm/contest/6914/B
    牛牛有一个质数p，和两个区间\left [ a,b \right ][a,b]，\left [ c,d \right ][c,d]，分别在两个区间中取一个数x，y。求有多少对\left ( x,y\right )(x,y)使得x \ast yx∗y是p的倍数。给定你两个区间，求从区间中取出数相乘是p的倍数的个数。
 */
public class niuke002_2020_8_15 {

    public static void main(String[] args) {
//        System.out.println(NiuNiu2.numbers(3,7,4,6,3));
        System.out.println(niuke002_2020_8_15.numbers(3,3,3,3,3));
    }
    /**
     * 返回两个区间内各取一个值相乘是p的倍数的个数
     * @param a int整型 第一个区间的左边界
     * @param b int整型 第一个区间的右边界
     * @param c int整型 第二个区间的左边界
     * @param d int整型 第二个区间的右边界
     * @param p int整型 质数
     * @return long长整型
     */
    public static long numbers (int a, int b, int c, int d, int p) {
        long count1 = 0;
        long count2 = 0;
        long result = 0;
        count1 += b / p - (a - 1) / p; // [0, n]中有几个数是p的倍数 -- n / p 个
        count2 += d / p - (c - 1) / p;
        result = count1 * (d - c + 1) + count2 * (b - a + 1);
        return result - count1 * count2;
    }
}
