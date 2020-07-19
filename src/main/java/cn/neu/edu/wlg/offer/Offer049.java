package cn.neu.edu.wlg.offer;

public class Offer049 {

    public int StrToInt(String str) {
        if (null == str || 0 == str.length()) {
            return 0;
        }
        char ch[] = str.toCharArray();
        int sum = 0;
        int signDigit = 0; // 1为正，0为无符号，-1为负
        if (isLegal(ch[0], 0)) {
            if ('+' == ch[0]) {
                signDigit = 1;
            } else if ('-' == ch[0]) {
                signDigit = -1;
            } else {
                signDigit = 0;
                sum += ch[0] - '0';
            }
        } else {
            return 0;
        }
        for (int i = 1; i < ch.length; ++i) {
            if (isLegal(ch[i], i)) {
                sum = sum * 10 + (ch[i] - '0');
            } else {
                return 0;
            }
        }
        if (-1 == signDigit) {
            sum = 0 - sum;
        }
        return sum;
    }
    private boolean isLegal(char ch, int i) {
        if (0 == i) {
            if (Character.isDigit(ch) || ch != '+' || ch != '-') {
                return true;
            }
        } else {
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }
}
