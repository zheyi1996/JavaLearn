package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class BeiKe002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String b = scanner.nextLine();
        String s = scanner.next();
        if(n == 0 || null == s) {
            System.out.println(0);
        } else if(n < 4) {
            System.out.println(s.length());
        } else {
            char first = s.charAt(0);
            int min = n;
            for(int i = 1; i < n; ++i) {
                if(first == s.charAt(i)) {
                    int temp = len(s.substring(0, i), s.substring(i));
                    min = Math.min(n - temp + 1, min);
                }
            }
            System.out.println(min);
        }
    }
    public static int len(String s1, String s2) {
        if(null == s1 || null == s2 || 0 == s1.length() || 0 == s2.length()) {
            return 0;
        }
        int i = 0, j =0;
        int count = 0;
        while (i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                ++count;
                ++i;
                ++j;
            } else {
                break;
            }
        }
        return count;
    }
}
