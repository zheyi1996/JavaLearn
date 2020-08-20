package cn.neu.edu.wlg.ZJoffer;

import java.util.ArrayList;

/*
    题目：滑动窗口的最大值
    思路：
        思路一：暴力法
            1. 指针指向第一个窗口的末尾
            2. 从此窗口末尾倒数size个值，比较大小 -- 注意数组不要越界
        思路二：
            1.
        根据滑动窗口的特点遍历一次即可
 */
public class Offer064 {

    public static void main(String[] args) {
        Offer064 offer064 = new Offer064();
        ArrayList<Integer> arrayList = offer064.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        System.out.println(arrayList);
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (null == num || 0 == num.length || 0 == size) {
            return  result;
        }
        if(num.length < size) {
            return result;
        }
        for (int i = size - 1; i < num.length; ++i) {
            int max = num[i];
            for (int j = i; j >= i - size + 1; --j) {
                max = max > num[j] ? max : num[j];
            }
            result.add(max);
        }
        return result;
    }


    public ArrayList<Integer> maxInWindows2(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (null == num || 0 == num.length) {
            return  result;
        }
        int max = num[0];
        for (int i = 1; i < size; ++i) {
            max = max > num[i] ? max : num[i];
        }
        result.add(max);
        if (num.length <= size) {
            return result;
        } else {
//            for (int i = 1)
        }
        return null;
    }
}
