package cn.neu.edu.wlg.writtenExamination;

import java.util.HashSet;
import java.util.Scanner;
/*
    题目：全排列
 */
public class Ali_8_28_001 {
    static HashSet<String> hashSet = new HashSet<>();
    static int m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        m = scanner.nextInt();
        String str = String.valueOf(n);
        int result = Permutation(str);
        System.out.println(result);
    }
    public static int Permutation(String str) {
        if (0 == str.length()) {
            return 0;
        }
        char [] ch = new char[str.length()];
        char [] strCh = str.toCharArray();
        getAllPermutation(hashSet, ch, strCh, 0);
        return hashSet.size();
    }
    private static void getAllPermutation(HashSet<String> arrayList, char [] ch, char [] strCh, int num) {
        if (num == strCh.length) {
            String temp = String.valueOf(ch);
            if(ch[0] != '0' && Integer.parseInt(temp) % m == 0) {
                hashSet.add(temp);
            }
            return;
        }
        for (int i = 0; i < strCh.length; ++i) {
            if (' ' == strCh[i]) {
                continue;
            }
            ch[num] = strCh[i];
            strCh[i] = ' ';
            getAllPermutation(arrayList, ch, strCh, num + 1);
            strCh[i] = ch[num];
        }
    }
}
