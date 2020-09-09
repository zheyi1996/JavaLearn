package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class TianYiYun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(",");
        int[] arr = new int[str.length];
        for(int i = 0; i < str.length; ++i) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(dp_opt(arr));
    }

    public static int dp_opt(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int a = opt[i - 2] + arr[i];
            int b = opt[i - 1];
            opt[i] = Math.max(a, b);
        }
        return opt[arr.length - 1];
    }
}

