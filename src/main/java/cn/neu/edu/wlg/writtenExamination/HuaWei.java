package cn.neu.edu.wlg.writtenExamination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class HuaWei {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        HashSet<Character> hashSet = new HashSet<>();

        int max = 0;
        int s = 0;
        int e = 0;
        for(int i = 0; i < str.length(); ++i) {

            for(int j = i; j < str.length(); ++j) {
                if (!hashSet.contains(str.charAt(j))) {
                    hashSet.add(str.charAt(j));
                } else {
                    if(max < hashSet.size()) {
                        s = i;
                        e = j;
                        max = hashSet.size();
                        hashSet.clear();
                    }
                    break;
                }
                if (j == str.length() - 1) {
                    if(max < hashSet.size()) {
                        s = i;
                        e = j;
                        max = hashSet.size();
                        hashSet.clear();
                    }
                }
            }
        }
        for (int i = s; i <= e; ++i) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
        System.out.println(max);
    }
}
// abcadefcgbcdabcdefg