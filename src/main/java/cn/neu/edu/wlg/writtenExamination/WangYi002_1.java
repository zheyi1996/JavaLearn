package cn.neu.edu.wlg.writtenExamination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WangYi002_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stopStrs = scanner.nextLine().trim().split(" ");
        Set<String> set = new HashSet<>();
        for(String str : stopStrs) {
            set.add(str);
        }
        String[] aStrs = scanner.nextLine().trim().split(" ");
        String[] bStrs = scanner.nextLine().trim().split(" ");
        ArrayList<String> aArrayList = new ArrayList<>();
        ArrayList<String> bArrayList = new ArrayList<>();
        for(int i = 0; i < aStrs.length; ++i) {
            if(set.contains(aStrs[i])) {
                continue;
            }
            aArrayList.add(aStrs[i]);
        }
        for(int i = 0; i < bStrs.length; ++i) {
            if(set.contains(bStrs[i])) {
                continue;
            }
            bArrayList.add(bStrs[i]);
        }
        String[] A = aArrayList.toArray(new String[aArrayList.size()]);
        String[] B = bArrayList.toArray(new String[bArrayList.size()]);
        System.out.println(minDistance(A, B));
    }
    public static int minDistance(String[] word1, String[] word2) {
        int n = word1.length;
        int m = word2.length;
        if (n * m == 0)
            return n + m;
        int [][] D = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (!word1[i - 1].equals(word2[j - 1]))
                    left_down += 1;
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }
}
