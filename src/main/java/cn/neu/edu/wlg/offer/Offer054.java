package cn.neu.edu.wlg.offer;

/*
    题目：正则表达式
    思路：ASCII总共256个字符
    步骤：
        1. 创建一个容量为256的char数组
        2. 每插入一个字符，如果该字符第一次出现，则记录index++，否则记录为-1
            0 表示该字符未曾出现
            -1 表示该字符出现次数超过1次
            index 反应字符的出现顺序
 */

public class Offer054 {

    int [] count = new int[256];
    int index = 1;
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (0 == count[ch]) { // 说明该字符第一次出现，
            count[ch] = ++index; // 用来记录各个字符第一次出现的升序序列
        } else {
            count[ch] = -1; // 说明该字符出现超过一次
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int temp = Integer.MAX_VALUE;
        char ch = '#';
        for (int i = 0; i < 256; ++i) {
            if (0 != count[i] && -1 != count[i] && count[i] < temp) {
                temp = count[i];
                ch = (char) i;
            }
        }
        return ch;
    }
}
