package cn.neu.edu.wlg.ZJoffer;

import java.util.ArrayList;

/*
    题目：和为S的连续正数序列
    思路：
    知识点：ArrayList深度拷贝
 */
public class Offer041 {

    public static void main(String[] args) {
        Offer041 offer041 = new Offer041();
        System.out.println(offer041.FindContinuousSequence(5));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int small = 1;
        int big = 2;
        int tempSum = small + big;
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<>();
        while (big < sum) {
            if (tempSum == sum) {
                for (int i = small; i <= big; ++i) {
                    result.add(i);
                }
                ArrayList<Integer> temp = (ArrayList<Integer>) result.clone();
                results.add(temp);
                result.clear();
                ++big;
                tempSum -= small;
                tempSum += big;
                ++small;
            } else if (tempSum < sum) {
                ++big;
                tempSum += big;
            } else {
                tempSum -= small;
                ++small;
            }
        }
        return results;
    }
}
