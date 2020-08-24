//package cn.neu.edu.wlg.writtenExamination;
//
//// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Three360_001 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] a = new int[n + 1];
//        int[] c = new int[n + 1];
//        for (int i = 1; i <= n; ++i) {
//            a[i] = i;
//        }
//        int[] flag = new int[m];
//        for (int i = 0; i < m; ++i) {
//            flag[i] = in.nextInt();
//        }
//
//        int k = 1;
//        for (int i = 0; i < m; ++i) {
//            if (1 == flag[i]) {
//                c[k] = a[k];
//                a[k] = -1;
//            } else {
//                if (2 == flag[i + 1]) {
//                    ++i;
//                    continue;
//                } else {
//                    if ((k & 1) == 0) {
//                        for(int j = k + 1; k <= n; j = j + 2) {
//                            int temp = a[j];
//                            a[j] = a[j + 1];
//                            a[j + 1] = temp;
//                        }
//                        for (int j = 1; j <= k; j = j + 2) {
//                            int temp = a[j];
//                            a[j] = a[j + 1];
//                            a[j + 1] = temp;
//                        }
//                    } else {
//                        for(int j = k + 1; j < n - 1; j = j + 2) {
//                            int temp = a[j];
//                            a[j] = a[j + 1];
//                            a[j + 1] = temp;
//                        }
//                        for (int j = 2; j <= k; j = j + 2) {
//                            int temp = c[j];
//                            c[j] = c[j + 1];
//                            c[j + 1] = temp;
//                        }
//                        int temp = a[n];
//                        a[n] = c[1];
//                        c[1] = temp;
//                    }
//                }
//            }
//        }
//        for(int j = k + 1; j. <= n; ++j) {
//            System.out.print(String.valueOf(a[j]) + ' ');
//        }
//        for (int j = 1; j < k; ++j) {
//            System.out.print(String.valueOf(c[j]) + ' ');
//        }
//
//        System.out.println(String.valueOf(c[n]));
//    }
//}
////            if (1 == flag) {
////                    a[0] = a[1];
////                    for(int j = 2; j <= n; ++j) {
////                    a[j - 1] = a[j];
////                    }
////                    a[n] = a[0];
////                    } else if (2 == flag) {
////                    for (int j = 1; j <= n; j += 2) {
////                    a[0] = a[j];
////                    a[j] = a[j + 1];
////                    a[j + 1] = a[0];
////                    }
////                    }
//
//
////public class Three360_001 {
////    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////        int n = in.nextInt();
////        int count = 0;
////        for (int i = 0; i < n; ++i) {
////            String str = in.next();
////            if (str.length() > 10 || !str.matches("[a-zA-Z]+")) {
////                continue;
////            } else {
////                ++count;
////            }
////        }
////        System.out.println(count);
////    }
////}
//
//
//
//
//
//
//
//
