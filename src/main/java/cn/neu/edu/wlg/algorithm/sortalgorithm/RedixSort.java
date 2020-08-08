package cn.neu.edu.wlg.algorithm.sortalgorithm;

import java.util.Arrays;

public class RedixSort {
    public static void main(String[] args) {
        int [] arr = {53, 3, 542, 748, 14, 214};
        RedixSort.raxixSort(arr);
    }
    public static void raxixSort(int [] arr) {
        // 定义十个桶
        int [][] buckets = new int[10][arr.length];
        // 记录每个桶中实际存放多少个数据
        int [] bucketElementCounts = new int[10];
        // 求最大位数
        int max = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        int temp = 1;
        for (int i = 0; i  < maxLength; ++i) {
            for (int j = 0; j < arr.length; ++j) {
                int digitOfElement = arr[j] / temp % 10;
                // 放到桶中
                buckets[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                ++bucketElementCounts[digitOfElement];
            }
            // 将桶中元素取出
            int index = 0;
            for (int k =0; k < 10; ++k) {
                for (int h = 0; h < bucketElementCounts[k]; ++h) {
                    arr[index++] = buckets[k][h];
                }
                // 清空桶中元素
                bucketElementCounts[k] = 0;
            }
            temp *= 10;
            System.out.println(Arrays.toString(arr));
        }
    }
}
