package cn.neu.edu.wlg.offer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
Offer004:替换空格
思路:
    明确需求:
        1. 在原来的字符串上做替换 -- 要保证输入的字符串后面有足够多的空余内存
            1. 先计算空格数目
            2. 计算替换后的字符串长度
            3. 从后向前遍历，遇到空格用“%20”替换 -- 防止数据覆盖
        2. 创建新的字符串并在新的字符串上做替换
            1. 先计算空格数目
            2. 计算新的字符串长度，并构建新字符数组
            3. 逐个遍历和copy, 遇到空格用户“%20”替换
盲点：
    1. StringBuffer
    2. charAt(i)
 */
public class Offer002 {

    // 需求1
    @ParameterizedTest
    @ValueSource(strings = "w l g")
    public String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0) {
            return str.toString();
        }
        int newLength = newLength(str);
        char[] newChar = new char[newLength];
        int idx = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                newChar[idx++] = '%';
                newChar[idx++] = '2';
                newChar[idx++] = '0';
            } else {
                newChar[idx++] = str.charAt(i);
            }
        }
        System.out.println(new String(newChar));
        return new String(newChar);
    }

    // 需求2
    @ParameterizedTest
    @ValueSource(strings = "w l g")
    public String replaceSpace1(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return str.toString();
        }
        int oldLength = str.length();
        int newLength = newLength(str);
        str.setLength(newLength); // 设置新的字符串长度
        for (int i = oldLength - 1; i >= 0; --i) {
            if(str.charAt(i) == ' ') {
                str.setCharAt(--newLength, '0');
                str.setCharAt(--newLength, '2');
                str.setCharAt(--newLength, '%');
            } else {
                str.setCharAt(--newLength, str.charAt(i));
            }
        }
        System.out.println(str);
        return str.toString();
    }

    private int newLength(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                ++spaceNum;
            }
        }
        return str.length() + spaceNum * 2;
    }
}
