package cn.neu.edu.wlg.writtenExamination;

import java.util.*;
/*
    参考题目：牛牛的房间
    思路：
        1. 以1，x为根节点分别计算出其他节点到1，x的距离
        2. 如果一个节点到1的距离小于等于到x的距离，那么就此节点一定不是最优点
            因为如果1距离此点更近，那么x肯定不会选择到此节点与n相遇，另外1也不会允许x在背后追自己
        3. 在所有距离1大于距离x的节点中选择最大的一个
    知识点：
        1. Queue
            offer() -- 添加元素
            poll() -- 取出元素并删除
        2. 对象数组
            对于对象数组，使用运算符new只是为数组本身分配空间，并没有对数组的元素进行初始化，即数组元素都为空。
            对于基本数据类型，采用new初始化数组时，数组元素也进行了相应的初始化。
    参考：
        https://blog.csdn.net/qq_31036127/article/details/108042608
        https://ac.nowcoder.com/acm/contest/6915/B
*/
public class MeiTuan004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Point[] edges = new Point[n];
        for (int i = 0; i < n - 1; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            edges[i] = new Point(a, b);
        }
        if (x == y) {
            System.out.println(0);
            return;
        }
        List<Integer>[] lists = new List[n + 1];
        for (int i = 1; i <= n; ++i) {
            lists[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n -  1;++i) {
            lists[edges[i].x].add(edges[i].y);
            lists[edges[i].y].add(edges[i].x);
        }
        int ans = 0;
        int[] dis1 = bfs(x, lists, n);
        int[] dis2 = bfs(y, lists, n);
        for (int i = 1; i <= n; ++i) {
            if(dis1[i] > dis2[i]) {
                ans = Math.max(ans, dis1[i]);
            }
        }
        System.out.println(ans);
    }
    public  static  int[] bfs(int x, List<Integer>[] lists, int n) {
        int[] dis = new int[n + 1];
        dis[x] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        while (queue.size() > 0) {
            int u = queue.poll();
            for(int v : lists[u]) {
                if (dis[v] == 0) {
                    dis[v] = dis[u] + 1;
                    queue.offer(v);
                }
            }
        }
        return dis;
    }
}
class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
