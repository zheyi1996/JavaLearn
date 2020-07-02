package cn.neu.edu.wlg.leetcode;

// indexOf函数
// KMP算法

import java.util.Scanner;

/**
 * KMP
 * 思路：
 * 1. 根据搜索词做出部分匹配表
 * 2. 进行搜索，搜索失败后根据部分匹配表进行位移
 */
public class LeetCode028 {

    public static void main(String[] args) {
        String haystack = new String();
        String needle = new String();
//        while(true) {
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNext()) {
                haystack = scanner.next();
            }
            if(scanner.hasNext()) {
                needle = scanner.next();
            }
            Solution028_IndexOf solution = new Solution028_IndexOf();
            System.out.println(solution.strStr(haystack, needle));
            scanner.close();
//        }

    }
}

class Solution028_IndexOf {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

class Solution028_KMP {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}