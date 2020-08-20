package cn.neu.edu.wlg.ZJoffer;

import java.util.LinkedList;
import java.util.List;

/*
    题目：圆圈中最后剩下的数
    思路一：环形单链表 时间复杂度n*m
        剪枝：记录剩余小朋友的个数num，如果m >= num，则让temp = num + m % num 作为m使用
        (如果m大于n，则多余的圈数没必要数)


 */
public class Offer046 {

    public static void main(String[] args) {
        Offer046 offer046 = new Offer046();
        System.out.println(offer046.LastRemaining_Solution(5, 3));
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            list.add(i);
        }
        // 要删除元素的位置
        int idx = 0;
        // 开始计数的位置
        int start = 0;
        while (list.size() > 1) {
//            int steps = m % (list.size() - 1);
            for (int i = 1; i < m; ++i) {
                idx = (idx + 1) % list.size();
            }
            list.remove(idx);
            start = idx;
        }
        return list.get(0);
    }
}

