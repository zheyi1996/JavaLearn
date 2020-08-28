package cn.neu.edu.wlg.AcWing;

import java.util.Scanner;
/*
    题目：有向图最短路径问题
    思路：dist记录
 */
public class Ac849 {
    static int n, m;
    static int[][] graph; // 存储每条边
    static int[] dist; // 存储1号到每个点的最短距离
    static boolean[] st; // 记录哪些节点已经加入
    static int INF = 0x3f3f3f3f; // 设置无穷大

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArr = scanner.nextLine().split(" ");
        n = Integer.parseInt(strArr[0]);
        m = Integer.parseInt(strArr[1]);
        graph = new int[n + 1][n + 1];
        dist = new int[n + 1];
        st = new boolean[n + 1];
        for(int i = 0; i <= n; ++i) {
            dist[i] = INF;
            for(int j = 0; j <= n; ++j) {
                graph[i][j] = INF;
            }
        }
        for(int i = 0; i < m; ++i) {
            strArr = scanner.nextLine().split(" ");
            int x = Integer.parseInt(strArr[0]);
            int y = Integer.parseInt(strArr[1]);
            int z = Integer.parseInt(strArr[2]);
            graph[x][y] = Math.min(graph[x][y], z);
        }
        System.out.print(dijkstra());
    }
    public static int dijkstra() {
        dist[1] = 0;
        for(int i = 0; i < n; ++i) {
            int temp = -1;
            for(int j = 1; j <= n; ++j) {
                if(!st[j] && (-1 == temp || dist[temp] > dist[j])) {
                    temp = j;
                }
            }
            st[temp] = true;
            for(int j = 1; j <= n; ++j) {
                dist[j] = Math.min(dist[j], dist[temp] + graph[temp][j]);
            }
        }
        if(dist[n] == INF)  return -1;
        return dist[n];
    }
}
