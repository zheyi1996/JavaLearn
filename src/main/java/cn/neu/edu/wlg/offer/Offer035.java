package cn.neu.edu.wlg.offer;

/*
    题目：数组中的逆序对
    思路：
        思路一：最朴素的暴力求解法 -- 时间上不能通过
        思路二: 归并排序
            拆分 - 取中间位置，划分左右
            归并
        1 2 3 4 & 5 6 7 0
                  5 6 & 7 0
                  5 & 6 | 7 & 0
                  5 6 & 0 7 +1
                  0 5 6 7 + 2

        5 6
        0 7
 */
public class Offer035 {

    private int count = 0;

    public static void main(String[] args) {
        Offer035 offer035 = new Offer035();
        int [] array = {1,2,3,4,5,6,7,0};
        System.out.println(offer035.InversePairs(array));
    }
    public int InversePairs(int [] array) {
        if (null == array || 0 == array.length) {
            return 0;
        }
        mergeSort(array, 0, array.length - 1);
//        System.out.println(count);
        return count;
    }
    private void mergeSort(int [] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左右拆分
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            // 左右归并
            merge(array, low, mid, high);
        }
    }
    private void merge(int [] arr, int low, int mid, int high) {
        int [] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 两个有序数组排序
        // 把较小的数移动到新数组中
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[j++];
            } else {
                ++count;
                count %= 1000000007;
                temp[k++] = arr[i++];
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
            arr[h + low] = temp[h];
        }
    }
}
