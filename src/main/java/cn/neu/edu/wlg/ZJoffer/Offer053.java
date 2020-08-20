package cn.neu.edu.wlg.ZJoffer;

/*
    题目：表示数值的字符串
    思路：正则表达式
        e5成立？
        首先判断所有字符是不是合格，+ - 0-9 . e E
        分类讨论：
            1. 首先必须有数字，数字前可能有正负号，数字后可能有.
            2. 可能出现e,E，如果有那么后面的数必须为整数

 */
public class Offer053 {

    public static void main(String[] args) {
        Offer053 offer053 = new Offer053();
        char [] str = {'e','1'};
        System.out.println(offer053.isNumeric(str));
    }
    public boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        // ？ 零次或一次匹配前面的字符或子表达式
        // * 零次或多次匹配前面的字符或子表达式。
        // + 一次或多次匹配前面的字符或子表达式。
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }
}
