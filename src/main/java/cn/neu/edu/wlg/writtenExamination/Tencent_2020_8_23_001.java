package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class Tencent_2020_8_23_001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        int highMax = -1;
        int highLocation = -1;
        int widthMax = 0;
        int[] widthStart = new int[n];
        int[] widthEnd = new int[n];
//        int[] widthStart = new int[n];
//        int[] widthEnd = new int[n];
        int j = 0;
        boolean flag = true;
        while (0 != sum) {
            for (int i = 0; i < n; ++i) {
                if (arr[i] > highMax) {
                    highMax = arr[i];
                    highLocation = i;
                }
                if (arr[i] >= 1 && flag) {
                    widthStart[j] = i;
                    flag = false;
                }
                if (0 == arr[i]) {
                    widthEnd[j] = i;
                    ++j;
                    flag = true;
                }
            }

        }
    }
}
