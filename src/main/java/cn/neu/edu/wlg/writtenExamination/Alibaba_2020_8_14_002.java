package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

/*
    第二题：
        两种操作： 选择数字串中任意长度为2的连续子串Si, Si+1, 将Si的值减一, Si+1值加一, 如23 会变为14; 选择数字串中任意长度为2的连续字串Si, Si+1, 将Si的值+1，si+1值-1, 如14变为23。如果2个串可以通过上述操作相互转换，则成为相似。先给出q次询问，每次询问输入一个数字串，对于每次询问请你计算出有多少个串和si相似，如输入2 90 01，输出 9 1。(数字串最长为10的9次方，结果对1000000007取余)
    思路有误，题目不完善
 */
public class Alibaba_2020_8_14_002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入p
        int p = scanner.nextInt();
        for (int i = 0; i < p; ++i) {
            String strNum = scanner.next();
            System.out.println(Alibaba_2020_8_14_002.getSimilarResult(strNum));
        }
    }
    public static int getSimilarResult(String strNum) {
        int sum = 0;
        for (int i = 1; i < strNum.length(); ++i) {
            sum += Math.min(9 - Character.getNumericValue(strNum.charAt(i - 1)), Character.getNumericValue(strNum.charAt(i)))
                    + Math.min(Character.getNumericValue(strNum.charAt(i - 1)), 9 - (int) Character.getNumericValue(strNum.charAt(i)));
            sum %= 1000000007;
        }
        return sum;
    }
}
