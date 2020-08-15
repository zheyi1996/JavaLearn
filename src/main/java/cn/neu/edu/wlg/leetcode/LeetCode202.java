package cn.neu.edu.wlg.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode202 {

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