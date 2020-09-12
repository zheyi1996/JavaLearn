package cn.neu.edu.wlg.writtenExamination;

import java.util.Arrays;
import java.util.Scanner;

public class HaoWeiLai002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.print(arr[n - 1]);
        for(int i = n - 2; i >= 0; --i) {
            System.out.print(' ');
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
