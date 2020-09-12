package cn.neu.edu.wlg.writtenExamination;

import java.util.HashSet;
import java.util.Scanner;

/*
    HashSet
 */
public class WangYi002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; ++i) {
            int n = scanner.nextInt();
            String start = "0,0";
            String end;
            HashSet<String> hashSet = new HashSet<>();
            int movex = 0;
            int movey = 0;
            hashSet.add("0,0");
            for(int j = 0; j < n; ++j) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if(-1 == y) {
                    continue;
                }
                switch(x) {
                    case 0: // 上
                        ++movex;
                        break;
                    case 1: // 下
                        --movex;
                        break;
                    case 2: // 左
                        --movey;
                        break;
                    case 3: // 右
                        ++movey;
                        break;
                }
                String temp = movex + "," + movey;
                hashSet.add(temp);
            }
            end = movex + "," + movey;

//            for(String str : hashSet) {
//                System.out.println(str);
//            }
        }

    }
    public static void dfs(HashSet hashSet, String start, String end) {

    }
}
//class Cell {
//    int x
//}
