package cn.neu.edu.wlg.ZJoffer;

import java.util.Arrays;

/*
    题目：扑克牌顺子
    思路：先排序，然后得到0的个数，然后计算连续两数之差-1的和，这些和如果大于0的个数，则不是顺子
        1 2 3 4 0
        1 2 4 0
        1 3 3 4 0
    知识点：
        1. Arrays.sort();
 */
public class Offer045 {

    public boolean isContinuous(int [] numbers) {
        if (null == numbers || 0 == numbers.length) {
            return false;
        }
        Arrays.sort(numbers);
        int zeroCount = 0;
        int diffCount = 0;
        boolean flag = true;
        for (int i = 1; i < numbers.length; ++i) {
            if (0 == numbers[i-1]) {
                ++zeroCount;
                continue;
            } else if (numbers[i] == numbers[i - 1]) {
                flag = false;
                break;
            } else {
                diffCount += (numbers[i] - numbers[i - 1] - 1);
            }
        }
        if (!flag || diffCount > zeroCount) {
            return false;
        }
        return true;
    }
}
