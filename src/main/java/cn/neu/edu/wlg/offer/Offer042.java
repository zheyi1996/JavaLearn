package cn.neu.edu.wlg.offer;

import java.util.ArrayList;

/*
    题目：和为s的两个数字
    思路一：两个for循环 O(n)
    思路二：利用排序数组，两个指针，一个从前往后，一个每次都从后往前
            如果两者和等于sum，则找到，如果两者和小于sum，则结束本轮查找
 */
public class Offer042 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (null == array || array.length < 2) {
            return arrayList;
        }
        int littleNum = -1;
        int bigNum = -1;
        int mulMin = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = array.length - 1; j > i; --j) {
                int temp = array[i] + array[j];
                if (temp == sum) {
                    if (array[i] * array[j] < mulMin) {
                        littleNum = Math.min(array[i], array[j]);
                        bigNum = Math.max(array[i], array[j]);
                        mulMin = array[i] * array[j];
                    }
                } else if(temp < sum) {
                    break;
                }
            }
        }
        if (-1 != littleNum) {
            arrayList.add(littleNum);
            arrayList.add(bigNum);
        }
        return arrayList;
    }
}
