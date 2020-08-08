package cn.neu.edu.wlg.algorithm.sortalgorithm;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int [] arr = {3, 9, -1, 10, -2, 1};
        ShellSort.shellSort(arr);
    }
    // 移动法
    public static void shellSort(int [] arr) {
        // 增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; ++i) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
