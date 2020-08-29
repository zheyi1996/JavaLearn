package cn.neu.edu.wlg.leetcode;

/*
    拓扑排序：深度优先搜索
    节点标记：
        0 未搜索
        1 正在搜索
        2 已经完成搜索(没有成环)
*/
import java.util.ArrayList;
class LeetCode207 {
    int[] visited;
    ArrayList<ArrayList<Integer>> edges;
    boolean flag = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        edges = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        for(int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < numCourses; ++i) {
            if(0 == visited[i]) {
                dfs(i);
            }
        }
        return flag;
    }
    public void dfs(int u) {
        visited[u] = 1;
        for(int v : edges.get(u)) {
            if(0 == visited[v]) {
                dfs(v);
                if(!flag)
                    return;
            } else if(1 == visited[v]) {
                flag = false;
                return;
            }
        }
        visited[u] = 2;
    }
}