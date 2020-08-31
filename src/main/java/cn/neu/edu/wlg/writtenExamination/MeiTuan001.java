package cn.neu.edu.wlg.writtenExamination;

import java.util.HashSet;
import java.util.Scanner;

public class MeiTuan001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        int[] result = new int[n];
        int k = 0;
        for(int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                arr[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; ++j) {
                if (hashSet.contains(arr[j])) {
                    continue;
                } else {
                    hashSet.add(arr[j]);
                    result[k++] = arr[j];
                    break;
                }
            }
        }
        for (int i = 0; i < n - 1; ++i) {
            System.out.print(result[i] + " ");
        }
        System.out.println(result[n - 1]);
    }
}
