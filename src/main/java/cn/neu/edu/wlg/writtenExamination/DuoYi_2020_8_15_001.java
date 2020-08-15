package cn.neu.edu.wlg.writtenExamination;

import java.util.HashSet;
import java.util.Set;

/*
    题目：LeetCode202 快乐数
 */
public class DuoYi_2020_8_15_001 {

    Set<Integer> middleValues = new HashSet<>();
    public boolean isHappy(int n) {
        if (middleValues.contains(n)) {
            return false;
        }
        if (1 == n) {
            return true;
        }
        middleValues.add(n);

        int squaresSum = 0;
        while(0 != n) {
            int temp = n % 10;
            squaresSum += temp * temp;
            n /= 10;
        }
        return isHappy(squaresSum);
    }
}
