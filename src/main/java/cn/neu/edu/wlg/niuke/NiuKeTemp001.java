package cn.neu.edu.wlg.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
    题目：牛牛的房间
    思路：
        1. 以1，x为根节点分别计算出其他节点到1，x的距离
        2. 如果一个节点到1的距离小于等于到x的距离，那么就此节点一定不是最优点
            因为如果1距离此点更近，那么x肯定不会选择到此节点与n相遇，另外1也不会允许x在背后追自己
        3. 在所有距离1大于距离x的节点中选择最大的一个
    知识点：
        1. Queue
            offer() -- 添加元素
            poll() -- 取出元素并删除
    参考：
        https://blog.csdn.net/qq_31036127/article/details/108042608
        https://ac.nowcoder.com/acm/contest/6915/B
*/

public class NiuKeTemp001 {
        public int solve (int n, int x, Point[] Edge) {
            List<Integer>[] lists = new List[n + 1];
            for(int i = 1; i <= n; ++i) {
                lists[i] = new ArrayList<Integer>();
            }
            for(Point point : Edge) {
                lists[point.x].add(point.y);
                lists[point.y].add(point.x);
            }
            int[] dist1 = bfs(1, lists, n);
            int[] dist2 = bfs(x, lists, n);
            int temp = 0;
            for(int i = 1; i <= n; ++i) {
                if(dist1[i] > dist2[i]) {
                    temp = Math.max(dist1[i], temp);
                }
            }
            return temp;
        }
        public static int[] bfs(int root, List<Integer>[] lists, int n) {
            int[] dist = new int[n + 1];
            dist[root] = 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(root);
            while(queue.size() > 0) {
                int u = queue.poll();
                for(int v : lists[u]) {
                    if(0 == dist[v]) {
                        dist[v] = dist[u] + 1;
                        queue.offer(v);
                    }
                }
            }
            return dist;
        }
}
    class Point {
        int x;
        int y;
    }