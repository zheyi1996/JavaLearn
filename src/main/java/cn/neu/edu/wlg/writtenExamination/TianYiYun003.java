package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class TianYiYun002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getResult(n));
    }
    public static int getResult(int n) {
        if(n <= 0){
            return 0;
        }
        int p1 = 0, p2=0, p3=0;
        int[] result = new int[n];
        result[0] = 1;
        for(int i=1;i<n;i++){
            result[i]=Math.min(Math.min(result[p1]*2,result[p2]*3),result[p3]*5);
            if(result[i]==result[p1]*2){
                p1++;
            }else if(result[i]==result[p2]*3){
                p2++;
            }else{
                p3++;
            }
            if(result[i]==result[i-1]){
                i--;
            }
        }
        return result[n - 1];
    }
}

