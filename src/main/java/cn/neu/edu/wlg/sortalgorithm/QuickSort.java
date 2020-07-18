package cn.neu.edu.wlg.sortalgorithm;

import java.util.ArrayList;

/*
    快速排序：
        从待排序数组中随机选择一个元素，将数组分为大于和小于等于该元素的两个部分，然后在两个部分重复上述过程
 */
public class QuickSort {
    public void qSort(int [] input) {
        quickSort(input, 0, input.length - 1);
    }
    public void quickSort(int [] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partition(array, low, high);
        quickSort(array, low, index - 1);
        quickSort(array, index + 1, high);
    }
    public int partition(int [] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            while (array[high] >= key && high > low) { //从后半部分向前扫描
                --high;
            }
            array[low] = array[high];
            while (array[low] <= key && high > low) { // 从前半部分向后扫描
                ++low;
            }
            array[high] = array[low];
        }
        array[high] = key;
        return high;
    }
}
