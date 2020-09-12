package cn.neu.edu.wlg.writtenExamination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
/*
    思路：
        queue
 */
public class BeiKe003 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayList<HashSet<Integer>> arr = new ArrayList<HashSet<Integer>>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            HashSet<Integer> temp = new HashSet<>();
            for(int j = 0; j < k; ++j) {
                temp.add(scanner.nextInt());
            }
            arr.add(temp);
            queue.offer(i + 1);
        }
        for(int j = 1; j < n; ++j) {
            LinkedList<Integer> queueTemp = new LinkedList<>();
            for(int i = 0; i < m; ++i) {
                if(arr.get(i).contains(i + 1)) {
                    continue;
                }
                queueTemp.offer(i + 1);
            }
        }
    }
}
