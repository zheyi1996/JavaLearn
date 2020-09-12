package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class Baidu001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int zero = 0;
        int five = 0;
        for(int i = 0; i < n; ++i) {
            int num = scanner.nextInt();
            if(0 == num) {
                ++zero;
            } else {
                ++five;
            }
        }
        if (0 == zero) {
            System.out.println(-1);
        } else if(five < 9) {
            System.out.println(0);
        } else {
            String str = "555555555";
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < five / 9; ++i) {
                stringBuffer.append(str);
            }
            for (int i = 0; i < zero; ++i) {
                stringBuffer.append(0);
            }
            System.out.println(stringBuffer);
        }
    }
}
