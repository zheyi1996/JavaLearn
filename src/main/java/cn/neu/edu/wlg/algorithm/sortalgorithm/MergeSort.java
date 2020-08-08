package cn.neu.edu.wlg.algorithm.sortalgorithm;

/*
    归并排序：先分割再合并，把排序问题转化为两个有序数列的排序问题
    算法步骤：
        1. 求数组中间位置 mid
        2. 将数组拆分为左右两个子数组
        3. 归并左右子数组(两个有序数列排序)
            3.1 创建辅助数组temp，长度为 high - low + 1
            3.2 将两个有序子数组顺序对比大小，将较小(或较大)的存放到辅助数组中
            3.3 将两数组中剩余的数存放到数组中
            3.4 使该有序数组覆盖原数组的相应部分
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int [] array = {1,2,3,4,5,6,7,0};
        int [] arr = mergeSort.sort(array, 0, array.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
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
        for (int h = 0; h < temp.length; ++h) {
            arr[h+low] = temp[h];
        }
    }
}
