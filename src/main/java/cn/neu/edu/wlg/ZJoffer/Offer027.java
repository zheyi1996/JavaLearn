package cn.neu.edu.wlg.ZJoffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

/*
    题目：字符串的排列
    思路：
        递归
        如何避免重复？
 */
public class Offer027 {
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
            if(Integer.parseInt(temp) % m == 0) {
                hashSet.add(temp);
            }
            return;
        }
        for (int i = 0; i < strCh.length; ++i) {
            if (0 == i & '0' == strCh[i]) {
                continue;
            }
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



//public class Offer027 {
//
//    public static void main(String[] args) {
//        Offer027 offer027 = new Offer027();
//        ArrayList<String> arrayList = offer027.Permutation("aab");
//        for (int i = 0; i < arrayList.size(); ++i) {
//            System.out.println("第" + i + "个: " + arrayList.get(i));
//        }
//    }
//    public ArrayList<String> Permutation(String str) {
//        if (null == str) {
//            throw new NullPointerException("字符串为空！");
//        }
//        ArrayList<String> results = new ArrayList<>();
//        if (0 == str.length()) {
//            return results;
//        }
//        char [] ch = new char[str.length()];
//        char [] strCh = str.toCharArray();
//        HashSet<String> hashSet = new HashSet<>();
//        getAllPermutation(hashSet, ch, strCh, 0);
//        results.addAll(hashSet);
//        results.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        return results;
//    }
//    private void getAllPermutation(HashSet<String> arrayList, char [] ch, char [] strCh, int num) {
//        if (num == strCh.length) {
//            String temp = String.valueOf(ch);
//            arrayList.add(temp);
//            return;
//        }
//        for (int i = 0; i < strCh.length; ++i) {
//            if (' ' == strCh[i]) {
//                continue;
//            }
//            ch[num] = strCh[i];
//            strCh[i] = ' ';
//            getAllPermutation(arrayList, ch, strCh, num + 1);
//            strCh[i] = ch[num];
//        }
//    }
//}