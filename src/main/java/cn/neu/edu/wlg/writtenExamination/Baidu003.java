package cn.neu.edu.wlg.writtenExamination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baidu003 {

    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        if (m < 3) {
            System.out.println(0);
        }
        search(0, n, m, new ArrayList<>());
        System.out.println(count % 100000007);
    }
    public static void search(int sum, int n, int m, List<Integer> list) {
        if (n == sum) {
            count = count % 100000007 + 1;
            return;
        }
        if (sum > n) {
            return;
        }
        for (int i = 1; i <= m; ++i) {
            if (list.contains(i)) {
                continue;
            }
            if (list.size() <= 2) {
                list.add(i);
            }
            List<Integer> t = new ArrayList<>(list);
            if(t.size() == 3) {
                t.remove(0);
            }
            search(sum + i, n, m, t);
        }
    }
}
