package cn.neu.edu.wlg.offer;

/*
    题目：数值的整数次方
    思路：二分法
    注意点：
        注意exponent可能为负
 */
public class Offer012 {

    public double Power(double base, int exponent) {
        if (0 == base) {
            return 0;
        }
        if (exponent > 0) {
            if (1 == exponent) {
                return base;
            }
            if (0 == exponent % 2) {
                return Power(base, exponent / 2) * Power(base, exponent / 2);
            }
            else {
                return Power(base, exponent / 2) * Power(base, exponent / 2) * base;
            }
        } else if (0 == exponent) {
            return 1;
        } else {
            if (0 == exponent % 2) {
                return 1 / (Power(base, Math.abs(exponent) / 2) * Power(base, Math.abs(exponent) / 2));
            }
            else {
                return 1 / (Power(base, Math.abs(exponent) / 2) * Power(base, Math.abs(exponent) / 2) * base);
            }
        }
    }
}
