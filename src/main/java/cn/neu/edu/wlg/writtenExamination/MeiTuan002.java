package cn.neu.edu.wlg.writtenExamination;

import java.util.HashMap;
import java.util.Scanner;

public class MeiTuan002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(indexHead(str));
    }
    public static String indexHead(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int head = 0;
        int end = s.length() - 1;
        int[] visitedHead = new int[2];
        int[] visitedEnd = new int[2];
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'M') {
                visitedHead[0] = 1;
            } else if(visitedHead[0] == 1) {
                if(s.charAt(i) == 'T') {
                    head = i + 1;
                    break;
                }
            }
        }
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == 'T') {
                visitedHead[0] = 1;
            } else if(visitedHead[0] == 1) {
                if(s.charAt(i) == 'M') {
                    end = i - 1;
                    break;
                }
            }
        }
        return s.substring(head, end + 1);
    }
}
