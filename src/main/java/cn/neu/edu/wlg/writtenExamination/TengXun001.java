package cn.neu.edu.wlg.writtenExamination;

import java.util.ArrayList;
import java.util.Scanner;

public class TengXun001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; ++i) {
            b[i] = scanner.nextInt();
        }

        int i = 0, j = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(i < n && j < m) {
            if(a[i] < b[j]) {
                ++j;
            } else if (a[i] > b[j]) {
                ++i;
            } else {
                arr.add(a[i]);
//                System.out.println(a[i]);
                ++i;
                ++j;
            }
        }
        for(i = 0; i < arr.size() - 1; ++i) {
            System.out.print(arr.get(i));
            System.out.print(' ');
        }
        System.out.println(arr.get(arr.size() - 1));
    }
}
