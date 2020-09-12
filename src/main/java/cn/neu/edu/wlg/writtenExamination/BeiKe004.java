package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;
public class BeiKe004 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[2 * n];
        int[] b = new int[2 * n];
        int[] c = new int[2 * n];
        for(int i = 0; i < 2 * n; ++i) {
            a[i] = scanner.nextInt();
        }
        for(int i = 0; i < 2 * n; ++i) {

            b[i] = scanner.nextInt();
        }
        for(int i = 0; i < 2 * n; ++i) {
            c[i] = b[i] - a[i];
//            c[i] = scanner.nextInt();
        }
        int sum = 0;
        int temp = 1;
        int i = n - 1, j = n;
        while(i >= 0 && j < 2 * n) {
            if(c[i] > c[j]) {
                sum += c[i];
                if(sum < 0) {
                    temp -= sum;
                    sum = 0;
                }
                --i;
            } else {
                sum += c[j];
                if(sum < 0) {
                    temp -= sum;
                    sum = 0;
                }
                ++j;
            }
        }
        while(i >= 0) {
            sum += c[i];
            if(sum < 0) {
                temp -= sum;
                sum = 0;
            }
            --i;
        }
        while(j < 2 * n) {
            sum += c[j];
            if(sum < 0) {
                temp -= sum;
                sum = 0;
            }
            ++j;
        }
        System.out.println(temp);
    }
}
