package cn.neu.edu.wlg.AcWing;

/*
    题目：01背包问题
    思路：
        * 如果装不下当前物品，那么前n个物品的最佳组合和前n-1个物品的最佳组合是一样的
        * 如果装的下当前物品
          * 假设1：装当前物品，给当前物品预留了相应空间的情况下，前n-1个物品在减去当前物品的重量后的最佳组合加上当前物品的价值就是总价值；
          * 假设2：不装当前物品，那么前n个物品的最佳组合和前n-1个物品的最佳组合式一样的。
        * 选取假设1和假设2中较大的价值，为当前最佳组合的价值。
 */
import java.util.Scanner;
public class Ac002 {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 0; i < N; ++i) {
            v[i + 1] = scanner.nextInt();
            w[i + 1] = scanner.nextInt();
        }
        for (int i = 1; i <= N; ++i) {
            for(int j = 1; j <= V; ++j) {
                if (v[i] <= j) {
                    dp[i][j] = Math.max(w[i] + dp[i - 1][j - v[i]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}


