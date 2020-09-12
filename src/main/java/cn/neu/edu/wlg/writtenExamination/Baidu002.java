package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class Baidu002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; ++i) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] niu = new int[n + 1];
            for (int j = 1; j <= n; ++j) {
                niu[j] = 0;
            }
            for(int j = 0; j < m; ++j) {
                int kt = scanner.nextInt();
                int[] flag = new int[n + 1];
                for (int kk = 0; kk < kt; ++kk) {
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    for (int k = l; k <= r; ++k) {
                        if (flag[k] == 1) {
                            continue;
                        }
                        flag[k] = 1;
                        ++niu[k];
                    }
                }
            }
            int count = 0;
            StringBuilder str = new StringBuilder();
            for (int k = 1; k <= n; ++k) {
                if (niu[k] == m) {
                    ++count;
                    str.append(k);
                    str.append(' ');
                }
            }
            System.out.println(count);
            System.out.println(str.toString().trim());
        }
    }
}
