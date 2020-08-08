package cn.neu.edu.wlg.algorithm.sortalgorithm;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int [] arr = {3, 9, -1, 10, -2};
        InsertSort.insertSort(arr);
    }
    // 插入排序
    public static void insertSort(int [] arr) {
        for (int i = 1; i < arr.length; ++i) {
            // 定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1;
            // 数组后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                --insertIndex;
            }
            arr[insertIndex + 1] = insertVal;
            System.out.println("第" + i + "轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }
}
