package cn.neu.edu.wlg.offer;

/*
    题目：不用加减乘除做加法
    思路：
        十进制相加： 5 + 17 = 22
            1. 各位相加不进位 5 + 7 = 2 ; 0 + 1 = 1 -> 12
            2. 进位 5 + 7 进一位 -> 10
            3. 把前面的结果加起来 12 + 10 = 22
        二进制相加：101 + 10001 == 11010; 111 + 111 = 1110
            1. 各位相加不进位 异或运算 11000; 000
            2. 进位 与运算,相与为1的表示有进位 10; 111
            3. 把前面的结果加起来 11010; 1110
    算法步骤：
        1. 将两个数进行异或运算
        2. 将两个数相与，将结果左移
        3. 1 2结果求和，然后重复
 */
public class Offer048 {
    public static void main(String[] args) {
        Offer048 offer048 = new Offer048();
        System.out.println(offer048.Add(5, 17));
    }
    public int Add(int num1,int num2) {
        int sum;
        int carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (0 != num2);
        return num1;
    }
}
