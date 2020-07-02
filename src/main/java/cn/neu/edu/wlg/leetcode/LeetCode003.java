package cn.neu.edu.wlg.leetcode;

/*
    1.暴力求解，有待优化
 */
public class LeetCode003 {

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
//        int len = solution1.lengthOfLongestSubstring("abcabcbb");
//        int len = solution1.lengthOfLongestSubstring("bbbbb");
//        int len = solution1.lengthOfLongestSubstring("pwwkew");
        int len = solution1.lengthOfLongestSubstring(" ");
//        int len = solution1.lengthOfLongestSubstring("asjrgapa");
        System.out.println(len);
    }
}

class Solution1 {

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        for(int i = 0; i < s.length(); ++i) {
            int temp = 0;
            String s1 = "";
            for(int j = i; j < s.length(); ++j) {
                if(haveLetter(s1, s.charAt(j))){
                    break;
                }
                s1 = s1 + s.charAt(j);
                ++temp;
            }
            if(temp > max)
                max = temp;
        }
        return max;
    }
    public boolean haveLetter(String s1, char c) { //看该字母是否出现在前面的子串中

        for(int i = 0; i < s1.length(); ++i) {
            if(s1.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }
}





