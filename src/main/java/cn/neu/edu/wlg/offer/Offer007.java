package cn.neu.edu.wlg.offer;

import org.junit.Test;
import org.junit.jupiter.params.provider.ValueSource;

/*
    题目：输出斐波那契第n项
    思路：递归或循环
    知识点：
        1. 递归比循环更简洁，也更加容易理解
        2. 递归时间空间都比循环差，可以引起调用栈溢出的错误
        3. 贵的本质是把一个大问题分解为多个具有相同结构的小问题
 */
public class Offer007 {

    // 递归
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
    // 循环
    public int Fibonacci1(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int fibPreOne = 1;
            int fibPreTwo = 0;
            int fibN = 0;
            for (int i = 2; i <= n; ++i) {
                fibN = fibPreOne + fibPreTwo;
                fibPreTwo = fibPreOne;
                fibPreOne = fibN;
            }
            return fibN;
        }
    }
}
