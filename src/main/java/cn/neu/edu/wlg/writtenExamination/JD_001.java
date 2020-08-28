package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class JD_001 {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        int[][] arr = new int[n][n * 2 - 1];
        int j = n - 1, k = n - 1;
        for (int i = 0; i < n; ++i) {
            String[] strArr = scanner.nextLine().trim().split(" ");
            int temp = 0;
            for (int h = j; h <= k; ++h) {
                arr[i][h] = Integer.parseInt(strArr[temp++]);
            }
            --j;
            ++k;
        }
        getResult(n - 1, arr, arr[0][n - 1], 0, n);
        System.out.println(sum);
    }
    public static void getResult(int start, int[][] arr, int nums, int t, int length) {
        if (t == length - 1) {
            if (nums > sum) {
                sum = nums;
            }
            return;
        }
        if (start - 1 >= 0) {
            getResult(start - 1, arr, nums + arr[t + 1][start - 1], t + 1, length);
        }
        getResult(start, arr, nums + arr[t + 1][start], t + 1, length);
        if (start + 1 < length * 2 - 1) {
            getResult(start + 1, arr, nums + arr[t + 1][start + 1], t + 1, length);
        }
    }
}







