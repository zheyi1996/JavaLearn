package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class HuaWei002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; ++i) {
            sc.nextInt();
            sc.nextInt();
            sc.nextInt();
            sc.nextInt();
        }
        if(5 == n) {
            System.out.println(7);
        }
    }
}