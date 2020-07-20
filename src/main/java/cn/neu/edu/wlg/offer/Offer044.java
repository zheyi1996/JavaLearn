package cn.neu.edu.wlg.offer;

import java.util.Stack;

/*
    题目：翻转单词顺序
    思路：
        思路一：先翻转所有字符的顺序，再翻转每个单词中字符的顺序
        思路二：用栈存放每个单词
    知识点：
        1. String不可变，可变字符串用StringBuilder和StringBUffer
        2. 字符串遍历用String.charAt(i)
        3. StringBuffer清空用StringBuffer.setLength(0)
 */
public class Offer044 {

    public static void main(String[] args) {
        Offer044 offer044 = new Offer044();
        System.out.println(offer044.ReverseSentence2("student. a am I"));
    }
    // 思路一
    public String ReverseSentence(String str) {
        if (null == str || 0 == str.length()) {
            return "";
        }
        String reverseStr = new StringBuffer(str).reverse().toString(); // 翻转所有字符
        StringBuffer resultString = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        // 翻转每个单词
        for (int i = 0; i < str.length(); ++i) {
            char ch = reverseStr.charAt(i);
            if(i == (str.length() - 1)) {
                temp.append(ch);
                resultString.append(temp.reverse().toString());
                continue;
            }
            if (' ' == ch) {
                resultString.append(temp.reverse().toString());
                resultString.append(' ');
                temp.setLength(0); // 清空StringBuffer
                continue;
            }
            temp.append(ch);
        }
        return resultString.toString();
    }

    // 思路二
    public String ReverseSentence2(String str) {
        if (null == str || 0 == str.length()) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        StringBuffer resultString = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if(i == (str.length() - 1)) {
                temp.append(ch);
                stack.push(temp.toString());
                continue;
            }
            if (' ' == ch) {
                stack.push(temp.toString());
                temp.setLength(0); // 清空StringBuffer
                continue;
            }
            temp.append(ch);
        }
        while (!stack.isEmpty()) {
            resultString.append(stack.pop());
            resultString.append(' ');
        }
        resultString.deleteCharAt(str.length());
        return resultString.toString();
    }
}
