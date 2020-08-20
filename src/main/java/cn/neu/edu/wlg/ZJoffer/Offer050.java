package cn.neu.edu.wlg.ZJoffer;

/*
    题目：数组中的重复数字
    思路：
    知识点：
        1. String.valueOf(i)
        2. String.indexOf(), String.lastIndexOf()
        3. StringBuilder(线程不安全), StringBuffer(线程安全)
 */
public class Offer050 {

    public static void main(String[] args) {
        Offer050 offer050 = new Offer050();
//        int [] numbers = {2, 1, 3, 0, 4};
        int [] numbers = {2, 1, 3, 1, 4};
        int [] duplication = {-1};
        offer050.duplicate(numbers, numbers.length, duplication);
    }
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (null == numbers || 0 == numbers.length) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numbers.length; ++i) {
            stringBuffer.append(String.valueOf(numbers[i]) + ' ');
        }
        for (int i = 0; i < numbers.length; ++i) {
            if (stringBuffer.indexOf(String.valueOf(numbers[i]) + ' ') != stringBuffer.lastIndexOf(String.valueOf(numbers[i]) + ' ')) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
