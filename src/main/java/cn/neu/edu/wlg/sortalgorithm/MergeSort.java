package cn.neu.edu.wlg.sortalgorithm;

/*
    归并排序：先分割再合并，把排序问题转化为两个有序数列的排序问题
 */
public class MergeSort {

    public int[] sort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左右拆分
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            // 左右归并
            merge(arr, low, mid, high);
        }
        return arr;
    }
    public void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 两个有序数组排序
        // 把较小的数移动到新数组中
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 把左边剩余的数移动到新数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 把右边剩余的数移动到新数组
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        // 使用有序的新数组覆盖原数组
        for (int h = 0; h <= temp.length; ++h) {
            arr[h+low] = temp[h];
        }
    }
}
