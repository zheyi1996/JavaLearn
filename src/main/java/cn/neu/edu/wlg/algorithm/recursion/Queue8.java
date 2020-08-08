package cn.neu.edu.wlg.algorithm.recursion;

/*
    重点：
        1. 判断是否冲突
        2. 使用一维数组
        3. 回溯
 */
public class Queue8 {

    // 定义一个max表示共有多少个皇后
    int max = 8;
    // 定义数组array，保存皇后放置位置的结果
    int [] array = new int[max];
    int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
    }

    // 编写一个方法，放置第n个皇后
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; ++i) {
            // 先把当前这个皇后n，放到该行的第1列
            array[n] = i;
            // 判断放置后是否冲突
            if (judge(n)) {
                check(n + 1);
            }
        }
    }
    // 写一个方法，可以将皇后摆放的位置打印出来
    private void print() {
        ++count;
        System.out.println("第" + count + "个");
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    // 判断是否冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; ++i) {
            // 同一列，同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }
}
