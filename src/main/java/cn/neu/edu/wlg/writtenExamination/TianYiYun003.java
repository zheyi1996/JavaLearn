package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class TianYiYun003 {

    public static void main(String[] args) {
        for(int a = 0; a <= 9; ++a) {
            for(int b = 0; b <= 9; ++b) {
                for(int c = 0; c <= 9; ++c) {
                    for(int d = 0; d <= 9; ++d) {
                        int sum = a;
                        sum = sum * 10;
                        sum += b;
                        sum = sum * 10;
                        sum += c;
                        sum = sum * 10;
                        sum += d;

                        int sum2 = b;
                        sum2 = sum2 * 10;
                        sum2 += c;
                        sum2 = sum2 * 10;
                        sum2 += d;
                        sum2 = sum2 * 10;
                        sum2 += a;
                        if(sum + sum2 == 8888) {
                            System.out.print(a);
                            System.out.print(' ');
                            System.out.print(b);
                            System.out.print(' ');
                            System.out.print(c);
                            System.out.print(' ');
                            System.out.print(d);
                            System.out.println();
                        }
                    }
                }
            }
        }
    }

}

