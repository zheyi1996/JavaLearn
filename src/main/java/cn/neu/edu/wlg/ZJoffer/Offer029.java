package cn.neu.edu.wlg.ZJoffer;

import java.util.ArrayList;

/*
    题目：最小的K个数
    思路：
        1. 快速排序
 */
public class Offer029 {

    public static void main(String[] args) {
        Offer029 offer029 = new Offer029();
        int [] input = {4,5,1,6,2,7,3,8};
        offer029.GetLeastNumbers_Solution(input, 4);
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (null == input || 0 == input.length || k > input.length) {
            return arrayList;
        }
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; ++i) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }
    public void quickSort(int [] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int mid = partition(arr, low, high);
        if (low <= mid - 1) {
            quickSort(arr, low, mid - 1);
        }
        if (mid + 1 <= high) {
            quickSort(arr, mid + 1, high);
        }
    }
    public int partition(int [] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (arr[high] >= temp && low < high) { // 从后向前遍历
                --high;
            }
            arr[low] = arr[high];
            while (arr[low] <= temp && low < high) { // 从前向后遍历
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
