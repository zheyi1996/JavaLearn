package cn.neu.edu.wlg.ZJoffer;

/*
    题目：左旋字符串
    思路：
        思路一：先分别翻转两部分的字符顺序，再整体翻转两部分的字符顺序
            abcXYZdef 3
            cbafedZYX
            XYZdefabc
        思路二：交换顺序
    知识点：stringBuffer2.deleteCharAt(0);
 */
public class Offer043 {

    public static void main(String[] args) {
        Offer043 offer043 = new Offer043();
        System.out.println(offer043.LeftRotateString("abcXYZdef", 3));
    }
    public String LeftRotateString(String str,int n) {
        if (null == str || 0 == str.length()) {
            return "";
        }
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str);
        for (int i =0; i < n; ++i) {
            stringBuffer1.append(str.charAt(i));
            stringBuffer2.deleteCharAt(0);
        }
        return stringBuffer2.toString() + stringBuffer1.toString();
    }
}
