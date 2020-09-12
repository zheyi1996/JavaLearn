package cn.neu.edu.wlg.writtenExamination;

import java.util.HashMap;
import java.util.Scanner;

public class XiaoMi001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pass = scanner.nextLine().split(" ");
        for(String pas : pass) {
            int small = 0, big = 0;
            int sp = 0, number = 0;
            char[] arr = pas.toCharArray();
            for(char a : arr) {
                if(a >= 97 && a <= 122) {
                    ++small;
                } else if(a >= 48 && a <= 57) {
                    ++number;
                } else if(a >= 65 && a <= 90) {
                    ++big;
                } else {
                    sp++;
                }
            }
            if(arr.length >= 8 && arr.length <= 120) {
                if(sp > 0 && small > 0 && big > 0 && number > 0) {
                    System.out.println(0);
                } else {
                    System.out.println(2);
                }
            } else {
                System.out.println(1);
            }
        }
    }
}
