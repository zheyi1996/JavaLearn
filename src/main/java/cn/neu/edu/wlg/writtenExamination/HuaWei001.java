package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class HuaWei001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[] A = new int[K];
        int[] B = new int[K];
        for(int i = 0; i < K; ++i) {
            A[i] = sc.nextInt();
        }
        for(int i = 0; i < K; ++i) {
            B[i] = sc.nextInt();
        }
        int N = sc.nextInt();
        int[] C = new int[N];
        int[] D = new int[N];
        for(int i = 0; i < N; ++i) {
            C[i] = sc.nextInt();
        }
        for(int i = 0; i < N; ++i) {
            D[i] = sc.nextInt();
        }
        for(int i = 0; i <= N - K; ++i) {
            if(C[i] == A[0] && D[i] == B[0]) {
                if(judge(K, N, A, B, C, D, i)) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
        System.out.println("0");
    }
    public static  boolean judge(int K, int N,int[] A, int[] B, int[] C, int[] D, int i) {
        if(0 == A.length || 0 == B.length || 0 == C.length || 0 == D.length) {
            return false;
        }
        if(K + i - 1 >= N) {
            return false;
        }
        for(int j = 0; j < K; ++j) {
            if(A[j] != C[i + j] || B[j] != D[i + j]) {
                return false;
            }
        }
        return true;
    }
}